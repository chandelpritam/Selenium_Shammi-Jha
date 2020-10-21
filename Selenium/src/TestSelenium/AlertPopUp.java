package TestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AlertPopUp {

	public static void main(String[] args) throws Exception {

		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.xpath("//*[@name='proceed']")).click();

		// How to verify Alert text
		System.out.println(driver.switchTo().alert().getText());
		String expectedResult = "Please enter a valid user name";
		Assert.assertEquals(driver.switchTo().alert().getText(), expectedResult);
		System.out.println("Alert get verified");

		// To accept the alert
		driver.switchTo().alert().accept();

		// To dismiss the alert
		// driver.switchTo().alert().dismiss();

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
