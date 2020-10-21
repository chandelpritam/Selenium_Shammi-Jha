package TestSelenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log4j {

	public static void main(String[] args) throws Exception {

		// We need to create logger class instance so we need to pass class name for
		// which we want to create log file, in this case class name is Log4j
		Logger logger = Logger.getLogger("Log4j");

		// We have to configure Log4j properties file
		PropertyConfigurator.configure("C:\\Workspace\\log4j.properties");

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.info("ChromeDriver Opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("ImplicitWait Given");
		driver.get("https://www.facebook.com/");
		logger.info("Facebook Application Opened");

		Thread.sleep(3000);

		driver.close();
		driver.quit();
	}

}
