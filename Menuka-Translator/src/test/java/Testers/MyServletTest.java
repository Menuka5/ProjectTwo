package Testers;

import hsenid.MyServlet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by hsenid on 3/30/16.
 */
public class MyServletTest {

    @BeforeMethod
    public void setUp() throws Exception {
        MyServlet test1 = new MyServlet();

    }

    @Test
    public void testDoGet() throws Exception {

    }
}