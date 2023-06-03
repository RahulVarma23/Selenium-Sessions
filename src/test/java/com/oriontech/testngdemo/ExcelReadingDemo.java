package com.oriontech.testngdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;
import java.io.IOException;

public class ExcelReadingDemo {

    @Test(dataProvider = "CredentialsData")
    public void printData(String username, double age ) {
        System.out.println("username: "+username+ " age: "+age);
    }

    @DataProvider(name = "CredentialsData")
    public Object [] [] readCredsTestData() throws IOException {
        String filePath = ".//src//main//resources//testFiles//credentials.xlsx";
        String sheetName = "creds";
        return ExcelUtils.readDataFromExcel(filePath, sheetName);
    }
}
