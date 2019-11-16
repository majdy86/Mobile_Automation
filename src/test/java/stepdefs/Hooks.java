package stepdefs;

import PageObjects.PageFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import utils.DriverManager;
import utils.PropManager;


public class Hooks {

    public DriverManager driverManager;

    public Hooks(DriverManager driverManager){
        this.driverManager = driverManager;
    }

    @Before
    public void setup(){
    }

    @After
    public void tearDown(){
        System.out.println("test");
        driverManager.getDriver().quit();

    }
}
