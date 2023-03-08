package lumaPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lumatestcases.BaseClass;
import lumatestcases.LoginUser;

public class Allexecution extends BaseClass {
	public static WebDriver driver;
	LoginUser loginuser;

	@BeforeTest
	public void Launch() throws Exception {
		launchbrowser();

	}

	@Test
	public void lc() {
		loginuser = new LoginUser(driver);
		loginuser.verifylink();

		loginuser.LoginDetails();
		System.out.println(projectpath);
	}

	// WebElement button =
	// driver.findElement(By.xpath("//span[@class='customer-name'][1]/button/span"));
	// button.click();
	// driver.findElement(By.xpath("//div[@class='customer-menu']/ul/li/a[1]")).click();
	// driver.findElement(By.xpath("//div[@data-target='dropdown'][1]")).click();
	// driver.findElement(By.id("search")).sendKeys("Shirts");
	// driver.findElement(By.xpath("//button[@class='magnifying-glass']")).click();

	//// button[@class='action switch'][1]

}
