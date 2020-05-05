package testWorkflow;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Dell.Test.Com.Dell.Test.BaseClass;
import Com.Dell.Test.Com.Dell.Test.Log4jPage;
import Com.Dell.Test.Com.Dell.Test.LoginBasepage;


public class Loginpage extends BaseClass {
	
	@Test
	public void logintest() throws IOException {
		
		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginBasepage lbpage=new LoginBasepage(driver);
		
		lbpage.clickSignin();
		lbpage.setUsername(Username);
		lbpage.setPwd(password);
		lbpage.clickSubmit();
	     
		
		if(driver.getTitle().equals("Book My Furniture - QA(2.3.2)-Final"))
		{
			Assert.assertTrue(true);
			capturescreenshot(driver,"logintest");
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	}


