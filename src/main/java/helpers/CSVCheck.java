package helpers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVCheck {

    public static void main(String[] args) throws FileNotFoundException{

        ArrayList<String> valuesInSheetOne = new ArrayList<String>();
        ArrayList<String> valuesInSheetTwo = new ArrayList<String>();

        File sheet1 = new File(System.getProperty("user.dir") + "\\src//main//resources//Source.csv");
        File sheet2 = new File(System.getProperty("user.dir") + "\\src//main//resources//Target.csv");

        Scanner scannerForSheetOne = new Scanner(sheet1);
        Scanner scannerForSheetTwo = new Scanner(sheet2);

        String linefromfile1 = scannerForSheetOne.nextLine();
        while (scannerForSheetOne.hasNextLine()) {
            String[] arr1 = linefromfile1.split(",");
            for(String str: arr1) {
                valuesInSheetOne.add(str);
            }
            //valuesInSheetOne.add(scannerForSheetOne.nextLine().split(",")[1]);
            //scannerForSheetOne.next();
        }//scannerForSheetOne.close();

        String linefromfile2 = scannerForSheetTwo.nextLine();
        while (scannerForSheetTwo.hasNextLine()) {
            String[] arr2 = linefromfile2.split(",");
            //valuesInSheetTwo.add(scannerForSheetTwo.nextLine().split(",")[1]);
            for(String str: arr2) {
                valuesInSheetOne.add(str);
            }
        } //scannerForSheetTwo.close();

        int iteration = 0;

        System.out.printf("%-6s%-6s%-6s\n","Sheet-1", "    ", "Sheet-2");
        System.out.println();

        for (String value : valuesInSheetOne) {
            if(valuesInSheetOne.get(iteration).compareToIgnoreCase(valuesInSheetTwo.get(iteration)) != 0) {
                System.out.printf("%-7s%-6s%-7s\n",valuesInSheetOne.get(iteration), " --> ", valuesInSheetTwo.get(iteration));
               System.out.println(linefromfile1);
            }
            iteration++;
        }
    }
}