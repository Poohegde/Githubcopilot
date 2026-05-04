package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    // Locators for elements on the home page
    private By welcomeMessage = By.id("welcomeMessage");
    private By searchBox = By.id("searchBox");
    private By searchButton = By.id("searchButton");
    private By searchResults = By.id("searchResults");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to verify the presence of the welcome message
    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public boolean isHomePageDisplayed() {
        return isWelcomeMessageDisplayed();
    }

    // Method to search for an item
    public void searchForItem(String item) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(item);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultsDisplayed() {
        return !driver.findElements(searchResults).isEmpty() && driver.findElement(searchResults).isDisplayed();
    }
}