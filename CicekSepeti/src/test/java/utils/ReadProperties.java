package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ReadProperties {

    public static ResourceBundle getProperties(String systemSourcesDir){

        ResourceBundle bundle = null;
        try {
            String propertyDir = "/src/test/resources/properties/"+systemSourcesDir+".properties";

            InputStream propertiesStream = new FileInputStream(System.getProperty("user.dir") + propertyDir);

            bundle = new PropertyResourceBundle(new InputStreamReader(propertiesStream, StandardCharsets.UTF_8));

            propertiesStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bundle;
    }
}