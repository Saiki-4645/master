package pagetests;

import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;
import utils.LoggerUtil;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    Logger logger;
    String browserName = "chrome";
    String url = "https://www.saucedemo.com/";
    String username = "standard_user";
    String password = "secret_sauce";

    @Before
    public void setup() {
        driver = DriverFactory.getDriver(browserName);
        logger = LoggerUtil.getLogger();
        driver.get(url);
        logger.info("Opened the Page.");
        loginPage = new LoginPage(driver);
        logger.info("Initialised the Page.");
    }

    @Test
    public void testLogin() {
        loginPage.login(username, password);
        logger.info("Trying to login.");
        assertTrue(loginPage.verifyLogin());
        logger.info("Successfully Logged In.");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
