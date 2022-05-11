package com.project.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Utilities.XLUtils;
import com.project.pageObjects.LoginPage;

public class Tc_002 extends BaseClassw{
		
@Test(dataProvider="LoginData")
public void  loginDDT(String username,String password) throws IOException, InterruptedException
{
	{
		LoginPage login=new LoginPage(driver);
		
		//test=extent.createTest("TestCase002");
		log.info("URL is opened");
		login.setusername(username);
		log.info("Username is Entered");
		login.setpassword(password);
		log.info("Password is entered");
		login.clickbutton();
		log.info("Button is clicked");
		Thread.sleep(3000);
		
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
			
			Assert.assertTrue(true);
			log.info("test is passed");
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
			driver.switchTo().defaultContent();
		}
			
			else
			{
			getScreenshot(driver,"loginDDT");
			Thread.sleep(2000);
			driver.navigate().refresh();
			   log.info("test is failed");
				Assert.assertTrue(false);
			
		}
		
	}
}

@DataProvider(name="LoginData")
String [][] getData() throws IOException{
	 String path=System.getProperty("user.dir")+"/src/test/java/com/project/testData/LoginData.xlsx";

//String path=C:\Users\chitr\eclipse-workspace\InetBankingProject\src\test\java\com\inetbanking\testData\LoginData.xlsx

	 int rownum=XLUtils.getRowCount(path, "Sheet1");
	 int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	 String logindata[][]=new String[rownum][colcount];
	 
	for ( int i=1;i<=rownum;i++)
	{
		for (int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
		}
	}
	 return logindata;
	
}
}
