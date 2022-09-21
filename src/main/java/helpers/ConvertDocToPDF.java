package helpers;

import java.io.*;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;


public class ConvertDocToPDF {

    public static boolean docToPDF(String location, File[] files){
        POIFSFileSystem fs = null;
        String newFileName = null;
        String outputFileName = null;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                try {
                    Document pdfDoc = new Document();
                    if(files[i].getName().endsWith("doc")) {
                     newFileName = files[i].getName().replace(".doc", "");
                }else{
                     newFileName = files[i].getName().replace(".docx", "");
                }
                    String output_file = files[i].getParent() + "//" + newFileName + ".pdf";
                     outputFileName = newFileName + ".pdf";
                    String path = files[i].getParent();
                    System.out.println("Path is "+path);
                    System.out.println("Starting the test");
                    //FileInputStream fis = new FileInputStream("C:\\Users\\Pankaj\\Downloads\\TestFolder\\Test.docx");
                    FileInputStream fis = new FileInputStream( files[i]);
                    XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                    XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                    System.out.println(extractor.getText());
            /*fs = new POIFSFileSystem(new FileInputStream("C:\\Users\\Pankaj\\Downloads\\TestFolder\\TestDoc.doc"));
            XWPFDocument doc = new XWPFDocument(fs);
            WordExtractor we = new WordExtractor(doc);*/

                    OutputStream file = new FileOutputStream(new File(output_file));

                    PdfWriter writer = PdfWriter.getInstance(pdfDoc, file);
                    pdfDoc.open();
                    writer.setPageEmpty(true);
                    pdfDoc.newPage();
                    writer.setPageEmpty(true);
                    //String[] paragraphs = we.getParagraphText();
                    String paragraphs = extractor.getText();
                    // for (int i = 0; i < paragraphs.length(); i++) {

                    //xdoc.getParagraphs(i);
                    // CharacterRun run = pr.getCharacterRun(i);
                    // run.setBold(true);
                    // run.setCapitalized(true);
                    // run.setItalic(true);
                /*paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n", "");
                System.out.println("Length:" + paragraphs[i].length());
                System.out.println("Paragraph" + i + ": " + paragraphs[i].toString());*/
                    pdfDoc.add(new Paragraph(paragraphs));
                    // }
                    pdfDoc.close();
                    System.out.println("Document testing completed");
                } catch (Exception e) {
                    System.out.println("Exception during test");
                    e.printStackTrace();
                } finally {
                    System.out.println("Pdf file has been created at location : " + location + " with name " + outputFileName);
                }

            }
        }//pdfDoc.close();
        return true;}
    public File[] finder(String dirName){
        File dir = new File(dirName);
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".doc")||(name.endsWith(".docx")));
            }
        });
    }
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\Pankaj\\Downloads\\TestFolder\\";
        ConvertDocToPDF  docToPdf = new ConvertDocToPDF();
        File[] files = docToPdf.finder(fileLocation);
        docToPDF(fileLocation, files);
    }
}
