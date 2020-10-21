package IntializeDrivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class TestNgAnnotations {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	public FluentWait<WebDriver> fluentwait;
	protected static Logger Log = Logger.getLogger(TestNgAnnotations.class);
	
	public static ExtentReports extent;
	public static ExtentTest extlog;
	
@BeforeSuite
	
	public void deleteFailed() throws IOException {
		
		//File file = new File(BrowserData.getFailedtestcasesPath());
		
		//CommonFunctions.deleteDirectory(file);
	
	//need to write code for failed test cases
	
	Log.info("Suite begins");
		
	}
	
	@BeforeTest
	public void loadPropertFile() {
  
		
		Log.info("EXECUTION OF TEST CASE BEGINS");
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host name", "Ramesh Dell");
		extent.addSystemInfo("user name", "Ramesh VCM");
		extent.addSystemInfo("Environment", "QA");
		
		
    }
	
	
	@BeforeClass
	public void setUp() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(BrowserData.getpropertiesfilePath());
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", BrowserData.getbrowserpath());
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
			
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			Log.info("Driver is initialized");
		}
		else if(browserName.equals("Firefox"))
		{
			//write the geicko driver info
		}
		else
		{
			//write the IE driver info
		}
		wait = new WebDriverWait(driver, 40);
		fluentwait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(60))
	            .pollingEvery(Duration.ofMillis(500))
	            .ignoring(org.openqa.selenium.NoSuchElementException.class);
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
	  
	}
	
	
	@AfterTest
	  public  void deletecookies() {
		 
		 driver.manage().deleteAllCookies();
		 driver.quit();
		 Log.info("");
		 Log.info("*******************************END OF TEST CASE*************************************");
		 Log.info("");
		 extent.flush();
		 extent.close();
		
		  
	  }
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extlog.log(LogStatus.FAIL, "TEST CASE FAILED IS"+result.getName());//to add name to extent reports
			extlog.log(LogStatus.FAIL, "TEST CASE FAILED IS"+result.getThrowable());
			String Failscreenshotpath = CommonFunctions.failedscreenshot(driver, result.getName());
			extlog.log(LogStatus.FAIL, extlog.addScreenCapture(Failscreenshotpath));//Add screenshot in extent report
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extlog.log(LogStatus.SKIP, "TEST CASE SKIPPED IS"+result.getName());
			
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			
			extlog.log(LogStatus.PASS, "TEST CASE PASSED IS"+result.getName());
		}
		
		extent.endTest(extlog);//ending for each method
		
	}
	
		
		
		
		
	
	
	
	
    public void enter(String S , WebDriver driver , String Value) throws InterruptedException {
			
			  try {
				  
				
				 wait = new WebDriverWait(driver,40);
		         WebElement ele = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(S)));
		         CommonFunctions.scrolltocentre(ele, driver);
		         CommonFunctions.highlight(ele , driver);
		         Thread.sleep(1000);
		         
		         ele.sendKeys(Value);
		         }
		         catch(org.openqa.selenium.NoSuchElementException e) {
		 		    e.printStackTrace(); }
		         catch(org.openqa.selenium.ElementNotInteractableException |org.openqa.selenium.ElementNotSelectableException e) {
			      WebElement ele = driver.findElement(By.xpath(S));
				  CommonFunctions.javascriptclick(ele, driver); }
			  }
    
    public String getText(String S , WebDriver driver ) throws InterruptedException {
		
		  try {
			
			 wait = new WebDriverWait(driver, 40);
	         WebElement ele = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(S)));
	         CommonFunctions.scrolltocentre(ele, driver);
	         CommonFunctions.highlight(ele , driver);
	         Thread.sleep(1000);
	         return ele.getText();
	         }
	         catch(org.openqa.selenium.NoSuchElementException e) {
	        	 
	        	 return "Element not found";
	        	 
	         }
		  
		  catch(org.openqa.selenium.StaleElementReferenceException e) {
			  Thread.sleep(8000);
			  wait = new WebDriverWait(driver, 60);
		         WebElement ele = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(S)));
		         CommonFunctions.scrolltocentre(ele, driver);
		         CommonFunctions.highlight(ele , driver);
		         Thread.sleep(1000);
		         return ele.getText();
				
		  }
		  }
  
  public void sleep(int sleep) throws InterruptedException {
  	Thread.sleep(sleep*1000);
  }
  
  public void click(String S , WebDriver driver) throws InterruptedException {
		
	  try {
		  
		 wait = new WebDriverWait(driver, 40);
         WebElement ele = (WebElement)wait.until(ExpectedConditions.elementToBeClickable((By.xpath(S))));
         CommonFunctions.scrolltocentre(ele, driver);
         CommonFunctions.highlight(ele , driver);
         Thread.sleep(1000);
         ele.click();}
          catch(org.openqa.selenium.NoSuchElementException e) {
 		  e.printStackTrace(); }
      
	      catch(org.openqa.selenium.StaleElementReferenceException e) {
		 
	    	  int totalAttempts = 10;
              
                 while (totalAttempts > 0) { // loops forever until break
                       totalAttempts = totalAttempts-1;

	    		    try { // checks code for exceptions
	    		        WebElement ele= (WebElement)wait.until(ExpectedConditions.elementToBeClickable((By.xpath(S))));  
	    		        ele.click();
	    		        break; // if no exceptions breaks out of loop
	    		    } 
	    		    catch (org.openqa.selenium.StaleElementReferenceException e1) { 
	    		       Thread.sleep(3000);
	    		        continue; // continues to loop if exception is found
	    		    } }
	    	  
	    	   }    catch(org.openqa.selenium.WebDriverException e) {
	      WebElement ele = driver.findElement(By.xpath(S));
		  CommonFunctions.javascriptclick(ele, driver); }
	       
	  
	  }




}
