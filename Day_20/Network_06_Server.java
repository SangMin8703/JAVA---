package network;

import java.net.*;
import java.io.*;

// 클라이언트 측의 소켓에서 전달하는 데이터를 수신하기 위한 쓰레드
class ServerSideThread extends Thread {
	private BufferedReader input;
	
	public ServerSideThread(InputStream is) {
		// 쓰레드의 생성자에서 클라이언트의 소켓으로부터
		// 데이터를 수신할 수 있는 문자열 스트림을 생성		
		input = new BufferedReader(new InputStreamReader(is));
	}
	
	// 쓰레드가 동작할 로직의 구현
	public void run() {
		String clientMsg = "";		
		String checkMsg = "Bye";
		try {
			// 클라이언트의 소켓에서 Bye 문자열이 전달될때까지
			// 계속해서 메세지를 수신할 수 있도록 합니다.
			do {			
					clientMsg = input.readLine();			
				System.out.printf("클라이언트의 메세지 : %s\n", clientMsg);			
			} while( !clientMsg.equals(checkMsg) );
			
		} catch (IOException e) {			
			System.out.println("ServerSide-1");
			e.printStackTrace();
		} finally {
			// 클라이언트의 소켓으로부터 데이터를 수신할 수 있는 스트림을 종료
			if( input != null ) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("ServerSide-2");
					e.printStackTrace();
				}
			}
			
			System.out.println("클라이언트의 접속이 종료됨 - 2");
		}
	}
}

public class Network_06_Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버 소켓 객체 생성 완료");

		System.out.println("서버 소켓 accept 메소드 실행");
		Socket client = server.accept();		
		System.out.println("클라이언트의 접속 발생");		
		
		OutputStream os = client.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);		
		
		// 클라이언트에서 전달되는 데이터를 처리하기 위한 쓰레드 객체의 생성과 실행
		// main 메소드는 클라이언트로 데이터를 전송하는 역할,
		// 클라이언트의 데이터는 별도의 쓰레드를 사용하여 처리
		// (비동기 방식의 통신 - main 메소드의 흐름은 클라이언트의 데이터 전송과 별개로 진행)
		ServerSideThread inputThread = 
				new ServerSideThread(client.getInputStream());
		inputThread.start();
		
		pw.println("Hello Client~");
		pw.flush();		
		
		String input = "";
		String checkMsg = "Bye";
		BufferedReader keyboard = 
				new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("클라이언트에 전달할 메세지를 입력 : ");
			input = keyboard.readLine();
			
			if( client.isClosed() ) {
				System.out.println("클라이언트의 접속이 종료됨-1");
				break;
			}
			pw.println(input);
			pw.flush();			
		} while( !input.equals(checkMsg) );
		
		pw.close();
		server.close();
		client.close();
		System.out.println("프로그램 종료");		
	}
}









