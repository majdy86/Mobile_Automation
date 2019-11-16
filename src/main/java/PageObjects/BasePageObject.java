package PageObjects;

/**
 * Created by Amal on 1/14/2019.
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object base class. It provides the base structure and properties for a
 * page object to extend.
 */

public abstract class BasePageObject {


    public BasePageObject() {

    }
    /**
     * Constructor
     */
    public BasePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
