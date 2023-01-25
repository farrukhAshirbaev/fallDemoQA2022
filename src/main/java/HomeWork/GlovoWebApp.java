package HomeWork;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class GlovoWebApp {
    static WebDriver driver;
    static Faker faker = new Faker();

    @BeforeClass
    public static void settings() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://glovoapp.com/kg/ru/bishkek/");
    }

    @Test(description = "Press to button Start! for start Registy")
    public static void goToRegisterBlock() {
        WebElement pressToButtonStart = driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
        pressToButtonStart.click();
    }

    @Test(description = "Check Text in PopUp")
    public static void checkTextInRegistryPopUp() {
        final String headTittle = "Зарегистрироваться в Glovo";
        final String faceBook = "Вход с помощью Facebook";
        final String dividingLine = "или";

        final String placeHolderName = "Имя";
        final String placeHolderEmail = "Адрес эл. почты";
        final String placeHolderPassword = "Пароль";

        final String registerWithEmailMail = "Зарегистрироваться с помощью эл. почты";

        final String logInButton = "Войти";


        assertTextEqual("//h2[@class = 'title mt-0 mb-4']", headTittle);
        assertTextEqual("//button[@class='social-button social-button--control']", faceBook);
        assertTextEqual("//div[@class='divider']", dividingLine);
        assertTextEqual("(//span[@class='placeholder'])[1]", placeHolderName);
        assertTextEqual("(//span[@class='placeholder'])[2]", placeHolderEmail);
        assertTextEqual("(//span[@class='placeholder'])[3]", placeHolderPassword);
        assertTextEqual("(//span[@class='helio-button__content'])[6]", registerWithEmailMail);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");

        assertTextEqual("//button[@data-e2e-id='header-user-login']", logInButton);

    }

    @Test(description = "Use Empty Field")
    public static void registryIfFieldIsEmpty() {
        pressButton("//button[@id='signup-button']");
    }

    @Test(description = "Use Space")
    public static void useSpaceInField() {
        insertText("(//input[@data-test-id='text-field-input'])[1]", " ");
        insertText("(//input[@data-test-id='text-field-input'])[2]", " ");
        insertText("(//input[@data-test-id='text-field-input'])[3]", " ");

        pressButton("//button[@id='signup-button']");
    }

//    @Test (description = "insert Only Name")
//    public static void insertName(){
//        insertText("(//input[@data-test-id='text-field-input'])[1]"," ");
//    }

    @Test(description = "register")
    public static void registerInPopUp() {
        String name = generateFakeFullName();
        String email = generateFakeEmail();
        String password = generateFakePassword();

        WebElement insertName = driver.findElement(By.xpath("(//input[@data-test-id='text-field-input'])[1]"));
        insertName.sendKeys(name);

        WebElement insertEmail = driver.findElement(By.xpath("(//input[@data-test-id='text-field-input'])[2]"));
        insertEmail.sendKeys(email);

        WebElement insertPassword = driver.findElement(By.xpath("(//input[@data-test-id='text-field-input'])[3]"));
        insertPassword.sendKeys(password);

        pressButton("//button[@id='signup-button']");
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
        element.sendKeys(text);
    }

    public static void insertTextWithFaker(String selector, String text) {
//        fname = generateFakeFullName
        WebElement element = driver.findElement(By.xpath(selector));
        element.sendKeys(text);
    }

    public static void pressButton(String selector) {
        WebElement element = driver.findElement(By.xpath(selector));
        element.click();
    }


    public static String generateFakeFullName() {
        return faker.name().fullName();
    }

    public static String generateFakeEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateFakePassword() {
        return faker.internet().password();
    }

}
