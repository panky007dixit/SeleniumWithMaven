package stepdefs;

import com.google.common.base.Verify;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import helpers.PropertiesUtil;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    WebDriver driver;

    //String driverPath = "src//test//resources//chromedriver.exe";
    //String driverPath = "src//test//resources//IEDriverServer.exe";
    //String driverPath = "src//test//resources//geckodriver.exe";
    @Given("I click on login link")
    public void iClickOnLoginLink() {
        //System.setProperty("webdriver.gecko.driver", driverPath);
        //System.setProperty("webdriver.ie.driver", driverPath);
        //System.setProperty("webdriver.chrome.driver", driverPath);
        /*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", true);*/
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.setExperimentalOption("useAutomationExtension",false);*/
        //driver = new FirefoxDriver();
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        driver.manage().window().maximize();
        String appTitle = driver.getTitle();
        System.out.println("Title is " + appTitle.toString());
        String expTitle = "WebDriver";
        if (appTitle.equals(expTitle)) {
            System.out.println("Verification Successful");
        } else {
            System.out.println("Verification Failed");

        }
    }

    @When("I enter valid username and password")
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

    @Then("I am able to login successfully")
    public void iAmAbleToLoginSuccessfully() throws Exception {
        String location = PropertiesUtil.getProperties("PropertiesFileLocation");
        System.out.println("Properties File is located at " + location);
        driver.quit();
    }

    //@Test(expected = ArithmeticException.class)
    @Given("I test exception for (.*)")
    public void iTestException(String count) throws Exception {
        //Boolean status = true;
        /*while (Integer.valueOf(count)> 0) {
            if (Integer.valueOf(count) == 0) {
                break;
            } else {*/
                int val1, val2;
                try {
                    //this block will contain statements that may raise exceptions
                    System.out.println("Try Block:: Start");
                    val1 = Integer.valueOf(count);
                    val2 = 25 / val1;
                    System.out.println(val2);
                    System.out.println("Try Block:: End");
                } catch (ArithmeticException e) {
                    //handler for ArithmeticException
                    System.out.println("ArithmeticException :: Divide by Zero!!" + e.getMessage());
            /*String driverPath = "src//test//resources//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            WebDriver driver = new ChromeDriver();
            driver.quit();*/
                    if (e.getMessage().contains("by zero")) {
                        System.out.println("Exception Skipped - Test Case not executed");
                        //Verify.verify(e.getMessage().contains("by zero"));
                        //Assert.assertTrue(e.getMessage().contains("by zero"));
                        //System.exit(0);
                        //break;
                    } else {
                        throw new Exception(e);
                    }
                } //status = false;
           // }
            System.out.println("Outside try-catch:: Rest of the code.");
        }
   // }

    @And("exception is validated successfully")
    public void exceptionIsValidatedSuccessfully() {
        System.out.println("Validation done");
    }
}
