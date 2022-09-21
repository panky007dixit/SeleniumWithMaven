package helpers;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVProgramWithPrimaryKey {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
    String path="src//main//resources//";
    String file1="Source.csv";
    String file2="Target.csv";
    String file3="Compared.csv";
        List<String> al1 = new ArrayList<String>();
        List<String> al2 = new ArrayList<String>();
    //ArrayList al3=new ArrayList();
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
int row = 0;
    FileWriter writer = new FileWriter(path + file3);
    writer.append("MismatchValue");
    writer.append('\n');
    BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
    BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));

    String dataRow1 = CSVFile1.readLine();
        String dataRow2 = CSVFile2.readLine();
        while (dataRow1 != null)
        {
            String[] dataArray1 = dataRow1.split(",");
            map1.put("EmpID",dataArray1[0]);
            if(row>dataArray1.length+1){
                row++;
            }
            for (String item1:dataArray1)
            {
                al1.add(item1);
            }

            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }
        CSVFile1.close();
        while (dataRow2 != null)
        {
            String[] dataArray2 = dataRow2.split(",");
            for (String item2:dataArray2)
            {
                al2.add(item2);
            }

            dataRow2 = CSVFile2.readLine(); // Read next line of data.
        }
        CSVFile2.close();
        for(Object str : al2){
            al1.remove(str);
            //al1.add(str);
            /*writer.append(""+al1);
            writer.append('\n');*/
        }
    for(Object str : al1){
        System.out.println("al1 is"+str.toString());
    }
    int size = al1.size();
    while(size!=0){
        size--;
        writer.append("From File1 : "+al1.get(size));
        writer.append('\n');
    }
        writer.flush();
        writer.close();
        /*for(Object str : al2){
            System.out.println("al2 is"+str.toString());
        }*/
        /*List<Integer> common = (List<Integer>) al1.stream().filter(al2::contains).collect(toList());
        for(Object str : common){
            System.out.println("common is"+str.toString());
        }*/
/*        for(int i=0;i<al1.size();i++) {
            if (al1.get(i).equals(al1.stream().filter(al2::contains).collect(toList()))) {
 continue;
            }else{
                writer.append(""+al1.get(i).toString());
            }
        }*/
        for(int i=0;i<al1.size();i++){
            for(int j=0;j<al2.size();j++){
                if(al1.get(i).toString().equals(al2.get(j).toString())){
                    continue;
                }else{
                  /*  writer.append("Mismatch data "+al1.get(i));
                    writer.append('\n');*/
                }
            }
        }
        /*Reader in;
        Reader in2;
        Iterable<CSVRecord> records = null;
        Iterable<CSVRecord> records2 = null;
        try
        {
            in = new FileReader(path+file1);
            in2 = new FileReader(path+file2);
            records = CSVFormat.EXCEL.withHeader().parse(in); // header will be ignored
            records2 = CSVFormat.EXCEL.withHeader().parse(in2); // header will be ignored
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (CSVRecord record : records) {
            String line = "";
            //String[] arr1 = new String[record.size()];
            for ( int i=0; i < record.size(); i++)
            {
                if ( line == "" ) {
                    line = line.concat(record.get(i));
                    String[] arr1 = line.split(",");
                    for(String arr: arr1){
                        System.out.println(arr);
                    }
                }
                else {
                    line = line.concat("," + record.get(i));
                }
            }
            System.out.println("read line: " + line);
        }
        for (CSVRecord record2 : records2) {
            String line2 = "";
            //String[] arr2 = new String[record2.size()];
            for ( int i=0; i < record2.size(); i++)
            {
                if ( line2 == "" ) {
                    line2 = line2.concat(record2.get(i));
                    String[] arr2 = line2.split(",");
                    for(String arr: arr2){
                        System.out.println(arr);
                    }
                }
                else {
                    line2 = line2.concat("," + record2.get(i));
                }
            }
            System.out.println("read line: " + line2);

        }*/
    }
}
