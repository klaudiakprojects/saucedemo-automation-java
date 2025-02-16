package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.className(".error-message-container h3");
    public static final String errorMessageText = "Epic sadface: Username and password do not match any user in this service";

    public void typeUsername(String username) {
        set(usernameInput, username);
    }

    public void typePassword(String password) {
        set(passwordInput, password);
    }

    public ProductsPage clickLoginButton() {
        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage loginIn(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return clickLoginButton();
    }

    public String wrongCredentialsErrorMessage() {
        return find(errorMessage).getText();

    }
}