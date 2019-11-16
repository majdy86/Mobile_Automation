package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverManager;
import utils.PropManager;

public class Login extends BasePageObject{

    private String loginPageURL = PropManager.getInstance().getProperty("env") + PropManager.getInstance().getProperty("login.page");

    @FindBy(name = "email")
    protected WebElement email;

    DriverManager driverManager;
    public Login(DriverManager driverManager) {
        super(driverManager.getDriver());
        this.driverManager = driverManager;
    }

    public void navigateToLoginPage(){
        driverManager.getDriver().get(loginPageURL);
        email.sendKeys("test");
    }

}
