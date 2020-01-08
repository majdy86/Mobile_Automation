package FactoryObjects;

import com.browserstack.local.Local;
import enums.DriverType;
import enums.EnvironmentType;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropManager;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private WebDriver driver;
    public WebDriverWait waitExplicit;
    private Local local;

    private void createDriver(){
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
        String OSPath = "";
        System.out.println("OS_Name:" + SystemUtils.OS_NAME + " OS_Vresion:" + SystemUtils.OS_VERSION);
        if(SystemUtils.OS_NAME.contains("Window"))
            OSPath = "_windows";

        if(SystemUtils.OS_NAME.contains("Linux"))
            OSPath = "_linux";
        switch (DriverType.getBrowser()) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                options.addArguments("--no-sandbox"); // Bypass OS security model
                options.addArguments("--headless");
                System.setProperty("webdriver.chrome.driver", "drivers" + File.separator+ "chrome" + File.separator + PropManager.getInstance().getProperty("chrome_filename" + OSPath));
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/fireFox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver createRemoteDriver() {
        String USERNAME = PropManager.getInstance().getProperty("browserstack_username");
        String ACCESS_KEY = PropManager.getInstance().getProperty("browserstack_access_key");
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", System.getProperty("browser"));
        caps.setCapability("project","Project-1");
        caps.setCapability("build","1.0");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.networkLogs", "true");
        try{
            if (System.getProperty("local") != null && System.getProperty("local").equals("true")) {
                caps.setCapability("browserstack.local", "true");
                local = new Local();
                Map<String, String> options = new HashMap<String, String>();
                options.put("key", ACCESS_KEY);
                local.start(options);
            }
            return driver = new RemoteWebDriver(new URL(URL), caps);
        }catch (Exception e){
            throw new RuntimeException("Couldn't initialize Remote Driver");
        }
    }

    public WebDriver getDriver()  {
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

    public long getExplicitlyWait(){
        String explicitlyWait = PropManager.getInstance().getProperty("explicitlyWait");
        if(explicitlyWait != null){
            try{
                return Long.parseLong(explicitlyWait);
            }catch(NumberFormatException e){
                throw new RuntimeException("Not able to parse value: " + explicitlyWait);
            }
        }
        return 30;
    }

        private void setWebDriver(WebDriver driver) {
        if (driver != null) {
            this.driver = driver;
        }
    }

  public WebDriverWait getwaitExplicit(WebDriver driver)  {
        if (waitExplicit == null) {

            waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(getExplicitlyWait()));
        }
       return waitExplicit;

    }

}
