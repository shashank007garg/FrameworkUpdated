package com.test.automation.uiAutomation.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public Excel_Reader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String[][] getDataFromSheet(String sheetName) {

		int rowcount;
		int columncount;
		try {

			XSSFSheet sheet = workbook.getSheet(sheetName);

			rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			columncount = sheet.getRow(0).getLastCellNum();

			String dataSets[][] = new String[rowcount][columncount];
			System.out.println("-------- excel Reader Started ----------");

			for (int i = 1; i <= rowcount; i++) {

				row = sheet.getRow(i);
//				Row newRow=sheet.createRow(rowcount+1);

				for (int j = 0; j < columncount; j++) {

					cell = row.getCell(j);
//					Cell newCell=newRow.createCell(j);
//					newCell.setCellValue("shashank");
					
					CellType type=cell.getCellType();
					
					// If cell of type String , then this if condition will work
					if (type == CellType.STRING)
						dataSets[i - 1][j] = cell.getStringCellValue();
					

					// If cell of type Number , then this if condition will work
					else if (type ==CellType.NUMERIC) {
						int i1=(int) cell.getNumericCellValue();
						
						String cellText=String.valueOf(i1); 
					
								
						dataSets[i - 1][j] = cellText;
					} 
					else if (type==CellType.BLANK) {
						
						String cellText =  "";
								
						dataSets[i - 1][j] = cellText;
					}
					
					
					else
						// If cell of type boolean , then this if condition will
						// work
						dataSets[i - 1][j] = String.valueOf(cell
								.getBooleanCellValue());
					

				}
			}
			
			return dataSets;
		}

		catch (Exception e) {
			System.out.println("Exception in excel file" + e.getMessage());
		}
		return null;

	}

}
