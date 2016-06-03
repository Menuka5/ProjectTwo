package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlockedUserTest {

    WebDriver driver;

    @DataProvider(name = "LoginCredentials")
    public static Object[][] correctLogins() {
        return new Object[][]{
                {"blocked", "blocked"},
                {"test1", "aaa"},
                {"datepicker", "123"}
        };
    }

    @BeforeTest
    public void starBrowser() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Menuka-Translator/");
    }

    @Test(dataProvider = "LoginCredentials", priority = 1)
    public void LoginPageTest(String username, String password) throws InterruptedException {

        String expectedTitle = "Access Denied";

        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

//        Thread.sleep(1000);

        WebElement usernameSet = driver.findElement(By.name("username"));
        usernameSet.sendKeys(username);

        WebElement passwordSet = driver.findElement(By.name("password"));
        passwordSet.sendKeys(password);

//        Thread.sleep(1000);
        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        Assert.assertEquals(expectedTitle, driver.getTitle());
        driver.get("http://localhost:8080/Menuka-Translator/");
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
