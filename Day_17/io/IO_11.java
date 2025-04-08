package io;
import java.io.*;

public class IO_11 {
	public static void main(String[] args) {
		String strSrcFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10.java";
		String strDescFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10_Copy.java";
		
		// IO_10.java 파일을 복사하여
		// IO_10_Copy.java 파일을 생성하세요.
		int input;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {			
			// IO_10.java 파일을 읽어오기 위한 입력 스트림 객체 생성
			fis = new FileInputStream(strSrcFileName);
			bis = new BufferedInputStream(fis);		
			// IO_10_Copy.java 파일에 출력하기 위한 출력 스트림 객체 생성
			// FileOutputStream 클래스의 객체를 생성하면서
			// append 매개변수를 사용하는 생성자를 사용할 수 있습니다.
			// append 매개변수를 true 로 지정하면 기존의 파일 내용뒤에
			// 데이터를 추가할 수 있습니다.
			// append 매개변수의 값을 false 지정하거나, append 를 사용하지 않는
			// 생성를 통해 객체를 생성하면, 기존의 파일은 내용을 삭제되고 새롭게 기록됩니다.			
			fos = new FileOutputStream(strDescFileName, true);			
			bos = new BufferedOutputStream(fos);
			
			while( (input = bis.read()) != -1 )
				bos.write(input);
			
			bis.close();		
			bos.close();
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}






