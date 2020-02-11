package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testcontext)
	{
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user-dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user-dir")+"Extent-config.xml");
		 
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Enviornment","QA");
		
		htmlReporter.config().setDocumentTitle("Test project");
		htmlReporter.config().setReportName("functional report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
		public void onTestsuccess(ITestResult tr)
		{
			logger=extent.createTest(tr.getName());
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public void onTestfailure(ITestResult tr)
		{
			logger=extent.createTest(tr.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenshotpath);
		
		if(f.exists())
		{
			try {
				 logger.fail((Markup) logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		}
		
		public void onfinish(ITestContext testContext) {
			
			extent.flush();
			
		}
	}


