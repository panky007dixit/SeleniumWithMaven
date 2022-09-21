package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class BrowserStackTest {

    public static final String USERNAME = "buntydixit1";
    public static final String AUTOMATE_KEY = "8ptFQvWWTpyMwbemxLEN";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private static WebDriver driver = null;
    //public static void main(String[] args) throws Exception {
    public static WebDriver browserStack() throws Exception {
        String drivername = PropertiesUtil.getProperties("BrowserName");
        //String drivername = System.getProperty("BrowserName");
        /*Scanner scanner = new Scanner(System.in);
        String browsername = scanner.nextLine();*/
        //System.out.println("Input browsername : ");
        switch (drivername) {
            case "browserstack" :
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "11.0");
            caps.setCapability("browserstack.local", "false");
            caps.setCapability("browserstack.selenium_version", "3.14.0");
            return new RemoteWebDriver(new URL(URL), caps);
            case "local" :
                DesiredCapabilities localcaps = new DesiredCapabilities();
                localcaps.setCapability("os", "Windows");
                localcaps.setCapability("os_version", "10");
                localcaps.setCapability("browser", "Firefox");
                localcaps.setCapability("browser", "Firefox");
                localcaps.setCapability("browser_version", "74.0 beta");
                localcaps.setCapability("browserstack.local", "true");
                localcaps.setCapability("browserstack.selenium_version", "3.14.0");
                localcaps.setCapability("browserstack.localIdentifier", "Test007");
                driver = new RemoteWebDriver(new URL(URL), localcaps);
                //DesiredCapabilities.internetExplorer();
                //return new RemoteWebDriver(new URL(URL), localcaps);
                return driver;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + drivername);
        }
        /*driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());*/
       // driver.quit();
    }
}