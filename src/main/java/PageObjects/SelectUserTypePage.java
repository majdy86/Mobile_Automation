package PageObjects;


import FactoryObjects.DriverFactory;
import enums.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectUserTypePage extends BasePageObject {

    @FindBy(id = "signup-customer-label")
    protected WebElement userTypePM;

    @FindBy(id = "signup-executor-label")
    protected WebElement userTypeExecutor;

    @FindBy(id = "signup-btn-type-next")
    protected WebElement next;


    WebDriver driver;

    public SelectUserTypePage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory.getDriver();

    }

    public void selectUserType(UserType userType) {
        switch (userType) {
            case PM:
                //userTypePM.click();
                clickUsingJavaScriptExecutor(userTypePM, driver);
                break;
            case Executor:
                //userTypeExecutor.click();
                clickUsingJavaScriptExecutor(userTypeExecutor, driver);
                break;

        }
    }

    public void clickOnNext() {
        clickUsingJavaScriptExecutor(next, driver);

    }
}
