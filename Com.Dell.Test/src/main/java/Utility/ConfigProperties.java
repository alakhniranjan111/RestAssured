package Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigProperties {
	
	Properties pro;
	
	
	public ConfigProperties() {
		
		File src= new File("./Configurations/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			}
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		}
	
	public String getpageurl() {
		String baseurl=pro.getProperty("baseUrl");
		return baseurl;
	}
	
	public String getusername() {
		String username=pro.getProperty("Username");
		return username;
	}
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public String getchromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String iepath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

}
