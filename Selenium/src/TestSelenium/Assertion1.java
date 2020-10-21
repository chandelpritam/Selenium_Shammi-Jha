package TestSelenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assertion1 {
	WebDriver driver;

	@Test
	public void testcase1() throws Exception {
		String expectedValidation = "Sorry, we don't recognise this email.";

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('login-signin').click()");

		Thread.sleep(3000);
		String actualValidation = driver.findElement(By.xpath("//p[@id='username-error']")).getText();
		System.out.println(actualValidation);

		Assert.assertEquals(expectedValidation, actualValidation);
		System.out.println("Assertion Successfully Validated");
		Thread.sleep(3000);

		Assert.assertFalse(driver.findElement(By.id("username-error")).isSelected());
		System.out.println("We are good with assertion");
		Thread.sleep(3000);

		driver.close();
		driver.quit();

	}
}
