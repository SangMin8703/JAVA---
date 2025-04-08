package io;
import java.io.*;
public class IO_20 {
	public static void main(String[] args) {
		// 파일을 대상으로 입력/출력하기 위한 문자 스트림 클래스
		// 파일에 문자를 입출력하기 위한 방법
		// 1. 파일 처리에 관련된 바이트 스트림 클래스를 활용하는 방법
		//  - 파일 처리에 관련된 바이트 스트림을 생성
		//  - 해당 바이트 스트림은 문자 스트림으로 변환
		//  - 필요한 부가 기능(버퍼, 출력 메소드 제공)을 제공하는 클래스의 객체를 생성하여 
		//    파일 입출력 처리		
		// 2. 파일 처리에 관련된 문자 스트림 클래스를 활용하는 방법
		//  - FileReader(파일에서 입력받는 경우 사용), FileWriter(파일에 출력하느 경우 사용)
		//  - 문자열을 파일에 입출력하는 경우 다이렉트로 문자 스트림을 파일에 연결할 수 있습니다.
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_char.txt";
		
		// 파일에 출력할 수 있는 문자 스트림 클래스
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			// 아래의 FileWriter 클래스의 객체를 만드는 것은
			// 기존의 아래 코드와 동일한 결과를 반환
			// fos = new FileOutputStream(strFileName);
			// osw = new OutputStreamWriter(fos);
			fw = new FileWriter(strFileName);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.println("FileWriter 클래스를 사용한 출력 예제");
			
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}












