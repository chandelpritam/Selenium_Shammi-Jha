package LoginTest;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import IntializeDrivers.Methoddatastoreimpl;
import IntializeDrivers.PDFMapper;
import IntializeDrivers.PDFUtility;
import IntializeDrivers.TestNgAnnotations;
import Pages.Loginpage;

public class successlogin extends TestNgAnnotations {
	
	public static PDFMapper Pd;
	public static HashMap<Integer,String> mapper;
	public Methoddatastoreimpl md;
	public String path = "C:\\Users\\DELL\\Documents\\Datasheet.xlsx";
	
	@Test(description ="Launch salesforce website", priority =1)
	public void OpenApplication() throws InterruptedException
	{
		extlog= extent.startTest("OpenApplication");
		driver.get("https://vcm--cog1.cs93.my.salesforce.com");
		sleep(5);
		Log.info("Salesforce Application is opening");
		
	}
	
	@Test(description ="Enter login details", priority =2)
	public void enterdetails() throws Exception
	{
		extlog= extent.startTest("enterdetails");
		int i=0;
		Loginpage Lpage= new Loginpage();
		mapper = new HashMap<Integer,String>();
		Pd = new PDFMapper(mapper,driver);
		md= new Methoddatastoreimpl("Login","enterdetails",path);
		Lpage.EnterUsername(md.getvalue("Username1"));
		Pd.PDFScreenshot(driver, i++, "entering login page");
		Log.info("Entering username");
		Lpage.Enterpassword(md.getvalue("Password1"));
		//Assert.fail();
		//Assert.fail("Failing intentionally");
		Lpage.clickLogin();
		Pd.PDFScreenshot(driver, i++, "entering login page");
		Log.info("User successfully login to salesforce application with username and password");
		PDFUtility.addImagetoPDF(mapper, i, "enterdetails");
	}

}
