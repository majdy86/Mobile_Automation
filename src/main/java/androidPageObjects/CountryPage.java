package androidPageObjects;

import factoryObjects.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.startsWith;

public class CountryPage extends BasePageObject{

    AndroidDriver driver;

    public CountryPage(MobileDriverFactory mobileDriverFactory){
        super(mobileDriverFactory.getDriver());
        this.driver = (AndroidDriver) mobileDriverFactory.getDriver();
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[7]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
    private AndroidElement jordan;



    public void clickOnJordanButton() {
        jordan.click();
    }

}
