package io;

import java.io.*;

// 버퍼
// 임시기억 저장공간
// 하드웨어 사이의 속도 차이를 완화시켜주기 위한 목적으로 사용되는 메모리 공간

// 버퍼 기능을 제공하는 바이트스트림 클래스
// BufferedInputStream, BufferedOutputStream
// 위의 클래스들은 기존의 바이트스트림에 버퍼의 기능을 추가할 수 있는 클래스
// 버퍼 기능을 제공하는 스트림은 단독으로 사용되지 않습니다.
// (다른 스트림 객체를 서포트하는 역할)
public class IO_07 {
	public static void main(String[] args) {		
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_buffer.txt";
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// 파일에 출력할 수 있는 스트림 객체의 생성
			fos = new FileOutputStream(strFileName);
			// 파일에 출력할 수 있는 스트림 객체에 버퍼의 기능을 추가
			// BufferedOutputStream 클래스의 생성자는 
			// 바이트스트림 타입의 객체를 매개변수로 사용합니다.
			// 아래의 생성자는 FileOutputStream 스트림 객체를 생성자에 전달하여
			// 파일에 출력할 때, 버퍼를 사용하여 출력합니다.
			bos = new BufferedOutputStream(fos);
			
			// BufferedOutputStream 클래스의 write 메소드
			// 실제 출력 대상에 출력하는 것이 아닌
			// 버퍼에 기록을 하는 기능을 수행하는 메소드
			// 버퍼에 기록된 데이터는 flush, close 메소드가 호출되면
			// 실제 출력 대상에게 출력됩니다.
			bos.write(48);
			// BufferedOutputStream 클래스의 flush 메소드
			// 버퍼를 비우는 메소드
			// 버퍼를 비우면서 실제 출력 대상에 데이터를 출력하는 기능을 수행
			// 아래의 flush는 현재 버퍼에 있는 48 을 값을 파일에 출력
			bos.flush();
			
			bos.write(65);
			bos.write(97);
			
			System.in.read();
			
			// 스트림이 중첩되어서 사용되는 경우
			// 외부의 스트림을 종료하면 내부의 스트림도 종료됩니다.
			// BufferedOutputStream 클래스의 close 메소드는
			// 스트림을 종료하면서 버퍼에 남아있는 데이터를 출력하는 기능을 
			// 추가적으로 수행합니다.
			bos.close();
			
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}














