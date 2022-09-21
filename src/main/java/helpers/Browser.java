package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Browser {
    protected WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browserName) throws Exception{
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src//test//resources//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testParameterWithXML() throws InterruptedException{
        driver.get("https://www.google.co.in/");
        System.out.println(""+driver.toString());
        driver.findElement(By.name("q")).sendKeys("login");
    }
}