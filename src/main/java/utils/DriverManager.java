package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amal on 1/13/2019.
 */
public class DriverManager {

    private WebDriver driver ;
    // public static final ThreadLocal<Logger> log = new ThreadLocal<Logger>();

    public DriverManager(){
        if (driver == null) {
            driver = getDriver();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setWebDriver(createInstance(PropManager.getInstance().getProperty("browser")));
        }
        return driver;
    }

    public WebDriver createInstance(String browserName) {
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
                System.setProperty("webdriver.chrome.driver", "drivers/windows/chrome/chromedriver.exe");
                driver = new ChromeDriver();
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
