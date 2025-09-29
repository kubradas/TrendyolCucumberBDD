package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public By cartIcon      = By.className("account-basket");
    public By basketRowWrp  = By.cssSelector("div.pb-basket-item-wrapper-v2[data-content-id]");
    public By productName2  = By.cssSelector("p.pb-item");
    public By cartItem      = By.className("pb-basket-item");
    public By checkoutBtn   = By.cssSelector("a.ty-link-btn-primary");
    public By modal         = By.cssSelector(".pb-guest-order-flow-modal");
    public By twoButtons    = By.cssSelector(".pb-guest-order-flow-modal .two-buttons");
    public By guestBtn      = By.cssSelector(".pb-guest-order-flow-modal .two-buttons > button:first-of-type");
    public By loginBtn      = By.cssSelector(".pb-guest-order-flow-modal .two-buttons > button:last-of-type");


    public CartPage(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public WebElement firstRowWrapper() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(basketRowWrp));
    }

    public String firstItemName() {
        WebElement nameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(productName2));
        String title = nameEl.getAttribute("title");
        return (title != null && !title.trim().isEmpty())
                ? title.trim()
                : nameEl.getText().replaceAll("\\s+", " ").trim();
    }

    public int itemsCount() {
        return driver.findElements(cartItem).size();
    }

    public static String noSpacesLower(String s) {
        return (s == null) ? "" : s.replaceAll("\\s+", "").toLowerCase();
    }

    public void clickCheckoutBtn() {
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(checkoutBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ty-overlay, .loading, .spinner")));
        } catch (TimeoutException ignored) {}

        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }

    public void checkCheckoutOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(twoButtons));
        wait.until(ExpectedConditions.visibilityOfElementLocated(guestBtn));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
    }

    private boolean isVisible(By by) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofMillis(1500));
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean guestOptionIsDisplayed() { return isVisible(guestBtn); }
    public boolean loginOptionIsDisplayed() { return isVisible(loginBtn); }
}
