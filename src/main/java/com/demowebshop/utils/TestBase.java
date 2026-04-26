package com.demowebshop.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    private static WebDriver driver;
    private static String registeredEmail;
    private static String registeredPassword;

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void setRegisteredEmail(String email) {
        registeredEmail = email;
    }

    public static String getRegisteredEmail() {
        return registeredEmail;
    }

    public static void setRegisteredPassword(String password) {
        registeredPassword = password;
    }

    public static String getRegisteredPassword() {
        return registeredPassword;
    }
}