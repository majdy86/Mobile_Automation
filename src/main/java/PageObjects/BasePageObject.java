package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {

    /**
     * Constructor
     */
    public BasePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
