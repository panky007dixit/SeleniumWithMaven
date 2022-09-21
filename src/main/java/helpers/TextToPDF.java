package helpers;
import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TextToPDF {

    public static boolean convertTextToPDF(String location, File[] file) throws Exception

    {
        FileInputStream fis = null;
        DataInputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                try {
                    // Document pdfDoc = new Document();
                    Document pdfDoc = new Document();
                    // String output_file = file.getParent() + "//" + "sample.pdf";
            /*for (int i = 1; i <= file.length; i++) {
                if (file[i].isFile()) {*/
                    String newFileName = file[i].getName().replace(".txt", "");
                    String output_file = file[i].getParent() + "//" + newFileName + ".pdf";
                    String outputFileName = newFileName + ".pdf";
                    PdfWriter writer = PdfWriter.getInstance(pdfDoc,
                            new FileOutputStream(output_file));
                    pdfDoc.open();
                    pdfDoc.setMarginMirroring(true);
                    pdfDoc.setMargins(36, 72, 108, 180);
                    pdfDoc.topMargin();

                    BaseFont courier = BaseFont.createFont(BaseFont.COURIER,
                            BaseFont.CP1252, BaseFont.EMBEDDED);
                    Font myfont = new Font(courier);

                    // Font myfont = new Font();
                    Font bold_font = new Font();

                    bold_font.setStyle(Font.BOLD);
                    bold_font.setSize(10);

                    myfont.setStyle(Font.NORMAL);
                    myfont.setSize(9);

                    pdfDoc.add(new Paragraph("\n"));

                    if (file[i].exists()) {
                        fis = new FileInputStream(file[i]);
                        in = new DataInputStream(fis);
                        isr = new InputStreamReader(in);
                        br = new BufferedReader(isr);

                        String strLine;

                        while ((strLine = br.readLine()) != null) {
                            Paragraph para = new Paragraph(strLine + "\n", myfont);
                            para.setAlignment(Element.ALIGN_JUSTIFIED);

                            pdfDoc.add(para);
                            System.out.println("Pdf file has been created at location : " + location + " with name " + outputFileName);
                        }
                    } else {

                        System.out.println("no file exists!");
                        return false;
                    }
                    pdfDoc.close();
                    //}}
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                } finally {
                    if (br != null) {
                        br.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    if (isr != null) {
                        isr.close();
                    }
                }
                //return true;
            }
        }return true;}
    public File[] finder(String dirName){
        File dir = new File(dirName);
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
    }
    public static void main(String args[]) throws Exception {
        //String fileLocation = "C:\\Users\\Pankaj\\Desktop";
        String fileLocation = "C:\\Users\\Pankaj\\Downloads\\TestFolder";
        //File file = new File("C:\\Users\\Pankaj\\Desktop\\debug.txt");
        TextToPDF  textToPDF = new TextToPDF();
        File[] files = textToPDF.finder(fileLocation);
     convertTextToPDF(fileLocation, files);
    }
}

