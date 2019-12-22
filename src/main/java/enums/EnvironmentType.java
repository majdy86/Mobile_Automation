package enums;

import utils.PropManager;

public enum EnvironmentType {
    LOCAL,
    REMOTE;

    public static EnvironmentType getEnvironmentType() {
        String environment = PropManager.getInstance().getProperty("environment").toLowerCase();
        EnvironmentType environmentType;
        switch (environment) {
            case "local":
                environmentType = LOCAL;
                break;
            case "remote":
                environmentType = REMOTE;
                break;
            default:
                throw new IllegalStateException("Unexpected environment value: " + environment);
        }
        return environmentType;
    }
}
