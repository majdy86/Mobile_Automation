package androidStepDefs;

import factoryObjects.AndroidPageFactory;
import io.cucumber.java.en.And;

public class LoginStepDefs {

    AndroidPageFactory androidPageFactory;

    public LoginStepDefs(AndroidPageFactory androidPageFactory) {
        this.androidPageFactory = androidPageFactory;
    }

    @And("fill the email field with an existing email address (.*)")
    public void setEmailField(String email){
        androidPageFactory.loginPage().setEmailTextField(email);
    }

    @And("fill the password field with a valid password (.*)")
    public void setPasswordField(String password){
        androidPageFactory.loginPage().setPasswordTextField(password);
    }


}
