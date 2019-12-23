package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsListPage extends BasePageObject {

    DriverFactory driverFactory;

    @FindBy(name = "Filter")
    private WebElement filterText;

    public ProjectsListPage(DriverFactory driverFactory) throws Exception {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }

    public void displayProjectsList(){
        filterText.isDisplayed();
        System.out.println(filterText.isDisplayed());
    }




}
