package hsenid;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This is my ServletContextListener class
 * I've entered the database parameters to web.xml
 */
public class MyListener implements ServletContextListener {

    /**
     * When Web app starts the MyListener works
     * Then contextInitialized method invokes.
     */
    public void contextInitialized(ServletContextEvent event) {

        ServletContext context = event.getServletContext();
        String url = context.getInitParameter("dburl");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        DBConnector db = null; // Here we Created the Database connection
        try {
            db = new DBConnector(url, username, password);
            context.setAttribute("Database", db); //We use this method because we can use it another class (The Added attribute)
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}
