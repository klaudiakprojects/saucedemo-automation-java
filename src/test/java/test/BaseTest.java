package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setupChrome() {
        driver = new ChromeDriver();
        driver.get(url);

        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}