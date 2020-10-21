package TestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws Exception {
		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");

		// Locate web element using javascript
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('email').value='abc@gmail.com'");
		jse.executeScript("document.getElementById('pass').value='123456'");

		// Clicking on web element using javascript
		jse.executeScript("document.getElementById('u_0_2').click()");
		Thread.sleep(3000);
		jse.executeScript("document.getElementById('u_1_2').checked=true");// another way to click using checked=true

		// Scroll up
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, 400)");

		// Scroll down
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0, -400)");

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
