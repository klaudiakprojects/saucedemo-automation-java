package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductsPage extends BasePage {

    public List<String> getProductsTitlesText() {
        List<WebElement> productsTitles = driver.findElements(By.className("inventory_item_name"));

        List<String> titlesText = new ArrayList<>();
        for (WebElement product : productsTitles) {
            titlesText.add(product.getText());
        }
        return titlesText;
    }

    public boolean checkIfProductTitlesAreUnique() {
        List<String> titles = getProductsTitlesText();
        Set<String> uniqueTitles = new HashSet<>(titles);
        return uniqueTitles.size() == titles.size();
    }
}
