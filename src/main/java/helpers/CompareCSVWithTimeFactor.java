package helpers;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class CompareCSVWithTimeFactor {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        String path="src//main//resources//";
        /*String file1="SourceWithPipe.csv";
        String file2="TargetWithPipe.csv";
        String file3="Result.csv";*/
        String file1="1.csv";
        String file2="2.csv";
        String file3="3.csv";
        List al1=new ArrayList();
        List al2=new ArrayList();
        List al3=new ArrayList();

        Map<String,String> mp = new LinkedHashMap<String,String>();
        Set set = new TreeSet();
        int matchcount = 0;
        int rowcount = 0;
        int count = 0;
        FileWriter writer = new FileWriter(path + file3);
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow1 = CSVFile1.readLine();
        String dataRow2 = CSVFile2.readLine();
        writer.append("Result");
        writer.append('\n');
        System.out.println("HeaderLength "+dataRow1.length());
       // for(int i=0;i<dataRow1.length();i++){
        Date dt = new Date();
        System.out.println("Started at "+dt.getTime());
        outer:
        while (dataRow1 != null) {
            //BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
            String[] file1array = dataRow1.split(Pattern.quote("|"));
            al2.add(file1array[0]);
            mp.put("Policy" + "_" + count, file1array[0]);
            if(mp.get("Policy" + "_" + count).equalsIgnoreCase(mp.get("Policy" + "_" + count))){

            }

        inner:
            while (dataRow2 != null) {
                String[] file2array = dataRow2.split(Pattern.quote("|"));
                al3.add(file2array[0]);
                if (file1array[0].equalsIgnoreCase(file2array[0])) {
                    //System.out.println("Policy matched in "+count+" row of File2");
                        if (dataRow1.equalsIgnoreCase(dataRow2)) {
                            //System.out.println("File1 Row matched in "+count+" row of File2");
                        } else {
                            file2array = dataRow2.split(Pattern.quote("|"));
                            try{
                            if (file1array.length != file2array.length) {
                                writer.append("Arrays are not same length");
                            }}catch(Exception e){
                                System.out.println("Exception -> File1Array and File2Array are not of same length");
                            }
                            for (int i = 0; i < file1array.length; i++) {
                                if (file1array[i].equalsIgnoreCase(file2array[i])) {
                                } else {
                                    writer.append("" + "'" + file1array[i] + "'" + " from file1 row {" + dataRow1 + "}" + " not found in File2 at column " + (i + 1) + " in row --> ");     //+dataRow2+" of File2");
                                    writer.append(dataRow2);
                                    writer.append('\n');
                                }
                            }
                            // }  //Another for loop
                        }
                        dataRow2 = CSVFile2.readLine();
                        matchcount++;
                        //continue outer;
                    }
                else {
                    dataRow2 = CSVFile2.readLine();
                    dataRow1 = CSVFile1.readLine();
                    mp.put("Policy" + "_" + rowcount, file1array[0]);
                    rowcount++;
                    continue outer;
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
        System.out.println("Ended at "+dt.getTime());
        for(Object bs:al3)
        {
            al2.remove(bs);
        }

        set.addAll(al2);
        for(Object str : set){
            writer.append("Policy "+str.toString()+" not found in File2");
            writer.append('\n');
        }

        CSVFile1.close();
        CSVFile2.close();
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        //}
    }}