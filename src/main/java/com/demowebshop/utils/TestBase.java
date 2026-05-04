package com.demowebshop.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {

    private static WebDriver driver;
    private static String registeredEmail;
    private static String registeredPassword;

    public static void initializeDriver() {
        String browser = System.getenv("BROWSER") != null ? System.getenv("BROWSER") : "chrome";
        boolean isHeadless = Boolean.parseBoolean(System.getenv("HEADLESS"));
        boolean isCI = Boolean.parseBoolean(System.getenv("CI"));

        // For GitHub Actions, force headless if CI environment
        if (isCI) {
            isHeadless = true;
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");

                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");

                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.get("https://demowebshop.tricentis.com/");
    }

    // Rest of your existing code...
}