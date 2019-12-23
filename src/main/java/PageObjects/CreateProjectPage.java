package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class CreateProjectPage extends BasePageObject {

    DriverFactory driverFactory;
    public CreateProjectPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
