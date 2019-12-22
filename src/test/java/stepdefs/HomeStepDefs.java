package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class HomeStepDefs {

    PageFactory pageFactory;

    public HomeStepDefs(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }

    @Given("the user navigate to home page")
    public void theUserNavigateToHomePage() throws Exception {
        pageFactory.homePage().navigateToHomePage();
    }

    @And("click on Signup")
    public void clickOnSignup() throws Exception {
        pageFactory.homePage().signupFromHomePage();
    }
}
