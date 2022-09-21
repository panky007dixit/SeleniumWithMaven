package helpers;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareCSVReportWithLoop {
    /*String filePath="";
    String file1="";
    String file2="";
    String file3="File3.csv";*/
    /*String[] strArray =null;
    String[] strArray2 =null;*/
    List<String> al1 = new ArrayList<String>();
    List<String> al2 = new ArrayList<String>();
    int i ,j , k ,l =0;
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
       // CSVWriter writer = new CSVWriter(new FileWriter(file), ',');
        FileWriter writer = new FileWriter(file,false);
        writer.write("");
        //writer.append(dataRow1);
        //writer.append('\n');
        writer.append("MismatchData");
        writer.append(",");
        writer.append("MismatchRow");
        writer.append('\n');
        System.out.println("Header is "+dataRow1);
        // for(int i=0;i<dataRow1.length();i++){
        CSVReader reader = new CSVReader(new FileReader(filePath+file1), ',');
        CSVReader reader2 = new CSVReader(new FileReader(filePath+file2), ',');
        List<String[]> csvBody = reader.readAll();
        List<String[]> csvBody2 = reader2.readAll();
        //String[] strArray = new String[csvBody.size()];
        //String[] strArray2 = new String[csvBody2.size()];
        // get CSV row column and replace with by using row and column
        for( i=0; i<csvBody.size(); i++) {
             String[] strArray = csvBody.get(i);
              al1 =  Arrays.asList(strArray);
       // }
            for ( j = 0; j < csvBody2.size(); j++) {
                  String[] strArray2 = csvBody2.get(j);
                 al2 =  Arrays.asList(strArray2);
                //if(al1.get(i).equals(al2.get(j))){
                if(strArray.equals(strArray2)){
                    continue;
                }else{
                   // String[] finalArray = new String[] {csvBody.get(i)[i]};
                     writer.append(csvBody.get(i)[i]);
                    writer.append(""+strArray.toString());
                    writer.append('\n');
                    //csvBody.get(i)[i]= csvBody2.get(j)[j];
                }
         //   }
           // for( k=0; k<strArray.length; k++){
              /*  for(k=0;k<al1.size();k++) {
                //for( l=0; l<strArray2.length; l++){
                    for( l=0; l<al2.size(); l++){
              //  if(strArray[k].equalsIgnoreCase(strArray2[l])){
                        if(al1.get(k).equals(al2.get(l))){
                     continue;
                    //csvBody.get(k)[l] = "Updated_date"; //Target replacement
                }else{
                    csvBody.get(i)[k]= csvBody2.get(j)[l];
                }
            }}*/
         }}
        reader.close();
        reader2.close();
        // Write to CSV file which is open
        //CSVWriter writer2 = new CSVWriter(new FileWriter(filePath+file3), ',');
        //writer.writeAll(csvBody);
        CSVFile1.close();
        CSVFile2.close();
        writer.flush();
        writer.close();
       // writer.flush();
       // writer.close();
    }
}
