package PageObjects;

import FactoryObjects.DriverFactory;
import enums.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropManager;

public class SignupPage extends BasePageObject {

    DriverFactory driver;

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
        this.driver = driverFactory;
    }

    public void selectUserType(UserType userType) {
        switch (userType) {
            case PM:
                //userTypePM.click();
                clickUsingJavaScriptExecutor(userTypePM, driver.getDriver());
                break;
            case Executor:
                //userTypeExecutor.click();
                clickUsingJavaScriptExecutor(userTypeExecutor, driver.getDriver());
                break;

        }
        //Thread.sleep(5000);
    }

    public void filltheRegisterationInfoAndRegister() {

    }
}
