package hsenid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck {
    private static final Logger logger = LogManager.getLogger(LoginCheck.class);
    public Connection myConn;


    public LoginCheck(Connection DBConn) throws IOException, SQLException {
        this.myConn = DBConn;
        logger.info("LoginCheck, Connection stabilised!!");

    }

    public boolean checking(String uName, String pWord) {

        logger.info("LoginCheck, Checking Login Credentials");
        boolean returnValur = false;
        ResultSet rs;
        ResultSet resultSet=null;
        PreparedStatement preparedStatement;


        try {
            String hashedPass = HashClass.SHA1(pWord);
            PreparedStatement pst = myConn.prepareStatement("select * from userdetails where username=? and password=?");
            pst.setString(1, uName);
            pst.setString(2, hashedPass);
            rs = pst.executeQuery();
            returnValur = rs.next();
            logger.info("Loging Check has completed.");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                myConn.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }

        return returnValur;

    }

}
