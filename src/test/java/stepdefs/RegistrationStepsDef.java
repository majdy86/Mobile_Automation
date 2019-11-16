package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import utils.PropManager;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class RegistrationStepsDef {

    // a global object will be created the moment the constructor get executed
    private ApiConfig apiConfig;

    private String basePath = PropManager.getInstance().getProperty("registration.base.path");

    public RegistrationStepsDef(ApiConfig apiConfig){
        this.apiConfig = apiConfig;
    }

    @Given("^the following valid registration data")
    public void validRegistrationData(Map<String, String> registerData){
        Map<String, String> map = new HashMap<>(registerData);

        apiConfig.setRequestSpecification( given()
                .contentType(ContentType.JSON)
                .body(registerData));



    }

    @When("the user calls the registration api")
    public void callRegisterationApi() {
        apiConfig.setResponse( apiConfig.getRequestSpecification().post(basePath));
    }



}
