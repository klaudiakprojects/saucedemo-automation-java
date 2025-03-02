package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    public static final String errorMessageText = "Epic sadface: Username and password do not match any user in this service";
    public static final String blockedUserMessageText = "Epic sadface: Sorry, this user has been locked out.";

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

    public ProductsPage logInAsCorrectUser() {
        String username = "standard_user";
        String password = "secret_sauce";

        return logIn(username, password);
    }

    public ProductsPage logIn(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return clickLoginButton();
    }

    public String wrongCredentialsErrorMessage() {
        By errorMessage = By.xpath("//div[@class='error-message-container error']/h3");
        return find(errorMessage).getText();
    }

    public String blockedUserErrorMessage() {
        By errorMessage = By.xpath("//div[@class='error-message-container error']/h3");
        return find(errorMessage).getText();
    }

}