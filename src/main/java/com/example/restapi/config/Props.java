package com.example.restapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.example.restapi.config")
public class Props {
    private static String resourceFolder;

    public static String getResourceFolder() {
        return resourceFolder;
    }

    public static void setResourceFolder(String resourceFolder) {
        Props.resourceFolder = resourceFolder;
    }

}
