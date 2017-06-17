package com.app.DAO.JdbcDao;

import com.app.BackendException.DatabaseException;
import com.app.DAO.DAOCompany;
import com.app.Entities.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by User on 13.06.2017.
 */
public class JdbcDAOCompany implements DAOCompany{

    private static final String READ_SQL = "select * from companies where company_id=?";
    private static final String CREATE_SQL = "insert into companies(company_name) value(?)";
    private static final String UPDATE_SQL = "update companies set company_name=?, developer_lastname=?, where company_id=?";
    private static final String DELETE_SQL = "delete from companies where company_id=?";


    @Override
    public void create(Company entity) {

        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(CREATE_SQL) ) {
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Company> read(int id) {
        try(Connection connection = ConnectionToDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(READ_SQL) ) {
            ps.setInt(1, id);
        try(ResultSet result = ps.executeQuery()){
            
        }

        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        return null;
    }

    @Override
    public Company update(Company entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Company> getAll() {
        return null;
    }
}
