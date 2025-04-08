package io;
import java.io.*;
import java.util.*;

// 다수개의 객체를 입출력하는 방법
// 컬렉션 클래스를 사용한 다수개의 객체 입출력
// 컬렉션 클래스는 자체적으로 직렬화를 구현하고 있는 클래스입니다.
// (직렬화를 구현하고 있기 때문에 컬렉션 객체는 외부로 출력될 수 있습니다.)
// 컬렉션 클래스의 객체가 출력될 때, 해당 컬렉션 객체가 저장하고 있는 데이터도 같이 출력됩니다.
// 이때, 컬렉션 객체가 저장하고 있는 데이터(객체)가 직렬화를 구현하고 있다면
// 문제없이 출력될 수 있습니다.

public class IO_32 {
	public static void main(String[] args) {		
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_collection.txt";
		
		ArrayList<Integer> list = new ArrayList<>();
		for( int i = 1 ; i <= 100000 ; i++ )
			list.add(i);
		
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

















