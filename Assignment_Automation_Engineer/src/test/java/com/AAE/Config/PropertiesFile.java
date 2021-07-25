/**
 * 
 */
package com.AAE.Config;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Raushan
 *
 */
public class PropertiesFile {
	
	Properties prop = new Properties();
	
	
	public PropertiesFile() throws Exception
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Raushan\\eclipse-workspace\\Assignment_Automation_Engineer\\src\\test\\java\\com\\AAE\\Config\\config.properties");
		prop.load(file);
		
	}
	public String dataExtract(String data) 
	{
		return prop.getProperty(data);
	}

	
	
}
