package io;
import java.io.*;
import java.util.*;

public class IO_34 {
	public static void main(String[] args) {		
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_points.txt";
		
		Random random = new Random();
		ArrayList<Point> list = new ArrayList<>();
		for( int i = 1 ; i <= 1000000 ; i++ )
			list.add(new Point(random.nextInt(i+500), random.nextInt(i+500)));
		
		for( int i = 0 ; i < list.size() ; i++ )
			list.get(i).print();
		
		ObjectOutputStream oos;
		try {			
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(strFileName)));
			
			// 컬렉션 클래스의 객체는 객체 입출력이 가능합니다.
			// 이때 해당 컬렉션 클래스의 내부 데이터(객체)들도 같이 입출력됩니다.
			// (내부의 데이터가 직렬화를 구현하고 있는 경우만 에러없이 실행)
			oos.writeObject(list);
			oos.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

















