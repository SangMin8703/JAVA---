package io;
import java.io.*;

// 문자 출력 스트림에 버퍼의 기능을 사용하기 위한 
// BufferedWriter 클래스와 PrintWriter 클래스
// 문자열을 출력하는 경우 다양한 형태의 기능을 지원할 필요가 있습니다
// BufferedWriter 클래스의 경우 문자를 출력할 때, 버퍼를 사용하여
// 성능을 높일 수 있지만 write 메소드만 제공하는 클래스이기 때문에
// 기본 출력 객체인 System.out 과 같이 다양한 메소드를 제공할 수 없습니다.
// 이런 이유로 다양한 출력 메소드를 지원하는 PrintWriter 클래스와 조합되어
// 사용되는 것이 일반적입니다.

public class IO_19 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_char.txt";
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			// 1 byte 단위로 파일에 출력하는 스트림 객체 생성
			fos = new FileOutputStream(strFileName);
			// 1 byte 단위로 파일에 출력하는 스트림 객체를 문자 스트림으로 변환
			osw = new OutputStreamWriter(fos);
			// 출력 문자 스트림에 버퍼의 기능을 추가
			bw = new BufferedWriter(osw);
			// 다양한 출력 메소드를 제공하는 PrintWriter 타입의 객체를 생성
			// 일반적으로 생성자의 매개변수로는 BufferedWriter 타입이 사용됩니다. 
			//pw = new PrintWriter(bw);
			// PrintWriter 클래스의 객체를 생성할 때, 
			// 생성자의 매개변수로 boolean 타입의 AutoFlush 속성을 전달하면			
			// true 의 값이 전달된 경우, print 기능을 수행한 후 자동으로 flush 메소드를 호출
			// (기본값은 false)
			pw = new PrintWriter(bw, true);
						
			pw.println(48);
			pw.println(65);
			pw.println(97);
			
			System.in.read();
			
			pw.println('0');
			pw.println('A');
			pw.println('a');
			
			pw.println("Hello PrintWriter");
			
			pw.close();			
			
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}










