package network;

import java.io.IOException;
// Java 언어에서 네트워크 통신을 위해 사용되는 클래스
// java.net.ServerSocket
//  - ServerSocket 클래스는 클라이언트(원격지에서 접속 요청을 전달하는 PC)의
//    점속을 받아들여 Socket 클래스의 객체로 변환할 수 있는 클래스
//  - new ServerSocket(포트번호);
// java.net.Socket
//  - Socket 클래스는 원격지의 두 컴퓨터간에 데이터를 송수신할 수 있는 클래스
//  - new Socket(서버소켓이 대기중인 PC의 IP 주소, 포트번호);
import java.net.*;
public class Network_01_Server {
	public static void main(String[] args) throws IOException {
		
		// 서버 PC의 구현
		// 1. ServerSocket 클래스의 객체를 생성하여 
		//    특정 포트번호를 할당합니다.
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버 소켓 객체 생성 완료");
		// 2. ServerSocket 클래스의 객체를 사용하여
		//    클라이언트의 접속을 대기합니다.(accept 메소드)
		//   - ServerSocket 의 accept 메소드는 클라이언트의 접속이 일어날 때까지
		//     무한대기하는 메소드입니다.
		//   - 클라이언트의 접속이 들어오면, 해당 클라이언트와 통신할 수 있는 Socket 객체가
		//     반환됩니다.
		System.out.println("서버 소켓 accept 메소드 실행");
		Socket client = server.accept();		
		System.out.println("클라이언트의 접속 발생");
		
		server.close();
		client.close();
		System.out.println("프로그램 종료");		
	}
}









