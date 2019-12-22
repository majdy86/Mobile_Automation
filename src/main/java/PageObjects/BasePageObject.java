package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePageObject {

    DriverFactory driverFactory;

    public BasePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
