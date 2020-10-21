package com.facebook.tests;

import org.testng.annotations.Test;

import com.facebook.ScreenShotOnFailure.ScreenShotOnFailure;
import com.facebook.pages.LoginPage;

public class LogInTest extends ScreenShotOnFailure {

	@Test
	public void doLogInTest() throws Exception {
		LoginPage lp = new LoginPage();
		lp.clickEmailorPhone();
		lp.enterUsername();
		lp.clickPassword();
		lp.enterPassword();
	}

}
