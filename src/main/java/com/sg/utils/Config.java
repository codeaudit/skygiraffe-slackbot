package com.sg.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by ayush on 8/11/16.
 */
public class Config {

    private static Properties prop;

    static{
        InputStream is = null;
        try {
            prop = new Properties();
            is = Config.class.getClassLoader().getResourceAsStream("config");
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}
