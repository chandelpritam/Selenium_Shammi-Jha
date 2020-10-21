package TestSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("how stuff works");

		// How to handle Auto Suggestion
		WebElement AllSuggestion = driver.findElement(By.xpath("//*[@role='listbox']"));
		List<WebElement> AllSearch = AllSuggestion.findElements(By.tagName("li"));
		System.out.println("Total Auto Suggestion:" + AllSearch.size());

		for (int i = 0; i < AllSearch.size(); i++) {
			String AllSuggestionList = AllSearch.get(i).getText();
			String finalResult = "how stuff works quiz";

			if (AllSuggestionList.equalsIgnoreCase(finalResult)) {
				AllSearch.get(i).click();
				System.out.println("You Have Selected:" + finalResult);
				break;
			}
		}
	}

}

