package androidStepDefs;

import factoryObjects.AndroidPageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDefs {

    AndroidPageFactory androidPageFactory;

    public HomePageStepDefs(AndroidPageFactory androidPageFactory) {
        this.androidPageFactory = androidPageFactory;
    }

    @Given("clicks on login button")
    public void clickOnLoginButton() {
        androidPageFactory.genericPage().clickLoginButton();
    }

    @Then("the user should redirected to home page")
    public void homePageLogoDisplayed(){
        androidPageFactory.homePage().homePageLogoDisplayed();
    }




}
