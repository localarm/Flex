package com.pavel.flex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesReader {

    public static HashMap<String, String> read() {
        Properties props = new Properties();
        HashMap<String, String> properties = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(new File("./app.properties"));
            props.load(fis);
            properties.put("dateformat", props.getProperty("dateformat"));
            properties.put("daytime", props.getProperty("daytime"));
            properties.put("values", props.getProperty("values"));
            properties.put("imgexc", props.getProperty("imgexc"));
            properties.put("imagesdir", props.getProperty("imagesdir"));
            properties.put("word", props.getProperty("word"));
        } catch (IOException e) {
            System.out.println("cant read app.properties");
            System.exit(2);
        }
        return properties;
    }
}
