package PageObjects;

import FactoryObjects.DriverFactory;

public class ProjectDetailsPage extends BasePageObject {

    DriverFactory driverFactory;

    public ProjectDetailsPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }
}
