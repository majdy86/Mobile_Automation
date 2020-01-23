package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SettingsStepDefs {

    PageFactory pageFactory;

    public SettingsStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;
    }

    @Given("the user navigate to Settings Page (.*) (.*)")
    public void theUserNavigateToLoginPage(String username, String password)  {
        pageFactory.loginPage().loggedInProjectManager(username,password);
        pageFactory.settingsPage().navigateToSettingsPage();
    }

    @And("clicks on general info from the settings list")
    public void clickOnGeneralInfo(){
        pageFactory.settingsPage().clickOnGeneralInfo();
    }

    @When("the user change the first name")
    public void changeFirstName(){
        pageFactory.getUser().setFirstName();
        pageFactory.settingsPage().changeFirstName(pageFactory.getUser().getFirstName());
    }

    @And("clicks on save button")
    public void clickOnSave(){
        pageFactory.settingsPage().clickOnSave();
    }

    @Then("the first name should be changed")
    public void checkNewFirstName(){
        pageFactory.settingsPage().checkNewFirstName(pageFactory.getUser().getFirstName());
    }
}
