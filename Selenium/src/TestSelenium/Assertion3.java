package TestSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion3 {
	@Test
	public void testCase1() {

		String expectedTitle = "Gooogle";
		String actualTitle = "Google";

		try {
			Assert.assertEquals(actualTitle, expectedTitle, "Actaul and Expected are not equal");
		} catch (AssertionError a) {
			a.printStackTrace();
		}
		System.out.println("We are checking assertion");
	}

}
