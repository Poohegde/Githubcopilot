package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.DriverFactory;
import utils.DatabaseUtils;

public class UiTests {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        String baseUrl = System.getenv("APP_BASE_URL");
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = "https://automationexercise.com/";
        }
        driver.get(baseUrl);

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void testRegistration() {
        registrationPage.fillRegistrationForm("testuser", "test@example.com", "password123");
        registrationPage.submitRegistration();
        Assert.assertTrue(registrationPage.isRegistrationSuccessful(), "Registration failed.");
    }

    @Test(priority = 2)
    public void testDatabaseVerification() {
        String username = "testuser";
        Assert.assertTrue(DatabaseUtils.isUserRegistered(username), "User not found in the database.");
    }

    @Test(priority = 3)
    public void testLogin() {
        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("password123");
        loginPage.submitLogin();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after login.");
    }

    @Test(priority = 4)
    public void testSearchItem() {
        homePage.searchForItem("item name");
        Assert.assertTrue(homePage.isSearchResultsDisplayed(), "Search results are not displayed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}