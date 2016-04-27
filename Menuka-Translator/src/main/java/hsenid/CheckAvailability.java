package hsenid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CheckAvailability extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CheckAvailability.class);
    private static final long serialVersionUID = -734503860925086969L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            logger.info("Check availability called");
            DBConnector dbPool = (DBConnector)getServletContext().getAttribute("DBConnection");
            Connection myConn = dbPool.getConn();

           /* String connectionURL = "jdbc:mysql://localhost:3306/students"; // students is my database name
            Connection connection;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "password");*/


            String uname = request.getParameter("uname");

            PreparedStatement ps = myConn.prepareStatement("select username from userdetails where username=?");
            ps.setString(1,uname);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                out.println("<font color=green><b>"+uname+"</b> is avaliable</font>");

                logger.info("Username detected!!!");
            }
            else{
                out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
            }
            out.println();

        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}