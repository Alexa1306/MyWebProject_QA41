package tests;

import config.BaseTest;
import helpers.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class PhoneBookTest extends BaseTest {

    @Test(description = "The test checks the empty field warning declaration.")
    @Parameters("browser")
    public void registrationWithoutPassword(@Optional("chrome") String browser) throws InterruptedException {
        Allure.description("User already exist. Login and add contact.!");

        MainPage mainPage = new MainPage(getDriver());
        Allure.step("Click by Login button");
        LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());
        Allure.step("Click by Reg button");
        String expectedString = "Wrong";

        Alert alert= loginPage.fillEmailField("myemail@mail.com").clickByRegistartionBUtton();
        boolean isAlertHandled = AlertHandler.handleAlert(alert, expectedString);
        Assert.assertTrue(isAlertHandled);
    }


        @Test(description = "The test checks creation new contact for authorized user.")
        @Parameters("browser")
    public void createContactForAuthorizedUser(@Optional("chrome") String browser) throws InterruptedException {


            MainPage mainPage = new MainPage(getDriver());

            LoginPage loginPage = mainPage.openTopMenu(TopMenuItem.LOGIN.toString());

//           BasePage basePage = (BasePage) loginPage.fillEmailField(EmailGenerator.generateEmail(2,4,2)).
//                   fillPasswordField(PasswordStringGenerator.generateString()).
            BasePage basePage = (BasePage) loginPage.fillEmailField("dd@ffg.ru").
                  fillPasswordField("!@12QQaaqwwer").
            clickByLoginButton();
           AddPage addPage = mainPage.openTopMenu(TopMenuItem.ADD.toString());
           addPage.fillFormAndSave();


    }

}