package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasePage {
    @FindBy(how = How.LINK_TEXT, linkText = "Log in")
    private WebElement loginlink;
    @FindBy(how = How.ID, id = "wpName1")
    private WebElement usernameInputElement;
    @FindBy(how = How.ID, id = "wpPassword1")
    private WebElement passwordElement;
    @FindBy(how = How.ID, id = "wpLoginAttempt")
    private WebElement loginbutton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        loginlink.click();
        usernameInputElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginbutton.click();
        return new HomePage(driver);
    }
}