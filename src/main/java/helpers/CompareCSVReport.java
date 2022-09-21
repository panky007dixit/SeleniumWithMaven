package helpers;

import java.io.*;

public class CompareCSVReport {
    /*String filePath="";
    String file1="";
    String file2="";
    String file3="File3.csv";*/
    public void compareReport(String filePath, String file1, String file2, String file3) throws IOException {
        /*this.filePath=filePath;
        this.file1=file1;
        this.file2=file2;*/
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(filePath+file1));
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(filePath+file2));
        String dataRow1 = CSVFile1.readLine();
        File file = new File(filePath+file3);
        if(!file.exists()) {
            file.createNewFile();
        }else{
            file.delete();
        }
        //FileWriter writer = new FileWriter(filePath + file3,false);
        //new FileWriter(file,false).close();
        FileWriter writer = new FileWriter(file,false);
        writer.write("");
        writer.append(dataRow1);
        writer.append('\n');
        System.out.println("Header is "+dataRow1);
        // for(int i=0;i<dataRow1.length();i++){
        while (dataRow1 != null){
            //BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
            String dataRow2 = CSVFile2.readLine();
            while (dataRow2 != null){
                if(dataRow1.trim().equalsIgnoreCase(dataRow2.trim())){
                    //continue;
                    dataRow1 = CSVFile1.readLine();
                    dataRow2 = CSVFile2.readLine();
                }else{
                    //writer.append(dataRow1);
                    writer.append(dataRow2);
                    writer.append('\n');
                    dataRow1 = CSVFile1.readLine();
                    dataRow2 = CSVFile2.readLine();
                }
            }
    }
        CSVFile1.close();
        CSVFile2.close();
        writer.flush();
        writer.close();
    }
}
