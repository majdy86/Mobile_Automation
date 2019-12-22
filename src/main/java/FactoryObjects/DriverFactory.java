package FactoryObjects;

import com.browserstack.local.Local;
import enums.DriverType;
import enums.EnvironmentType;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropManager;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;
    private Local local;

    private void createDriver() throws Exception {
        switch (EnvironmentType.getEnvironmentType()) {
            case LOCAL:
                setWebDriver(createLocalDriver());
                break;
            case REMOTE:
                setWebDriver(createRemoteDriver());
                break;
        }
    }


    private WebDriver createLocalDriver() {
        String windowsPath = "";
        if(SystemUtils.OS_NAME.contains("Window"))
            windowsPath = "_windows";
        switch (DriverType.getBrowser()) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "drivers" + File.separator+ "chrome" + File.separator + PropManager.getInstance().getProperty("chrome_filename" + windowsPath));
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/windows/fireFox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                break;
        }
        return driver;
    }

    public WebDriver createRemoteDriver() throws Exception {
        String USERNAME = PropManager.getInstance().getProperty("browserstack_username");
        String ACCESS_KEY = PropManager.getInstance().getProperty("browserstack_access_key");
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", System.getProperty("browser"));
        caps.setCapability("project","Project-1");
        caps.setCapability("build","1.0");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", "true");

        if (System.getProperty("local") != null && System.getProperty("local").equals("true")) {
            caps.setCapability("browserstack.local", "true");
            local = new Local();
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", ACCESS_KEY);
            local.start(options);
        }
        return driver = new RemoteWebDriver(new URL(URL), caps);

    }

    public WebDriver getDriver() throws Exception {
        if (driver == null) {
            createDriver();

        }
        driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public long getImplicitlyWait(){
        String implicitlyWait = PropManager.getInstance().getProperty("implicitlyWait");
        if(implicitlyWait != null){
            try{
                return Long.parseLong(implicitlyWait);
            }catch(NumberFormatException e){
                throw new RuntimeException("Not able to parse value: " + implicitlyWait);
            }
        }
        return 30;
    }

        private void setWebDriver(WebDriver driver) {
        if (driver != null) {
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.driver = driver;
        }

    }

}
