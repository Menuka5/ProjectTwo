package hsenid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private final static Logger logger = LogManager.getLogger(MyListener.class);

    /**
     * When Web app starts the MyListener works
     * Then contextInitialized method invokes.
     */
    public void contextInitialized(ServletContextEvent event) {
        logger.info("Servlet Context Listener Initialised");

        ServletContext context = event.getServletContext();
        String url = context.getInitParameter("dburl");


        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        DBConnector db = null; // Here we Created the Database connection
        try {
            db = new DBConnector(url, username, password);
            context.setAttribute("Database", db); //We use this method because we can use it another class (The Added attribute)
            logger.trace("DBConnection created!!!");
            
        } catch (IOException e) {
            logger.error("MyListener IOException !!!", e);
        } catch (SQLException e) {
            logger.error("MyListener SQLException !!!", e);
        }


    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}
