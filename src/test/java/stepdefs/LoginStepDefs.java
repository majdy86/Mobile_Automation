package stepdefs;

import PageObjects.Login;
import PageObjects.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.PropManager;


public class LoginStepDefs {
    private String basePath = PropManager.getInstance().getProperty("login.base.path");

    //private ApiConfig apiConfig;
    private DriverManager driverManager;
    public static Login loginpage;

    public LoginStepDefs(DriverManager driverManager){
       this.driverManager = driverManager;
    }

    @Given("the user navigate to Login Page")
    public void theUserNavigateToLoginPage() {
        loginpage = PageFactory.loginPage(driverManager);
        loginpage.navigateToLoginPage();
        System.out.println("test");
    }
    /*@Given("^a (.*) and (.*)$")
    public void setupLoginApi(String username, String password) {
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);
        apiConfig.setRequestSpecification(given()
                .contentType(ContentType.JSON)
                .body(credentials));

    }


    @When("the user calls the login api")
    public void callTheLoginApi() {
       apiConfig.setResponse(apiConfig.getRequestSpecification().when().post(basePath));

    }





    @Then("the api should return a token")
    public void verifyTokenReturned(){
        apiConfig.getResponse().then().body("token", notNullValue());
    }*/
}
