package com.project.Utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
public ReadConfig() {
		
		File src=new File ("./Configuration//Config.txt");
		try {
			FileReader obj=new FileReader(src);
			pro=new Properties();
			pro.load(obj);
		}
		catch(Exception e) {
			
			System.out.println("Exception is "+e.getMessage());
		}}
		
	public String getApplicationURL() {
		
		String url=pro.getProperty("baseURL");
			return url;
			}
	
	public String getusername() {
		
		String username=pro.getProperty("username");
		return username;
		
	}
		
	public String getpassword() {
		
		String password =pro.getProperty("password");
		return password;
		
	} 
	
	public String getchromepath() {
		
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
public String getgeckopath() {
		
		String geckopath=pro.getProperty("geckopath");
		return geckopath;
	}
public String getEdgedriver() {
	
	String Edgedriver=pro.getProperty("Edgedriver");
	return Edgedriver;
}
	
}
