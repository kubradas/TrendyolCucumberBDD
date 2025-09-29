package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    WebDriverWait wait;
    WebDriver driver;

    public SearchResultsPage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

    public By resultsContainer = By.cssSelector(".prdct-cntnr-wrppr");
    public By productCardLink = By.cssSelector("div.p-card-wrppr.with-campaign-view a.p-card-chldrn-cntnr");
    public By productId1 = By.cssSelector("div[data-id]");

    public By sortDropdown = By.cssSelector(".search-sort-container");
    public By sortDropdownList = By.cssSelector("ul.search-dropdown");
    public By Recommended = By.cssSelector("ul.search-dropdown > li:nth-of-type(1)");
    public By PriceLow = By.cssSelector("ul.search-dropdown > li:nth-of-type(2)");
    public By PriceHigh = By.cssSelector("ul.search-dropdown > li:nth-of-type(3)");
    public By BestSeller = By.cssSelector("ul.search-dropdown > li:nth-of-type(4)");
    public By MostFavorite = By.cssSelector("ul.search-dropdown > li:nth-of-type(5)");
    public By Newest = By.cssSelector("ul.search-dropdown > li:nth-of-type(6)");
    public By MostEvaluated = By.cssSelector("ul.search-dropdown > li:nth-of-type(7)");
    public By selectedOrder = By.cssSelector(".selected-order");


    public List<WebElement> waitResults() {

        wait.until(ExpectedConditions.presenceOfElementLocated(resultsContainer));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCardLink));
    }

    public void clickFirstVisibleProduct() {
        List<WebElement> links = waitResults();

        WebElement firstVisible = links.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No visible product link"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", firstVisible);

        wait.until(ExpectedConditions.elementToBeClickable(firstVisible)).click();
    }

    public void selectSortType(String sortType){
        WebElement sortElement = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        sortElement.click();

        WebElement sortList = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdownList));

        switch (sortType) {
            case "Önerilen":
                sortList.findElement(Recommended).click();
                break;
            case "En düşük fiyat":
                sortList.findElement(PriceLow).click();
                break;
            case "En yüksek fiyat":
                sortList.findElement(PriceHigh).click();
                break;
            case "En çok satan":
                sortList.findElement(BestSeller).click();
                break;
            case "En favoriler":
                sortList.findElement(MostFavorite).click();
                break;
            case "En yeniler":
                sortList.findElement(Newest).click();
                break;
            case "En çok değerlendirilen":
                sortList.findElement(MostEvaluated).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid sort type: " + sortType);
        }
    }

    public void verifySelectedOrder(String sortType){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement selectedSort = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedOrder));
        String selectedText = selectedSort.getText();
        if(!selectedText.equals(sortType)){
            throw new IllegalStateException("Sort type mismatch: expected " + sortType + " but found " + selectedText);
        }
    }
}
