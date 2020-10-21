package TestSelenium;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws Exception {

		// Specify location of file
		File src = new File("Specify the File Location");

		// Load the file
		FileInputStream fis = new FileInputStream(src);

		// Load Workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Load WorkSheet
		XSSFSheet sh = wb.getSheet("File Name");

		// Get the name of loaded sheet
		System.out.println(sh.getSheetName());

		// print username from excel sheet
		System.out.println(sh.getRow(0).getCell(0).getStringCellValue());

		//
	}

}
