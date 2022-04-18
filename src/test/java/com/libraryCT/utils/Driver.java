package com.libraryCT.utils;

import com.libraryCT.constants.Constants;
import com.libraryCT.testbase.PagesInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        ConfigurationReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        if (driverPool.get()==null){

            String browserType = ConfigurationReader.getProperty("browser").toLowerCase();
            String headless = ConfigurationReader.getProperty("headless").toLowerCase();

            switch (browserType){
                case "remote-chrome":
                    try{
                        String gridAddress= ConfigurationReader.getProperty("gridAddress");
                        URL url = new URL("https://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case "remote-firefox":
                    try{
                        String gridAddress= ConfigurationReader.getProperty("gridAddress");
                        URL url = new URL("https://"+gridAddress+":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url,desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless.equalsIgnoreCase("true")) {
                        chromeOptions.setHeadless(true);
                        driverPool.set(new ChromeDriver(chromeOptions));
                    } else {
                        driverPool.set(new ChromeDriver());
                    }
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless.equalsIgnoreCase("true")) {
                        firefoxOptions.setHeadless(true);
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                    } else {
                        driverPool.set(new FirefoxDriver());
                    }
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.set(new OperaDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    break;
                default:
                    throw new RuntimeException("Browser is not supported");
            }
        }
        if (ConfigurationReader.getProperty("windowMaximize").equalsIgnoreCase("true")){
            driverPool.get().manage().window().maximize();
        } else {
            int w = Integer.parseInt(ConfigurationReader.getProperty("windowWidth") );
            int h = Integer.parseInt(ConfigurationReader.getProperty("windowHeight") );
            driverPool.get().manage().window().setSize(new Dimension(w, h));
        }
        driverPool.get().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().close();
            driverPool.remove();
        }
    }
}