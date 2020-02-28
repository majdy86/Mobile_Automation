package androidPageObjects;

import factoryObjects.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GenericPage extends BasePageObject {

    AppiumDriver driver;

    @AndroidFindBy(id = "com.talabat:id/btnLogin")
    AndroidElement loginButton;

    @AndroidFindBy(id = "android:id/autofill_save_no")
    AndroidElement noThanks;

    public GenericPage(MobileDriverFactory mobileDriverFactory) {
        super(mobileDriverFactory.getDriver());
        this.driver = mobileDriverFactory.getDriver();
    }

    public void clickLoginButton(){
        loginButton.click();


    }

    public void clickNoThanksSavePasswordAlert(){
        try{
            noThanks.click();
        }catch(Exception e){

        }
    }
}