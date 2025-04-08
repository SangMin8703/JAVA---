package io;
import java.io.*;
public class IO_16 {
	public static void main(String[] args) {		
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10.java";
		
		// IO_10.java 파일의 내용을 화면에 출력하세요.
		
		// 파일의 데이터를 문자열로 읽어들이기 위한 버퍼 클래스
		BufferedReader br;
		// 파일의 데이터를 문자열로 읽어와 저장하는 String 변수
		String data;
		
		try {
			// FileInputStream fis = new FileInputStream(strFileName);
			// InputStreamReader isr = new InputStreamReader(fis);
			// BufferedReader br = new BufferedReader(isr);
			
			// 일반적으로 많이 사용하는 BufferedReader 객체의 생성방법
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(strFileName)));
			
			int count = 0;
			char target = 'e';
			
			// 파일의 내용을 한줄씩 읽어와 data에 저장합니다.
			// data 의 값이 null 이 아니라면 스트림의 끝(파일의 끝)이 아니기 때문에
			// 한줄씩 출력할 수 있습니다.
			while( (data = br.readLine()) != null ) {
				System.out.println(data);
				
				for( int i = 0 ; i < data.length() ; i++ ) {
					if( data.charAt(i) == target )
						count++;
				}				
			}
			
			System.out.printf("%c : %d\n", target, count);
				
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}









