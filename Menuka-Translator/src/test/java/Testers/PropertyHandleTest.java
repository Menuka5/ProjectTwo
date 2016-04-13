package Testers;

import hsenid.PropertyHandle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by hsenid on 4/1/16.
 */
public class PropertyHandleTest {
    String url, user, password;

    @BeforeTest
    public void setUp() throws Exception {
        PropertyHandle testObj = new PropertyHandle();
        url = testObj.getUrl();
        user = testObj.getDbuser();
        password = testObj.getPassword();

    }

    @Test
    public void testGetUrl() throws Exception {
        Assert.assertEquals(url, "jdbc:mysql://localhost:3306/hsenid");

    }

    @Test
    public void testGetDbuser() throws Exception {
        Assert.assertEquals(user, "root");
    }

    @Test
    public void testGetPassword() throws Exception {
        Assert.assertEquals(password, "root");
    }
}