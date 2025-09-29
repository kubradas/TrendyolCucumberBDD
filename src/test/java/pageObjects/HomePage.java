package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriverWait wait;
    WebDriver driver;

    public HomePage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

    public By closeModal = By.cssSelector(".modal-section-close");
    public By rejectAllCookies = By.id("onetrust-reject-all-handler");
    public By searchInputBy = By.cssSelector("input[data-testid='suggestion']");
    public By cookieContainer = By.className(".ot-sdk-container");
    public By suggestionItems = By.cssSelector("a[data-testid='suggestion-item']");

    public void SearchItem(String name) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchInputBy));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionItems));
    }

    public void getSearchTextAndClick() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement firstSuggestion = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(suggestionItems)));
        String category = firstSuggestion.getText();
        System.out.println("Category found: " + category);
        firstSuggestion.click();
    }
}
