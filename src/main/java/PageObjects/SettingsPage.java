package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePageObject {

    DriverFactory driverFactory;
    public SettingsPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
