package com.hos.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 20:41
 * Description: Get All Properties File
 */
public class HosConfiguration {

    private static HosConfiguration configuration;

    private static Properties properties;

    static {
        PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        configuration = new HosConfiguration();
        try {
            configuration.properties = new Properties();
            Resource[] resources = resourceLoader.getResources("classpath:*.properties");
            for (Resource resource : resources) {
                Properties props = new Properties();
                InputStream input = resource.getInputStream();
                props.load(input);
                input.close();
                configuration.properties.putAll(props);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HosConfiguration() {}

    public static HosConfiguration getConfiguration() {
        return configuration;
    }

    public String getString(String key) {
        return properties.getProperty(key);
    }

    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }

    public long getLong(String key) {
        return Long.parseLong(properties.getProperty(key));
    }

}
