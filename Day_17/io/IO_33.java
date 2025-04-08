package io;
import java.io.*;
import java.util.*;
public class IO_33 {
	public static void main(String[] args) {
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_collection.txt";

		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(strFileName)));
			
			ArrayList<Integer> list = (ArrayList<Integer>)ois.readObject();

			for( int i = 0 ; i < list.size() ; i++ )
				System.out.printf("list[%d] = %d\n", i, list.get(i));
			
			ois.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}








