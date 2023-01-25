//package intro;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class Demo1 {
//
//@Test
//    public void  testDemo1() throws InterruptedException {
//
//    WebDriverManager.chromedriver().setup();
//
//    WebDriver driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//    driver.get("https://demoqa.com/text-box");
//
//    WebElement fullInputFieldName = driver.findElement(By.id("userName"));
//    fullInputFieldName.sendKeys("Farrukh");
//
//    WebElement fullInputFieldEmail = driver.findElement(By.id("userEmail"));
//    fullInputFieldEmail.sendKeys("fara@mail.ru");
//
//    WebElement fullInputFieldCurrAddress = driver.findElement(By.id("currentAddress"));
//    fullInputFieldCurrAddress.sendKeys("Test long Text to match");
//
//    WebElement fullInputFieldPermanentAddress = driver.findElement(By.id("permanentAddress"));
//    fullInputFieldPermanentAddress.sendKeys("i live in Bish");
//
//
//
//    WebElement clickSubmitButton = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
//    clickSubmitButton.click();
//
//    fullInputFieldName.getText();
//}
//}
