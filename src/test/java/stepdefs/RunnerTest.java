package stepdefs;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.Reporter;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions( features="src/test/java/features/",
        glue = "",
        monochrome = true,
        tags = {"@testtwo"},
        plugin ={"pretty","json:reports/cucumber.json","html:reports/",
        //plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:reports/extentreport/report.html"
          }
          )
public class RunnerTest {
    /*@AfterClass
    public static void writeExtentReport() {
        ExtentReports reports = new ExtentReports();
        ExtentHtmlReporter reporter = new ExtentHtmlReporter();
        reports.attachReporter(reporter);
        reporter.loadXMLConfig("reports/extentreport/extentconfig.xml");
    }*/
}