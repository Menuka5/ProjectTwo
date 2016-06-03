package hsenid.UserFiles;

import hsenid.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsernameChecker extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(UsernameChecker.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String username = req.getParameter("searchword");
        DBConnector dbpool = (DBConnector) getServletContext().getAttribute("DBConnection");
        JSONObject jsonObject = new JSONObject();

        Connection myConn = null;
        try {
            myConn = dbpool.getConn();
            String likeQuery = "Select * from userdetails WHERE username=?";
            preparedStatement = myConn.prepareStatement(likeQuery);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            jsonObject.put("boolVal", resultSet.next());


        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            if (myConn != null) {
                try {
                    myConn.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }

        out.print(jsonObject);
        out.flush();

    }
}
