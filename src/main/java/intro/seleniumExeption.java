package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.rmi.Remote;
import java.time.Duration;
import java.util.List;

public class seleniumExeption extends BaseTest {

    @Test
    public void noSuchElementException() {
        //noSuchElementException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello World");

    }

    @Test
    public void noSuchWindowException() {
        //noSuchWindowException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("hello");
    }

    @Test
    public void noSuchFrameException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        alertHelper.acceptAlert();
    }

    @Test
    public void invalidSelectorException() {
        browserHelper.openURL("https://demoqa.com/text-box");
        SessionId s = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session Id is : " + s);
//        driver.findElements(By.cssSelector("(//button[@type='button'])[2]"));
    }

    @Test
    public void noSuchSessionExcepted() {
        //noSuchSessionExcepted
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceException() {
        //staleElementReferenceException
        browserHelper.openURL("amazon.com");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
                break;
            }
        }
    }

    @Test
    public void timeOutException(){
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
    }


}
