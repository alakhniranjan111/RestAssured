package Com.Dell.Test.Com.Dell.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




/**
 * Unit test for simple App.
 */

public class AppTest 
{
	
	@Test
	public void test() throws InterruptedException {
		
		System.setProperty("webdriver.chromedrivr.driver","C:/Users/Alakh_niranjan_Kumar/Pictures/Selenium/chromedriver.exe");
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@name='btnK']")).click();
		Thread.sleep(2000);
		
		driver.close();
		
		
	}

	
	
}