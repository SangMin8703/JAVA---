package io;
import java.io.*;
// 문자 스트림
// 바이트 스트림은 1 byte 단위로 입출력을 수행하는 스트림이기 때문에
// 2 byte 의 문자체계를 지원하는 Java 에서는 문자을 입출력할 수 없습니다.
// Java의 문자 스트림은 단독으로 스트림을 생성할 수 있지만
// 바이트 스트림으로부터 문자 스트림을 생성할 수 도 있습니다.

// 바이트 스트림을 문자 스트림으로 변환하기 위해 사용되는 클래스
// InputStreamReader(입력 바이트스트림을 입력 문자스트림으로 변환), 
// OutputStreamWriter(출력 바이트스트림을 출력 문자스트림으로 변환)
public class IO_13 {
	public static void main(String[] args) {		
		// 키보드 입력을 사용하여 문자를 입력받는 예제
		int input = 0;
		
		try {
			System.out.print("문자를 입력하세요 : ");
			
			// System.in 객체는 InputStream 클래스의 객체이기 때문에
			// 키보드에 입력된 문자의 데이터를 1 byte 만 읽어옵니다.
			// 이런 경우 한글과 같이 2 byte 저장되는 문자는 올바로 잃어올 수 없습니다.
			// input = System.in.read();
			
			// 1 byte 단위로 입력을 수행하는 System.in 객체를
			// 2 byte 단위로 입력을 수행하도록 변환
			// (바이트 스트림을 문자 스트림으로 변환)
			InputStreamReader isr = new InputStreamReader(System.in);
			// InputStreamReader 는 문자스트림이기 때문에
			// 키보드로부터 2 byte 단위로 입력을 수행합니다.
			input = isr.read();
			
			System.out.printf("입력된 문자 : %c\n", input);
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}













