package com.app.DAO.JdbcDao;

import com.app.BackendException.DatabaseException;
import com.app.DAO.DAOProject;
import com.app.Entities.Customer;
import com.app.Entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 18.06.2017.
 */
public class JdbcDAOProject implements DAOProject {

    private static final String CREATE_SQL = "insert into projects(project_name, project_cost, company_id, customer_id) values(?, ?, ?, ?)";
    private static final String READ_SQL = "select * from projects where project_id=?";
    private static final String UPDATE_SQL = "update projects set project_name=?, project_cost=?, company_id=?, customer_id=? where project_id=?";
    private static final String DELETE_SQL = "delete from projects where project_id=?";
    private static final String GET_ALL_SQL = "select * from projects";


    @Override
    public void create(Project entity) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getCost());
            ps.setInt(3, entity.getCompanyId());
            ps.setInt(4, entity.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Project> read(int id) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(READ_SQL)) {
            ps.setInt(1, id);
            Project project = new Project();
            try (ResultSet result = ps.executeQuery()) {
                if (!result.next()) return Optional.empty();
                project.setId(result.getInt("PROJECT_ID"));
                project.setName(result.getString("PROJECT_NAME"));
                project.setCost(result.getInt("PROJECT_COST"));
                project.setCost(result.getInt("COMPANY_ID"));
                project.setCost(result.getInt("CUSTOMER_ID"));
            }
            return Optional.of(project);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Project> update(Project entity) {
        Optional<Project> project = read(entity.getId());
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getCost());
            ps.setInt(3, entity.getCompanyId());
            ps.setInt(4, entity.getCustomerId());
            ps.setInt(5, entity.getId());
            ps.executeUpdate();
            return project;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

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
    public List<Project> getAll() {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
             ResultSet result = ps.executeQuery()) {
            List<Project> projects = new ArrayList<>();

            while (result.next()) {
                Project project = new Project();
                project.setId(result.getInt("PROJECT_ID"));
                project.setName(result.getString("PROJECT_NAME"));
                project.setCost(result.getInt("PROJECT_COST"));
                project.setCompanyId(result.getInt("COMPANY_ID"));
                project.setCustomerId(result.getInt("CUSTOMER_ID"));
                projects.add(project);
            }
            return projects;

        } catch (Exception e) {  //ловлю Exception, а не SQLException потому что .add может кидать много разных Exception,
            // но пользователю это не надо. Ему главное знать, что к БД не удалось обратиться.
            throw new DatabaseException(e);
        }
    }
}
