package com.app.DAO;

import com.app.Entities.Developer;

import java.sql.*;
import java.util.List;

import static com.app.DAO.ConnectionToDB.getConnection;

/**
 * Created by User on 12.06.2017.
 */
public class DAODeveloperImpl implements DAODeveloper {

    @Override
    public void create(Developer entity) {
        try (Connection connection = getConnection();
//    Statement statement = connection.createStatement()
             PreparedStatement ps = connection.prepareStatement("INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) VALUES(?, ?)")
        ) {
//    String sql = "INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) VALUES('"+entity.getName()+"', '"+entity.getLastName()+"')";
//    statement.execute(sql);

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLastName());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Developer read(long id) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM developers WHERE DEVELOPER_ID=?")) {
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            Developer developer = new Developer();
            while (result.next()) {
                developer.setId(result.getLong("DEVELOPER_ID"));
                developer.setName(result.getString("DEVELOPER_NAME"));
                developer.setLastName(result.getString("DEVELOPER_LASTNAME"));
            }
return developer;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Developer update(Developer entity) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }
}
