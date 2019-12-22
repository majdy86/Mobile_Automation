package stepdefs;

import FactoryObjects.PageFactory;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utils.PropManager;


public class LoginStepDefs {
    private String basePath = PropManager.getInstance().getProperty("login.base.path");
    PageFactory pageFactory;

    public LoginStepDefs(PageFactory pageFactory){
        this.pageFactory = pageFactory;
    }

    @Given("the user navigate to Login Page")
    public void theUserNavigateToLoginPage() throws Exception {

        pageFactory.loginPage().navigateToLoginPage();
        System.out.println("test");
//        Assert.assertEquals(5, 3);
    }


}
