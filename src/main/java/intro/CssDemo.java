package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest{

    @Test
    public void cssTest1(){
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
//        driver.findElement(By.cssSelector("li[id='p_89/Apple']")).sendKeys("Iphone", Keys.ENTER);


        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']"));
            for (WebElement e : allBrands){
                System.out.println(e.getText());
            }
    }


}
