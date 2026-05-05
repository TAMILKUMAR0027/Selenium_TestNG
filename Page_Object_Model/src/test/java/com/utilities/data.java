package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class data {

    String filePath = "C:\\Users\\tamil\\git\\repository18\\Page_Object_Model\\src\\test\\resources\\OrangeHrm.xlsx";

    @DataProvider(name = "ValidData", parallel = true)
    public Object[][] excelDataProvider() throws IOException {
        return getExcelData(filePath, "Sheet1");
    }

    @DataProvider(name = "InvalidData", parallel = true)
    public Object[][] excelDataProvider1() throws IOException {
        return getExcelData(filePath, "Sheet2");
    }

    public String[][] getExcelData(String filename, String sheetName) throws IOException {

        FileInputStream fs = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        XSSFSheet sheet = workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(0);

        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = row.getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfCols];

        for (int i = 1; i < noOfRows; i++) {

            row = sheet.getRow(i);

            for (int j = 0; j < noOfCols; j++) {

                Cell cell = row.getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
        }

        workbook.close();
        fs.close();

        return data;
    }
}