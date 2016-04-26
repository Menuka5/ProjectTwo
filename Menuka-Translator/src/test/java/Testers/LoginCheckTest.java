package Testers;

import hsenid.DBConnector;
import hsenid.LoginCheck;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hsenid on 3/30/16.
 */
public class LoginCheckTest {
    DBConnector aTestConn;

    public LoginCheckTest() throws IOException, SQLException {
        aTestConn = new DBConnector();
    }

    @DataProvider(name = "objectTestData")
    public static Object[][] objectTestData() {
        return new Object[][]{
                {new TestData("test", "test123", true)},
                {new TestData("Sloth", "Baby", false)},
                {new TestData("test", "", false)},
                {new TestData("", "test123", false)},
                {new TestData("", "", false)},
                {new TestData("vbcxv", "", false)},
                {new TestData("", "bfgs", false)},
                {new TestData("test", "dsfaw", false)},
                {new TestData("edsdf", "test123", false)}

        };
    }

    @Test(dataProvider = "objectTestData")
    public void testChecking(TestData tst) throws Exception {
        String uname = tst.get(0);
        String pword = tst.get(1);
        boolean val = tst.getStatus();

        LoginCheck checkin = new LoginCheck(aTestConn.getConn());

        Assert.assertEquals(checkin.checking(uname, pword), val);

    }

}

class TestData {
    public String[] items;
    public Boolean status;


    public TestData(String x, String y, boolean z) {
        this.items = new String[]{x, y}; // should probably make a defensive copy
        this.status = z;
    }

    public String get(int x) {
        return items[x];
    }

    public Boolean getStatus() {
        return status;
    }

}