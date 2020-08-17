package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public TestBase() {
		try{
			 prop = new Properties();
			 FileInputStream ip = new FileInputStream(new File("D:/Lendingkart/personal/Personal/org.com.rupeekapitest/src/main/java/com/qa/config/config.properties"));
			 prop.load(ip);
			System.out.println(prop.get("URL"));			
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	
		
	}

}
