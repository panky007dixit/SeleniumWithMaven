package helpers;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/* file1 - file2 = file3*/
public class CompareCSVCellValueWithPipeUsingMap {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        String path="src//main//resources//";
        String file1="SourceWithPipe.csv";
        String file2="TargetWithPipe.csv";
        String file3="Result.csv";
        List al1=new ArrayList();
        List al2=new ArrayList();
        List al3=new ArrayList();
        //ArrayList al3=new ArrayList();
        Map mp = new LinkedHashMap();
        String key=null;
        String value= null;
        String[] file1array;
        String[] file2array;
        int count = 0;
        FileWriter writer = new FileWriter(path + file3);
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow1 = CSVFile1.readLine();
        String dataRow2 = CSVFile2.readLine();
        //writer.append(dataRow1);
        writer.append("Result");
        writer.append(",");
        writer.append(dataRow1);
        writer.append('\n');
        System.out.println("HeaderLength "+dataRow1.length());
       // for(int i=0;i<dataRow1.length();i++){
        outer:
        while (dataRow1 != null) {
            //BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
            file1array = dataRow1.split(Pattern.quote("|"));
            mp.put("Policy" + "_" + count, file1array[0]);
            /*count++;
            dataRow1 = CSVFile1.readLine();*/
            // }
        /*for (Object name : mp.keySet()) {
            key = name.toString();
            value = mp.get(name).toString();
            System.out.println(key + " " + value);
        }*/
        inner:
            while (dataRow2 != null) {
                //Object[] values = mp.values().toArray(new String[mp.size()]);
                // al2 = Arrays.asList(mp.values());
                //for (Object str : al2) {
                if (dataRow2.contains(mp.get("Policy" + "_" + count).toString())) {
                    if (dataRow1.equalsIgnoreCase(dataRow2)) {
                        //dataRow1 = CSVFile1.readLine(); // Read next line of data.
                        //dataRow2 = CSVFile2.readLine();
                        //count++;
                    } else {
                        file2array = dataRow2.split(Pattern.quote("|"));
                        for (int i = 0; i < file1array.length; i++) {
                            // for (int j = 0; j < arr1.length; j++) {
                            if (Arrays.asList(file2array).get(i).equalsIgnoreCase(file1array[i])) {
                                //continue;
                                /*writer.append("" + "'" + file1array[i] + "'" + " found in File2 at column " + (i + 1) + " in row ");     //+dataRow2+" of File2");
                                writer.append(",");
                                writer.append(dataRow2);
                                writer.append('\n');*/
                            } else {
                                //writer.append(""+"'"+arr1[i]+"'"+" not found at column "+(i+1)+" in row "+Arrays.asList(arr2).toString()+" of File2");
                                writer.append("" + "'" + file1array[i] + "'" + " not found in File2 at column " + (i + 1) + " in row ");     //+dataRow2+" of File2");
                                writer.append(",");
                                writer.append(dataRow2);
                                writer.append('\n');
                            }
                        }
                    }
                    dataRow2 = CSVFile2.readLine();
                    //continue outer;
                }
                else {
                    file2array = dataRow2.split(Pattern.quote("|"));
                    for (int i = 0; i < file1array.length; i++) {
                        // for (int j = 0; j < arr1.length; j++) {
                        if (Arrays.asList(file2array).get(i).equalsIgnoreCase(file1array[i])) {
                            //continue;
                            /*writer.append("" + "'" + file1array[i] + "'" + " found in File2 at column " + (i + 1) + " in row ");     //+dataRow2+" of File2");
                            writer.append(",");
                            writer.append(dataRow2);
                            writer.append('\n');*/
                        } else {
                            //writer.append(""+"'"+arr1[i]+"'"+" not found at column "+(i+1)+" in row "+Arrays.asList(arr2).toString()+" of File2");
                            writer.append("" + "'" + file1array[i] + "'" + " not found in File2 at column " + (i + 1) + " in row ");     //+dataRow2+" of File2");
                            writer.append(",");
                            writer.append(dataRow2);
                            writer.append('\n');
                        }
                    }
                    dataRow2 = CSVFile2.readLine();
                    //continue inner;
                }
                //dataRow2 = CSVFile2.readLine();
                //}
                //continue inner;
                }
            if(dataRow2==null){
                CSVFile2.close();
                CSVFile2 = new BufferedReader(new FileReader(path+file2));
                dataRow2 = CSVFile2.readLine();
                count++;
                dataRow1 = CSVFile1.readLine();
                continue outer;
            }
                /*count++;
                dataRow1 = CSVFile1.readLine();*/
            }
        //}
        CSVFile1.close();
        CSVFile2.close();
            try {
               // FileWriter writer = new FileWriter(path + file3);
                /*while (size != 0) {
                    size--;
                    writer.append("" + al1.get(size));
                    //writer.append("" + al3.get(size));
                    writer.append('\n');
                }*/
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        //}
    }}