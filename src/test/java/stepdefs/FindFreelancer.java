package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import utils.PropManager;

import static io.restassured.RestAssured.*;

public class FindFreelancer {
    private String basePath = PropManager.getInstance().getProperty("findfreelancers.base.path");

    private ApiConfig apiConfig;

    public FindFreelancer(ApiConfig apiConfig){
        this.apiConfig = apiConfig;
    }

    @Given("a valid find freelancer api")
    public void findFreelancer(){
        apiConfig.setRequestSpecification(given().basePath(basePath).contentType(ContentType.JSON));
    }

    @When("the user call the find freelancer api")
    public void callFindFreelancerApi(){
        apiConfig.setResponse(apiConfig.getRequestSpecification().get());
    }
}
