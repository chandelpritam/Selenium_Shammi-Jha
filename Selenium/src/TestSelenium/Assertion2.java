package TestSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion2 {
	@Test
	public void testCase2() {
		int a = 10;
		int b = 20;

		String expectedTitle = "Google";
		String actualTitle = "Google";

		Assert.assertEquals(actualTitle, expectedTitle, "Actaul and Expected are not equal");
		System.out.println("Assertion Pass");

		Assert.assertFalse(a > b, "assertFalse condition get failed");
		System.out.println("Balle Balle");

		Assert.assertTrue(a > b, "assertTrue conditionget passed");
		System.out.println("Balle Balle");

		// As assert fails execution will stop here
		// Further line of code will not execute
		System.out.println("We are checking assertion");
	}
}
