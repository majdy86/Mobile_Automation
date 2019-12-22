package stepdefs;

import FactoryObjects.PageFactory;
import enums.UserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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

    @And("Fill the registration info")
    public void fillTheRegistrationInfo() {
        pageFactory.signupPage().filltheRegisterationInfoAndRegister();
    }
}
