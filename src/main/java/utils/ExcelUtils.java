package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object [] [] readDataFromExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream;

        //Load the excel file
        fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        //Get the desired sheet of the workbook
        Sheet sheet = workbook.getSheet(sheetName);

        //Get row and column counts
        int rowCount = sheet.getLastRowNum()+1;
        int columnCount = sheet.getRow(0).getLastCellNum();

        //create a two dimentional object
        Object [] [] data = new Object[rowCount-1][columnCount];

        //Read data from cells
        for(int i= 1;i<rowCount ;i++){
            Row row = sheet.getRow(i);
            for(int j=0;j<columnCount;j++){
                Cell cell = row.getCell(j);
                data [i-1][j] = getCellData(cell);
            }
        }
        return data;
    }

    public static Object getCellData(Cell cell){
        switch(cell.getCellType()){
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            default:
                return StringUtils.EMPTY;
        }
    }
}
