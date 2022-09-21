package helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CSVRowCol {
    static int[] getRowsColsNo() {
        Scanner scanIn = null;
        int rows = 0;
        int cols = 0;
        String InputLine = "";
        try {
            scanIn = new Scanner(new BufferedReader(
                    new FileReader("src//main//resources//SourceWithPipe.csv")));
            scanIn.useDelimiter(",");
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split(",");
                rows++;
                cols = InArray.length;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return new int[]{rows, cols};
    }
    public static void main (String[] args){
        int[] returned = getRowsColsNo();
        for(int str:returned) {
            System.out.println(String.valueOf(str));
        }
    }
}
