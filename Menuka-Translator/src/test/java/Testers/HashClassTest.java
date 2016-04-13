package Testers;

import hsenid.HashClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HashClassTest {

    @DataProvider(name = "test1")
    public static Object[][] testHashData() {
        return new Object[][]{{"test", "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"}, {"5678", "2abd55e001c524cb2cf6300a89ca6366848a77d5"}, {"12345", "8cb2237d0679ca88db6464eac60da96345513964"}, {"^&(()**&%$#&()", "fd04af6813cf8f853d5211a220a9e945635141da"}, {"^&%()_()(**74758938", "3dfc3c042e4a1df63b3fa7f2bd022da4c991e60d"}, {"&*^$%##$%2124e34fvhsdvbnfvj", "3015dce9aed24d31efdb0441457fb2747d1da5df"}};
    }

    @Test(dataProvider = "test1")
    public void testSHA1(String testHashValue, String Hashof) throws Exception {
//        String testHashValue = "Menuka";
//        String Hashof = "d6bda902b3223e85ccb9f7e4095d11282e682e2a";


        Assert.assertEquals(HashClass.SHA1(testHashValue), Hashof);


    }
}