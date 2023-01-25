package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo extends BaseTest {

    @Test
    public static void test1() {
        browserHelper.openURL("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        browserHelper.switchToWindow(1);
        Helper.pause(3000);
        browserHelper.switchToParent();
        Helper.pause(3000);
    }
}
