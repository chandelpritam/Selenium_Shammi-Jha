package TestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws Exception {

		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		// Enter Username
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abc@facebook.com");

		// Explicit Wait to check password field is visible and will enter password
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pass']"))).sendKeys("123456");

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
