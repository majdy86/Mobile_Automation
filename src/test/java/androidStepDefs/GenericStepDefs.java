package androidStepDefs;

import factoryObjects.AndroidPageFactory;
import io.cucumber.java.en.When;

public class GenericStepDefs {

    AndroidPageFactory androidPageFactory;
    public GenericStepDefs(AndroidPageFactory androidPageFactory){
        this.androidPageFactory = androidPageFactory;

    }

    @When("the user clicks on login button")
    public void clickLoginButton(){
        androidPageFactory.genericPage().clickLoginButton();
    }

}
