package IntializeDrivers;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class PDFMapper {

	// String scenariopath;
		public static HashMap<Integer , String> mapper;
		public static WebDriver driver;

		public PDFMapper(HashMap<Integer, String> mapper, WebDriver driver )
		{
		//this.scenariopath= scenariopath;
		this.mapper=mapper;
		this.driver =driver;
			
		}
		
		public HashMap<Integer , String> PDFScreenshot(WebDriver driver,int i,String comment)
		{
			
			try {
				FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("user.dir"+"/Screenshots" + i + ".png"));
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}

			mapper.put(i, comment);
			return mapper;
			
		
		}

}
