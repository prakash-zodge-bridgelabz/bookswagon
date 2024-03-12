package bw_utility;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class utility {
    public static long IMPLICIT_WAIT = 10;
    public static long PAGE_LOAD_TIMEOUT = 20;

    //Reading excel data
    public static String testDataPath="D:\\Quality Kiosk SDET\\Application Interface & E2E QA\\bookswagon\\src\\main\\java\\bw_testData\\loginDetails.xlsx";

    static Workbook book;
    static org.apache.poi.ss.usermodel.Sheet sheet;
    public static Object[][] getTestData(String SheetName){
        FileInputStream file = null;
        try{
            file = new FileInputStream(testDataPath);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try{
            book = WorkbookFactory.create(file);
        }catch(IOException | EncryptedDocumentException e){
            e.printStackTrace();
        }
        sheet = book.getSheet(SheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0;i<sheet.getLastRowNum();i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }
}
