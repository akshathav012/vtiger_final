package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheets
 * @throws Throwable 
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromExcel(String sheetName, int rowNo, int celNo ) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(celNo);
		String value = cel.getStringCellValue();
		return value;
		
		
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.createCell(celNo);
		cel.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
	}
	
	/**
	 * This method will return the last row number
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getLastRowNum();
		return row;
	}
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheet name
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleDataFromExcel(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}



























