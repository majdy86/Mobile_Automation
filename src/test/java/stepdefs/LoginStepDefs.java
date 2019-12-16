package stepdefs;

import PageObjects.Login;
import FactoryObjects.PageFactory;
import io.cucumber.java.en.Given;
import FactoryObjects.DriverFactory;
import utils.PropManager;


public class LoginStepDefs {
    private String basePath = PropManager.getInstance().getProperty("login.base.path");
    PageFactory pageFactory;

    public LoginStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;

    }

    //private ApiConfig apiConfig;
    @Given("the user navigate to Login Page")
    public void theUserNavigateToLoginPage() throws Exception {

        pageFactory.loginPage().navigateToLoginPage();
        System.out.println("test");
    }
}
