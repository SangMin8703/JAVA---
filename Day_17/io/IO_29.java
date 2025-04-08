package io;
import java.io.*;
public class IO_29 {
	public static void main(String[] args) {
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_serializable.txt";

		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(strFileName)));
			
			IO_28_Model model = (IO_28_Model)ois.readObject();
			model.printMembers();
			
			ois.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}








