package Utilityclases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {
	public static String fetchProperty(String key) throws Exception{ 
    
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("./Properties/loginCred.properties");
		p.load(fis);
		
	String data=p.getProperty(key);
	
	return data;
	}
	public static void main(String[] args) throws Exception {
		fetchProperty("url");
	}
}
