package factoryObjects;

import com.browserstack.local.Local;
import enums.DriverType;
import enums.EnvironmentType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropManager;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileDriverFactory {

    private AppiumDriver driver;
    private Local local;
    DesiredCapabilities caps = new DesiredCapabilities();


    private void createDriver(){
        switch (EnvironmentType.getEnvironmentType()) {
            case LOCAL:
                setWebDriver(createLocalDriver());
                break;
        }
    }


    @SneakyThrows
    private AppiumDriver createLocalDriver() {

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropManager.getInstance().getProperty("mobile_platform"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,PropManager.getInstance().getProperty("mobile_platform_version"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,PropManager.getInstance().getProperty("mobile_device_name"));
        caps.setCapability(MobileCapabilityType.APP, getAbsoluteAppPath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropManager.getInstance().getProperty("mobile_automation_name"));
        caps.setCapability(MobileCapabilityType.FULL_RESET, PropManager.getInstance().getProperty("mobile_full_reset"));

        switch (DriverType.getMobileDriver()) {
            case ANDROID:
                caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, PropManager.getInstance().getProperty("app_activity"));
                caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PropManager.getInstance().getProperty("app_package"));
                caps.setCapability(AndroidMobileCapabilityType.AUTO_LAUNCH, PropManager.getInstance().getProperty("auto_launch"));
                caps.setCapability(AndroidMobileCapabilityType.AVD, PropManager.getInstance().getProperty("avd"));
                caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, PropManager.getInstance().getProperty("auto_grant_permissions"));

                driver = new AndroidDriver(new URL(PropManager.getInstance().getProperty("appium_server")), caps);
                break;

            case iOS:
                break;

        }
        return driver;
    }

    public AppiumDriver getDriver()  {
        if (driver == null) {
            createDriver();

        }
        driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
        return  driver;
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

        private void setWebDriver(AppiumDriver driver) {
        if (driver != null) {
            this.driver = driver;
        }
    }

    @SneakyThrows
    private String getAbsoluteAppPath(){
        File testingApp = new File(PropManager.getInstance().getProperty("mobile_app_folder_path")
                + File.separator +
                PropManager.getInstance().getProperty("mobile_app_name"));
        return testingApp.getAbsolutePath();
    }


}
