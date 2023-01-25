package HomeWork.RegistrationForm;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Registration extends Helper {
    static ElementLocation test = new ElementLocation();

    @Test(description = "We need to Open Registration Form", priority = 1)
    public static void openRegistrationForm() throws InterruptedException {

        test.button.click();

    }

    @Test(description = "Insert text in Field", priority = 2)
    public static void insertText() {

        Users fara = new Users();

        List<WebElement> containerOfData = driver.findElements(By.xpath("//div[@class='rt-tbody']"));

        test.firstNameField.sendKeys(fara.fName);
        test.lastNameField.sendKeys(fara.lName);
        test.emailField.sendKeys(fara.eMail);
        test.ageField.sendKeys(fara.age);
        test.salaryField.sendKeys(fara.salary);
        test.departmentField.sendKeys(fara.department);

        test.submitBtn.click();

        WebElement getList = driver.findElement(By.xpath("(//div[@class='rt-tr -even'])[2]"));
        //WebElement getList = driver.findElement(By.xpath("//div[@class='rt-tbody']"));





    }


}


