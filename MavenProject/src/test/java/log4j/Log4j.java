package log4j;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4j {
	Logger log = LogManager.getLogger(Log4j.class);
	String projectpath = System.getProperty("user.dir");

	// Logger import from org.apache.logging.log4j

	@Test
	public void navigate() throws Exception {
		WebDriverManager.chromedriver().setup();
		FileInputStream file = new FileInputStream(
				projectpath + "\\src\\test\\java\\log4jResources\\log4jconfigure.properties");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		log.warn("This is warn");
		log.error("This is error");
	}

}
