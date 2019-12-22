package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PropManager;

public class HomePage extends BasePageObject {

    private String homePage = PropManager.getInstance().getProperty("env");

    DriverFactory driver;

    @FindBy(xpath = "//button[@class='signup']")
    protected WebElement signupHomePage;


    public HomePage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory;
    }

    public void navigateToHomePage() {
        driver.getDriver().get(homePage);
    }

    public void signupFromHomePage() {
        //signupHomePage.click();
        clickUsingJavaScriptExecutor(signupHomePage, driver.getDriver());
    }
}
