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
    public static Connection myConn;


    public LoginCheck() throws IOException, SQLException {
        try {
            PropertyHandle dbData = new PropertyHandle();
            DBConnector mine = new DBConnector(dbData.getUrl(), dbData.getDbuser(), dbData.getPassword());
            this.myConn = mine.getConn();
            logger.info("LoginCheck, Connection stabilised!!");

        } catch (IOException e) {
            logger.error("LoginCheck, IOException!!", e);
            throw new IOException();
        } catch (SQLException e) {
            logger.error("LoginCheck, SQLException!!", e);
            throw new SQLException();
        }

    }

    public boolean checking(String uName, String pWord) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {

        logger.info("LoginCheck, Checking Login Credentials");
        logger.error("Error Test LoginCheck.java");
        ResultSet rs = null;

        String hashedPass = HashClass.SHA1(pWord);
        PreparedStatement pst = myConn.prepareStatement("select * from users where username=? and password=?");
        pst.setString(1, uName);
        pst.setString(2, hashedPass);
        rs = pst.executeQuery();

        return rs.next();
    }

}
