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

public class SearchUser extends HttpServlet{
    private static final Logger logger = LogManager.getLogger(DBConnector.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ResultSet resultSet=null;

        DBConnector dbPool = (DBConnector)getServletContext().getAttribute("DBConnection");

        try {
            Connection myConn = dbPool.getConn();
            Connection myConn2 = dbPool.getConn();
            String query = "SELECT fname, lname, dob, country, email, mnumber,username FROM userdetails";
            PreparedStatement preparedStatement = myConn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            ArrayList users = new ArrayList();
            ArrayList dob = new ArrayList();
            ArrayList country = new ArrayList();
            ArrayList email = new ArrayList();
            ArrayList usernames = new ArrayList();
            ArrayList mobile = new ArrayList();


            while (resultSet.next()){
                users.add(resultSet.getString("fname") + " " +resultSet.getString("lname"));
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

            RequestDispatcher view = request.getRequestDispatcher("/SearchUser.jsp");
            view.forward(request, resp);


         /*   out.println("<br>");

            for (int i = 0; i < users.size(); i++) {
                out.println(users.get(i) +" " + dob.get(i) +" " + country.get(i) +" " + email.get(i) +" " + mobile.get(i)+" " +usernames.get(i) + "<br>");
            }*/

/*
            usernames = new String[userCount];
            out.println(userCount);

            int i=0;
            while (resultSet.next()){

                out.println(resultSet.getString("fname") + "<br>");

                usernames[i] = resultSet.getString("fname");


                i++;
            }
*/

      /*      for (String x : usernames){
                out.println("Size of array -> " + x +"<br>");
            }*/


        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
