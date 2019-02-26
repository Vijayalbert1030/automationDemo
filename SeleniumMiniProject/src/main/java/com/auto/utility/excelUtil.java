package com.auto.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelUtil {
		WebDriver driver; 
		FileInputStream FRead; 
		XSSFWorkbook wb; 
		XSSFSheet sh;
		String d1,d2;
		@Before
		public void beforeTest() throws IOException {
		driver = new ChromeDriver();
		FRead=new FileInputStream("/Users/vijay.kumar.albert/Desktop/Userdata.xlsx"); 
		wb=new XSSFWorkbook(FRead);
		sh= wb.getSheetAt(0);
		d1=sh.getRow(0).getCell(0).getStringCellValue();
		d2=sh.getRow(0).getCell(1).getStringCellValue();

		
		
		Workbook workbookForScript = null;
		org.apache.poi.ss.usermodel.Sheet sheetDetailsForScript = null;
		
		File fileForScript = new File(filePath);
		try(FileInputStream fileInputStreamForScript = new FileInputStream(fileForScript);){

			if(filePath.contains("xlsx")) {
				workbookForScript = new XSSFWorkbook(fileInputStreamForScript);
			}else{
				workbookForScript = new HSSFWorkbook(fileInputStreamForScript);
			}
			sheetDetailsForScript = workbookForScript.getSheetAt("Test");
			int rows = sheetDetailsForScript.getSheetAT("0");
	        
			int readColumnFrom = 0;
			String testDataColNo = propertyFileReader.getValue("");
			if(null != testDataColNo && !"".equals(testDataColNo)){
				readColumnFrom = Integer.parseInt(testDataColNo);
			}
			  
		    for (int i = 1; i < rows; i++) {
			  
			GetExcelCellVaueUtil cellVaueUtil = new GetExcelCellVaueUtil();
			String serialNo = cellVaueUtil.getCellValue(sheetDetailsForScript.getRow(i).getCell(0));
			String scriptName = cellVaueUtil.getCellValue(sheetDetailsForScript.getRow(i).getCell(1));
			String value = cellVaueUtil.getCellValue(sheetDetailsForScript.getRow(i).getCell(5));
			String toolType = cellVaueUtil.getCellValue(sheetDetailsForScript.getRow(i).getCell(6));
		} 

}
		}
