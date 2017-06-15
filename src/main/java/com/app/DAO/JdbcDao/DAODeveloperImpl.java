package com.app.DAO.JdbcDao;

import com.app.BackendException.DatabaseException;
import com.app.DAO.DAODeveloper;
import com.app.Entities.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 12.06.2017.
 */
public class DAODeveloperImpl implements DAODeveloper {

    private static final String READ_SQL = "select * from developers where developer_id=?";
    private static final String CREATE_SQL = "insert into developers(developer_name, developer_lastname) values(?, ?, ?)";
    private static final String UPDATE_SQL = "update developers set developer_name=?, developer_lastname=?, where developer_id=?";
    private static final String DELETE_SQL = "delete from developers where developer_id=?";
    private static final String ADD_SKILLS = "insert into developer_skill(developer_id, skill_id) values(?, ?)";
    private static final String ADD_PROJECTS = "insert into developer_poject(developer_id, project_id) values(?, ?)";
    private static final String SELECT_SKILLS_ID = "select skill_id from developer_skill where developer_id=?";

    @Override
    public void create(Developer entity) {
        try (Connection connection = ConnectionToDB.getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(CREATE_SQL)) {
                ps.setString(1, entity.getName());
                ps.setString(2, entity.getLastName());
                ps.executeUpdate();
            }

            addSkillsToDeveloper_skillTable(entity, connection);
//            addDevelopersAndProjectsToDeveloper_projectTable(entity, connection);


        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    private void addSkillsToDeveloper_skillTable(Developer entity, Connection connection) throws SQLException {
        List<Integer> skillsId = entity.getSkillIdList();
        for (Integer skillId : skillsId) {
            try (PreparedStatement ps = connection.prepareStatement(ADD_SKILLS)) {
                ps.setInt(1, entity.getId()); //TODO У меня еще нет id в entity (id автоматически создается в БД)
                ps.setInt(2, skillId);
                ps.executeUpdate();
            }
        }
    }

    private void addDevelopersAndProjectsToDeveloper_projectTabl(Developer entity, Connection connection) throws SQLException {

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

            //добавить Map<Integer, Integer> projectIDSalary

            return Optional.of(developer);

        } catch (SQLException e) {
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

    @Override
    public Developer update(Developer entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public boolean deleteByKey(int id) {
        return false;
    }
}
