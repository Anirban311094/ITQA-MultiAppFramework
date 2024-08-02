package com.SetupAuxiliaries.excelhandle;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelHandles {

//Work with Excel Sheets
    
    //get values under getValueColumn where currentColumn=currentValue
    public static ArrayList<String> getTheValues(String filePath, String sheetName, String currentColumn, String currentValue, String getValueColumn) {
        System.out.println("Path: "+filePath+"\n Sheet: "+sheetName+"\n Column: "+currentColumn+"\n currentValue"+currentValue+"\n getValueColumn"+getValueColumn);
    	ArrayList<String> values = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
            }

            int currentColIndex = -1;
            int getValueColIndex = -1;

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " is empty.");
            }

            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equals(currentColumn)) {
                    currentColIndex = cell.getColumnIndex();
                }
                if (cell.getStringCellValue().equals(getValueColumn)) {
                    getValueColIndex = cell.getColumnIndex();
                }
            }

            if (currentColIndex == -1) {
                throw new IllegalArgumentException("Column " + currentColumn + " does not exist.");
            }
            if (getValueColIndex == -1) {
                throw new IllegalArgumentException("Column " + getValueColumn + " does not exist.");
            }

            for (Row row : sheet) {
                Cell cell = row.getCell(currentColIndex);
                if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(currentValue)) {
                    Cell valueCell = row.getCell(getValueColIndex);
                    if (valueCell != null && valueCell.getCellType() == CellType.STRING) {
                        values.add(valueCell.getStringCellValue());
                    } else if (valueCell != null && valueCell.getCellType() == CellType.NUMERIC) {
                        values.add(String.valueOf(valueCell.getNumericCellValue()));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return values;
    }
    
    public static ArrayList<String> getAllRowValues(String filePath, String sheetName, String currentColumn, String currentValue) {
        ArrayList<String> values = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
            }

            int currentColIndex = -1;

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " is empty.");
            }

            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equals(currentColumn)) {
                    currentColIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (currentColIndex == -1) {
                throw new IllegalArgumentException("Column " + currentColumn + " does not exist.");
            }

            for (Row row : sheet) {
                Cell cell = row.getCell(currentColIndex);
                if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(currentValue)) {
                    for (Cell valueCell : row) {
                        if (valueCell.getColumnIndex() != currentColIndex) {
                            if (valueCell.getCellType() == CellType.STRING) {
                                values.add(valueCell.getStringCellValue());
                            } else if (valueCell.getCellType() == CellType.NUMERIC) {
                                values.add(String.valueOf(valueCell.getNumericCellValue()));
                            }
                        }
                    }
                    break; // Stop after finding the first matching row
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return values;
    }
    
    
	
}
