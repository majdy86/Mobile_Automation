package hooks;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import factoryObjects.MobileDriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;

public class Hooks {

    public MobileDriverFactory mobileDriverFactory;

    public Hooks(MobileDriverFactory mobileDriverFactory) {
        this.mobileDriverFactory = mobileDriverFactory;
    }

    @Before
    public void setup() {

    }

    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) mobileDriverFactory.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "./target/allure-results/" + System.currentTimeMillis() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            FileInputStream inputstream = new FileInputStream(new File(dest).getAbsolutePath());

            Allure.addAttachment("Screenshot", "Image", inputstream, ".png");

        }
        mobileDriverFactory.getDriver().closeApp();
        mobileDriverFactory.getDriver().quit();

    }

}
