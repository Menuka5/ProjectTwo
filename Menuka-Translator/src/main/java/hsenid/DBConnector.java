package hsenid;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnector {

    /**
     * Task of this class is to create database connection using servlet context listener.
     *
     */
    public static Connection conn; // This static so we can change value in any method


    public DBConnector(String url, String username, String password) {
        /**
         * @param url
         * This is the database url of the connection
         * @param username
         * Username of the database
         * @param password
         * password of particular database user given above
         */

        try {
            PropertyHandle data = new PropertyHandle();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(data.getUrl(), data.getDbuser(), data.getPassword()); // creating the db connection

        } catch (ClassNotFoundException e) { //Handling the exceptions
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        /**
         * returning the created connection
         */
        return conn;
    }
}
