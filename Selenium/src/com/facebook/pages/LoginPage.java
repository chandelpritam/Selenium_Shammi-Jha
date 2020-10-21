package com.facebook.pages;

import com.facebook.genericPage.MasterPage;

public class LoginPage extends MasterPage {
	public LoginPage() throws Exception {
		super();
	}

	// Click Email or Phone
	public void clickEmailorPhone() {
		click("EmailOrPhone");
	}

	// Enter Username
	public void enterUsername() {
		sendData("EmailOrPhone", "abc@gmail.com");
	}

	// Click Password
	public void clickPassword() {
		click("Password");
	}

	// Enter Password
	public void enterPassword() {
		sendData("Password", "12345");
	}

	public void signUp() {
		System.out.println("This is sign up methode");
	}
}
