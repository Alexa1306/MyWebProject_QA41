package pages;

import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class AddPage extends BasePage {
    @FindBy(xpath="//input[@placeholder='Name']")
    WebElement nameField;

    @FindBy(xpath="//input[@placeholder='Last Name']")
    WebElement LastName;
@FindBy(xpath = "//input[@placeholder='Phone']")
    WebElement Phone;

@FindBy(xpath = "//input[@placeholder='email']")
    WebElement Email;

@FindBy(xpath = "//input[@placeholder='Address']")
    WebElement Address;
@FindBy(xpath = "//input[@placeholder='desc']")
    WebElement Description;

@FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveButton;

    public AddPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }
    public  void fillFormAndSave(){
            nameField.sendKeys(NameAndLastNameGenerator.generateName());
            LastName.sendKeys(NameAndLastNameGenerator.generateLastName());
            Phone.sendKeys(PhoneNumberGenerator.generatePhoneNumber());
            Email.sendKeys(EmailGenerator.generateEmail(3,4,2));
            Address.sendKeys(AddressGenerator.generateAddress());

            WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(5000));
            WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Save')]")));
            saveButton.click();


    }
}