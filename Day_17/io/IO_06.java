package io;
import java.io.*;
public class IO_06 {
	public static void main(String[] args) {
		String strFileName = "C:\\work\\sources\\java\\Day_17\\output.txt";
		int input;
		int size = 0;
		byte [] buffer = new byte[100];
		
		try {
			// File 로부터 1 byte 단위로 읽을 수 있는 스트림의 생성
			FileInputStream fis = new FileInputStream(strFileName);			
			/*
			// 파일에서 1 byte 씩 읽어서 처리하는 방법
			input = fis.read();
			System.out.printf("input = %d( %c )\n", input, input);
			input = fis.read();
			System.out.printf("input = %d( %c )\n", input, input);
			input = fis.read();
			System.out.printf("input = %d( %c )\n", input, input);
			*/
			
			// 파일의 내용을 배열의 크기만큼 읽어서 처리하는 방법
			size = fis.read(buffer);
			for( int i = 0 ; i < size ; i++ )
				System.out.printf("%d( %c )\n", buffer[i], buffer[i]);
			
			fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}





