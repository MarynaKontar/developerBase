package com.app.DAO.JdbcDao;

import com.app.BackendException.DatabaseException;
import com.app.DAO.DAODeveloper;
import com.app.Entities.Developer;

import java.sql.*;
import java.util.*;

/**
 * Created by User on 12.06.2017.
 */
public class JdbcDAODeveloper implements DAODeveloper {

    private static final String CREATE_SQL = "insert into developers(developer_name, developer_lastname) values(?, ?)";
    private static final String READ_SQL = "select * from developers where developer_id=?";
    private static final String UPDATE_SQL = "update developers set developer_name=?, developer_lastname=? where developer_id=?";
    private static final String DELETE_SQL = "delete from developers where developer_id=?";
    private static final String ADD_SKILLS = "insert into developer_skill(developer_id, skill_id) values(?, ?)";
    private static final String DELETE_SKILLS = "delete from developer_skill where developer_id=? ";
    private static final String ADD_PROJECTS = "insert into developer_project(developer_id, project_id, salary) values(?, ?, ?)";
    private static final String DELETE_PROJECTS = "delete from developer_project where developer_id=?";
    private static final String SELECT_SKILLS_ID = "select skill_id from developer_skill where developer_id=?";
    private static final String SELECT_PROJECT_ID_AND_SALARY = "select project_id, salary from developer_project where developer_id = ?";
    private static final String GET_ALL_SQL = "select * from developers";

    @Override
    public void create(Developer entity) {

        try (Connection connection = ConnectionToDB.getConnection()) {
            connection.setAutoCommit(false);
//            Savepoint savepoint = null;
            int id = 0;
            try (PreparedStatement ps = connection.prepareStatement(CREATE_SQL,
                    Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, entity.getName());
                ps.setString(2, entity.getLastName());
//                savepoint = connection.setSavepoint("SavepointCreate");
                int affectedRows = ps.executeUpdate();
//                System.out.println("affectedRows = " + affectedRows);
                connection.commit();
                if (affectedRows == 0) {
                    throw new SQLException("Creating developer failed, no rows affected.");
                }
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        id = generatedKeys.getInt(1);
//                        System.out.println("id = " + id);
                    }
                }

                addSkillsToDeveloper_skillTable(entity, connection, id);
                addDevelopersAndProjectsToDeveloper_projectTable(entity, connection, id);
                connection.commit();

            } catch (Exception e) {
//                connection.rollback();
                connection.rollback();
                throw e;
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    private void addSkillsToDeveloper_skillTable(Developer entity, Connection connection, int id) throws Exception {
        List<Integer> skillsId = entity.getSkillIdList();
        if (skillsId != null) {
            for (Integer skillId : skillsId) {
                try (PreparedStatement ps = connection.prepareStatement(ADD_SKILLS)) {
                    ps.setInt(1, id);
                    ps.setInt(2, skillId);
                    ps.executeUpdate();
                }
            }
        }
    }

    private void addDevelopersAndProjectsToDeveloper_projectTable(Developer entity, Connection connection, int id) throws Exception {
        Map<Integer, Integer> projectIDSalary = entity.getProjectIDSalary();
        Integer project;
        Integer salary;
        if (projectIDSalary != null) {
            for (Map.Entry<Integer, Integer> entry : projectIDSalary.entrySet()) {
                project = entry.getKey();
                salary = entry.getValue();
                try (PreparedStatement ps = connection.prepareStatement(ADD_PROJECTS)) {
                    ps.setInt(1, id);
                    ps.setInt(2, project);
                    ps.setInt(3, salary);
                    ps.executeUpdate();
                }
            }
        }
    }

    @Override
    public Optional<Developer> read(int id) {
        try (Connection connection = ConnectionToDB.getConnection()) {
            Developer developer = new Developer();
            try (PreparedStatement ps = connection.prepareStatement(READ_SQL)) {
                ps.setInt(1, id);

                try (ResultSet result = ps.executeQuery()) {
                    if (!result.next()) return Optional.empty();
                    developer.setId(result.getInt("DEVELOPER_ID"));
                    developer.setName(result.getString("DEVELOPER_NAME"));
                    developer.setLastName(result.getString("DEVELOPER_LASTNAME"));
                }
            }

            List<Integer> skillsId = getSkillsIdByKey(id, connection);
            developer.setSkillIdList(skillsId);

            developer.setProjectIDSalary(getProjectIdAndSalaryByKey(id, connection));

            return Optional.of(developer);

        } catch (Exception e) {
            throw new DatabaseException(e);
        }


    }

    private List<Integer> getSkillsIdByKey(int id, Connection connection) throws SQLException {

        List<Integer> skillsId = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_SKILLS_ID)) {
            ps.setInt(1, id);
            try (ResultSet result = ps.executeQuery()) {
                while (result.next()) {
                    skillsId.add(result.getInt("skill_id"));
                }
            }
        }
        return skillsId;
    }

    private Map<Integer, Integer> getProjectIdAndSalaryByKey(int id, Connection connection) throws SQLException {

        Map<Integer, Integer> projectIdAndSalary = new HashMap<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_PROJECT_ID_AND_SALARY)) {
            ps.setInt(1, id);
            try (ResultSet result = ps.executeQuery()) {
                while (result.next()) {
                    projectIdAndSalary.put(result.getInt("project_id"), result.getInt("salary"));
                }
            }
        }
        return projectIdAndSalary;
    }


    @Override
    public Optional<Developer> update(Developer entity) {
        Optional<Developer> developer = read(entity.getId());
        try (Connection connection = ConnectionToDB.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getLastName());
                ps.setInt(3, entity.getId());
                ps.executeUpdate();

                deleteSkills(entity, connection);
                addSkillsToDeveloper_skillTable(entity, connection, entity.getId());

                deleteProjects(entity, connection);
                addDevelopersAndProjectsToDeveloper_projectTable(entity, connection, entity.getId());

                connection.commit();
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
        return developer;
    }

    private void deleteSkills(Developer entity, Connection connection) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(DELETE_SKILLS)) {
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        }
    }

    private void deleteProjects(Developer entity, Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_PROJECTS)) {
            ps.setInt(1, entity.getId());
            ps.executeUpdate();
        }
    }


    /**
     * There is CASCADE mode in DB on deleting
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Developer> getAll() {

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
             ResultSet result = ps.executeQuery()) {
            List<Developer> developers = new ArrayList<>();

            while (result.next()) {
                Developer developer = new Developer();
                Integer id = result.getInt("developer_id");
                developer.setId(id);
                developer.setName(result.getString("developer_name"));
                developer.setLastName(result.getString("developer_lastname"));

                List<Integer> skillsId = getSkillsIdByKey(id, connection);
                developer.setSkillIdList(skillsId);

                Map<Integer, Integer> projectIDSalary = getProjectIdAndSalaryByKey(id, connection);
                developer.setProjectIDSalary(projectIDSalary);

                developers.add(developer);
            }
            return developers;

        } catch (Exception e) {  //ловлю Exception, а не SQLException потому что .add может кидать много разных Exception,
            // но пользователю это не надо. Ему главное знать, что к БД не удалось обратиться.
            throw new DatabaseException(e);
        }
    }
}

