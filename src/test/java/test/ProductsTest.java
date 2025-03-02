package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void areProductsTitlesUnique() {

        LoginPage loginPage = new LoginPage();
        loginPage.logInAsCorrectUser();
        ProductsPage productsPage = new ProductsPage();

        Assert.assertTrue(productsPage.checkIfProductTitlesAreUnique());
        }
    }

