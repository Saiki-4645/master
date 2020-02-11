package pagetests;

import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.LoggerUtil;

import static org.junit.Assert.assertTrue;

public class AddToCartTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    Logger logger;
    String browserName = "chrome";
    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";
    String itemName = "T-shirt";
    int itemCount = 2;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver(browserName);
        logger = LoggerUtil.getLogger();
        driver.get(url);
        logger.info("Opened the Page.");
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        logger.info("Successfully Logged In.");
        homePage = new HomePage(driver);
    }

    @Test
    public void testAddToCart() {
        logger.info("Trying to add items to cart.");
        int addedItemsCount = homePage.addToCart(itemName, itemCount);
        logger.info("Added " + addedItemsCount + " " + itemName + "s to Cart.\n");
        assertTrue(homePage.verifyItemsAreAddedToCart());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
