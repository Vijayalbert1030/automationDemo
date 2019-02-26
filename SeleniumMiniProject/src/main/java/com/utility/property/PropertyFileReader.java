package com.utility.property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyFileReader {
	

	  Properties props = null;
	  String path = System.getProperty("user.dir") +System.getProperty("file.separator") + "application.properties";

	  /**
	   * Class constructor
	   */
	  public PropertyFileReader() {
		try 
		(FileInputStream fis = new FileInputStream(path);)
		{
		  
		  props = new Properties();
		  props.load(fis);
		  fis.close();
		}  catch (Exception exception) {
			System.out.println(exception.getMessage());
			}
	  }

	  /**
	   * Method is used to get value of the key from application.properties file
	   *
	   * @param key - key name
	   * @return value
	   */
	  public String getValue(String key) {

		String value = props.getProperty(key);
		if (null != value) {
		  return value;
		} else {
		  return null;
		}
	  }

	  /**
	   * Method is used to set key and values in the application.properties file
	   *
	   * @param key - key name
	   * @param value - key value
	   */
	  public void setValue(String key, String value) {

		try {

		  props.setProperty(key, value);
		  props.store(new FileOutputStream(path), null);

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} 

	  }

	  /**
	   * Method is used to remove key and value from application.properties file
	   *
	   * @param keyName - key name
	   */
	  public void removeKey(String keyName) {
		props.remove(keyName);

	  }

	}
