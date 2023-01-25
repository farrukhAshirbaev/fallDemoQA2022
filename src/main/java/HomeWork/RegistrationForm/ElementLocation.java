package HomeWork.RegistrationForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementLocation {

    public ElementLocation() {
        PageFactory.initElements(Helper.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"addNewRecordButton\"]")
    public WebElement button;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Age']")
    public WebElement ageField;

    @FindBy(xpath = "//input[@placeholder='Salary']")
    public WebElement salaryField;

    @FindBy(xpath = "//input[@placeholder='Department']")
    public WebElement departmentField;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitBtn;

}
