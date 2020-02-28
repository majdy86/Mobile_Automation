package enums;

import utils.PropManager;

public enum DriverType {
    iOS,
    ANDROID;

    public static DriverType getMobileDriver() {
        String mobileDriverType = PropManager.getInstance().getProperty("mobile_platform").toLowerCase();
        DriverType driverType;
        switch (mobileDriverType) {
            case "ios":
                driverType = iOS;
                break;
            case "android":
                driverType = ANDROID;
                break;
            default:
                throw new IllegalStateException("Unexpected mobile driver value: " + mobileDriverType);
        }

        return driverType;
    }
}
