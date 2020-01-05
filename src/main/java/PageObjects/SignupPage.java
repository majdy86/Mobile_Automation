package PageObjects;

import FactoryObjects.DriverFactory;
import enums.UserType;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropManager;

import java.time.Duration;
import java.util.Map;

public class SignupPage extends BasePageObject {

    @FindBy(id = "signup-email")
    protected WebElement email;

    @FindBy(id = "first_name")
    protected WebElement firstName;

    @FindBy(id = "last_name")
    protected WebElement lastName;

    @FindBy(id = "signup-tzone")
    protected WebElement timezone;

    @FindBy(id = "signup-password")
    protected WebElement password;

    @FindBy(id = "signup-rpassword")
    protected WebElement confirmPassword;

    @FindBy(id = "type5")
    protected WebElement agreeTerms;

    @FindBy(id = "reg")
    protected WebElement register;

    WebDriver driver;

    public SignupPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory.getDriver();
    }


    public void filltheRegisterationInfo(Map<String, String> registrationInfo) {

        email.sendKeys(System.currentTimeMillis() + registrationInfo.get("email"));
        firstName.sendKeys(registrationInfo.get("firstName"));
        lastName.sendKeys(registrationInfo.get("lastName"));
        password.sendKeys(registrationInfo.get("password"));
        confirmPassword.sendKeys(registrationInfo.get("confirmPassword"));

        Select timeZone = new Select(timezone);
        timeZone.selectByVisibleText(registrationInfo.get("timeZone"));

    }

    public void agreeToTerms() {

        clickUsingJavaScriptExecutor(agreeTerms, driver);
    }

    public void clickOnRegister() {
        // register.click();
        clickUsingJavaScriptExecutor(register, driver);
    }

    public void checkRegisterButtonIsNotDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOf(register));
        } catch (Exception e) {
            Assert.fail("Register Button is Not Clickable");
        }
    }

    public void checkTheUserIsONActivationPage() {

    }
}
