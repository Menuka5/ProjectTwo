package hsenid;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class DBConnector {
    private static final Logger logger = LogManager.getLogger(DBConnector.class);
    /**
     * Task of this class is to create database connection using servlet context listener.
     */
    public static Connection conn; // This static so we can change value in any method
    ComboPooledDataSource cpds;


    public DBConnector() throws IOException, SQLException {
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
            logger.info("DBConnecter connection created");

            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(data.getDbDriver());
            cpds.setJdbcUrl(data.getUrl());
            cpds.setUser(data.getDbuser());
            cpds.setPassword(data.getPassword());

            //Setting pooling configurations
            cpds.setMinPoolSize(10);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(30);

        } catch (IOException e) {
            logger.error("DBConnector IOException!!!", e);
            throw new IOException();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() throws SQLException {
        /**
         * returning the created connection
         */
        return cpds.getConnection();
    }

}
