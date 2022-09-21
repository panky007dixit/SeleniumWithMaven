package stepdefs;

import helpers.BrowserStackTest;
import helpers.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginStep {
    private static WebDriver driver = null;
    private LoginPage loginPage;
    private HomePage homePage;

   /* @Before
    public void startUp() {
        //make sure you download chrome driver and copy to resource folder.
        System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }*/

   /*public LoginStep() throws Exception {
       driver= BrowserStackTest.browserStack();
   }*/
    @Given("^I navigate app$")
    public void i_navigate_app() throws Throwable {
        //System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
        //driver = new FirefoxDriver();
        driver= BrowserStackTest.browserStack();
        //driver= WebDriverFactory.createWebDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    @When("^enter user id and enter password$")
    public void enter_user_id_and_enter_password() throws Throwable {
        loginPage.login("Panky1991", "Password@007");
    }

    @Then("^I go to the mail app with mail panel$")
    public void i_goto_the_mail_app_with_mail_panel() throws Throwable {
        homePage = new HomePage(driver);
        homePage.verifyLogin("Panky1991");
        driver.quit();
    }

    @Given("I (.*)(?: )?")
    public void iLogin(String text) {
        if(System.getProperty("testType").equalsIgnoreCase("Sanity")){
            System.out.println("Sanity call");
        }else if (System.getProperty("testType").equalsIgnoreCase("Regression")) {
            System.out.println("Regression call");
        }
        if(text.equalsIgnoreCase("login successfully")) {
            System.out.println( text);
        }else{
            System.out.println("just login");
        }
    }
}