package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public ProductPage productPage;
    public CartPage cartPage;
    public SearchResultsPage searchResultsPage;

    public PageObjectManager(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public HomePage getHomePage(){
        homePage = new HomePage(wait, driver);
        return homePage;
    }

    public ProductPage getProductPage(){
        productPage = new ProductPage(wait, driver);
        return productPage;
    }

    public CartPage getCartPage(){
        cartPage = new CartPage(wait, driver);
        return cartPage;
    }

    public SearchResultsPage getSearchResultsPage(){
        searchResultsPage = new SearchResultsPage(wait, driver);
        return searchResultsPage;
    }
}
