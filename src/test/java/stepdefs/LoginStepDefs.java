package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PropManager;


public class LoginStepDefs {

    PageFactory pageFactory;

    public LoginStepDefs(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }

    @Given("the user navigate to Login Page")
    public void theUserNavigateToLoginPage() {

        pageFactory.loginPage().navigateToLoginPage();
    }

    @And("fill the username field with (.*) (.*)")
    public void setUsername(String unusedParam, String username) {
        pageFactory.loginPage().setEmail(username);
    }

    @And("fill the password field with (.*) (.*)")
    public void setPassword(String unusedParam, String password) {
        pageFactory.loginPage().setPassword(password);
    }

    @When("the user clicks on sign in button")
    public void clickSignin() {
        pageFactory.loginPage().clickSignIn();
    }

    @Then("the user should be redirected to projects list page")
    public void findFilterHeader() {
        pageFactory.projectsListPage().checkFilterHeader();
    }

    @Then("the following error message should displays \"These credentials do not match our records.\"")
    public void invalidPasswordErrMsg(){
        pageFactory.loginPage().invalidCredentialsErrMsg();
    }

    @Then("the user should get a message that password is required")
    public void checkEmptyPassword(){
        pageFactory.loginPage().checkPasswordRequired();
    }

    @Then("the user should get a message that username is required")
    public void checkEmptyUsername(){
        pageFactory.loginPage().checkUsernameRequired();
    }


}
