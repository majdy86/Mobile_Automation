package PageObjects;

import FactoryObjects.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsListPage extends BasePageObject {

    DriverFactory driverFactory;

    @FindBy(xpath = "//div[@class='row justify-content-center sett-elems reverse']//h2[@class='title big-type-title'][contains(text(),'Filter')]")
    private WebElement filterText;

    public ProjectsListPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driverFactory = driverFactory;
    }

    public void checkFilterHeader(){
        filterText.isDisplayed();
    }


}
