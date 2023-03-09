package DataDrivenTest;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingDataFromExcel {

	@Test
	public void verifyexceldata() throws Exception {

		FileInputStream file = new FileInputStream("F:\\BITUMEN PATCHES QUANTITY.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Bitumen Patches Quantity 1");
		// XSSFSheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum(); // return row count
		int columncount = sheet.getRow(0).getLastCellNum(); // returns column/cell count
		for (int i = 0; i < rowcount; i++) {
			XSSFRow currentrow = sheet.getRow(i); // focus on current row
			for (int x = 0; x < columncount; x++) {
				String value = currentrow.getCell(x).toString(); // read the value from cell
				System.out.print("  " + value);

			}
			System.out.println();
		}

	}

}
