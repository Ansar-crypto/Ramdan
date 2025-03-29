package com.actitimeautomation.sample;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling1{
    public static void main (String [] args) throws IOException {
        Workbook workbook=null;
        String filepath="E:/XL selenium/Test.xlsx";
        String extension=filepath.substring(filepath.indexOf(".")+1);
        System.out.println(extension);
        //access file
        FileInputStream inputStream=new FileInputStream(filepath);
        //Based on the extension of file,access the work of file
        if (extension.equals("xlsx")){
            workbook=new XSSFWorkbook(inputStream);
        } else if (extension.equals("xls")) {
            workbook=new HSSFWorkbook(inputStream);
        }
        //get the control of sheet
        Sheet sheet=workbook.getSheet("sheet1");
        //get the total number of rows
        int totalRows=sheet.getPhysicalNumberOfRows();
        //get the total coloumn from 0th Row
        int totalColomns=sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i=1;i<=totalRows-1;i++){
            Row row=sheet.getRow(i);
            for (int j=0;j<=totalColomns-1;j++){
                Cell cell=row.getCell(j);
                //check the type of cell
                CellType cellType=cell.getCellType();
                Object value=null;
                //get the value of cell based on the type
                if (cellType.equals(CellType.NUMERIC)){
                    value=cell.getNumericCellValue();
                } else if (cellType.equals(CellType.STRING)) {
                    value=cell.getStringCellValue();
                } else if (cellType.equals(CellType.BOOLEAN)) {
                    value=cell.getBooleanCellValue();
                }
                else {
                    value=" ";
                }
                System.out.print(value+" ");
            }
            System.out.println();
        }
        //close workbook
        workbook.close();
        //close file
        inputStream.close();
    }
}
