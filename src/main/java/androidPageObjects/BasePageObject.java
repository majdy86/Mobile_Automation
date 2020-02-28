package androidPageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {

    /**
     * Constructor
     */
    public BasePageObject(AppiumDriver driver) {
        PageFactory.initElements( new AppiumFieldDecorator(driver), this);
    }
}
