package hsenid.UserFiles;

import hsenid.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
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
import java.util.ArrayList;

public class SearchUser extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(DBConnector.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ResultSet resultSet = null;
        ResultSet count = null;


        DBConnector dbPool = (DBConnector) getServletContext().getAttribute("DBConnection");
        Connection myConn = null;
        Connection myConn2 = null;

        try {
            myConn = dbPool.getConn();
            myConn2 = dbPool.getConn();
            String query = "SELECT fname, lname, dob, country, email, mnumber,username FROM userdetails limit 5";
            String query2 = "SELECT COUNT(*) as total FROM userdetails";
            PreparedStatement preparedStatement = myConn.prepareStatement(query);
            PreparedStatement countStatement = myConn2.prepareStatement(query2);

            resultSet = preparedStatement.executeQuery();
            count = countStatement.executeQuery();

//            logger.info(countVal);

            ArrayList users = new ArrayList();
            ArrayList dob = new ArrayList();
            ArrayList country = new ArrayList();
            ArrayList email = new ArrayList();
            ArrayList usernames = new ArrayList();
            ArrayList mobile = new ArrayList();


            while (resultSet.next()) {
                users.add(resultSet.getString("fname") + " " + resultSet.getString("lname"));
                dob.add(resultSet.getString("dob"));
                country.add(resultSet.getString("country"));
                email.add(resultSet.getString("email"));
                usernames.add(resultSet.getString("username"));
                mobile.add(resultSet.getString("mnumber"));
            }

            request.setAttribute("name", users);
            request.setAttribute("dob", dob);
            request.setAttribute("country", country);
            request.setAttribute("email", email);
            request.setAttribute("username", usernames);
            request.setAttribute("mnumber", mobile);
//            request.setAttribute("count", countVal);

            RequestDispatcher view = request.getRequestDispatcher("/SearchUser.jsp");
            view.forward(request, resp);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                myConn.close();
//                myConn2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        /*try {

            myConn = dbPool.getConn();


            PreparedStatement preparedStatement = myConn.prepareStatement(query2);
            count = preparedStatement.executeQuery();
            System.out.println(count.getInt(1));


        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
