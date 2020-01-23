package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebDriver;

public class GenericPage extends BasePageObject {

    WebDriver driver;
    public GenericPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory.getDriver();
    }


    public void refreshPage() {
        driver.navigate().refresh();
    }
}
