package helpers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public List<Map<String,String>> getData(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        List<Map<String,String>> ls = null;
        FileInputStream fin = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook =  new XSSFWorkbook(fin);
        //workbook.getSheet(sheetName);
        ls.add((Map<String, String>) workbook.getSheet(sheetName));
        Sheet sheet = getSheetByName(excelFilePath,sheetName);
        //return readSheet(sheet);
        return ls;
    }
    private void readSheet(String excelFilePath) throws IOException {
        FileInputStream fin = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook =  new XSSFWorkbook(fin);
    }
    public List<Map<String,String>> getData(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        List<Map<String,String>> ls = null;
        FileInputStream fin = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook =  new XSSFWorkbook(fin);
        //workbook.getSheet(sheetName);
        ls.add((Map<String, String>) workbook.getSheet(String.valueOf(sheetNumber)));
        Sheet sheet = getSheetByIndex(excelFilePath,sheetNumber);
        //return readSheet(sheet);
        return ls;
    }
    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }
    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }
    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(new File(excelFilePath));
    }
    private List<Map<String,String>> readSheet(Sheet sheet){
        Row row;
        int totalrow = sheet.getPhysicalNumberOfRows();
        List<Map<String,String>> excelrows = new ArrayList<Map<String,String>>();
        return excelrows;
    }
    public String readCellData(String filepath, int vRow, int vColumn)
    {
        String value=null;          //variable for storing the cell value
        Workbook wb=null;           //initialize Workbook null
        try
        {
//reading data from a file in the form of bytes
            FileInputStream fis=new FileInputStream(filepath);
//constructs an XSSFWorkbook object, by buffering the whole stream into the memory
            wb=new XSSFWorkbook(fis);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index
        //Sheet sheet=wb.getSheet(sheetName);   //getting the XSSFSheet object at given index
        Row row=sheet.getRow(vRow); //returns the logical row
        Cell cell=row.getCell(vColumn); //getting the cell representing the given column
        value=cell.getStringCellValue();    //getting cell value
        return value;               //returns the cell value
    }
    public List<String> readExcel(String filePath, int sheetNumber) throws IOException {
        List<String> ls = new ArrayList<>();
        try{
        File file=new File(filePath);
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook book=new XSSFWorkbook(fis);
        XSSFSheet sheet=book.getSheetAt(sheetNumber);
        //    XSSFSheet sheet=book.getSheet(sheetName);
        XSSFRow row;
        XSSFCell cell;
        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            row=(XSSFRow) rowIterator.next();
            Iterator cellIterator = row.cellIterator();
            while (cellIterator.hasNext())
            {
                cell=(XSSFCell) cellIterator.next();
                //Check the cell type and format accordingly
                /*if (cell.getCellType() == cell.CELL_TYPE_STRING)
                {
                    System.out.print(cell.getStringCellValue()+" ");
                }
                else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                {
                    System.out.print(cell.getNumericCellValue()+" ");
                }else {
                }*/
                switch (cell.getCellType())
                {
                    //case Cell.CELL_TYPE_NUMERIC:
                    case NUMERIC:
                       // System.out.print(cell.getNumericCellValue() + "\t");
                        ls.add(String.valueOf(cell.getNumericCellValue()));
                        //return value;
                        break;
                    //case Cell.CELL_TYPE_STRING:
                    case STRING:
                       // System.out.print(cell.getStringCellValue() + "\t");
                        ls.add(String.valueOf(cell.getStringCellValue()));
                        //return value;
                        break;
                }
            }
            //System.out.println("");
        }
        //file.close();
    } catch (Exception e) {
        e.printStackTrace();
    }return ls;
    }
    public Object[][] readExcelData(String filePath,int sheetNumber) throws IOException
    {
        //String Filepath="E:\\Old\\ExtentReports\\ExcelFiles\\login.xlsx";
        File file=new File(filePath);
        FileInputStream fis=new FileInputStream(file);
        XSSFWorkbook book=new XSSFWorkbook(fis);
        XSSFSheet sheet=book.getSheetAt(sheetNumber);
        Object[][] data=new Object[sheet.getLastRowNum()][2];
        for(int i=1;i<=sheet.getLastRowNum();i++)
        {
            for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
            {
                Cell cell=sheet.getRow(i).getCell(j);
                switch(cell.getCellType()) {

                    case STRING :
                    //case Cell.CELL_TYPE_STRING :    //when apache poi version is less than 4
                    {
                        data[i-1][j]=cell.getStringCellValue();
                    }
                    case NUMERIC:
                    //case Cell.CELL_TYPE_NUMERIC :   //when apache poi version is less than 4
                    {
                        data[i-1][j]=cell.getStringCellValue();
                    }
                    default :
                    {
                        data[i-1][j]=cell.getStringCellValue();
                    }
                }
            }
        }
        for(int i=0;i<data.length;i++)
        {
            for(int j=0;j<data[i].length;j++)
            {
                System.out.println(data[i][j]);
            }
        }
        return data;
    }
}
