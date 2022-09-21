package parallel;

import helpers.BrowserStackTest;
import helpers.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class Parallel2StepDef {
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

   /*public Parallel1StepDef() throws Exception {
       driver= BrowserStackTest.browserStack();
   }*/
    @Given("^I navigate app2$")
    public void i_navigate_app() throws Throwable {
        //System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
        //driver = new FirefoxDriver();
        driver= WebDriverFactory.createWebDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    @When("^enter user id and enter password2$")
    public void enter_user_id_and_enter_password() throws Throwable {
        loginPage.login("Panky1991", "Password@007");
    }

    @Then("^I go to the mail app with mail panel2$")
    public void i_goto_the_mail_app_with_mail_panel() throws Throwable {
        homePage = new HomePage(driver);
        homePage.verifyLogin("Panky1991");
        driver.quit();
    }
}