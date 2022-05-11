package com.project.testCases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.project.Utilities.ReadConfig;

public class BaseClassw {

	ReadConfig config=new ReadConfig();
	
	public String baseURL=config.getApplicationURL();
			public String username=config.getusername();
			public String password=config.getpassword();
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		log=Logger.getLogger("demoapp");
	    PropertyConfigurator.configure("log4j.properties");
		//configure("log4j.properties");
	    
	    if (br.equals("chrome"))
	    {
         System.setProperty("webdriver.chrome.driver",config.getchromepath());
		driver=new ChromeDriver();
	    }
	    else if (br.equals("gecko")){
	        System.setProperty("webdriver.gecko.driver",config.getgeckopath());
			driver=new FirefoxDriver();
	    	 }
	    else if (br.equals("edge"))
	    {
	        System.setProperty("webdriver.edge.driver",config.getEdgedriver());
	 driver=new EdgeDriver();
	    }
	    driver.get(baseURL);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	
	}
	
	public static void  getScreenshot(WebDriver driver,String screenshotName)throws IOException{
	//	String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
	File target =new File (System.getProperty("user.dir")+"/Screenshots/"+screenshotName+".png");
			FileUtils.copyFile(source, target);
}}
