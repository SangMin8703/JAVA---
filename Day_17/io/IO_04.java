package io;

import java.io.IOException;

public class IO_04 {
	public static void main(String[] args) {		
		byte [] buffer = new byte[20];
		int size = 0;		
		
		try {
			System.out.print("버퍼에 저장할 내용을 입력하세요 : ");
			// InputStraem 클래스의 read 메소드
			//  - byte 배열과 OFFSET, SIZE을 매개변수로 사용하는 read 메소드
			//  - 입력에 사용되는 버퍼의 내용을 매개변수로 전달된 byte 배열에 
			//    입력하는 메소드
			//  - 해당 배열의 OFFSET 인덱스부터 입력을 수행합니다.
			//  - SIZE 의 크기만큼의 byte를 입력받습니다.
			//   (SIZE 보다 큰 데이터가 입력되는 경우 무시합니다.)
			//  - 입력된 바이트의 수를 int 타입으로 반환합니다.
			
			// buffer 배열에 0 번째 인덱스부터 입력을 수행하고
			// 입력받을 최대 바이트 수는 20 byte
			//size = System.in.read(buffer, 0, buffer.length);
			
			// buffer 배열에 7 번째 인덱스부터 입력을 수행하고
			// 입력받을 최대 바이트 수는 5 byte
			size = System.in.read(buffer, 7, 5);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.printf("size(입력된 바이트의 수) = %d\n", size);
		
		for( int i = 0 ; i < buffer.length ; i++ ) {		
			System.out.printf("%d ", buffer[i]);
		}		
	}
}






