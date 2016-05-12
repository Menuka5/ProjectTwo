package hsenid.UserFiles;

import hsenid.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
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

public class SendUserRole extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(SendUserRole.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBConnector dbpool = (DBConnector) getServletContext().getAttribute("DBConnection");
        JSONArray jsonArray = new JSONArray();

        Connection myConn = null;

        try {
            myConn = dbpool.getConn();
            String query = "SELECT * FROM group_name";

            preparedStatement = myConn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();

                jsonObject.put("group_id", resultSet.getString("group_id"));
                jsonObject.put("group_name", resultSet.getString("group_name"));

                jsonArray.put(jsonObject);

            }
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

        out.print(jsonArray);
        out.flush();

    }
}
