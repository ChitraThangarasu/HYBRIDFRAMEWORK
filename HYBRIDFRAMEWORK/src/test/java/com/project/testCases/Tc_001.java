package com.project.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
	
import com.project.pageObjects.LoginPage;

public class Tc_001 extends BaseClassw {
		
@Test
public void loginTest() throws IOException
{
	log.info("URL is opened");
	LoginPage login=new LoginPage(driver);
	login.setusername(username);
	log.info("Username is Entered");
	login.setpassword(password);
	log.info("Password is entered");
	login.clickbutton();
	log.info("Button is clicked");
	System.out.println(driver.getTitle());
	if(driver.getTitle().equals("Swag Labs")) {
		
		Assert.assertTrue(true);
		log.info("Assertiontrue");
}
		else
		{
			getScreenshot(driver, "loginTest");
			log.info("test is failed");
			Assert.assertTrue(false);
		
	}
}

}
