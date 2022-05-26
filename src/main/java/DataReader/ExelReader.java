package DataReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExelReader {


    public Object[][] readXsls() throws IOException{
        File path=new File("D:/intelliJWorkspace/SimpleRestAssure/src/main/java/DataReader/data.xlsx");
        FileInputStream file=new FileInputStream(path);

        XSSFWorkbook workbook=new XSSFWorkbook(file) ;
        XSSFSheet sheet=workbook.getSheetAt(0);
        int totalRows=sheet.getLastRowNum()+1;
        int totalCols=sheet.getRow(0).getLastCellNum();
        String [][] array=new String [totalRows][totalCols];

        for (int i = 0; i <totalRows ; i++) {
            for (int j = 0; j <totalCols ; j++) {
                XSSFRow row= sheet.getRow(i);
                array [i][j]=row.getCell(j).toString();

            }

        }


     workbook.close();

        return  array;
    }


}
