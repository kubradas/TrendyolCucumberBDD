package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.SearchResultsPage;
import utils.TestContextSetup;

public class SearchResultsPageStepDefinition {

    SearchResultsPage searchResultsPage;
    TestContextSetup testContextSetup;

    public SearchResultsPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        searchResultsPage = testContextSetup.pageObjectManager.getSearchResultsPage();
    }

    @And("I select the first product from the search results")
    public void SelectTheFirstProductFromSearchResults() {

        searchResultsPage.clickFirstVisibleProduct();

        WebElement productContainer = testContextSetup.wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchResultsPage.productId1));

        testContextSetup.expectedProductId = productContainer.getAttribute("data-id");
        System.out.println("Expected product id: " + testContextSetup.expectedProductId);

        testContextSetup.genericUtils.switchToNextPage();
        System.out.println("Switched to product page: " + testContextSetup.driver.getTitle());
    }

    @And("I sort products by {string}")
    public void SortProductsBySortType(String sortType) {
        searchResultsPage.selectSortType(sortType);
    }

    @Then("products should be displayed in {string} order")
    public void productsShouldBeDisplayedInSortTypeOrder(String sortType) {
        searchResultsPage.verifySelectedOrder(sortType);
    }
}

