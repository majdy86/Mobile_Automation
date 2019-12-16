package FactoryObjects;

import com.browserstack.local.Local;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropManager;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Amal on 1/13/2019.
 */
public class DriverFactory {

    private WebDriver driver ;
    private Local l;
    // public static final ThreadLocal<Logger> log = new ThreadLocal<Logger>();

    public DriverFactory() throws Exception {
        if (driver == null) {
            driver = getDriver();
        }
    }

    public WebDriver getDriver() throws Exception {
        if (driver == null) {
            setWebDriver(createInstance(PropManager.getInstance().getProperty("browser")));
        }
        return driver;
    }

    public WebDriver createInstance(String browserName) throws Exception {
        WebDriver driver;
        browserName = (browserName != null) ? browserName : "chrome";

        switch (Browser.valueOf(browserName.toUpperCase())) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/windows/fireFox/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", "drivers/windows/IE/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case CHROME:
                String USERNAME = "majdisuleiman1";
                String ACCESS_KEY = "BxJaxqF7ha2zUYNAezzx";
                String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", System.getProperty("browser"));

//                if (System.getProperty("local") != null && System.getProperty("local").equals("true")) {
//                    caps.setCapability("browserstack.local", "true");
//                    l = new Local();
//                    Map<String, String> options = new HashMap<String, String>();
//                    options.put("key", ACCESS_KEY);
//                    l.start(options);
//                }

                driver = new RemoteWebDriver(new URL(URL), caps);
//                System.setProperty("webdriver.chrome.driver", "drivers/windows/chrome/chromedriver.exe");
//                driver = new ChromeDriver();
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", "drivers/windows/edge/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drivers/windows/chrome/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        // maximize browser's window on start
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    private static enum Browser {
        FIREFOX,
        CHROME,
        IE,
        EDGE
    }


    public void setWebDriver(WebDriver driver) {
        if (driver != null) {
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.driver = driver;
        }

    }
}
