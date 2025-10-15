package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {
	static FileInputStream f;// to get the details from the file
	static XSSFWorkbook wb;// to get the details from the workbook
	static XSSFSheet sh;// to get the details from the sheet

	public static String getStringData(int a, int b, String sheet) throws IOException// a & b row and cell/coloum values
																						// in excel
	{
		f = new FileInputStream(Constant.TestDataFile);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();// method to get string value
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(
				"C:\\Users\\USER\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\Grocery_App_Data.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x);
	}

}
