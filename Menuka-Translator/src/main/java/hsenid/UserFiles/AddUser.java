package hsenid.UserFiles;

import hsenid.DBConnector;
import hsenid.HashClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hsenid on 4/25/16.
 */
public class AddUser extends HttpServlet {

    private final static Logger logger = LogManager.getLogger(AddUser.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        logger.info("AddUser Class called");
        String firstname = request.getParameter("fname");
        String lastname = request.getParameter("lname");
        String dob = request.getParameter("date");
        dob = dob.replaceAll("/", "-");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        long mnumber =  Long.parseLong(request.getParameter("mnumber"));
        String username = request.getParameter("username");
        String password=null;

        String query = "insert into userdetails (fname, lname, dob, country, email, mnumber, username, password) values (?, ?, ?, ?, ?, ?, ?, ?)";



        DBConnector dbPool = (DBConnector)getServletContext().getAttribute("DBConnection");
        try {
            password = HashClass.SHA1(request.getParameter("password"));
            Connection myConn = dbPool.getConn();
            PreparedStatement preparedStatement = myConn.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, email);
            preparedStatement.setLong(6, mnumber);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);
            preparedStatement.executeUpdate();
            logger.info("Data insertion complete!!!");

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        out.println("First Name -> " + firstname +"<br>");
        out.println("Last Name -> " + lastname+"<br>");
        out.println("Date -> " + dob+"<br>");
        out.println("Country -> " + country+"<br>");
        out.println("Mobile -> " + mnumber+"<br>");
        out.println("email -> " + email+"<br>");
        out.println("username -> " + username+"<br>");
        out.println("Password -> " + password+"<br>");
    }
}
