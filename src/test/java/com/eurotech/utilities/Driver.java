package com.eurotech.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver() {}

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome": //Chrome - chrome - cHROME
                  // selenium-java --> before version  4.6.0
                    driver = new ChromeDriver(); // Polymorphism
                    break;
                case "chrome-headless":

                    driver = new ChromeDriver(new ChromeOptions());
                    break;
                case "firefox":

                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":

                    driver = new FirefoxDriver(new FirefoxOptions());
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");

                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");

                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");

                    driver = new SafariDriver();
                    break;
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
