package stepdefs;

import FactoryObjects.PageFactory;
import enums.UserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class SignupStepDefs {

    PageFactory pageFactory;

    public SignupStepDefs(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }


    @When("the user select (.*) as a user type")
    public void theUserSelectPMAsAUserType(UserType userType) {
        pageFactory.selectUserTypePage().selectUserType(userType);
    }

    @And("click on Next")
    public void clickOnNext() {
        pageFactory.selectUserTypePage().clickOnNext();
    }

    @And("Fill the (.*) registration info")
    public void fillTheRegistrationInfo(String scenarioCase , Map<String, String> registrationInfo) {
        pageFactory.signupPage().filltheRegisterationInfo(registrationInfo);
    }


    @And("Agree To Terms & Conditions")
    public void agreeToTermsConditions() {
        pageFactory.signupPage().agreeToTerms();
    }

    @And("Click on Register")
    public void clickOnRegister() {
        pageFactory.signupPage().clickOnRegister();
    }

    @Then("the user should get redirected to Activate account page")
    public void theUserShouldGetRedirectedToActivateAccountPage() {
        pageFactory.signupPage().checkRegisterButtonIsNotDisplayed();

    }
}
