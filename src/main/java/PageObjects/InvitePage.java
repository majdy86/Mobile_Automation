package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class InvitePage extends BasePageObject {

    DriverFactory driverFactory;
    public InvitePage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
