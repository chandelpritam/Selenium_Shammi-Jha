package TestSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckBox {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		// it is not good approch to handle multiple web elements
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='-1']")).click();

		// Creating a list for all radio button
		List<WebElement> radios = driver.findElements(By.xpath("//input[contains(@type,'radio')]"));
		System.out.println("Total number of radio buttons" + radios.size());

		Thread.sleep(3000);
		System.out.println(radios.get(1).isSelected());
		Thread.sleep(3000);
		System.out.println(radios.get(0).isEnabled());
		Thread.sleep(3000);
		System.out.println(radios.get(2).isDisplayed());
		Thread.sleep(3000);

		// 3rd way
		List<WebElement> radios1 = driver.findElements(By.xpath("//label[contains(@class,'mt')]"));

		driver.close();
		driver.quit();
	}

}
