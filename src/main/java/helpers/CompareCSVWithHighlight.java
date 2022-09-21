package helpers;
import java.io.*;
import java.util.ArrayList;

/* file1 - file2 = file3*/
public class CompareCSVWithHighlight {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        String path="src//main//resources//";
        String file1="Source.csv";
        String file2="Target.csv";
        String file3="Compared.csv";
        ArrayList al1=new ArrayList();
        ArrayList al2=new ArrayList();
        ArrayList al3=new ArrayList();
        //ArrayList al3=new ArrayList();
        File file = new File(path+file3);
        if(!file.exists()) {
            file.createNewFile();
        }else{
            file.delete();
        }
        FileWriter writer = new FileWriter(file,false);
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
        BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow1 = CSVFile1.readLine();
        String dataRow2 = CSVFile2.readLine();
        //writer.append("Difference");
        writer.append(dataRow1);
        writer.append('\n');
        System.out.println("HeaderLength "+dataRow1.length());
       // for(int i=0;i<dataRow1.length();i++){
        /*while (dataRow2 != null) {
            al2.add(dataRow2);
            dataRow2 = CSVFile2.readLine(); // Read next line of data.
        }*/
        while (dataRow1 != null)
        {
            al1.add(dataRow1);
            /*String[] dataArray1 = dataRow1.split(",");
            for (String item1:dataArray1)
            {
                al1.add(item1);
            }*/
            /*while (dataRow2 != null) {
                al2.add(CSVFile2.readLine());
                *//*if(!dataRow1.equalsIgnoreCase(dataRow2)) {
                    al2.add(CSVFile2.readLine());
                    dataRow2 = CSVFile2.readLine();
                }else{
                    writer.append("Match found in File2 for");
                    writer.append('\n');
                    writer.append(dataRow1);
                    dataRow2= CSVFile2.readLine();
                    //continue;
                }*//*

            }*/
            //dataRow2= CSVFile2.readLine();
            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }

        CSVFile1.close();
        /*BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow2 = CSVFile2.readLine();*/
        while (dataRow2 != null)
        {
            //for(int len =0; len<al1.size();len++){
            for(int len =0; len<al1.size();len++){
                if(al1.get(len).toString().contains(dataRow2)){
                    dataRow2=CSVFile2.readLine();
                }else{
                    writer.append(""+al1.get(len));
                    writer.append('\n');
                    dataRow2=CSVFile2.readLine();
                }
            }
            /*al2.add(CSVFile2.readLine());
            String[] dataArray2 = dataRow2.split(",");
            for (String item2:dataArray2)
            {
                al2.add(item2);

            }*/
          //  dataRow2 = CSVFile2.readLine(); // Read next line of data.
        }
        CSVFile2.close();
        /*for(int i=0;i<al1.size();i++)
        {
            for(int j=0;j<al2.size();j++)
            {
                if(String.valueOf(al1.get(i)).equalsIgnoreCase(String.valueOf(al2.get(j)))){
                  continue;
                }else{
                    writer.append(""+String.valueOf(al1.get(i)));
                    //writer.append(",");
                    writer.append('\n');
                }
            }
        }*/
        /*for(Object bs:al2)
        {
            al1.remove(bs);
        }*/

        int size=al1.size();
        System.out.println(size);
        System.out.println(al1);
        //System.out.println(al2);
        try
        {
            //FileWriter writer=new FileWriter(path+file3);
            /*while(size!=0)
            {
                size--;
                writer.append("From File1"+'\n'+al1.get(size));
                writer.append('\n');
            }*/
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }}