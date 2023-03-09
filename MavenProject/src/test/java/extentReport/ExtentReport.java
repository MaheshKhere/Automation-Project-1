package extentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	public WebDriver driver;
	String projectpath = System.getProperty("user.dir");
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;

	@Test
	public void TestReport() {
		// extentreports dependencies is 3.1.5 from com.aventstack
		htmlreport = new ExtentHtmlReporter(projectpath + "\\extentreport\\Test Report.html");
		System.out.println(projectpath);
		htmlreport.config().setDocumentTitle("Automation test");
		htmlreport.config().setReportName("Smoke Test");
		htmlreport.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("os", "windows");
		reports.setSystemInfo("QA", "Mahesh Khere");
		reports.setSystemInfo("browser", "Chrome");
		test = reports.createTest("TestReport");
		test.log(Status.INFO, "Open browser"); // return type status string details

		// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32
		// (2)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		reports.flush();
	}
}
