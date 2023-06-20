package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	@Test
	public void verifyslider() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");

		// Switch to inside frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions b = new Actions(driver);
		WebElement drag = driver.findElement(By.id("slider"));

		// Slider Move in Right direction
		b.dragAndDropBy(drag, 200, 0).perform();
		Thread.sleep(3000);

		// Slider move in left direction
		b.dragAndDropBy(drag, -100, 0).perform();
		// driver.close();
	}
}
