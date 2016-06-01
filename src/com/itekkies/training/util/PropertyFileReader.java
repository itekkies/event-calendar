package com.itekkies.training.util;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader {

	private static Map allProperties = null;
	private static String DEFAULT_PROPERTY_FILE = "config.properties";
	
	public static String getProperty(String fname, String pname) {
		if(allProperties == null) {
			System.out.println("all Properties is null, creating one");
			allProperties = new HashMap();
		}
		if(!allProperties.containsKey(fname)) {
			System.out.println("Property file not yet read, " + fname + " reading");
			Properties props = new Properties();
			InputStream fis = null;
			try {
				fis = PropertyFileReader.class.getClassLoader().getResourceAsStream(fname);
				props.load(fis);
				allProperties.put(fname, props);
			}
			catch(FileNotFoundException fne) {
				fne.printStackTrace();
			}
			catch(IOException io) {
				io.printStackTrace();
			}
			finally {
				try {
					fis.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		
		return ((Properties)allProperties.get(fname)).getProperty(pname);
	}
	
	public static String getProperty(String pname) {
		
		return getProperty(DEFAULT_PROPERTY_FILE, pname);
	}
}
