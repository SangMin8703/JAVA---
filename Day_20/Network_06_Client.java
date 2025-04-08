package network;

import java.net.*;
import java.io.*;

// 서버 측의 소켓에서 전달하는 데이터를 수신하기 위한 쓰레드
class ClientSideThread extends Thread {
	private BufferedReader input;
	
	public ClientSideThread(InputStream is) {
		// 쓰레드의 생성자에서 서버의 소켓으로부터
		// 데이터를 수신할 수 있는 문자열 스트림을 생성		
		input = new BufferedReader(new InputStreamReader(is));
	}
	
	// 쓰레드가 동작할 로직의 구현
	public void run() {
		String serverMsg = "";		
		String checkMsg = "Bye";
		try {
			// 서버의 소켓에서 Bye 문자열이 전달될때까지
			// 계속해서 메세지를 수신할 수 있도록 합니다.
			do {			
				serverMsg = input.readLine();			
				System.out.printf("서버의 메세지 : %s\n", serverMsg);			
			} while( !serverMsg.equals(checkMsg) );
			
		} catch (IOException e) {			
			System.out.println("ClientSide-1");
			e.printStackTrace();
		} finally {
			// 서버의 소켓으로부터 데이터를 수신할 수 있는 스트림을 종료
			if( input != null ) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("ClientSide-2");
					e.printStackTrace();
				}
			}
		}
	}
}

public class Network_06_Client {
	public static void main(String[] args) throws IOException {			
		System.out.println("소켓 객체 생성");
		Socket client = new Socket("localhost", 7777);
		System.out.println("서버에 접속 완료");		

		OutputStream os = client.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		
		// 서버측에서 전달하는 데이터를 수신하기 위한 쓰레드 객체의 생성과 실행
		// main 의 흐름과 별도로 진행되기 때문에
		// 클라이언트에서 서버쪽으로 데이터를 전송하는 데에 제약이 사라집니다.
		// (비동기 방식의 통신을 구현)
		ClientSideThread inputThread = 
				new ClientSideThread(client.getInputStream());
		inputThread.start();	
		
		String input = "";
		String checkMsg = "Bye";
		BufferedReader keyboard = 
				new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("서버에 전달할 메세지를 입력 : ");
			input = keyboard.readLine();
			
			if( client.isClosed() ) {
				System.out.print("서버와의 접속이 종료됨");
				break;
			}
			
			pw.println(input);
			pw.flush();			
		} while( !input.equals(checkMsg) );
		
		keyboard.close();		
		pw.close();
		client.close();
	}
}











