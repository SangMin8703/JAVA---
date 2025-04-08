package io;
import java.io.*;

// 문자 스트림에서의 버퍼 기능 제공 클래스
// BufferedReader : 문자 스트림의 입력에 버퍼의 기능을 추가
// BufferedWriter : 문자 스트림의 출력에 버퍼의 기능을 추가
// 문자 스트림에 버퍼의 기능을 추가하면
// 문자열의 단위로 입출력을 수행할 수 있습니다.
// (String 타입의 데이터를 입출력할 수 있습니다.
public class IO_15 {
	public static void main(String[] args) {		
		// 키보드에 입력된 내용을 문자열로 입력받는 예제
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			// 키보드 입력을 문자로 처리할 수 있는 스트림 객체 생성
			isr = new InputStreamReader(System.in);
			// 키보드 입력을 문자로 처리할 수 있는 스트림 객체에 버퍼의 기능을 추가
			br = new BufferedReader(isr);
			
			System.out.print("문자열을 입력 : ");
			// BufferedReader 클래스의 readLine 메소드는
			// 버퍼 내부에 있는 데이터를 개행문자(엔터키)를 만나기 전까지
			// 읽어들여 String 타입으로 반환하는 메소드
			// 리턴되는 타입은 String
			String msg = br.readLine();
			System.out.printf("입력된 문자열은 '%s' 입니다.\n", msg);			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}











