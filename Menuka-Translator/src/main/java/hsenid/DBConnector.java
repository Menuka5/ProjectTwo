package hsenid;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    private static final Logger logger = LogManager.getLogger(DBConnector.class);

    /**
     * Task of this class is to create database connection using servlet context listener.
     */
    public static Connection conn; // This static so we can change value in any method


    public DBConnector(String url, String username, String password) throws IOException, SQLException {
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
            logger.info("DBConnecter connection created");

            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(data.getDbDriver());
            cpds.setJdbcUrl(data.getUrl());
            cpds.setUser(data.getDbuser());
            cpds.setPassword(data.getPassword());

            //Setting pooling configurations
            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);

        } catch (ClassNotFoundException e) { //Handling the exceptions
            logger.error("DBConnector ClassNotFoundException!!!", e);
            throw new ClassCastException();
        } catch (IOException e) {
            logger.error("DBConnector IOException!!!", e);
            throw new IOException();
        } catch (SQLException e) {
            logger.error("DBConnector SQLException", e);
        } catch (PropertyVetoException e) {
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
