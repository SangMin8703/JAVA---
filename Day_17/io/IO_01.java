package io;

// 입출력(IO)
// Java 입출력은 스트림 개념을 적용합니다.
// Java 의 임출력은 단방향 통신으로 이뤄집니다.
// (입력과 출력에 사용되는 클래스가 분리되어 있습니다.)
// (입력과 출력 스트림으로 분류)

// 입력과 출력에 사용되는 데이터의 타입에 따라서 바이트, 문자 스트림으로 분류됩니다.
// 입력
//  - 바이트스트림 : InputStream
//  - 문자스트림 : Reader
// 출력
//  - 바이트스트림 : OutputStream
//  - 문자스트림 : Writer

// Java 의 모든 입출력 과정은 반드시 예외를 처리해야만 합니다.
// Java 의 모든 입출력 클래스들은 java.io 에서 제공됩니다.

import java.io.*;

public class IO_01 {
	public static void main(String[] args) {	
		// 키보드 입력을 처리하기 위한 입력 코드
		// 키보드 입력(기본 입력)을 구현하고 있는 System.in 객체
		// System.in 객체는 InputStream 클래스의 객체로서
		// 입력에 사용되고 있는 버퍼에서 1 Byte 단위의 입력을 수행할 수 있습니다.
		int input = 0;
		
		try {
			System.out.print("키보드 입력 : ");
			// InputStream 클래스의 read 메소드
			// 입력에 사용되는 버퍼에서 1 Byte 크기만큼 읽어와
			// int 타입으로 반환하는 메소드
			input = System.in.read();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.printf("input = %d\n", input);		
	}
}




















