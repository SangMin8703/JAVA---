package io;
import java.io.*;

public class IO_02 {
	public static void main(String[] args) {
		int input = 0;
		
		// 키보드 버퍼에서 입력 수행할경우 주의할 점
		// 엔터키 처리
		// 키보드의 엔터 키는 두개의 문자가 조합된 키 입니다.
		// 키보드 커서를 가장 왼쪽으로 이동시키는 \r (13)
		// 키보드 커서를 다음라인으로 내리는 \n (10)
		// 두개의 문자가 조합된 것이 엔터키 입니다.
		// 바이트 스트림을 사용하여 입력을 수행하는 경우
		// 엔터키가 입력되는 것을 인지하고 처리해야만 합니다.
		try {
			System.out.print("키보드입력(두자리이상) : ");
			
			input = System.in.read();
			System.out.printf("input = %d\n", input);
			
			input = System.in.read();
			System.out.printf("input = %d\n", input);
			
			input = System.in.read();
			System.out.printf("input = %d\n", input);			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
	}
}
