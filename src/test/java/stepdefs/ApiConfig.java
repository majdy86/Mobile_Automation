package stepdefs;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiConfig {

    RequestSpecification RequestSpecification;
    ValidatableResponse json;
    Response Response;
    String Token;
}
