package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    // Locators for the registration form elements
    private By usernameField = By.id("username");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registerButton = By.id("register");
    private By successMessage = By.id("successMessage");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill out the registration form
    public void fillRegistrationForm(String username, String email, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to submit the registration form
    public void submitRegistration() {
        driver.findElement(registerButton).click();
    }

    // Method to verify successful registration
    public boolean isRegistrationSuccessful() {
        WebElement message = driver.findElement(successMessage);
        return message.isDisplayed() && message.getText().contains("Registration successful");
    }
}