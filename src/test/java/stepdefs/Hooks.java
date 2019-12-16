package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import FactoryObjects.DriverFactory;


public class Hooks {

    public DriverFactory driverFactory;

    public Hooks(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
    }

    @Before
    public void setup(){
    }

    @After
    public void tearDown() throws Exception {
        driverFactory.getDriver().quit();

    }
}
