package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject {

    DriverFactory driverFactory;
    public ProfilePage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
