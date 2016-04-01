package hsenid;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck {
    public static Connection myConn;


    public LoginCheck() throws IOException, SQLException {
        try {
            PropertyHandle dbData = new PropertyHandle();
            DBConnector mine = new DBConnector(dbData.getUrl(), dbData.getDbuser(), dbData.getPassword());
            this.myConn = mine.getConn();

        } catch (IOException e) {
            throw new IOException();
        } catch (SQLException e) {
            throw new SQLException();
        }

    }

    public boolean checking(String uName, String pWord) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        ResultSet rs = null;

        String hashedPass = HashClass.SHA1(pWord);
        PreparedStatement pst = myConn.prepareStatement("select * from users where username=? and password=?");
        pst.setString(1, uName);
        pst.setString(2, hashedPass);
        rs = pst.executeQuery();
//        System.out.println(hashedPass);

        return rs.next();
    }

 /*   public static void main(String[] args) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {

        LoginCheck test = new LoginCheck();
//        test.checking();
        if (test.checking("test", "test123")) {
            System.out.println("Worked");
        } else {
            System.out.println("awla");
        }
    }*/

}
