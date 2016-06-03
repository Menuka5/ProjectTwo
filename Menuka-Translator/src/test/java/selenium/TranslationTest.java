package selenium;


import com.sun.deploy.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TranslationTest {
    WebDriver driver;

    @BeforeTest
    public void starBrowser() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/Menuka-Translator/");

        WebElement usernameClear = driver.findElement(By.name("username"));
        usernameClear.clear();

        WebElement passwordClear = driver.findElement(By.name("password"));
        passwordClear.clear();

//        Thread.sleep(2000);

//        WebElement usernameSet = driver.findElement(By.name("username"));
        usernameClear.sendKeys("conflict");

//        WebElement passwordSet = driver.findElement(By.name("password"));
        passwordClear.sendKeys("conflict");

//        Thread.sleep(2000);

        WebElement element = driver.findElement(By.id("submitButton"));
        element.click();
    }

    @DataProvider(name = "translateInfo")
    public Object[][] sendTranslateDetails(){
        return new Object[][]{
                {"English", "Latin", "Always Faithful", "Semper Fidelis"},
                {"French", "English", "paix", "peace"},
                {"Spanish", "English", "ayuda", "help"},
                {"Danish", "English", "spise", "eat"}
        };
    }


    @Test(dataProvider = "translateInfo")
    public void TranslationTest(String fromLangs, String toLang, String wordtotranslate, String expectedOutput){

//        driver.get("http://localhost:8080/Menuka-Translator/");

//        Thread.sleep(1000);

        WebElement fromLang = driver.findElement(By.name("from"));
        WebElement option = fromLang.findElement(By.xpath("//option[text()='" + fromLangs + "']"));
        option.click();

//        Thread.sleep(1000);

        WebElement select = driver.findElement(By.name("to"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for(WebElement option2 : options){
            if(option2.getText().equals(toLang)){
                option2.click();
                break;
            }
        }
//        Thread.sleep(1000);

        WebElement fromText = driver.findElement(By.name("fromText"));
        fromText.clear();
        fromText.sendKeys(wordtotranslate);

//        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.id("translateButton"));
        submitButton.click();

        String resultWithoutModify = driver.findElement(By.name("toText")).getText();
//        System.out.println(resultWithoutModify);

        String modifiedString = this.modifyString(resultWithoutModify);
        System.out.println(modifiedString);
    }


    public String modifyString(String tobeModify){
        tobeModify = tobeModify.trim();
        String[] store =  tobeModify.split("\\s+");
//        String[] newArray = Arrays.copyOfRange(store, 0, store.length);


//        System.out.println(store[0]+ " " + store[1]);

        String output=null;

        if (store.length == 0){
            output = "";
        }else if (store.length == 1){
            output = store[0];
        }else {
            output = String.join(",", store);
        }

        return output;
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
