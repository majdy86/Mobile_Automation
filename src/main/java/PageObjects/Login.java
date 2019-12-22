package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import FactoryObjects.DriverFactory;
import utils.PropManager;

public class Login extends BasePageObject{

    private String loginPageURL = PropManager.getInstance().getProperty("env") + PropManager.getInstance().getProperty("login.page");

    @FindBy(name = "email")
    protected WebElement email;

    DriverFactory driver;

    public Login(DriverFactory driverFactory) throws Exception {
        super(driverFactory.getDriver());
        this.driver = driverFactory;
    }

    public void navigateToLoginPage() throws Exception {
        driver.getDriver().get(loginPageURL);
        email.sendKeys("test");
    }

}
