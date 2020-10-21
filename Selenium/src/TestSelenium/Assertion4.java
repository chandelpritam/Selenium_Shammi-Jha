package TestSelenium;

import org.junit.Assert;
import org.testng.annotations.Test;

public class Assertion4 {
	@Test
	public void a() {
		int i = 30;
		int j = 30;

		try {
			Assert.assertTrue(i > j);
		} catch (AssertionError a) {
			System.out.println(a);
		}

		System.out.println("Assertion Fail");

		if (i == j) {
			System.out.println("TestCase is passed");
		} else {
			System.err.println("TestCase is failed");
		}
	}
}
