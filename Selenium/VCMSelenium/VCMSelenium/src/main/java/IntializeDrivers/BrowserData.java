package IntializeDrivers;

import java.io.IOException;

public class BrowserData {
	
	public static String getbrowserpath() throws IOException {
	String current = new java.io.File( "." ).getCanonicalPath();
	String Browserpath = current+"\\Browsers\\chromedriver.exe";
	return Browserpath;
	
	}
	
	public static String getpropertiesfilePath() throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
		String propertiesfilePath = current + "\\src\\main\\resources\\data.properties";
		return propertiesfilePath;
			
		}
	
	 public static String getFailedtestcasesPath() throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
		String FailedSSpath = current + "\\Screenshots\\FailedTCscreenshot";
		return FailedSSpath;
			
		}

	
}
