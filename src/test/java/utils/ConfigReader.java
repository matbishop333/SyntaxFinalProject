package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    // Called once, usually from Hooks or BaseClass
    public static void loadProperties(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file: " + filePath);
        }
    }

    public static String get(String key) {
        if (properties == null) {
            loadProperties(Constants.CONFIG_FILE_PATH);
        }
        return properties.getProperty(key);
    }
}
