package androidPageObjects;


import factoryObjects.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePageObject {

    AppiumDriver driver;

    @AndroidFindBy(id = "com.talabat:id/logo_image")
    AndroidElement homePageTalabatLogo;

    public HomePage(MobileDriverFactory mobileDriverFactory) {
        super(mobileDriverFactory.getDriver());
        this.driver = mobileDriverFactory.getDriver();
    }

    public void homePageLogoDisplayed() {
        homePageTalabatLogo.isDisplayed();
    }

}
