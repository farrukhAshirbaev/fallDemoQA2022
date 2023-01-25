package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo extends BaseTest {




    public static void practiceForm(){
        String name = driver.findElement(By.tagName("h5")).getText();
        System.out.println(name);
    }

    @Test
    public static void findXpath(){

        //absolut xpath
        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));
        String expectedEmailText = "Email";
        Assert.assertEquals(nameText.getText(), expectedEmailText);

        //relate Xpath
        WebElement relateXptah1 = driver.findElement(By.xpath("//label[@id='userEmail-label']"));
        Assert.assertTrue(expectedEmailText.contains(relateXptah1.getText()));

    }

    @Test
    public static void findXpath2(){

        WebElement relateXptah2 = driver.findElement(By.xpath("//input[@id='userEmail']"));
        relateXptah2.sendKeys("saimon@mail.ru");
        System.out.println(" Result is : " + relateXptah2.getAttribute("value"));
        Assert.assertEquals(relateXptah2.getAttribute("value"),"saimon@mail.ru");


        //Find Ind located when locator is duplicated
        WebElement relateIndXpath = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        System.out.println(relateIndXpath);
        //Find Element with all Text   (Full Name its - Title Text)  - Name Method Xpath ====> text()
        WebElement relateTextXpath = driver.findElement(By.xpath("//*[text()= 'Full Name']"));

        //Find Element with all Text   (Full Name its - Title Text)  - Name Method Xpath ====> text()
        WebElement relateContainsXpath = driver.findElement(By.xpath("//*[text()= 'Full Name']"));

    }

}

//glovoapp.com
//Get Started
//Fill All Field
//Click on Submit