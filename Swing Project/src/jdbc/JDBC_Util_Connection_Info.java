package jdbc;

import java.io.*;
import java.util.*;
public class JDBC_Util_Connection_Info {

	private File file;
	private Properties propertie;
	
	public JDBC_Util_Connection_Info(String fileName) {
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








