package network;

// Java 언어에서 네트워크 통신을 위해 사용되는 클래스
// java.net.ServerSocket
//  - ServerSocket 클래스는 클라이언트(원격지에서 접속 요청을 전달하는 PC)의
//    점속을 받아들여 Socket 클래스의 객체로 변환할 수 있는 클래스
//  - new ServerSocket(포트번호);
// java.net.Socket
//  - Socket 클래스는 원격지의 두 컴퓨터간에 데이터를 송수신할 수 있는 클래스
//  - new Socket(서버소켓이 대기중인 PC의 IP 주소, 포트번호);
import java.net.*;
import java.io.*;
public class Network_04_Server {
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
		
		// 3. 클라이언트와 연결된 Socket 객체를 사용하여
		//    입출력 스트림을 생성한 후, 데이터를 송수신합니다.
		//  - Socket 클래스의 getOutputStream 메소드
		//    현재 Socket에 연결된 상대방 쪽으로 데이터를 출력할 수 있는
		//    OutputStream 객체를 반환하는 메소드
		OutputStream os = client.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		//  - Socket 클래스의 getInputStream 메소드
		//    현재 Socket에 연결된 상대방 쪽에서 전달한 데이터를 입력받을 수 있는
		//    InputStream 객체를 반환하는 메소드
		InputStream is = client.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		pw.println("Hello Client~");
		pw.flush();		
		
		String clientMsg = "";
		String checkMsg = "Bye";
		do {
			clientMsg = br.readLine();
			System.out.printf("클라이언트의 메세지 : %s\n", clientMsg);		
			pw.println("메세지 수신 완료");
			pw.flush();	
		} while( !clientMsg.equals(checkMsg) );
		
		pw.close();
		br.close();
		
		server.close();
		client.close();
		System.out.println("프로그램 종료");		
	}
}









