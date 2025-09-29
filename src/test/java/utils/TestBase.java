package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String URL = prop.getProperty("url");
        String browser_prop = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false"));

        String browser = (browser_maven!=null) ? browser_maven : browser_prop;

        if(driver == null) {
            if (browser.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("start-maximized");

                if (headless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                }
                driver = new ChromeDriver(options);
            }
            if (browser.equalsIgnoreCase("firefox")){
                FirefoxOptions options = new FirefoxOptions();
                if (headless) {
                    options.addArguments("--headless");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--disable-gpu");
                }
                driver = new FirefoxDriver(options);
            }
            driver.get(URL);
        }
        return driver;
    }
}
