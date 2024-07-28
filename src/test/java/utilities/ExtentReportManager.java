package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import scala.annotation.newMain;

public class ExtentReportManager implements ITestListener{
	
	public ExtentReports extent;
	public ExtentSparkReporter sparkrepoter;
	public ExtentTest test ;
	String report;
	
		public void onStart(ITestContext textcontext) {
			
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			report = "Test-Report"+timestamp+".html";
			
			
			sparkrepoter = new ExtentSparkReporter(".\\reports\\"+report);
			extent = new ExtentReports();
			
			sparkrepoter.config().setDocumentTitle("Spotify");
			sparkrepoter.config().setReportName("apis");
			sparkrepoter.config().setTheme(Theme.DARK);
			
			
			extent.attachReporter(sparkrepoter);
			extent.setSystemInfo("Environemt name","QA");
		
		
			
			
		}
		 public void onTestSuccess(ITestResult result) {
			 
			 ExtentTest test = extent.createTest(result.getName());
			 test.assignCategory(result.getMethod().getGroups());
			 test.createNode(result.getName());
			 test.log(Status.PASS,"Test Susceed");
			 
		}
		 
		  public void onTestFailure(ITestResult result) {
			  
			  ExtentTest test = extent.createTest(result.getName());
			  test.createNode(result.getName());
			  test.log(Status.FAIL,"Test Failed");
			  test.log(Status.FAIL,result.getThrowable().getMessage());
		   
		}

		
		  public void onTestSkipped(ITestResult result) {
			  
			  ExtentTest test = extent.createTest(result.getName());
			  test.createNode(null);
			  test.log(Status.SKIP,"Test Skipped");
			  test.log(Status.SKIP,result.getThrowable().getMessage());
	
		 }
	
	
	
		public void onFinish(ITestContext context) {
			
			extent.flush();
		    
		 }

}
