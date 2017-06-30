package com.app.DAO.JdbcDao.JdbcDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 04.06.2017.
 */
public class ConnectionToDB {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionToDB.class);

//    private static final String url = "jdbc:postgresql://localhost:5432/homework_1";
//    private static final String username = "postgres";
//    private static final String password = "123581321lL";
//    private static final String driver = "org.postgresql.Driver";


    private static final String url = "jdbc:mysql://localhost:3306/homework_1?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "123581321lL";
    private static final String driver = "com.mysql.jdbc.Driver";

    //        static {
//        try {
//            LOGGER.info("Loading jdbc driver: " + driver);
//            Class.forName(driver);
//            LOGGER.info("Driver loaded successfully.");
//        } catch (ClassNotFoundException e) {
//            LOGGER.error("Cannot find driver: " + driver);
//            throw new NotFoundDBDriverException(e);
//        }
//    }

    protected static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }


//
//    //TODO 2 Зачем в этом методе ловить исключение и возвращать null? Если не будет connection все равно дальше работать не будем.
//    //Может кидать это исключение наверх и там "оборачивать"  в пользовательский exception?
//    public static Connection getConnection() {
//        Connection connection = null;
//
//        //TODO 1 Нормально расставила логгеры?
//        try {
//            LOGGER.info("Getting connection to DB: " + url);
//            connection = DriverManager.getConnection(url, username, password);
//            LOGGER.info("Successfully connected to DB.");
//            if (connection != null) {
//                return connection;
//            }
//        } catch (SQLException e) {
////            LOGGER.error("Exception occurred while connecting to DB: " + url, e);
//            throw new ConnectToDBException(e);
//        }
//        return connection;
//    }

}
