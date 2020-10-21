package TestSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws Exception {

		// Setting properties of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers");

		// Create list of all Componies
		List<WebElement> allCompines = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		System.out.println("Total Componies:" + allCompines.size());

		// Create list of all compony price list
		List<WebElement> currentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println("Total Componies:" + currentPrice.size());

		String componyName = "HFCL";
		for (int i = 0; i < allCompines.size(); i++) {
			if (allCompines.get(i).getText().equalsIgnoreCase(componyName)) {
				System.out.println(allCompines.get(i).getText() + "==" + currentPrice.get(i).getText());
				allCompines.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
