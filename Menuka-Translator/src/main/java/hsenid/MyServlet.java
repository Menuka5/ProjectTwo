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
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html"); // Set output as html

        PreparedStatement pst = null;
        ResultSet rs = null;
        Boolean status = false;


        // Getting parameters
        // from index.jsp
        HashClass Hashing = new HashClass();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            RequestDispatcher view = request.getRequestDispatcher("/translate.jsp");


            try {

                request.setAttribute("Error", "You haven't provide valid username or Password!!! ");
                LoginCheck statusVal = new LoginCheck();
                status = statusVal.checking(username, password);

                if (status) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    view.forward(request, resp);


                } else {
                    request.getRequestDispatcher("/index.jsp").forward(request, resp);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new IOException();
        } catch (ServletException e) {
            throw new ServletException();
        }

    }
}
