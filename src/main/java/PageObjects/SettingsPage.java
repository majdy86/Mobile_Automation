package PageObjects;

import FactoryObjects.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SettingsPage extends BasePageObject {

    WebDriver driver;

    private String settingsPageUrl = PropManager.getInstance().getProperty("env") + PropManager.getInstance().getProperty("project_manager_settings_page");

    @FindBy(id = "edit-fname")
    private WebElement firstName;

    @FindBy(css = "#edit-general-info")
    private WebElement generalInfo;

    @FindBy(id = "edit-save-btn")
    private WebElement saveButton;


    DriverFactory driverFactory;
    public SettingsPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
        this.driver = driverFactory.getDriver();
    }

    public void navigateToSettingsPage() {
        driver.get(settingsPageUrl);
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void clickOnGeneralInfo() {
        clickUsingJavaScriptExecutor(generalInfo,driver);
    }

    public void changeFirstName(String firstName) {
        this.firstName.clear();
        driverFactory.getwaitExplicit(driver,Duration.ofSeconds(5)).until(ExpectedConditions.attributeToBe(this.firstName,"value",""));
        this.firstName.sendKeys(firstName);
    }

    public void clickOnSave() {
        clickUsingJavaScriptExecutor(saveButton,driver);
//        saveButton.click();
    }

    public void checkNewFirstName(String firstName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(firstName,this.firstName.getAttribute("value"));
    }
}
