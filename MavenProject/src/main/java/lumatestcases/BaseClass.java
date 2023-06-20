package lumatestcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties p;
	public String projectpath = System.getProperty("user.dir");

	public WebDriver initializebrowser() throws Exception {
		p = new Properties();
		FileInputStream file = new FileInputStream(projectpath + "\\src\\test\\java\\lumaResources\\data.properties");
		p.load(file);
		String browsername = p.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "D:\\chromedriver_win32(2)\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(p.getProperty("amazonurl"));

		return driver;

	}

	public void launchbrowser() throws Exception {
		initializebrowser();
	}

	public void takesnap(String testmethodName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(projectpath + "\\snapshot\\" + testmethodName + ".png");
		FileUtils.copyFile(src, trg);
	}
//Reporting verification

	public boolean isLinkEqual(String expectedlink) {
		String actuallink = driver.findElement(By.linkText("Customer Service")).getText();
		if (actuallink.equals(expectedlink))
			return true;
		else
			return false;
	}

}
