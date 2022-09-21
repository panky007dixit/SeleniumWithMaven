package helpers;
import java.io.*;
import java.util.ArrayList;

/* file1 - file2 = file3*/
public class CompareCSVForCellValue {
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        String path="src//main//resources//";
        String file1="Source.csv";
        String file2="Target.csv";
        String file3="Compared.csv";
        String file4="CSVFile4.csv";
        ArrayList al1=new ArrayList();
        ArrayList al2=new ArrayList();
        //ArrayList al3=new ArrayList();
        int count = 0;
        FileWriter writer = new FileWriter(path + file3);
        FileWriter writer2 = new FileWriter(path + file4);
        BufferedReader CSVFile1 = new BufferedReader(new FileReader(path+file1));
        String dataRow1 = CSVFile1.readLine();
        //writer.append(dataRow1);
        /*writer.append("Row to Row Comparison between SourceFile and TargetFile");
        writer.append('\n');*/
        writer.append("DataFoundInFile1ButNotInFile2");
        writer.append('\n');
        writer2.append("DataFoundInFile2ButNotInFile1");
        writer2.append('\n');
        while (dataRow1 != null)
        {
            String[] dataArray1 = dataRow1.split(",");
            for (String item1:dataArray1)
            {
                al1.add(item1);
            }

            dataRow1 = CSVFile1.readLine(); // Read next line of data.
        }
        CSVFile1.close();

        BufferedReader CSVFile2 = new BufferedReader(new FileReader(path+file2));
        String dataRow2 = CSVFile2.readLine();

        while (dataRow2 != null)
        {
            /*int len = dataRow2.split(",").length;
            String[] dataArray2= new String[len];
            dataArray2 = dataRow2.split(",");
            if(dataRow2.contains(al1.get(count).toString())){
                count++;
                continue;
            }else {
                writer.append("Data " + al1.get(count).toString()+" Not found in Row "+count+" of File2");
                writer.append('\n');
                count++;
            }*/
            String[] dataArray2 = dataRow2.split(",");
            for (String item2:dataArray2)
            {
                al2.add(item2);

            }
            dataRow2 = CSVFile2.readLine(); // Read next line of data.
        }
        CSVFile2.close();
        /*writer.flush();
        writer.close();*/
        for(Object bs: al1) {
            if (al2.contains(bs)){
                /*writer.append("Data "+"'"+bs.toString()+"'"+" found in File2");
                writer.append('\n');*/
                continue;
            }else{
                writer.append("Data "+"'"+bs.toString()+"'"+" not found in File2");
                writer.append('\n');
            }
        }
        for(Object bs: al2) {
            if (al1.contains(bs)){
                /*writer2.append("Data "+"'"+bs.toString()+"'"+" found in File1");
                writer2.append('\n');*/
                continue;
            }else{
                writer2.append("Data "+"'"+bs.toString()+"'"+" not found in File1");
                writer2.append('\n');
            }
        }
        /*for(Object bs:al2)
        {
            *//*if(al1.contains(bs)) {
                al1.removeAll(al1);
                al1.add(bs);*//*
                al1.remove(bs);
           *//* }else{

            }*//*
        }*/
        writer.flush();
        writer.close();
        writer2.flush();
        writer2.close();
        int size=al1.size();
        //System.out.println("Values which are in File1 but not in File2 -> "+size);
        if(al1.equals(al2)){
            System.out.println("Both files are same");
        }else {
            /*try {
               // FileWriter writer = new FileWriter(path + file3);
                //while (size != 0) {
                for(Object obj : al1) {
                    //size--;
                    //writer.append("" + al1.get(size));
                    *//*writer.append("" + obj.toString());
                    writer.append('\n');*//*
                }
                *//*writer.flush();
                writer.close();*//*
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }}