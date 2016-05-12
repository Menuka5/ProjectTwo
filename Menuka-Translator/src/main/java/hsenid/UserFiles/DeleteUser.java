package hsenid.UserFiles;

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
import java.sql.SQLException;

public class DeleteUser extends HttpServlet{

    private static final Logger logger = LogManager.getLogger(DeleteUser.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement preparedStatement = null;
        Connection myConn=null;
        String username = req.getParameter("delete");
        DBConnector dbpool = (DBConnector) getServletContext().getAttribute("DBConnection");
        logger.info(username);

        try {
            myConn = dbpool.getConn();

            String deleteQuery = "DELETE FROM userdetails WHERE username=?";
            preparedStatement = myConn.prepareStatement(deleteQuery);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            logger.info("Reached the User Deletion");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }

            if (myConn != null){
                try {
                    myConn.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
