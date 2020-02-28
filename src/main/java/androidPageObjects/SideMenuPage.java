package androidPageObjects;

import factoryObjects.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SideMenuPage extends BasePageObject {

    AppiumDriver driver;

    @AndroidFindBy(id = "com.talabat:id/menu_open")
    AndroidElement sideMenuButton;

    @AndroidFindBy(id = "com.talabat:id/side_menu_user_title")
    AndroidElement userDisplayName;

    public SideMenuPage(MobileDriverFactory mobileDriverFactory) {
        super(mobileDriverFactory.getDriver());
        this.driver = mobileDriverFactory.getDriver();
    }

    public void clickSideMenuButton(){
        sideMenuButton.click();
    }

    public String getUserDisplayName(){
       return userDisplayName.getText();
    }
}
