package org.ictkerala.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream Excelfile=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Data_Group6.xlsx");
		

		XSSFWorkbook excelWbook=new XSSFWorkbook(Excelfile);
		XSSFSheet excelSheet=excelWbook.getSheetAt(0);
		System.out.println(excelSheet.getRow(1).getCell(0).getStringCellValue());

	}*/
	public static XSSFWorkbook excelWbook;
	//public static XSSFSheet excelSheet1;
	//public static XSSFSheet excelSheet2;
	public static XSSFSheet excelSheet;
	
	public static String getData(int rowNum,int colNum) throws IOException
	{
	FileInputStream inp=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Data_Group6.xlsx");
	excelWbook=new XSSFWorkbook(inp);
	//excelSheet1=excelWbook.getSheetAt(0);
	//excelSheet1=excelWbook.getSheetAt(1);
	excelSheet=excelWbook.getSheetAt(0);
	return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	

}
