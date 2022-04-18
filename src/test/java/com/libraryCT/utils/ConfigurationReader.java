package com.libraryCT.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    public static void readProperties(String filePath) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

    public static int getPropertyNumber(String keyword){
        int r = Integer.parseInt(keyword);
        return r;
    }

}