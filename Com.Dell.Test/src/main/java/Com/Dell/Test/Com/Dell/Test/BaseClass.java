package Com.Dell.Test.Com.Dell.Test;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utility.ConfigProperties;

public class BaseClass 
{
	
	ConfigProperties Rconfig= new ConfigProperties();
	
    public String baseUrl=Rconfig.getpageurl();
    public String Username=Rconfig.getusername();
    public String password=Rconfig.getpassword();
    public static WebDriver driver;
	public static Logger logger ;
	
	
    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
    	
    	if(br.equalsIgnoreCase("chrome"))
    	{
    	System.setProperty("webdriver.chromedrivr.driver",Rconfig.getchromepath());
   	    driver= new ChromeDriver();
    	}
    	else if
    	(br.equalsIgnoreCase("ie")) {
    		System.setProperty("webdriver.ie.driver",Rconfig.iepath());
       	    driver= new InternetExplorerDriver();
    		}
    	//driver.get(baseUrl);
   	    
   	    
   
   	   
    }
	
	@AfterClass
	public void tear() {
		
		driver.quit();
		
	}
	public void capturescreenshot(WebDriver driver, String tname) throws IOException{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("Com.Dell.Test/Screenshots")+"Screenshot"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
	}
	
	
}
