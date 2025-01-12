package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading config.properties file: " + e.getMessage());
            throw new RuntimeException("Failed to load config.properties file!", e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Error closing FileInputStream: " + e.getMessage());
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
