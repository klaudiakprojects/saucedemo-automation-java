package test;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
        loginPage.clickLoginButton();
    }
}