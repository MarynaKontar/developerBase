package com.app.DAO.JdbcDao.JdbcDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.JdbcDao.DAOCustomer;
import com.app.Entities.Customer;

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
public class JdbcDAOCustomer implements DAOCustomer {


    private static final String CREATE_SQL = "insert into customers(customer_name) value(?)";
    private static final String READ_SQL = "select * from customers where customer_id=?";
    private static final String UPDATE_SQL = "update customers set customer_name=? where customer_id=?";
    private static final String DELETE_SQL = "delete from customers where customer_id=?";
    private static final String GET_ALL_SQL = "select * from customers";


    @Override
    public void create(Customer entity) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Customer> read(int id) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(READ_SQL)) {
            ps.setInt(1, id);
            Customer customer = new Customer();
            try (ResultSet result = ps.executeQuery()) {
                if (!result.next()) return Optional.empty();
                customer.setId(result.getInt("CUSTOMER_ID"));
                customer.setName(result.getString("CUSTOMER_NAME"));
            }
            return Optional.of(customer);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Customer> update(Customer entity) {
        Optional<Customer> customer = read(entity.getId());
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
            ps.executeUpdate();
            return customer;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /**
     * when deleting set null customer_id (set in DB)
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
    public List<Customer> getAll() {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
             ResultSet result = ps.executeQuery()) {
            List<Customer> customers = new ArrayList<>();

            while (result.next()) {
                Customer customer = new Customer();
                customer.setId(result.getInt("customer_id"));
                customer.setName(result.getString("customer_name"));
                customers.add(customer);
            }
            return customers;

        } catch (Exception e) {  //ловлю Exception, а не SQLException потому что .add может кидать много разных Exception,
            // но пользователю это не надо. Ему главное знать, что к БД не удалось обратиться.
            throw new DatabaseException(e);
        }
    }

}
