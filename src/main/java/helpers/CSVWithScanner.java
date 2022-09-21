package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVWithScanner {

    public static void main(String[] args) throws Exception
    {
        ArrayList<String> al1 = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>();
        ArrayList al3 = new ArrayList();
        File sheet1 = new File(System.getProperty("user.dir") + "\\src//main//resources//CSVFile1.csv");
        File sheet2 = new File(System.getProperty("user.dir") + "\\src//main//resources//CSVFile2.csv");
        File sheet3 = new File(System.getProperty("user.dir") + "\\src//main//resources//CSVFile3.csv");

//parsing a CSV file into Scanner class constructor
        Scanner sc1 = new Scanner(new File(String.valueOf(sheet1)));
        Scanner sc2 = new Scanner(new File(String.valueOf(sheet2)));
        //String linefromfile1 = sc1.nextLine();
        sc1.useDelimiter(",");   //sets the delimiter pattern
        sc2.useDelimiter(",");
        while (sc1.hasNext())  //returns a boolean value
        {
            al1.add(sc1.next());
             //find and returns the next complete token from this scanner
        }System.out.print(al1.toString());
        sc1.close();  //closes the scanner
        while (sc2.hasNext())  //returns a boolean value
        {
            al2.add(sc2.next());
            //find and returns the next complete token from this scanner
        }System.out.print(al2.toString());
        sc2.close();
        int iteration = 0;
        System.out.println('\n');
        //System.out.printf("%-6s%-6s%-6s\n","Sheet-1", "    ", "Sheet-2");
        System.out.println();

        for (Object value : al2) {
                //if(al1.contains(al2.get(iteration))) {
                //System.out.printf("%-7s%-6s%-7s\n",al1.get(iteration), " --> ", al2.get(iteration));
            //al3.add(al1.remove(value));
                 al1.remove(value);
             //iteration++;
        }
        //System.out.println("From File1 "+al3.toString());
int size = al1.size();
        try {
             FileWriter writer = new FileWriter(sheet3);
            writer.append("DataFromFile1NotFoundInFile2");
            writer.append('\n');
                while (size != 0) {
                    size--;
                    writer.append("" + al1.get(size));
                    //writer.append("" + al3.get(size));
                    writer.append('\n');
                }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
