package PageObjects;


import FactoryObjects.DriverFactory;

public class SelectUserTypePage extends BasePageObject {

    DriverFactory driverFactory;

    public SelectUserTypePage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;

    }
}
