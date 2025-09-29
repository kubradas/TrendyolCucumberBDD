package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.CartPage;
import utils.TestContextSetup;

public class CartPageStepDefinition {

    TestContextSetup testContextSetup;
    CartPage cartPage;

    public CartPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @Then("I should see the product in the cart")
    public void ProductAddedToTheCartSuccessfully() {

        cartPage.openCart();

        WebElement rowWrapper = cartPage.firstRowWrapper();
        String actualProductId   = rowWrapper.getAttribute("data-content-id");
        String actualProductName = cartPage.firstItemName();

        System.out.println("Product in cart (name): " + actualProductName);
        if (actualProductId != null && !actualProductId.trim().isEmpty()) {
            System.out.println("Product in cart (id): " + actualProductId);
        }

        if (testContextSetup.expectedProductId != null &&
                !testContextSetup.expectedProductId.trim().isEmpty()) {
            Assert.assertEquals(actualProductId, testContextSetup.expectedProductId,
                    "Product IDs didn't match between PDP and Cart!"
            );
        }

        Assert.assertEquals(CartPage.noSpacesLower(actualProductName),
                CartPage.noSpacesLower(testContextSetup.expectedProductName),
                "Product names didn't match! expected [" + testContextSetup.expectedProductName + "] but found [" + actualProductName + "]"
        );

        Assert.assertTrue(cartPage.itemsCount() > 0, "No items found in the cart!");
        System.out.println("Product successfully added to the cart. Total items: " + cartPage.itemsCount());
    }

    @Then("I proceed to checkout and see login & guest checkout options")
    public void ProceedToCheckoutAndSeeOptions() {
        cartPage.openCart();
        cartPage.clickCheckoutBtn();
        cartPage.checkCheckoutOptions(); // modal + buttons visible

        Assert.assertTrue(cartPage.guestOptionIsDisplayed(),
                "Guest checkout option is not displayed (modal not opened or selector changed).");

        Assert.assertTrue(cartPage.loginOptionIsDisplayed(),
                "Login option is not displayed (modal not opened or selector changed).");
    }
}
