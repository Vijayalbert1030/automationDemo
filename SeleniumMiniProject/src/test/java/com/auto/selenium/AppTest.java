package com.auto.selenium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}


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
