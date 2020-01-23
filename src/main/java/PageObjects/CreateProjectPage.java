package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class CreateProjectPage extends BasePageObject {

    WebDriver driver;
    public CreateProjectPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory.getDriver();
    }
}
