package androidPageObjects;


import factoryObjects.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePageObject {

    @AndroidFindBy(id = "com.talabat:id/eTEmail")
    AndroidElement emailTextField;

    @AndroidFindBy(id = "com.talabat:id/eTPassword")
    AndroidElement passwordTextField;

    AppiumDriver driver;

    public LoginPage(MobileDriverFactory mobileDriverFactory) {
        super(mobileDriverFactory.getDriver());
        this.driver = mobileDriverFactory.getDriver();
    }

    public void setEmailTextField(String email){
        emailTextField.sendKeys(email);
    }

    public void setPasswordTextField(String password){
        passwordTextField.sendKeys(password);
    }


}
