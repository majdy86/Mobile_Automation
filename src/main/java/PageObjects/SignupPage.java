package PageObjects;

import FactoryObjects.DriverFactory;
import enums.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropManager;

import java.util.Map;

public class SignupPage extends BasePageObject {

    DriverFactory driverFactory;

    @FindBy(id = "1")
    protected WebElement userTypePM;

    @FindBy(id = "2")
    protected WebElement userTypeExecutor;

    @FindBy(xpath = "//button[contains(@class,'b-btn-standart role-btn')]")
    protected WebElement next;

    @FindBy(xpath = "//input[@placeholder='Email']")
    protected WebElement email;

    @FindBy(xpath = "//input[@id='first_name']")
    protected WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    protected WebElement lastName;

    @FindBy(name = "timezone")
    protected WebElement timezone;

    @FindBy(xpath = "//input[@placeholder='Password']")
    protected WebElement password;

    @FindBy(xpath = "//input[@placeholder='Password Confirmation']")
    protected WebElement confirmPassword;

    public SignupPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }

    public void selectUserType(UserType userType) {
        switch (userType) {
            case PM:
                //userTypePM.click();
                clickUsingJavaScriptExecutor(userTypePM, driverFactory.getDriver());
                break;
            case Executor:
                //userTypeExecutor.click();
                clickUsingJavaScriptExecutor(userTypeExecutor, driverFactory.getDriver());
                break;

        }
        //Thread.sleep(5000);
    }

    public void filltheRegisterationInfo(Map<String, String> registrationInfo) {
        WebDriverWait wait = driverFactory.getwaitExplicit(driverFactory.getDriver());
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(System.currentTimeMillis() + registrationInfo.get("email"));
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(registrationInfo.get("firstName"));
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(registrationInfo.get("lastName"));
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(registrationInfo.get("lastName"));
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(registrationInfo.get("password"));
        wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys(registrationInfo.get("confirmPassword"));


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnNext(){

        driverFactory.getwaitExplicit(driverFactory.getDriver()).until(ExpectedConditions.visibilityOf(next));
        clickUsingJavaScriptExecutor(next, driverFactory.getDriver());

    }

}
