package io;
import java.io.*;
import java.util.*;
public class IO_35 {
	public static void main(String[] args) {
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_points.txt";

		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(strFileName)));
			
			ArrayList<Point> list = (ArrayList<Point>)ois.readObject();

			for( int i = 0 ; i < list.size() ; i++ )
				list.get(i).print();
			
			ois.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}








