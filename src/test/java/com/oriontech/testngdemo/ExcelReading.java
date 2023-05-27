package com.oriontech.testngdemo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReading {


    @Test(dataProvider = "CredentialsData")
    public void printData(String username, String password ) {
        System.out.println("username: "+username+ " password: "+password);
    }

    @DataProvider(name = "CredentialsData")
    public Object [] [] readExcelTestData() throws IOException {
        FileInputStream fileInputStream;
        String filePath = ".//src//main//resources//testFiles//credentials.xlsx";

        //Load the excel file
        fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        //Get the desired sheet of the workbook
        Sheet sheet = workbook.getSheet("creds");

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
                data [i-1][j] = cell.getStringCellValue();
            }
        }
        return data;
    }
}
