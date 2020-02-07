package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='LOGIN']")
    WebElement loginButton;

    @FindBy(xpath="//div[text()='Products']")
    WebElement productsLabel;

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameTextBox));

        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }

    public boolean verifyLogin(){
        return productsLabel.isDisplayed()?true:false;
    }
}
