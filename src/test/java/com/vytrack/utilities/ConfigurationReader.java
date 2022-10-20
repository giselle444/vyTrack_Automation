package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {


        try {


            FileInputStream fileInputStream = new FileInputStream("configuration.properties");

            properties.load(fileInputStream);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String get_Property(String keyword){

        return properties.getProperty(keyword);
    }
}