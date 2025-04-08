package io;
import java.io.*;
public class IO_10 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_buffer.txt";
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		int input;
		try {
			// 파일로부터 데이터를 입력받을 수 있는 바이트스트림 객체 생성
			fis = new FileInputStream(strFileName);
			// 파일로부터 데이터를 입력받을 수 있는 바이트스트림 객체에 버퍼의 기능을 추가
			bis = new BufferedInputStream(fis);
			
			// 파일의 데이터를 입력받는 경우
			// 파일의 끝을 확인할 수 있어야 합니다.
			// (파일의 끝 : 더이상 읽을 데이터가 없는 경우)
			// InputStream 클래스의 read 메소드는
			// 더이상 읽을 데이터가 없는 경우(버퍼가 비어있는 경우)
			// -1 값을 반환합니다.
			// (-1 이 아니라면 데이터가 존재한다는 의미입니다.)
			while( (input = bis.read()) != -1 )
				System.out.printf("input -> %d, %c\n", input, input);
			
			bis.close();			
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}


