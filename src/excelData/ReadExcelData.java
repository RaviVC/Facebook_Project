package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import libraries.ExcelDataConfig;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static void main(String[]args) throws Exception {
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\ExcelDataInput\\TestData.xlsx");
		
		System.out.println(excel.getData(1, 1, 1));
			
	}

}
























/*File src = new File("C:\\ExcelDataInput\\TestData.xlsx");

FileInputStream fis = new FileInputStream(src);

XSSFWorkbook wb = new XSSFWorkbook(fis);

XSSFSheet Sheet1 = wb.getSheetAt(0);

int rowcount = Sheet1.getLastRowNum();

for(int i=0;i<rowcount;i++)
{
	String data1 = Sheet1.getRow(i).getCell(1).getStringCellValue();
	System.out.println("Test data from excel is " + data1);
} 

wb.close();*/

	//String data1 = Sheet1.getRow(0).getCell(0).getStringCellValue();
	//System.out.println("Data from excel is : " + data1);
	//String data2 = Sheet1.getRow(1).getCell(1).getStringCellValue();
	//System.out.println("Data from excel is : " + data2);
