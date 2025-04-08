package io;
import java.io.*;
public class IO_24 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_object.txt";
		try {
			// 객체의 입출력 스트림에 버퍼의 기능을 사용하는 방법
		
			// 입력 스트림 생성
			// 파일에서 데이터를 입력받기 위한 바이트 스트림 객체 생성
			FileInputStream fis = new FileInputStream(strFileName);
			// 파일에서 데이터를 입력받기 위한 바이트 스트림 객체에 버퍼의 기능을 추가
			BufferedInputStream bis = new BufferedInputStream(fis);
			// 버퍼의 기능이 추가된 파일 바이트 스트림 객체에 객체를 입력받을 수 있는 기능을 추가
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			// 일반적으로 선언하는 ObjectInputStream 객체의 생성 방법			
			/*
			ObjectInputStream ois = 
				new ObjectInputStream(			
					new BufferedInputStream(
							new FileInputStream(strFileName)));
			*/
			
			// 출력 스트림 생성
			// 파일에서 데이터를 입력받기 위한 바이트 스트림 객체 생성
			FileOutputStream fos = new FileOutputStream(strFileName);
			// 파일에 데이터를 출력하기 위한 바이트 스트림 객체에 버퍼의 기능을 추가
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			// 버퍼의 기능이 추가된 파일 바이트 스트림 객체에 객체를 출력할 수 있는 기능을 추가
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			/*
			ObjectOutputStream oos = 
				new ObjectOutputStream(			
					new BufferedOutputStream(
							new FileOutputStream(strFileName)));
			*/
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}







