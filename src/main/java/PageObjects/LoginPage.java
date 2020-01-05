package PageObjects;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import FactoryObjects.DriverFactory;
import utils.PropManager;

public class LoginPage extends BasePageObject {

    private String loginPageURL = PropManager.getInstance().getProperty("env") + PropManager.getInstance().getProperty("login.page");

    @FindBy(id = "signin-email")
    private WebElement email;

    @FindBy(id = "signin-password")
    private WebElement password;

    @FindBy(id = "signin-btn-submit")
    private WebElement signin;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dark']")
    private WebElement errorMessage;

    WebDriver driver;

    public LoginPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory.getDriver();
    }

    public void navigateToLoginPage() {
        driver.get(loginPageURL);
    }

    public void setEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public void clickSignIn() {
        clickUsingJavaScriptExecutor(signin,driver);
    }


    public void invalidCredentialsErrMsg() {
        assertThat(errorMessage.getText(),containsString(PropManager.getInstance().getProperty("signin_invalidcredentials_error_message")));
    }

    public void checkUsernameRequired(){
        assertTrue(Boolean.parseBoolean(email.getAttribute("Required")));
    }

    public void checkPasswordRequired(){
        assertTrue(Boolean.parseBoolean(password.getAttribute("Required")));
    }
}
