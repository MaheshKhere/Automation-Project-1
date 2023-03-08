package DataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SendingDataToApplication {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

		driver.findElement(By.id("wzrk-cancel")).click();
		FileInputStream file = new FileInputStream("C:\\Users\\HP\\Desktop\\Interest cal.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		for (int a = 1; a < rowcount; a++) {
			XSSFRow row = sheet.getRow(a);
			// XSSFCell princ = row.getCell(0); // capture cell value and strore in one
			// vairiable
			// int princvalue = (int) princ.getNumericCellValue(); // get cell value store
			// in vairable and do type casting
			int princvalue = (int) row.getCell(0).getNumericCellValue();
			int roi = (int) row.getCell(1).getNumericCellValue();
			int period = (int) row.getCell(2).getNumericCellValue();
			String frequency = row.getCell(3).getStringCellValue();
			int expvalue = (int) row.getCell(4).getNumericCellValue();

			driver.findElement(By.cssSelector("input[name=principal]")).sendKeys(String.valueOf(princvalue)); // convert
																												// string
																												// value
																												// to
																												// integer
			driver.findElement(By.cssSelector("input[name=interest")).sendKeys(String.valueOf(roi));
			driver.findElement(By.cssSelector("input[name=tenure]")).sendKeys(String.valueOf(period));

			Select tenuredrp = new Select(driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]"))); // tenure dropdown
			tenuredrp.selectByVisibleText("year(s)");

			Select frequencydrp = new Select(driver.findElement(By.xpath("//*[@id=\"frequency\"]"))); // frequency
																										// dropdown
			frequencydrp.selectByVisibleText("Simple Interest");

			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click(); // calculate button

			String actualvalue = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText(); // expected
																											// value

			if ((Double.parseDouble(actualvalue)) == expvalue) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click(); // clear button

		}

	}

}
