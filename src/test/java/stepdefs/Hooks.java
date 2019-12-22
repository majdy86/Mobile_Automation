package stepdefs;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import FactoryObjects.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;

public class Hooks {

    public DriverFactory driverFactory;

    public Hooks(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    @Before
    public void setup() {

    }

    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driverFactory.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "./target/allure-results/" + System.currentTimeMillis() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            FileInputStream inputstream = new FileInputStream(new File(dest).getAbsolutePath());

            Allure.addAttachment("Screenshot", "Image", inputstream, ".png");

        }

        driverFactory.getDriver().quit();

    }

}
