package com.crm.PRACTICE;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
	
	@Test
	public void readDataFromExcelSheet() throws EncryptedDocumentException, IOException
	{
		//step 1: load excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	    //step 2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//step3:get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//step 4:get the row
		Row ro = sh.getRow(1);
		//get the cell
		Cell ce = ro.getCell(1);
		//read the data from the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
	}

}
