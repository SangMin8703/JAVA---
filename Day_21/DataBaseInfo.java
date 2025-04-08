package database;

import java.io.*;
import java.util.*;
public class DataBaseInfo {

	private File file;
	private Properties propertie;
	
	public DataBaseInfo(String fileName) {
		file = new File(fileName);
		
		propertie = new Properties();
		
		try {
			this.propertie.load(
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(file), "UTF8")));
		} catch (IOException e) {
			propertie = null;
		}
	}
	public String readProperties(String key) {
		if( propertie == null )
			return "";
		
		return propertie.getProperty(key);
	}
}








