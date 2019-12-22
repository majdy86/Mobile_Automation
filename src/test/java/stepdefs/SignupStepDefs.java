package stepdefs;

import FactoryObjects.PageFactory;
import enums.UserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class SignupStepDefs {

    PageFactory pageFactory;

    public SignupStepDefs(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }


    @When("the user complete the sign-up workflow for a (.*)")
    public void theUserCompleteTheSignUpWorkflowForAPM(UserType userType) {
        pageFactory.signupPage().selectUserType(userType);

    }

    @When("the user select (.*) as a user type")
    public void theUserSelectPMAsAUserType(UserType userType) {
        pageFactory.signupPage().selectUserType(userType);
    }

    @And("click on Next")
    public void clickOnNext() {
        pageFactory.signupPage().clickOnNext();
    }

    @And("Fill the (.*) registration info")
    public void fillTheRegistrationInfo(String scenarioCase , Map<String, String> registrationInfo) {
        pageFactory.signupPage().filltheRegisterationInfo(registrationInfo);
    }


}
