package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class HomePage extends BasePage {
    @FindBy(how = How.LINK_TEXT, linkText = "Log out")
    private WebElement logoutlink;
    @FindBy(how = How.LINK_TEXT, linkText = "Panky1991")
    private WebElement mainpagelabel;

    public HomePage (WebDriver driver) {
        super(driver);
    }
    public void verifyLogin(String loginName) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // check home page
        wait.until(ExpectedConditions.visibilityOfAllElements(Arrays.asList(mainpagelabel, logoutlink)));
        wait.until(ExpectedConditions.textToBePresentInElement(mainpagelabel, loginName));
        logoutlink.click();
        System.out.println("End of Test");
    }
}