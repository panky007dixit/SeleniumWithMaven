package stepdefs;

import helpers.BrowserStackTest;
import helpers.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelDatatoFeatureStep {
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

    @Given("User fills form using sheetname (.*) and rownumber (.*)")
    public void user_fills_form_using_sheetname_and_rownumber(String sheetname, Integer rownum) throws IOException {
        String filePath = "src//main//resources//ExceltoFeature.xlsx";
        ExcelReader excelReader = new ExcelReader();
        List<String> ls = excelReader.readExcel(filePath, rownum);
        /*System.out.println("First Column in Header is "+excelReader.readExcel(filePath,0).get(0));
        System.out.println("Second Column in header is "+excelReader.readExcel(filePath,0).get(1));
        System.out.println("First Column in first row is "+excelReader.readExcel(filePath,0).get(2));
        System.out.println("Second Column in first row is "+excelReader.readExcel(filePath,0).get(3));*/
        for(String str : ls){
            System.out.println("Excel Data "+str);
        }
        //Object[][] data = excelReader.readExcelData(filePath,rownum);
        /*List<Map<String,String>> ls = excelReader.getData(filePath,sheetname);
        String name = ls.get(Integer.valueOf(rownum)).get("Name");
        String address = ls.get(Integer.valueOf(rownum)).get("Address");*/
        //System.out.println("Name is "+data[0].toString()+ " Address is "+data[1].toString());
        /*for(Object obj : ls){
            System.out.println("ExcelData is "+obj.toString());
        }*/
    }
    @Given("User fills form using excel")
    public void readExcel() throws IOException {
        String filePath = "src//main//resources//ExceltoFeature.xlsx";
        ExcelReader excelReader = new ExcelReader();
        System.out.println("Name from first row is "+excelReader.readCellData(filePath,1,0));
        System.out.println("Address from first row is "+excelReader.readCellData(filePath,1,1));
        /*Object[][] data = excelReader.readExcelData(filePath,0);
        for(Object str: data){
            System.out.println("ExcelData is "+str.toString());
        }*/
       // System.out.println("Name is "+data[0].toString()+ " Address is "+data[1].toString());
    }
}