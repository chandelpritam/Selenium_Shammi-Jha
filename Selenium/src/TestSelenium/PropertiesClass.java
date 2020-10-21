 package TestSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesClass {

	public static void main(String[] args) throws Exception {

		// Specify the location of properties file
		File src = new File("C:\\Workspace\\Repository\\Object_Repo.properties");

		// Create file input stream object to load the file
		FileInputStream fis = new FileInputStream(src);

		// Create Properties class object to read properties
		Properties pro = new Properties();
		pro.load(fis);

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		Thread.sleep(3000);

		// getProperties() is a method which accept key and return value for the same
		// key

		driver.findElement(By.xpath(pro.getProperty("EmailOrPhone"))).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath(pro.getProperty("Password"))).sendKeys("12345");

		driver.close();
		driver.quit();
	}

}
