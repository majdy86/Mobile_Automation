package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsListPage extends BasePageObject {

    DriverFactory driverFactory;

    @FindBy(className = "projects-cat-list")
    private WebElement filterText;

    public ProjectsListPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }

    public void checkFilterHeader(){
        filterText.isDisplayed();
    }


}
