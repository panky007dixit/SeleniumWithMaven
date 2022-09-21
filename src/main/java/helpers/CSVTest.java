package helpers;

import java.io.IOException;

public class CSVTest {
    public static void main (String args[]) throws IOException {
        String path="src//main//resources//";
        /*String file1="File1.csv";
        String file2="File2.csv";
        String file3="File3.csv";*/
        String file1="Source.csv";
        String file2="Target.csv";
        String file3="Compared.csv";
       // CompareCSVReport compareCSVReport = new CompareCSVReport();
        CompareCSVReportWithLoop compareCSVReport = new CompareCSVReportWithLoop();
        compareCSVReport.compareReport(path,file1,file2,file3);
    }
}
