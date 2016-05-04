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


public class AllData extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(AllData.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String username = req.getParameter("searchword");
        DBConnector dbpool = (DBConnector) getServletContext().getAttribute("DBConnection");
        JSONArray jsonArray = new JSONArray();
//        JsonArray jsonArray = new JsonArray();
        logger.info(username);
        try {
            Connection myConn = dbpool.getConn();
            String likeQuery = "SELECT * FROM userdetails";
            preparedStatement = myConn.prepareStatement(likeQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();
//                JsonObject jsonObject = new JsonObject();
                jsonObject.put("firstName", resultSet.getString("fname"));
                logger.info(resultSet.getString("fname"));
                jsonObject.put("lastName", resultSet.getString("lname"));
                jsonObject.put("dob", resultSet.getString("dob"));
                jsonObject.put("country", resultSet.getString("country"));
                jsonObject.put("email", resultSet.getString("email"));
                jsonObject.put("mobile", resultSet.getString("mnumber"));
                jsonObject.put("username", resultSet.getString("username"));

                jsonArray.put(jsonObject);

            }
            logger.info("JSON ARRAY Created");

            logger.info(jsonArray.toString());

//            resp.getWriter().write(jsonArray.toString());
            out.print(jsonArray);
            out.flush();

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
