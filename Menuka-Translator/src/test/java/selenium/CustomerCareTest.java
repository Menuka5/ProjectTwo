package selenium;

import hsenid.PropertyHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CustomerCareTest {

    PropertyHandle getUrl;
    WebDriver driver;

    public CustomerCareTest() throws IOException {
        getUrl = new PropertyHandle();
    }

    @BeforeTest
    public void starBrowser() {
        driver = new FirefoxDriver();
        driver.get(getUrl.getSeleniumUrl());
    }

    @DataProvider(name = "CustomerCareLogins")
    public Object[][] sendCustomerCare() {

        return new Object[][]{
                {"hulk", "hulk"},
                {"testalert", "test"},
                {"gfdgsdfawer", "1234"},
                {"refactor2", "test"}
//                {"help", "help"}
        };

    }

    @Test(dataProvider = "CustomerCareLogins")
    public void checkTranslator(String username, String password) {


        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

        usernameClear.sendKeys(username);
        passwordClear.sendKeys(password);

        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        WebElement Translator = driver.findElement(By.id("Translate"));
        boolean ttt = Translator.isDisplayed();

        Assert.assertTrue(ttt);
        driver.get(getUrl.getSeleniumUrl());
    }


    @Test(dataProvider = "CustomerCareLogins")
    public void checkUserSearch(String username, String password) throws InterruptedException {
        String expectedTitle = "Search a User";
        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

        usernameClear.sendKeys(username);
        passwordClear.sendKeys(password);

        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        WebElement userManagement = driver.findElement(By.className("dropdown-toggle"));
        userManagement.click();

        WebElement searchUser = driver.findElement(By.id("searchuser"));
        searchUser.click();
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.get(getUrl.getSeleniumUrl());
    }


    @Test(dataProvider = "CustomerCareLogins")
    public void userSearch(String username, String password) throws InterruptedException {
        String expectedTitle = "Search a User";
        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

        usernameClear.sendKeys(username);
        passwordClear.sendKeys(password);

        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement userManagement = driver.findElement(By.className("dropdown-toggle"));
        userManagement.click();
//        Thread.sleep(1000);
        WebElement searchUser = driver.findElement(By.id("searchuser"));
        searchUser.click();
//        Thread.sleep(1000);

        WebElement searchName = driver.findElement(By.id("search"));
        searchName.clear();
        searchName.sendKeys("test");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement search = driver.findElement(By.id("bn1"));
        search.click();
        search.click();

        driver.get(getUrl.getSeleniumUrl());


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
