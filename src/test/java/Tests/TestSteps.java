package Tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static DataAndProcedures.Data.*;
import static Selectors.ClassNames.accountDropDown;
import static Selectors.CssSelectors.*;
import static Selectors.Ids.*;

public class TestSteps {

    private  WebDriver chromeDriver;
    private  final int defaultWait = 5;
    private String userEmail = "";

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Coding\\SeleniumProject\\src\\test\\java\\Utils\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(defaultWait, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(defaultWait, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(defaultWait, TimeUnit.SECONDS);
        chromeDriver.get("https://demo.opencart.com/");
    }
    public  WebDriver getChromeDriver(){
        return chromeDriver;
    }

    @After
    public void killDriver(){
        if(chromeDriver != null){
            chromeDriver.quit();
        }
    }

    public String generateRandomEmail(){
        Random rand = new Random();
        userEmail = userFirstName + userLastName + Integer.toString(rand.nextInt(10000)) + "@example.com";
        return userEmail;
    }

    public  WebElement getElement(By selector, int waitFor){
        new WebDriverWait(getChromeDriver(), waitFor).until(ExpectedConditions.visibilityOfElementLocated(selector));
        return getChromeDriver().findElement(selector);
    }
    public  WebElement getElement(By selector){
        return getElement(selector, defaultWait);
    }

    @Given("User clicked on register button")
    public void ClickOnRegisterButton(){
        getElement(accountDropDown).click();
        getElement(registerButton).click();
    }

    @When("User enters all valid personal info")
    public void UserEntersPersonalData(){
        getElement(firstNameInput).sendKeys(userFirstName);
        getElement(lastNameInput).sendKeys(userLastName);
        getElement(lastNameInput).sendKeys(userLastName);
        getElement(emailInput).sendKeys(generateRandomEmail());
        getElement(phoneInput).sendKeys(userPhoneNumber);
        getElement(passwordInput).sendKeys(password);
        getElement(passwordConfirmInput).sendKeys(password);
    }

    @And("User accepts privacy policy")
    public void UserAcceptsPrivacyPolicy(){
        getElement(privacyPolicyCheckbox).click();
    }

    @And("User clicks on Continue registration button")
    public void UserClicksContinueButton(){
        getElement(registrationContinueButton).click();
    }

    @Then("User is navigated to home page")
    public void UserIsNavigatedToHomePage(){
        WebElement myAccount = getElement(yourAccountHasBeenCreatedTitle, 10);
        Assert.assertFalse(myAccount == null);
    }

}
