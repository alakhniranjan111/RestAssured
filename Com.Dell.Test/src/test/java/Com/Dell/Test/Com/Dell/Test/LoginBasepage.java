package Com.Dell.Test.Com.Dell.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBasepage {
	
	WebDriver ldriver;
	
	public LoginBasepage(WebDriver rdriver){
		
		ldriver=rdriver ;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/form/button[4]/span")
	WebElement txtSignIn ;
	
	@FindBy(xpath="//*[@id=\"emailId\"]")
	WebElement txtUsername ;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement txtPassword ;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement txtSubmit ;
	
	
	public void clickSignin() {
		
		txtSignIn.click();
	}
    public void setUsername(String uname) {
		
		txtUsername.sendKeys(uname);
	}
    public void setPwd(String Password) {
		
		txtPassword.sendKeys(Password);
	}
    public void clickSubmit() {
		
		txtSubmit.click();
	}
	
}
