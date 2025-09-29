package stepDefinitions;

import io.cucumber.java.en.And;
import org.testng.Assert;
import pageObjects.ProductPage;
import utils.TestContextSetup;

public class ProductPageStepDefinition {

    TestContextSetup testContextSetup;
    ProductPage productPage;

    public ProductPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.productPage = testContextSetup.pageObjectManager.getProductPage();
    }

    @And("I add the first product to the cart")
    public void AddTheProductToTheCart() {
        productPage.closeLocationIfPresent();

        testContextSetup.expectedProductName = productPage.readProductName();
        System.out.println("Adding to cart: " + testContextSetup.expectedProductName);

        productPage.addToCartNTimes(1);
    }

    @And("I add the first product to the cart {string} times")
    public void AddProductToTheCartMultipleTimes(String countStr) {
        productPage.closeLocationIfPresent();

        if (testContextSetup.expectedProductName == null || testContextSetup.expectedProductName.trim().isEmpty()) {
            testContextSetup.expectedProductName = productPage.readProductName();
        }
        System.out.println("Adding multiple: " + testContextSetup.expectedProductName);

        int times;
        try {
            times = Integer.parseInt(countStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Count must be an integer, got: " + countStr);
        }
        Assert.assertTrue(times > 0, "Count must be > 0");

        productPage.addToCartNTimes(times);
    }
}
