package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver = null;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateTo() {
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        //Assert.assertEquals("test app", driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LoginPage(driver); }

}
