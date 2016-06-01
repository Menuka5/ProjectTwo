package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by hsenid on 6/1/16.
 */
public class TestTestCase {
    public WebDriver driver;
    @BeforeTest
    public void setFireFox(){
        driver = new FirefoxDriver();
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void verifyHomePageTitle(){
        String expectedTitle = "Wikipedia";
        String actualTitle =  driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void closeFireFox(){
        driver.close();
    }
}
