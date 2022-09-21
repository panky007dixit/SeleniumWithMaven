package helpers;

import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/* file1 - file2 = file3*/
public class CompareCSVUsingMapFinal {
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
        //ArrayList al3=new ArrayList();
        Map<String,String> mp = new LinkedHashMap<String,String>();
        HashSet<String> st = new HashSet<String>();
        Set set = new TreeSet();
        String key=null;
        String value= null;
        //String[] file1array;
        //String[] file2array;
        int count = 0;
        String finalstring = "";
        FileWriter writer = new FileWriter(path + file3);
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow1 = CSVFile1.readLine();
        String dataRow2 = CSVFile2.readLine();
        //writer.append(dataRow1);
        writer.append("Result");
        //writer.append(",");
        //writer.append(dataRow1);
        writer.append('\n');
        System.out.println("HeaderLength "+dataRow1.length());
       // for(int i=0;i<dataRow1.length();i++){
        outer:
        while (dataRow1 != null) {
            //BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
            String[] file1array = dataRow1.split(Pattern.quote("|"));
            al2.add(file1array[0]);
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
                String[] file2array = dataRow2.split(Pattern.quote("|"));
                al3.add(file2array[0]);
                /*for(String arrstr: file2array) {
                    al3.add(arrstr);
                }*/
                    //if (file2array[0].equalsIgnoreCase(mp.get("Policy" + "_" + count).toString())) {
                if (file1array[0].equalsIgnoreCase(file2array[0])) {
                        if (dataRow1.equalsIgnoreCase(dataRow2)) {
                            //dataRow1 = CSVFile1.readLine(); // Read next line of data.
                            //dataRow2 = CSVFile2.readLine();
                            //count++;
                        } else {
                            file2array = dataRow2.split(Pattern.quote("|"));
                            try{
                            if (file1array.length != file2array.length) {
                                writer.append("Arrays are not same length");
                            }}catch(Exception e){
                                System.out.println("Exception -> File1Array and File2Array are not of same length");
                            }
                            for (int i = 0; i < file1array.length; i++) {
                                //  for (int j = 0; j < file2array.length; j++) {
                                // if (Arrays.asList(file2array).get(i).equalsIgnoreCase(file1array[i])) {
                                if (file1array[i].equalsIgnoreCase(file2array[i])) {
                                    //continue;
                                /*writer.append("" + "'" + file1array[i] + "'" + " found in File2 at column " + (i + 1) + " in row ");     //+dataRow2+" of File2");
                                writer.append(",");
                                writer.append(dataRow2);
                                writer.append('\n');*/
                                } else {
                                    //writer.append(""+"'"+arr1[i]+"'"+" not found at column "+(i+1)+" in row "+Arrays.asList(arr2).toString()+" of File2");
                                    writer.append("" + "'" + file1array[i] + "'" + " from file1 row {" + dataRow1 + "}" + " not found in File2 at column " + (i + 1) + " in row --> ");     //+dataRow2+" of File2");
                                    //writer.append(",");
                                    writer.append(dataRow2);
                                    writer.append('\n');
                                }
                            }
                            // }  //Another for loop
                        }
                        dataRow2 = CSVFile2.readLine();
                        //continue outer;
                    }
                else {
                    /*file2array = dataRow2.split(Pattern.quote("|"));
                    if (file1array.length != file2array.length) {
                        writer.append("Arrays are not same length");
                    }
                    for (int i = 0; i < file1array.length; i++) {
                        // for (int j = 0; j < file2array.length; j++) {
                        // if (Arrays.asList(file2array).get(i).equalsIgnoreCase(file1array[i])) {
                        if (file1array[i].equalsIgnoreCase(file2array[i])) {
                            //continue;
                            *//*writer.append("" + "'" + file1array[i] + "'" + " found in File2 at column " + (i + 1) + " in row ");     //+dataRow2+" of File2");
                            writer.append(",");
                            writer.append(dataRow2);
                            writer.append('\n');*//*
                        } else {
                            //writer.append(""+"'"+arr1[i]+"'"+" not found at column "+(i+1)+" in row "+Arrays.asList(arr2).toString()+" of File2");
                            writer.append("" + "'" + file1array[i] + "'" +" from file1 row {"+dataRow1+"}"+ " not found in File2 at column " + (i + 1) + " in row --> ");     //+dataRow2+" of File2");
                            //writer.append(",");
                            writer.append(dataRow2);
                            writer.append('\n');
                        }
                    }
               // }  //Another for loop*/
                    //finalstring = finalstring+dataRow2;
                        //st.add(mp.get("Policy_"+count));
                        /*String[] arr = dataRow2.split(Pattern.quote("|"));
                        for(String arrstr: arr) {
                            al3.add(arrstr);
                        }*/
                    dataRow2 = CSVFile2.readLine();
                    //continue inner;
                }
                //dataRow2 = CSVFile2.readLine();
                //}
                //continue inner;
                }
            if(dataRow2==null){
                /*writer.append(mp.get("Policy" + "_" + count).toString()+" not found in File2");
                writer.append('\n');*/
                //notfound.put("Policy" + "_" + count,mp.get("Policy" + "_" + count).toString());
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
        /*Iterator it = st.iterator();
     while(it.hasNext()){
         if(!al3.contains(it)){
             writer.append("Policy "+it+" not found in file2");
             writer.append('\n');
             it.next();
         }
     }*/
        /*for (Map.Entry<String,String> entry : mp.entrySet()){
            if(!(al3.contains(entry.getValue()))){
            //if(!Arrays.asList(finalstring).contains(entry.getValue())){
               // st.add(entry.getValue());
                writer.append("Policy "+entry.getValue()+" not found in File2");
                writer.append('\n');
            }
        }*/
        for(Object bs:al3)
        {
            al2.remove(bs);
        }

        set.addAll(al2);
        for(Object str : set){
            writer.append("Policy "+str.toString()+" not found in File2");
            writer.append('\n');
        }
       /* int size=al2.size();
        System.out.println(size);
        try
        {
            while(size!=0)
            {
                size--;
                //writer.append(""+al2.get(size));
                writer.append("Policy "+al2.get(size).toString()+" not found in File2");
                writer.append('\n');
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/
        /*for(String ststr : st){
            writer.append("Policy "+ststr+" not found in File2");
            writer.append('\n');
        }*/
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