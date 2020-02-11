package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    WebElement cartIcon;

    @FindBys(@FindBy(xpath = "//div[@class='inventory_item']"))
    List<WebElement> products;

    int addedItemCount;

    public int addToCart(String productName, int count) {
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        String name;
        addedItemCount = 0;
        for (WebElement product : products) {
            if (addedItemCount == count) {
                break;
            }
            name = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if (name.toLowerCase().contains(productName.toLowerCase())) {
                product.findElement(By.xpath(".//button[text()='ADD TO CART']")).click();
                addedItemCount++;
            }
        }
        return addedItemCount;
    }

    public boolean verifyItemsAreAddedToCart() {
        return addedItemCount != 0 ? true : false;
    }

}
