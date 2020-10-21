package TestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimulation {

	public static void main(String[] args) throws Exception {
		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipcart.com/");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();

		// Creating web element referance
		WebElement electronics = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		WebElement Men = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));

		// Mouse simulation using Actions class
		Actions action = new Actions(driver);

		// Mouse hover to electronic web element
		Thread.sleep(3000);
		action.moveToElement(electronics).build().perform();

		// Right click

	}

}
