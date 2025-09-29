package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public By closeLocationInfo = By.className("onboarding__default-renderer-primary-button");
    public By productName1      = By.className("product-title");
    public By addToCartBtn      = By.cssSelector("button[data-testid='add-to-cart-button']");

    public ProductPage(WebDriverWait wait, WebDriver driver){
        this.wait = wait;
        this.driver = driver;
    }

    public void closeLocationIfPresent() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(closeLocationInfo));
            btn.click();
        } catch (TimeoutException ignored) { }
    }

    public String readProductName() {
        WebElement nameEl = wait.until(ExpectedConditions.visibilityOfElementLocated(productName1));
        String title = nameEl.getAttribute("title");
        return (title != null && !title.trim().isEmpty())
                ? title.trim()
                : nameEl.getText().replaceAll("\\s+"," ").trim();
    }

    public void addToCartOnce() {
        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        add.click();
    }

    public void addToCartNTimes(int times) {
        for (int i = 0; i < times; i++) {
            addToCartOnce();
        }
    }
}
