package androidPageObjects;

import factoryObjects.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CountryPage extends BasePageObject{

    AppiumDriver driver;

    public CountryPage(MobileDriverFactory mobileDriverFactory){
        super(mobileDriverFactory.getDriver());
        this.driver = mobileDriverFactory.getDriver();
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
    private AndroidElement jordan;

    public void clickOnJordanButton() {
        jordan.click();
    }

}
