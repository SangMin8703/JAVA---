package io;
import java.io.*;

public class IO_12 {
	public static void main(String[] args) {
		String strSrcFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10.java";
		String strDescFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10_Copy.java";
		
		// IO_10.java 파일을 복사하여
		// IO_10_Copy.java 파일을 생성하세요.
		int size;
		// 파일의 내용을 읽어봐 저장할 배열의 생성
		// 1024 byte를 읽어오기 위한 배열
		byte [] input = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {			
			// IO_10.java 파일을 읽어오기 위한 입력 스트림 객체 생성
			fis = new FileInputStream(strSrcFileName);
			bis = new BufferedInputStream(fis);		
			// IO_10_Copy.java 파일에 출력하기 위한 출력 스트림 객체 생성 			
			fos = new FileOutputStream(strDescFileName);			
			bos = new BufferedOutputStream(fos);
			
			// 파일의 내용을 배열에 읽어와 출력하는 코드
			while( (size = bis.read(input)) != -1 )
				bos.write(input);
			
			bis.close();		
			bos.close();
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}






