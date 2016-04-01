package hsenid;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hsenid on 3/23/16.
 */
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                HttpSession session = req.getSession(false);
                if (session != null){
                    session.invalidate();
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            } catch (ServletException e) {
               throw new ServletException();
            } catch (IOException e) {
                throw new IOException();
            }


    }
}
