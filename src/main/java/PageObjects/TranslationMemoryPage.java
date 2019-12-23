package PageObjects;

import FactoryObjects.DriverFactory;

public class TranslationMemoryPage extends BasePageObject {

    DriverFactory driverFactory;
    public TranslationMemoryPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
