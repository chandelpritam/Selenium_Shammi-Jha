package TestSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingPopUp1 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");

		// print how many windows are opened
		Thread.sleep(3000);
		Set<String> popUpId = driver.getWindowHandles();
		System.out.println(popUpId);// alphanumeric Id of popUpId
		System.out.println(popUpId.size());

		Iterator<String> it = popUpId.iterator();
		String mainWindow = it.next();
		String popUpWindow1 = it.next();
		String popUpWindow2 = it.next();

		// switching to the main window as well as popup window and print the title
		driver.switchTo().window(popUpWindow1);
		System.out.println(driver.getTitle());

		Thread.sleep(3000);
		driver.switchTo().window(mainWindow);
		System.out.println(mainWindow); // alphanumeric Id of mainWindow
		System.out.println(driver.getTitle());

		driver.close();
		driver.quit();
	}

}
