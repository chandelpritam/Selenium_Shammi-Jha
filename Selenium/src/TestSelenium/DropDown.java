package TestSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws Exception {

		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(3000);

		// First way- Not recommanded but indursty use most
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='month']/option"));
		System.out.println("Total dropdown values are:" + list.size());
		list.get(9).click(); // September
		System.out.println(list.get(9).isDisplayed()); // Checking wheather Sep is displyed or not

		// Second Way- Recommanded
		WebElement BirthMonth = driver.findElement(By.xpath("//*[@id='month']"));
		// Will use Select class a constructor
		Select select = new Select(BirthMonth);
		// Select By Visible Text
		select.selectByVisibleText("Aug");
		// Select By Value
		select.selectByValue("12");
		// Select By Index
		select.selectByIndex(10);
		// Get selected value from dropdown
		System.out.println(select.getFirstSelectedOption().getText());

		// Third Way- We are storing the all dropdown value in list
		List<WebElement> dropdown = select.getOptions();
		for (int i = 0; i < dropdown.size(); i++) {
			String drowdownvalues = dropdown.get(i).getText();
			Thread.sleep(3000);
			if (drowdownvalues.equalsIgnoreCase("Aug")) {
				dropdown.get(i).click();
			}
		}

		// Forth Way- Checking the dropdown is supporting multiple selection or not
		// Return type will be always boolean
		System.out.println(select.isMultiple());
		select.selectByIndex(2);
		select.selectByValue("5");
		select.selectByVisibleText("Dec");
		select.deselectAll();

		// Fifth Way- Handle dropdown without using select class
		BirthMonth.sendKeys("Feb");
		driver.findElement(By.xpath("//*[@class='month']")).sendKeys("Mar");
		Thread.sleep(3000);

		driver.close();
		driver.quit();

	}

}
