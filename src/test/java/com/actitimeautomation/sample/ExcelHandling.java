package com.actitimeautomation.sample;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHandling {
    public Workbook getWorkbook(String filepath) {
        Workbook workbook = null;
        try {
            String extension = filepath.substring(filepath.indexOf(".") + 1);
            System.out.println(extension);
            //access file
            FileInputStream inputStream = new FileInputStream(filepath);
            //Based on the extension of file ,access the work of excel file
            if (extension.equals("xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else if (extension.equals("xls")) {
                workbook = new HSSFWorkbook(inputStream);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public Object[][] getExcelData(String filepath, String sheetname) throws IOException {
        Workbook workbook = getWorkbook(filepath);
        //get the control of sheet
        Sheet sheet = workbook.getSheet(sheetname);
        //get total number of rows
        int totalRows = sheet.getPhysicalNumberOfRows();
        //get the total column of 0th row
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        //two dimensional array
        Object[][] testData = new Object[totalRows - 1][totalColumns];
        for (int i = 1; i <= totalRows - 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j <= totalColumns - 1; j++) {
                Cell cell = row.getCell(j);
                //check the type of cell
                CellType cellType = cell.getCellType();
                Object value = null;
                //get the value from cell based on the type
                if (cellType.equals(CellType.NUMERIC)) {
                    value = cell.getNumericCellValue();
                } else if (cellType.equals(CellType.STRING)) {
                    value = cell.getStringCellValue();
                } else if (cellType.equals(CellType.BOOLEAN)) {
                    value = cell.getBooleanCellValue();
                } else {
                    value = "";
                }
                testData[i - 1][j] = value;
                System.out.println(value + " ");
            }
            System.out.println();
        }
        System.out.println(testData);
        //close workbook
        workbook.close();
        return testData;
    }
                public void writeExcelData(String filepath,String sheetname)throws IOException {
            Workbook workbook = getWorkbook(filepath);
            //create sheet from workbook refrences
            Sheet sheet = workbook.createSheet(sheetname);
            //create row from sheet refrence
            Row row = sheet.createRow(0);
            //create cell from row refrence
            Cell cell = row.createCell(0);
            //set value in cell
            cell.setCellValue(1);
            //create object of fileoutputstreame to write or save the file
            FileOutputStream outputStream = new FileOutputStream(filepath);
            //write or save the data workbook using FileoutputStream refrences
            workbook.write(outputStream);
            //close the workbook
            workbook.close();
            outputStream.close();
        }
                public static void main (String [] args)throws IOException{
                    ExcelHandling excelHandling=new ExcelHandling();
                    String filepath="E:/XL selenium/Test.xlsx";
                    excelHandling.getExcelData(filepath,"sheet1");
        }
    }