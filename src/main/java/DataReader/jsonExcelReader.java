package DataReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class jsonExcelReader {


    public Object[][] jsonResponsereadFromExcel() throws IOException, InvalidFormatException {

        File file=new File("D:/intelliJWorkspace/SimpleRestAssure/src/main/java/DataReader/jsonData.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheetAt(0);
        int total_rows=sheet.getPhysicalNumberOfRows();
        int total_cols=sheet.getRow(0).getLastCellNum();

        String [][]arr=new String[total_rows-1][total_cols];

        for (int i = 1; i < total_rows; i++) {
            for (int j = 0; j < total_cols; j++) {

                XSSFRow row=sheet.getRow(i);
                arr[i-1][j]=row.getCell(j).toString();

            }

        }
     workbook.close();

        return arr;
    }


}
