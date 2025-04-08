package io;
import java.io.*;
public class IO_08 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_buffer.txt";
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream(strFileName);
			// 1024 byte 의 버퍼를 사용하는 스트림 객체 생성
			bos = new BufferedOutputStream(fos, 1024);
			
			// 버퍼에 기록된 데이터는 3가지의 경우에
			// 실제 스트림을 통해 출력됩니다.
			// 1. flush 메소드를 호출하는 경우
			// 2. close 메소드가 호출되는 경우
			// 3. 버퍼 공간이 다 찼을경우
			
			bos.close();

		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}









