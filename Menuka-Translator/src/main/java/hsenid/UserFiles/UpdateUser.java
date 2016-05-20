package hsenid.UserFiles;

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
import java.sql.SQLException;

public class UpdateUser extends HttpServlet{
    private final static Logger logger = LogManager.getLogger(UpdateUser.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        logger.info("AddUser Class called");

        String firstname = request.getParameter("fname");
        String lastname = request.getParameter("lname");
        String dob = request.getParameter("date");
        String groupId = request.getParameter("userRole");
        dob = dob.replaceAll("/", "-");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        long mnumber = Long.parseLong(request.getParameter("mnumber"));
        String city_id = request.getParameter("states");
        String username = request.getParameter("username");;

        Connection myConn=null;
        PreparedStatement preparedStatement=null;

        String query = "UPDATE userdetails SET fname=?, lname=?, dob=?, country=?, email=?, city_id=?, mnumber=?, group_id=?  WHERE username=?;";

        DBConnector dbPool = (DBConnector) getServletContext().getAttribute("DBConnection");

        try {
            myConn = dbPool.getConn();
            preparedStatement = myConn.prepareStatement(query);

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, Integer.parseInt(city_id));
            preparedStatement.setLong(7, mnumber);
            preparedStatement.setInt(8, Integer.parseInt(groupId));
            preparedStatement.setString(9, username);
            preparedStatement.executeUpdate();
            logger.info("Update User query executed");
            request.getRequestDispatcher("UserUpdateSuccessAlert.jsp").forward(request, resp);

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

//        Check details recieve

        out.println("First Name -> " + firstname + "<br>");
        out.println("Last Name -> " + lastname + "<br>");
        out.println("Date -> " + dob + "<br>");
        out.println("Country -> " + country + "<br>");
        out.println("City -> " + city_id + "<br>");
        out.println("Mobile -> " + mnumber + "<br>");
        out.println("email -> " + email + "<br>");
        out.println("groupId -> " + groupId + "<br>");
        out.println("username -> " + username + "<br>");


    }

}
