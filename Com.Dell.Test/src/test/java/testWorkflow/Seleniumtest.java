package testWorkflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Seleniumtest {
	
	
	@Test
	public void test() {
		
		
		System.setProperty("webdriver.driver.chrome","Com.Dell.Test/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
				
				driver.get("www.google.com");
	}

}
