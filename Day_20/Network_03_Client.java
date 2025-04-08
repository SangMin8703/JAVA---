package network;

import java.net.*;
import java.io.*;
public class Network_03_Client {
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
		//  - Socket 클래스의 getInputStream 메소드
		//    현재 Socket에 연결된 상대방 쪽에서 전달한 데이터를 입력받을 수 있는
		//    InputStream 객체를 반환하는 메소드
		InputStream is = client.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//  - Socket 클래스의 getOutputStream 메소드
		//    현재 Socket에 연결된 상대방 쪽으로 데이터를 출력할 수 있는
		//    OutputStream 객체를 반환하는 메소드
		OutputStream os = client.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		
		String serverMsg = br.readLine();
		System.out.printf("서버의 메세지 : %s\n", serverMsg);
		
		pw.println("Hello Server~");
		pw.flush();
		
		br.close();	
		pw.close();
		client.close();
	}
}











