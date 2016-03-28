package hsenid;

import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is the servlet class
 */

public class MyServlet extends HttpServlet {
    /**
     * @param request
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) {
        resp.setContentType("text/html"); // Set output as html

        PreparedStatement pst = null;
        ResultSet rs = null;
        Boolean status = false;
        String username = request.getParameter("username");

        // Getting parameters
        // from index.jsp
        HashClass Hashing = new HashClass();
        try {
            String password = Hashing.SHA1(request.getParameter("password"));

            RequestDispatcher view = request.getRequestDispatcher("/translate.jsp");


            try {
                DBConnector mydata = (DBConnector) getServletContext().getAttribute("Database"); // Receive the DBConnector object created in MyListener class

                Connection myconn = mydata.getConn();// Receiving the connection
                pst = myconn.prepareStatement("select * from users where username=? and password=?");
                Mapping data1 = new Mapping();
                String[] names = {"Menuka", "Ishan"};

//                Setting attributes which want to send to index.jsp in case of wrong authentications given
                request.setAttribute("name", names);
                request.setAttribute("Error", "You haven't provide valid username or Password!!! ");
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery(); // executing the query
                status = rs.next();

                if (status) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    view.forward(request, resp);


                } else {
                    request.getRequestDispatcher("/index.jsp").forward(request, resp);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
