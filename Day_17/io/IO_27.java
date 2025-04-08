package io;
import java.io.*;
public class IO_27 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_object_custom.txt";

		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(strFileName)));
			
			IO_26_Model model = (IO_26_Model)ois.readObject();
			System.out.printf("model.num = %d\n", model.num);
			
			ois.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}








