package selenium;

import hsenid.PropertyHandle;
import hsenid.UserFiles.AddUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddUserTest {
    private static final Logger logger = LogManager.getLogger(AddUserTest.class);
    WebDriver driver;
    PropertyHandle getUrl;

    public AddUserTest() throws IOException {
        getUrl = new PropertyHandle();
    }

    @BeforeTest
    public void logAsAdmin() {
        driver = new FirefoxDriver();
        driver.get(getUrl.getSeleniumUrl());

    }

    @DataProvider(name = "AddUserData")
    public Object[][] sendAddUserData(){
        return new Object[][]{
                {"Kanak", "Ahila", "testemail@gmail.com", "94717388432", "Sri Lanka", "Matara","Customer care","passmjfns"},
                {"nikam", "baas", "nikambaas@yahoo.com", "94772399653", "Japan", "Yokohama","Translator", "tycfxyha"},
                {"sapaththu", "baas", "fhvgjdshg@gmail.com", "94412256895", "United States", "Las Vegas", "Administrator", "4bdf4gbs5734"}
        };

    }

    @Test(dataProvider = "AddUserData")
    public void addUserTest(String fistName, String lastName, String email, String number, String country, String city,String role,String passWord) {

        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

        usernameClear.sendKeys("test");
        passwordClear.sendKeys("test123");

        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();

        String expectedTitle = "User Added Successfully";
        WebElement userManagement = driver.findElement(By.className("dropdown-toggle"));
        userManagement.click();

        WebElement clickAddUser = driver.findElement(By.id("adduser"));
        clickAddUser.click();

        WebElement fName = driver.findElement(By.id("fname"));
        fName.clear();
        fName.sendKeys(fistName);

        WebElement lName = driver.findElement(By.id("lname"));
        lName.clear();
        lName.sendKeys(lastName);

        driver.findElement(By.id("date")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[3]/table/tbody/tr/td/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//td/span[2]")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//tr[2]/td[7]")).click();

        WebElement selectCountry = driver.findElement(By.xpath("//Select[@id='country']/option[normalize-space(text())='"+ country +"']"));
        selectCountry.click();

        WebElement selectCity = driver.findElement(By.xpath("//Select[@id='states']/option[normalize-space(text())='"+city +"']"));
        selectCity.click();

        WebElement email1 = driver.findElement(By.id("email"));
        WebElement mobile = driver.findElement(By.id("mnumber"));

        email1.clear();
        email1.sendKeys(email);

        mobile.clear();
        mobile.sendKeys(number);

        WebElement selectRole = driver.findElement(By.xpath("//Select[@id='userRole']/option[normalize-space(text())='"+ role + "']"));
        selectRole.click();

        WebElement username = driver.findElement(By.id("username"));
        username.clear();
        Random rand = new Random();
        int value = rand.nextInt(50000);

        username.sendKeys("Selenium" + value);
        WebElement password = driver.findElement(By.id("pass1"));
        password.clear();
        password.sendKeys(passWord);
        WebElement password2 = driver.findElement(By.id("pass2"));
        password2.clear();
        password2.sendKeys(passWord);

        WebElement submitButton = driver.findElement(By.id("sbtn"));
        submitButton.click();

        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        driver.get(getUrl.getSeleniumUrl());
        logger.info(getUrl.getSeleniumUrl());
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }


}
