package com.project.Utilities;
//listner class
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter{
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest logger;

public void onStart(ITestContext testcontext)
{
	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp 
	String repName="Test-Report-"+timeStamp+".html";
	htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name", "localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("user", "chitra");
	
	htmlReporter.config().setDocumentTitle("TestProject");//Tile of Report
	htmlReporter.config().setReportName("Functional test Report");//Name of the project
	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);// location of the chart
	htmlReporter.config().setTheme(Theme.DARK);
	}
public void onTestSuccess(ITestResult tr)
{
	logger=extent.createTest(tr.getName()); //create new entry in the Report
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//Send the passed information
}
public void onTestFailure(ITestResult tr)
{
	logger=extent.createTest(tr.getName()); //create new entry in the Report
logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));//Send the passed information
//String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";

File f= new File(screenshotpath);
if (f.exists()) {
	try {
		logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
	}
catch(IOException e)
	{
	e.printStackTrace();
	}
}

}
	
public void onTestSkipped(ITestResult tr)
{
	logger=extent.createTest(tr.getName()); //create new entry in the Report
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));//Send the passed information
}
	
public void onFinish(ITestContext testContext)
{
	
extent.flush();
}

	
}


