package PageObjects;

import FactoryObjects.DriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

import static org.junit.Assert.*;

public class ProjectsListPage extends BasePageObject {

    WebDriver driver;

    @FindBy(className = "projects-cat-list")
    private WebElement filterText;

    public ProjectsListPage(DriverFactory driverFactory) {
        super(driverFactory.getDriver());
        this.driver = driverFactory.getDriver();
    }

    public void checkFilterHeader(){
        boolean filterTextIsDisplayed = filterText.isDisplayed();
        assertTrue(filterTextIsDisplayed);
    }


}
