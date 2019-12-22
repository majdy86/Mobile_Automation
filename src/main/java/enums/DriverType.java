package enums;

import utils.PropManager;

public enum DriverType {
    CHROME,
    FIREFOX,
    SAFARI;

    public static DriverType getBrowser() {
        String browserType = PropManager.getInstance().getProperty("browser").toLowerCase();
        DriverType driverType;
        switch (browserType) {
            case "firefox":
                driverType = FIREFOX;
                break;
            case "safari":
                driverType = SAFARI;
                break;
            case "chrome":
                driverType = CHROME;
                break;
            default:
                throw new IllegalStateException("Unexpected browserType value: " + browserType);
        }

        return driverType;
    }
}
