package parallel;

/*import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;*/
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions( features="src/test/resources/parallel/",
        glue = "",
        monochrome = true,
        plugin ={"pretty","json:reports/cucumber.json","html:reports/",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:reports/extentreport/report.html"
          })
public class RunnerTest extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}