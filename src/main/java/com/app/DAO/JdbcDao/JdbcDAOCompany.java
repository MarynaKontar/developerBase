package com.app.DAO.JdbcDao;

import com.app.BackendException.DatabaseException;
import com.app.DAO.DAOCompany;
import com.app.Entities.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 13.06.2017.
 */
public class JdbcDAOCompany implements DAOCompany {

    private static final String CREATE_SQL = "insert into companies(company_name) value(?)";
    private static final String READ_SQL = "select * from companies where company_id=?";
    private static final String UPDATE_SQL = "update companies set company_name=? where company_id=?";
    private static final String DELETE_SQL = "delete from companies where company_id=?";
    private static final String GET_ALL_SQL = "select * from companies";

    @Override
    public void create(Company entity) {

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Company> read(int id) {

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(READ_SQL)) {
            ps.setInt(1, id);
            Company company = new Company();
            try (ResultSet result = ps.executeQuery()) {
                if (!result.next()) return Optional.empty();
                company.setId(result.getInt("COMPANY_ID"));
                company.setName(result.getString("COMPANY_NAME"));
            }
            return Optional.of(company);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }


    @Override
    public Optional<Company> update(Company entity) {
        Optional<Company> company = read(entity.getId());
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
            ps.executeUpdate();
            return company;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /**
     * when deleting company delete all company projects (set in DB)
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
    public List<Company> getAll() {

        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
             ResultSet result = ps.executeQuery()) {
            List<Company> companies = new ArrayList<>();

            while (result.next()) {
                Company company = new Company();
                company.setId(result.getInt("company_id"));
                company.setName(result.getString("company_name"));
                companies.add(company);
            }
            return companies;

        } catch (Exception e) {  //ловлю Exception, а не SQLException потому что .add может кидать много разных Exception,
            // но пользователю это не надо. Ему главное знать, что к БД не удалось обратиться.
            throw new DatabaseException(e);
        }
    }
}
