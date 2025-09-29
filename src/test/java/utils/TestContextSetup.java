package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObjectManager;

import java.io.IOException;
import java.time.Duration;

public class TestContextSetup {

    public WebDriver driver;
    public WebDriverWait wait;
    public String expectedProductId;
    public String expectedProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        driver = testBase.WebDriverManager();
        wait   = new WebDriverWait(driver, Duration.ofSeconds(5));
        pageObjectManager = new PageObjectManager(driver, wait);
        genericUtils = new GenericUtils(driver);
    }
}
