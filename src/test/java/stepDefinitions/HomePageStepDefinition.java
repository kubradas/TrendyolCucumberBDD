package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import utils.TestContextSetup;

import java.time.Duration;

public class HomePageStepDefinition {

    HomePage homePage;
    TestContextSetup testContextSetup;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        homePage = testContextSetup.pageObjectManager.getHomePage();
    }

    @Given("I am on the homepage")
    public void OnTheHomepage() {
        // modal & cookie
        testContextSetup.wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.closeModal)).click();
        testContextSetup.wait.until(ExpectedConditions.elementToBeClickable(homePage.rejectAllCookies)).click();
        testContextSetup.wait.until(ExpectedConditions.invisibilityOfElementLocated(homePage.cookieContainer));
    }

    @When("^I search for (.+) and select actual name of category$")
    public void SearchForAndSelectActualNameOfCategory(String shortName) {
        testContextSetup.wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
        homePage.SearchItem(shortName);
        homePage.getSearchTextAndClick();
    }
}
