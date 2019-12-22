package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import FactoryObjects.DriverFactory;
import utils.PropManager;

public class LoginPage extends BasePageObject{

    private String loginPageURL = PropManager.getInstance().getProperty("env") + PropManager.getInstance().getProperty("login.page");

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@class='asdfasdf']")
    private WebElement signin;

    DriverFactory driverFactory;

    public LoginPage(DriverFactory driverFactory) throws Exception {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }

    public void navigateToLoginPage() throws Exception {
        driverFactory.getDriver().get(loginPageURL);
    }

    public void setEmail(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public void clickSignIn() throws Exception {
        JavascriptExecutor executor = (JavascriptExecutor)driverFactory.getDriver();
        executor.executeScript("arguments[0].click();", signin);
    }

}
