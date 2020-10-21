package Pages;


import IntializeDrivers.TestNgAnnotations;

public class Loginpage extends TestNgAnnotations {
	
	public String username= "//input[@id='username']";
	public String password = "//input[@id='password']";
	public String Login = "//input[@id='Login']";
	
	public void EnterUsername(String Value) throws InterruptedException
	{
		Log.info("username finding");
		enter(username, driver, Value);
		
		
		
	}
	
	public void Enterpassword(String Value) throws InterruptedException
	{
		enter(password, driver, Value);
	}
	
	public void clickLogin() throws InterruptedException
	{
		click(Login, driver);
	}

}
