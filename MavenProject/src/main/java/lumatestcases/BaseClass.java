package lumatestcases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(p.getProperty("lumaurl"));

		return driver;
	}

	public void launchbrowser() throws Exception {
		initializebrowser();
	}
}
