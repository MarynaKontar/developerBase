package com.app.DAO.JdbcDao.JdbcDaoImpl;

import com.app.BackendException.DatabaseException;
import com.app.DAO.JdbcDao.DAOSkill;
import com.app.Entities.Skill;

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
public class JdbcDAOSkill implements DAOSkill {

    private static final String CREATE_SQL = "insert into skills(skill_name) value(?)";
    private static final String READ_SQL = "select * from skills where skill_id=?";
    private static final String UPDATE_SQL = "update skills set skill_name=? where skill_id=?";
    private static final String DELETE_SQL = "delete from skills where skill_id=?";
    private static final String GET_ALL_SQL = "select * from skills";


    @Override
    public void create(Skill entity) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Skill> read(int id) {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(READ_SQL)) {
            ps.setInt(1, id);
            Skill skill = new Skill();
            try (ResultSet result = ps.executeQuery()) {
                if (!result.next()) return Optional.empty();
                skill.setId(result.getInt("SKILL_ID"));
                skill.setName(result.getString("SKILL_NAME"));
            }
            return Optional.of(skill);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Optional<Skill> update(Skill entity) {

        Optional<Skill> skill = read(entity.getId());
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
            ps.executeUpdate();
            return skill;
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
    public List<Skill> getAll() {
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
             ResultSet result = ps.executeQuery()) {
            List<Skill> skills = new ArrayList<>();

            while (result.next()) {
                Skill skill = new Skill();
                skill.setId(result.getInt("SKILL_ID"));
                skill.setName(result.getString("SKILL_NAME"));
                skills.add(skill);
            }
            return skills;

        } catch (Exception e) {  //ловлю Exception, а не SQLException потому что .add может кидать много разных Exception,
            // но пользователю это не надо. Ему главное знать, что к БД не удалось обратиться.
            throw new DatabaseException(e);
        }
    }
}

