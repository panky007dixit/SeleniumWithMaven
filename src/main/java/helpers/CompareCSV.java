package helpers;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* file1 - file2 = file3*/
public class CompareCSV {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        String path="src//main//resources//";
        String file1="File1.csv";
        String file2="File2.csv";
        String file3="File3.csv";
        ArrayList al1=new ArrayList();
        ArrayList al2=new ArrayList();
        ArrayList al3=new ArrayList();
        //ArrayList al3=new ArrayList();
        FileWriter writer = new FileWriter(path + file3);
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow1 = CSVFile1.readLine();
        writer.append(dataRow1);
        System.out.println("HeaderLength "+dataRow1.length());
       // for(int i=0;i<dataRow1.length();i++){
        while (dataRow1 != null){
            //BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
            String dataRow2 = CSVFile2.readLine();
            while (dataRow2 != null){
                if(dataRow1.equalsIgnoreCase(dataRow2)){
                    //dataRow2 = CSVFile2.readLine();
                    //continue;
                    dataRow1 = CSVFile1.readLine(); // Read next line of data.
                    dataRow2 = CSVFile2.readLine();
                }else{
                    writer.append(dataRow1);
                    writer.append('\n');
                    dataRow1 = CSVFile1.readLine(); // Read next line of data.
                    dataRow2 = CSVFile2.readLine();
                }
            }
            /*if(!dataRow1.equalsIgnoreCase(dataRow2)){
                writer.write(dataRow1);
                dataRow2 = CSVFile2.readLine();
            }*/
            //dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }
        //System.out.println("Header from File1 is "+dataRow1);

        /*while (dataRow1 != null)
        {
            String[] dataArray1 = dataRow1.split(",");
            for (String item1:dataArray1)
            {
                al1.add(item1);
            }

            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }*/
        CSVFile1.close();

        /*BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow2 = CSVFile2.readLine();

        while (dataRow2 != null)
        {
            String[] dataArray2 = dataRow2.split(",");
            for (String item2:dataArray2)
            {
                al2.add(item2);

            }
            dataRow2 = CSVFile2.readLine(); // Read next line of data.
        }*/
        CSVFile2.close();
        /*for(int i=0;i<al1.size();i++)
        {
            for(int j=0;j<al2.size();j++)
            {
                if(al1.get(i).equals(al2.get(j))){
                  continue;
                }else{
                    writer.append(""+al2.get(i));
                    writer.append(",");
                    writer.append('\n');
                }
            }
        }*/
        /*for(Object bs:al2)
        {
            //if(al1.contains(bs)) {
                *//*al1.removeAll(al1);
                al1.add(bs);*//*
                al1.remove(bs);
             //al1.retainAll(al2);
                //al3.add(bs);

           // }else{
          // writer.append(""+bs);
           // }
        }*/

        int size=al1.size();
       // int size=al3.size();
       /* System.out.println(size);
        System.out.println(al1);*/
        /*if(al1.equals(al2)){
            System.out.println("Both files are same");
        }else {*/
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