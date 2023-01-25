package HomeWork;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.time.Duration;


public class StepFirst {
    static Faker faker = new Faker();
    static WebDriver driver;

    @BeforeClass
    public static void settings(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public static void CheckForm() throws InterruptedException {

        //Arrange
        String Name = generateFakeFullName();
        String Email = generateFakeEmail();
        String CurrentAddress = generateFakeAddress();
        String PermanentAddress = generateFakePermanentAddress();

        String checkName;
        String checkEmail;
        String checkCurrentAddress;
        String checkPermanent;


        //Act
        WebElement fullInputFieldName = driver.findElement(By.id("userName"));
        fullInputFieldName.sendKeys(Name);

        WebElement fullInputFieldEmail = driver.findElement(By.id("userEmail"));
        fullInputFieldEmail.sendKeys(Email);

        WebElement fullInputFieldCurrAddress = driver.findElement(By.id("currentAddress"));
        fullInputFieldCurrAddress.sendKeys(CurrentAddress);

        WebElement fullInputFieldPermanentAddress = driver.findElement(By.id("permanentAddress"));
        fullInputFieldPermanentAddress.sendKeys(PermanentAddress);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        Thread.sleep(3000);

        WebElement clickSubmitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        clickSubmitButton.click();

//        Thread.sleep(3000);


        //Assert
        WebElement checkNameInput = driver.findElement(By.cssSelector("#name"));
        checkName = checkNameInput.getText();
        assertEquals(checkName, "Name:"+Name);

        WebElement checkEmailInput = driver.findElement(By.cssSelector("#email"));
        checkEmail = checkEmailInput.getText();
        assertEquals(checkEmail, "Email:"+Email);

        WebElement checkCurrentAddressInput = driver.findElement(By.cssSelector("p#currentAddress"));
        checkCurrentAddress = checkCurrentAddressInput.getText();
        assertEquals(checkCurrentAddress, "Current Address :"+CurrentAddress);

        WebElement checkPermanentInput = driver.findElement(By.cssSelector("p#permanentAddress"));
        checkPermanent = checkPermanentInput.getText();
        assertEquals(checkPermanent, "Permananet Address :" + PermanentAddress);


    }

    public static String generateFakeFullName(){return faker.name().fullName();}
    public static String generateFakeEmail(){return faker.internet().emailAddress();}
    public static String generateFakeAddress(){return faker.address().city();}
    public static String generateFakePermanentAddress(){return faker.address().streetAddress();}
}
