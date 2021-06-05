package com.qa.classicCRM.utilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private static Workbook book;
	private static Sheet sheet;

//excelutil.java will read the data from excel sheet, java does not provide any excel operation we have to use third party operation apoice pooi. we have to add de
	// Dependencies

	public static String Test_Data_sheet_path = ".\\src\\main\\java\\com\\qa\\classicCRM\\testdata\\OpenCartTestDataWed (2).xlsx";

	public static Object[][] getTestData(String sheetName) {
		// in java we have a class to make the connection with the any excel file
		// now appoice poi will work start, we have to going into the workbook , going
		// into the workbook, we have workbook factory class is there
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream(Test_Data_sheet_path);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; // this line the object array is blank, now we have to fill the data
			//for traverse the object array , we will use for loop
			
			for(int i=0; i<sheet.getLastRowNum();i++) {
				for(int j=0; j< sheet.getRow(0).getLastCellNum();j++){
					// filling the data
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}

			// create method will give you the reference of workbook
			// we have to pass the object of file input stream here , inside the java memory
			// , it will create the repla of excel sheet
			// from book we have to go the sheets
			// after sheets, we have to read the rows and columns
			//the moment we write , the object array line, inside the memory:- 

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
return data;
	}

}
