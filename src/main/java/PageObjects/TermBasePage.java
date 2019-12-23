package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TermBasePage extends BasePageObject {

    DriverFactory driverFactory;
    public TermBasePage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
