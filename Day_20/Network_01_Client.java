package network;

import java.io.IOException;
import java.net.*;
public class Network_01_Client {
	public static void main(String[] args) throws IOException {
		// 클라이언트 PC의 구현
		// 1. Socket 클래스의 객체를 생성하여 서버 PC 로 접속합니다.
		//  - new Socket(서버의 IP, 서버의 PORT);
		//  - 동일한 컴퓨터에 서버와 클라이언트가 존재한다면
		//    서버의 주소는 "localhost" 또는 "127.0.0.1" 로 작성할 수 있습니다.		
		System.out.println("소켓 객체 생성");
		Socket client = new Socket("localhost", 7777);
		System.out.println("서버에 접속 완료");
		
		// 2. Socket 클래스의 객체를 사용하여 서버 쪽의 Socket 객체와
		//    데이터를 송수신 합니다.
		
		client.close();
	}
}
