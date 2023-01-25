package intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class BaseTest {
    static WebDriver driver;
    static BrowserHelper browserHelper;

     AlertHelper alertHelper;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }



    public static void assertTextEqual(String selector, String expectedText) {

        WebElement element = driver.findElement(By.xpath(selector));
        String actualText = element.getText().trim();
        Assert.assertEquals(actualText, expectedText);
    }

    public static void insertText(String selector, String text) {

        WebElement element = driver.findElement(By.xpath(selector));
        element.sendKeys(text, Keys.ENTER);
    }


    public static void pressButton(String selector) {
        WebElement element = driver.findElement(By.xpath(selector));
        element.click();
    }

    public static void goToElement(String selector){
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.xpath(selector));
        actions.moveToElement(element).perform();
    }

    public static void getProductList(String selector, String expectedText) {
        List<WebElement> productList = driver.findElements(By.xpath(selector));
        for (WebElement e : productList) {
//
            if (e.getText().equals(expectedText)) {
               WebElement input = e.findElement(By.xpath("//li/span/a"));
               input.click();
               break;
            }
        }
    }




}

