package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.LoginPage.blockedUserMessageText;
import static pages.LoginPage.errorMessageText;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/inventory.html"));
    }

    @Test
    public void wrongCredentialsLogin() {
        loginPage.typeUsername("test");
        loginPage.typePassword("test");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("/inventory.html"));

        String actualErrorMessage = loginPage.wrongCredentialsErrorMessage();

        Assert.assertEquals(actualErrorMessage, errorMessageText);
    }

    @Test
    public void loginAsBlockedUser() {
        loginPage.typeUsername("locked_out_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("/inventory.html"));

        String actualErrorMessage = loginPage.wrongCredentialsErrorMessage();

        Assert.assertEquals(actualErrorMessage, blockedUserMessageText);
    }
}