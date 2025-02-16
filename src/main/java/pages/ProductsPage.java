package pages;

import pages.BasePage;

public class ProductsPage extends BasePage {

    public boolean productsPageUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("/inventory.html");
    }

}
