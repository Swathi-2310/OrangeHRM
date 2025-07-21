package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import constants.FrameworkConstants;


public final class PropertyUtils {

    private PropertyUtils() {}

    private static final Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();
    
    static {
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
            property.load(fis);
            property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file.", e);
        }
    }

    public static String get(String key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key)) || CONFIGMAP.get(key).isEmpty()) {
            throw new RuntimeException("Property key '" + key + "' not found in config.properties");
        }
        return CONFIGMAP.get(key);
    }
}