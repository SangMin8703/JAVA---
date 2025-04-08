package io;
import java.io.*;
public class IO_09 {
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
			
			input = bis.read();
			System.out.printf("input -> %d, %c\n", input, input);
			input = bis.read();
			System.out.printf("input -> %d, %c\n", input, input);
			input = bis.read();
			System.out.printf("input -> %d, %c\n", input, input);
			
			bis.close();			
		} catch( IOException e ) {
			e.printStackTrace();
		}

	}
}








