package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class will read data from property file and return value to user
 * @author Dell
 *
 */

public class PropertyFileUtility {
	/**
	 * this method will read data from property file for the key given by user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pLib = new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
				
	}
	
}
