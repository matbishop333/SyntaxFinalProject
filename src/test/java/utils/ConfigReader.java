package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String get(String path, String key) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(path);
        Properties properties=new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        return properties.getProperty(key);
    }

    public static String get(String key) throws IOException {
        return get(Constants.CONFIG_FILE_PATH, key);
    };



}
