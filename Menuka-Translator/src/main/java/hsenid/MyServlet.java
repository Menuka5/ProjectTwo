package hsenid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is the servlet class
 */

public class MyServlet extends HttpServlet {
    private final static Logger logger = LogManager.getLogger(MyServlet.class);

    /**
     * @param request
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html"); // Set output as html

        PreparedStatement pst = null;
        ResultSet rs = null;
        Boolean status = false;
        Connection myConn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;


        // Getting parameters
        // from index.jsp
        HashClass Hashing = new HashClass();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            logger.info("received the credentials from the index.jsp ");
            RequestDispatcher view = request.getRequestDispatcher("/translate.jsp");
            DBConnector dbPool = (DBConnector) getServletContext().getAttribute("DBConnection");

            try {

                request.setAttribute("Error", "You haven't provide valid username or Password!!! ");
                LoginCheck statusVal = new LoginCheck(dbPool.getConn());
                status = statusVal.checking(username, password);

                if (status) {
                    logger.info("Access granted to the Traslator page");

                    myConn = dbPool.getConn();
                    String query = "select group_id from userdetails where username=? ";
                    preparedStatement = myConn.prepareStatement(query);
                    preparedStatement.setString(1, username);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()){
                        logger.error("Blocked User Entered ");
                            String group_id = resultSet.getString("group_id");
                            if (group_id.equals("4")){
                                logger.error("User's Access is denied");
                                request.getRequestDispatcher("/BlockedUserAlert.jsp").forward(request, resp);
                            }
                    }

                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);
                    view.forward(request, resp);

                } else {
                    logger.error("Illegal credentials provided, login failed!");
                    request.getRequestDispatcher("/index.jsp").forward(request, resp);
                }

            } catch (SQLException e) {
                logger.error(e.getMessage());

            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (ServletException e) {
            logger.error(e.getMessage());
        }

    }
}
