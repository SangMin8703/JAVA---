package io;
import java.io.*;
public class IO_31 {
	public static void main(String[] args) {
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_externalizable.txt";

		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(strFileName)));
			
			IO_30_Model model = (IO_30_Model)ois.readObject();
			model.printMembers();
			
			ois.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}








