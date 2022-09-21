package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVClear {
//    String path=System.getProperty("user.dir")+ File.separator +"Source.csv";
File path=new File(System.getProperty("user.dir")+ File.separator +"Source.csv");
    public void clearCsv() throws Exception {
        if(path.exists()) {
            System.out.println("Old out.csv file exists. Removing...");
            path.delete();
            FileWriter fw = new FileWriter(path, false);
            fw.append("Name,Age,Company,Salary");
            fw.append("\n");
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        }
    }
    public static void main (String args[]) throws Exception {
CSVClear clr = new CSVClear();
for (int i=0;i<3;i++) {
    clr.clearCsv();
    System.out.println("Program ran successfully");
}
    }
}
