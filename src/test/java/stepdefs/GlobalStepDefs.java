package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import utils.PropManager;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GlobalStepDefs {

    private ApiConfig apiConfig;

    public GlobalStepDefs(ApiConfig apiConfig){
        this.apiConfig = apiConfig;
    }


    @Then("the api should return status code of {int}")
    public void verifyStatusCode(int statusCode) {
        apiConfig.getResponse().then().statusCode(statusCode);
    }

    @Given("a logged in {word}")
    public void loggedInEmployer(Map<String,String> credentials){
        apiConfig.setRequestSpecification(given().contentType(ContentType.JSON).body(credentials));
        apiConfig.setResponse(apiConfig.getRequestSpecification().post(PropManager.getInstance().getProperty("login.base.path")));
        apiConfig.setToken(apiConfig.getResponse().then().statusCode(200).extract().path("token"));
        System.out.println(apiConfig.Token);
    }

}
