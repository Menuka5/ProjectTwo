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

public class LoginPageTest {
    WebDriver driver;

    @BeforeTest
    public void starBrowser() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Menuka-Translator/");
    }

    @Test(priority = 0)
    public void testTitle() {
        String expectedTitle = "Translator Login Page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
//        driver.close();
    }

    @DataProvider(name = "LoginCredentials")
    public static Object[][] correctLogins() {
        return new Object[][]{
                {"test", "test123"},
                {"conflict", "conflict"},
                {"help", "help"},
                {"hulk", "hulk"}
        };
    }

    @Test(dataProvider = "LoginCredentials", priority = 1)
    public void LoginPageTest(String username, String password) throws InterruptedException {

        String actualTitle = "Translate Window";

        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

//        Thread.sleep(1000);

//        WebElement usernameSet = driver.findElement(By.name("username"));
        usernameClear.sendKeys(username);

//        WebElement passwordSet = driver.findElement(By.name("password"));
        passwordClear.sendKeys(password);

//        Thread.sleep(1000);
        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        Assert.assertEquals(driver.getTitle(), actualTitle);

        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();

    }


    @DataProvider(name = "invaliedCredentials")
    public static Object[][] invaliedLogincredentials() {
        return new Object[][]{
                {"kdfjnb", "4nf7v6f"},
                {"", ""},
                {"", "test"},
                {"", "5ddf9898xc5v"},
                {"test", ""},
                {"test", "jnfkjasnf"},
                {"fjdhva", "dfsdjfkas"},
                {"4544848", "fgfdasgsdf"},
                {"6544875", "898484514"},
                {"fbmnvcx", "484654564564"},
                {"*&^$#^(*_(", "vsdvdfgv"},
                {"+__()&^$#@@$", "5154844544"},
                {"#$%%$$%^$$^&*()", ""},
                {"&&&&*****", "+_)*(&^^"},
                {"^*&^%$%^&*(", "hfhffhahhvsdv"}
        };

    }

    @Test(dataProvider = "invaliedCredentials")
    public void loginFailed(String username, String password) {
        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

//        Thread.sleep(1000);

        WebElement usernameSet = driver.findElement(By.name("username"));
        usernameSet.sendKeys(username);

        WebElement passwordSet = driver.findElement(By.name("password"));
        passwordSet.sendKeys(password);

        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        String expecteUrl = "http://localhost:8080/Menuka-Translator/MyServlet";
        String expectedTitle = "Translator Login Page";

        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        boolean state = false;

        if (actualTitle.equals(expectedTitle) && actualUrl.equals(expecteUrl)){
            state = true;
        }

        Assert.assertEquals(state, true);


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
