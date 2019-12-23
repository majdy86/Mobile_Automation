package PageObjects;

import FactoryObjects.DriverFactory;

public class WorkspacePage extends BasePageObject {

    DriverFactory driverFactory;

    public WorkspacePage(DriverFactory driverFactory){
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
