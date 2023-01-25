package intro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Helper {

    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void jsClick(WebDriver driver ,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click",element);
    }
}
