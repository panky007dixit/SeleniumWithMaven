package helpers;

//import org.apache.tools.ant.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CSVClass {
    public static void main(String[]args) throws IOException
    {
        String path="src//main//resources//";
        String file1="Source.csv";
        String file2="Target.csv";
        String file3="Compared.csv";
        String[][]cols={};
        String[][]cols1={};
        int row=0;
        int row1=0;
        int j=0;
/*Scanners=newScanner(newFile("WatfordUpdateFile.csv"));
Scannerc=newScanner(newFile("udc.csv"));
while(s.hasNextLine()){
Stringline=s.nextLine();
cols=line.split(",");
System.out.println(cols[0]);*/
        Scanner s=new Scanner(new File(path+file1));
        Scanner w=new Scanner(new File(path+file2));
        while(w.hasNextLine())
        {
            String line1=w.nextLine();
            System.out.println(cols.toString());
//cols[row]=line1.split(",");
            row++;
            if(!w.hasNextLine()){
                while(s.hasNextLine()){
                    String line2=s.nextLine();
//cols1[row1]=line2.split(",");
//putwhileloopindiffrentmethodbutbreak
                    if(cols[j].equals(cols1[row1]))
                    {
                        j++;
                        row1++;
                        System.out.print(cols[j]);
                        System.out.print("");
                        System.out.print(cols1[row1]);
                        System.out.println();
                    }else{
                        row1++;
                    }
                }
            }
        }
    }
}
