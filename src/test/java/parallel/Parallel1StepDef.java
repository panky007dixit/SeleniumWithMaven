package parallel;

import helpers.PropertiesUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Parallel1StepDef {
    //String driverPath = "src//test//resources//chromedriver.exe";
    //String driverPath = "src//test//resources//IEDriverServer.exe";
    String driverPath = "src//test//resources//geckodriver.exe";
    WebDriver driver;
    @Given("I click on login link1")
    public void iClickOnLoginLink() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        //System.setProperty("webdriver.ie.driver", driverPath);
        //System.setProperty("webdriver.chrome.driver", driverPath);
        /*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", true);*/
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.setExperimentalOption("useAutomationExtension",false);*/
        driver = new FirefoxDriver();
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        driver.manage().window().maximize();
        String appTitle=driver.getTitle();
        System.out.println("Title is "+appTitle.toString());
        String expTitle="WebDriver";
        if (appTitle.equals (expTitle)){
            System.out.println("Verification Successfull");
        }
        else{
            System.out.println("Verification Failed");

        }
    }

    @When("I enter valid username and password1")
    public void iEnterValidUsernameAndPassword() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("wpName1")).sendKeys("Panky1991");
        //driver.findElement(By.xpath("//*[@id=\"wpName1\"]")).sendKeys("Panky1991");  //for chrome
        driver.findElement(By.id("wpPassword1")).sendKeys("Password@007");
        //driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]")).sendKeys("Password@007");  //for chrome
        driver.findElement(By.id("wpLoginAttempt")).click();
        //driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();   // for chrome
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Log out")).click();
        //driver.findElement(By.xpath("//*[@id=\"pt-logout\"]/a")).click();    //for chrome
    }

    @Then("I am able to login successfully1")
    public void iAmAbleToLoginSuccessfully() throws Exception {
        String location = PropertiesUtil.getProperties("PropertiesFileLocation");
        System.out.println("Properties File is located at "+ location);
        driver.quit();
    }
}
