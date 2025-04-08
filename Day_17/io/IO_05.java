package io;
import java.io.*;

// 바이트 단위 출력 스트림
// - OutputStream 클래스
// - 일반적으로 OutputStream 클래스의 하위 클래스를 사용하여
//   출력 기능을 구현
// - FileOutputStream(파일 출력), ObjectOutputStream(객체 출력)
//   BufferedOutputStream(단독으로 사용되지 않고, 다른 스트림의 보조역할로 사용)
public class IO_05 {
	public static void main(String[] args) {	
		String strFileName = "C:\\work\\sources\\java\\Day_17\\output.txt";
		
		// try ~ catch 구문이 종료되면 자동으로 fos.close 메소드 호출을 위해 사용
		try(FileOutputStream fos = new FileOutputStream(strFileName)) {
			
			// output.txt 파일에 3 byte를 출력하는 예제
			fos.write(48);
			fos.write(65);
			fos.write(97);
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
