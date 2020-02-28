package utils;

import java.io.IOException;
import java.util.Properties;


public class PropManager {

    private static PropManager instance = null;
    private Properties properties;


    private PropManager() throws IOException {

        properties = new Properties();
        properties.load(getClass().getResourceAsStream("/configration.properties"));
        properties.load(getClass().getResourceAsStream("/mobiles_capabilites.properties"));
        properties.load(getClass().getResourceAsStream("/android_capabilites.properties"));

    }

    public static PropManager getInstance() {
        if (instance == null) {
            try {
                instance = new PropManager();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }


    /**
     * searches for the property with the specified key in this property
     *
     * @param key
     * @return the value for the property
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * @param key
     * @return the property value as an integer for the given key
     */
    public Integer getPropertyAsInt(String key) {
        String p = this.getProperty(key);
        if (p != null) {
            return Integer.parseInt(p);
        } else {
            return null;
        }
    }

    /**
     * @param key
     * @return the property value as a float for the given key.
     */
    public Float getPropertyAsFloat(String key) {
        String p = this.getProperty(key);
        if (p != null) {
            return Float.parseFloat(p);
        } else {
            return null;
        }


    }
}
