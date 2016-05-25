package hsenid.UserFiles.Permissions;

import hsenid.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PermissionsSender extends HttpServlet{
    private final static Logger logger = LogManager.getLogger(PermissionsSender.class);
    public static Connection myConn;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    public ArrayList<String> sendPermissions(String username){
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String quary= "SELECT permission FROM userdetails INNER JOIN group_permission ON userdetails.group_id = group_permission.group_id INNER JOIN permissions ON permissions.permission_id = group_permission.permission_id WHERE userdetails.username = ?";
        ArrayList<String> permissions = new ArrayList<String>();


        try {
            myConn = DBConnector.cpds.getConnection();
            preparedStatement = myConn.prepareStatement(quary);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                permissions.add(resultSet.getString("permission"));
            }

//            logger.error(permissions.size() + " Size worked!");

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {

            if (myConn != null){
                try {
                    myConn.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }

            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }

            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }

        return permissions;
    }


}
