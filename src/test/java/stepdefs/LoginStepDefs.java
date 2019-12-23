package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropManager;


public class LoginStepDefs {

    PageFactory pageFactory;

    public LoginStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;
    }

    @Given("the user navigate to Login Page")
    public void theUserNavigateToLoginPage() throws Exception {

        pageFactory.loginPage.navigateToLoginPage();
    }

    @And("fill the username field with (.*) (.*)")
    public void setUsername(String unusedParam, String username){
        pageFactory.loginPage.setEmail(username);
    }

    @And("fill the password field with (.*) (.*)")
    public void setPassword(String unusedParam, String password){
        pageFactory.loginPage.setPassword(password);
    }

    @When("the user clicks on sign in button")
    public void clickSignin() throws Exception {
        pageFactory.loginPage.clickSignIn();
    }

    @Then("the user should be redirected to projects list page")
    public void findFilterHeader(){

    }
}
