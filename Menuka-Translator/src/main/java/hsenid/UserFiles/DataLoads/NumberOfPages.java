package hsenid.UserFiles.DataLoads;

import hsenid.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

public class NumberOfPages extends HttpServlet{

    private static final Logger logger = LogManager.getLogger(NumberOfPages.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String countQuery = "SELECT COUNT(username) as count FROM userdetails";
        Connection myConn = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;

        try {
            myConn = DBConnector.cpds.getConnection();
            preparedStatement = myConn.prepareStatement(countQuery);
            resultSet = preparedStatement.executeQuery();
            String numberOfRecords;

            if(resultSet.next()){
                numberOfRecords = resultSet.getString("count");
                out.println((int)Math.ceil(Double.parseDouble(numberOfRecords)/10));
                out.flush();
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

    }
}
