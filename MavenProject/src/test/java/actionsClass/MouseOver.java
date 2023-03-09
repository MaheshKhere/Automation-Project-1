package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	@Test
	public void mouseover() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");

		Actions act = new Actions(driver);
		WebElement lang = driver.findElement(By.cssSelector("span[class=icp-nav-link-inner]")); // move to langauge
		act.moveToElement(lang).build().perform();
		WebElement addlist = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")); // move to account and
																								// list
		WebElement acc = driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span")); // move to account
		// act.moveToElement(addlist).build().perform();
		// act.moveToElement(acc).click().build().perform();

		act.moveToElement(addlist).moveToElement(acc).click().build().perform();
		Thread.sleep(3000);

		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		act.moveToElement(searchbox).click().sendKeys("T shirts").build().perform();// click and type tshirt

		act.moveToElement(searchbox).keyDown(Keys.BACK_SPACE).build().perform(); // remove tshirt by using backspace
		Thread.sleep(3000);
		// act.moveToElement(searchbox).keyDown(Keys.SHIFT).sendKeys("shoe").build().perform();//
		// shoe in uppercase
		driver.close();
	}

}
