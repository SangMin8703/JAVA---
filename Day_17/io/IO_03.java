package io;

import java.io.IOException;

public class IO_03 {
	public static void main(String[] args) {
		byte [] buffer = new byte[10];
		int size = 0;		
		
		try {
			System.out.print("버퍼에 저장할 내용을 입력하세요 : ");
			// InputStraem 클래스의 read 메소드
			//  - byte 배열을 매개변수로 사용하는 read 메소드
			//  - 입력에 사용되는 버퍼의 내용을 매개변수로 전달된 byte 배열에 
			//    입력하는 메소드
			//  - 입력된 바이트의 수를 int 타입으로 반환합니다.
			size = System.in.read(buffer);
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	
		System.out.printf("size(입력된 바이트의 수) = %d\n", size);
		
		//for( int i = 0 ; i < buffer.length ; i++ ) {
		for( int i = 0 ; i < size ; i++ ) {
			System.out.printf("%d ", buffer[i]);
		}
		System.out.println();
		
		
	}
}










