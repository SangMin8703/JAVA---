package network;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

// 다수 개의 클라이언트를 처리할 수 있는 서버측의 구현
// 다수 개의 클라이언트로부터 데이터를 입력받기 위해서
// 각각의 클라이언트 객체에 쓰레드를 생성해야 합니다.
// 입력 작업의 경우, 입력이 들어올때까지 해당 흐름이 BLOCK 되기 떄문에
// 입력 작업은 쓰레드로 처리하는 것이 효율적입니다.
public class Network_13_Server extends JFrame {
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JScrollPane center = new JScrollPane();
	
	private JLabel portLabel = new JLabel("PORT"); 
	private JTextField portNumberField = new JTextField(5);
	private JButton btnExec = new JButton("실행");
	
	private JTextArea textArea = new JTextArea();
	
	private JTextField messageField = new JTextField();
	private JButton btnSend = new JButton("전송");
	
	// 네트워크 처리를 위한 멤버를 선언
	private ServerSocket server;
	// 서버에 접속한 모든 클라이언트를 저장하는 컬렉션 객체
	private ArrayList<ClientSocket> clients = new ArrayList<>();	
	// 서버에 접속한 모든 클라이언트들에 대해서 중복 여부를 확인하기 위한 map 객체
	// IP 어드레스를 기준으로 각각의 클라이언트들을 구분
	private HashMap<String, ClientSocket> clientsMap = new HashMap<>();
	
	public Network_13_Server() {
		this.setTitle("Server");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		
		this.north.setLayout(new GridLayout(1, 3, 5, 7));
		this.portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.north.add(portLabel);
		this.north.add(portNumberField);
		this.north.add(btnExec);
		        
		this.textArea.setEditable(false);
		this.center.getViewport().add(textArea);
		
		this.south.setLayout(new BorderLayout(5, 7));
		this.south.add(messageField, BorderLayout.CENTER);
		this.south.add(btnSend, BorderLayout.EAST);
		
		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		// 이벤트 등록
		this.btnExec.addActionListener(new ServerSocketExecuteListener());
		this.btnSend.addActionListener(new SendProcListener());
		
		this.portNumberField.setText("7777");
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	// 접속된 클라이언트의 정보를 저장하는 클래스의 선언
	// 클라이언트의 소켓과 출력스트림 객체를 저장합니다.
	// 해당 객체가 저장하고 있는 소켓에서 입력받을 수 있도록
	// 쓰레드를 포함합니다.
	class ClientSocket {	
		private String ip;
		private Socket socket;
		private PrintWriter out;
		public ClientSocket(String ip, Socket socket) {
			this.ip = ip;
			this.socket = socket;			
			try {
				out = new PrintWriter(
						new BufferedWriter(
							new OutputStreamWriter(
								socket.getOutputStream())), true);
			} catch (IOException e) {
				textArea.append(ip + " - 클라이언트의 출력 스트림 객체 생성 실패\n");
			}
			
			// 해당 소켓으로부터 데이터를 입력받기 위한 쓰레드 객체의 생성과 실행
			new InputClientSocket().start();
		}		
		public void sendMsg(String msg) {
			if( out == null )
				return;
			this.out.println(msg);
		}		
		
		class InputClientSocket extends Thread {
			private BufferedReader in;
			public InputClientSocket() {
				try {
					in = new BufferedReader(
							new InputStreamReader(
								socket.getInputStream()));
				} catch (IOException e) {
					textArea.append(ip + " - 클라이언트의 입력 스트림 객체 생성 실패\n");
				}
			}
			public void run() {
				if( this.in == null )
					return;
				String msg = "";
				try {
					// (msg = in.readLine()) != null
					// 클라이언트의 접속이 종료되면 readLine 메소드는 null 값을 반환합니다.
					// readLine 메소드의 결과가 null 이 아니라면 클라이언트가 전달한 
					// 문자열임을 확인할 수 있습니다.
					while( (msg = in.readLine()) != null )
						textArea.append(msg + "\n");
				} catch (IOException e) {
					// 클라이언트의 접속이 비정상적으로 종료되면
					// readLine 메소드는 예외를 발생시킵니다.
					// 이부분은 클라이언트의 비정상적인 종료를 위한 처리부분입니다.
					textArea.append(ip + " - 클라이언트가 강제 종료 되었습니다.\n");
				} finally {
					if( in != null )
						try {
							in.close();
						} catch (IOException e) {							
							e.printStackTrace();
						}
					
					textArea.append(ip + " - 클라이언트의 접속이 종료되었습니다.\n");
				}
			}
		}
	}
	
	class ServerSocketExecuteListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			int port = Integer.parseInt(portNumberField.getText());
			try {
				
				server = new ServerSocket(port);
				textArea.append(port + " port 번호로 서버 구동 성공\n");
				
				// GUI 환경에서 accept 메소드를 실행하면
				// 이벤트 쓰레드가 BLOCK 상태로 빠지기 떄문에
				// 어떠한 이벤트도 처리할 수 없습니다.
				//client = server.accept();
				
				new Thread(new Runnable() {
					public void run() {
						try {							
							// 1:N 방식의 통신을 구현하기 위해서는 
							// 서버 소켓의 accept 메소드가 반복해서 수행되야 합니다.							
							while( true ) {
								textArea.append(
									port + " port 번호로 서버 대기 중...\n");
								Socket client = server.accept();
								
								// 각각의 클라이언트의 중복 여부를 
								// IP 주소를 사용하여 처리합니다.
								// 서버에 접속된 클라이언트의 정보를 수집하기 위해서
								// InetAddress 클래스를 사용합니다.
								// InetAddress 클래스의 객체는 소켓으로부터 추출할 수 있습니다.
								InetAddress inet = client.getInetAddress();
								// InetAddress 클래스의 getHostAddress 메소드는 현재 소켓의
								// IP 주소 값을 반환합니다.
								String strClientIP = inet.getHostAddress();
								
								// 각각의 클라이언트를 HashMap 에서 검색하여 존재하지 않는 클라이언트만
								// 접속을 허용합니다.
								Object search = clientsMap.get(strClientIP);
								// HashMap 의 get 메소드의 결과가 null 이라면
								// 현재 접속된 클라이언트들과 중복되지 않음을 확인
								if( search == null ) {
									// 클라이언트를 정보를 가지게 되는 사용자 정의 클래스의 객체 생성
									ClientSocket cs = new ClientSocket(strClientIP, client);
									// 새로운 클라이언트가 접속되면 ArrayList와 HashMap에 저장합니다.
									clients.add(cs);
									clientsMap.put(strClientIP, cs);
									textArea.append(
									strClientIP + 
									" - 클라이언트의 접속이 확인됨 - " + clients.size() + "\n");
								} else {
									// 중복된 클라이언트의 경우 접속을 허용하지 않음
									client.close();
									textArea.append(
										strClientIP + 
										"주소의 클라이언트는 이미 접속되었기 때문에 접속을 종료함 - " + 
										clients.size() + "\n");
								}								
							}
						} catch (IOException e) {							
							textArea.append(port + " port 번호로 서버 대기 중 문제발생\n");
						}
					}
				}).start();				
			} catch (IOException e1) {				
				textArea.append(port + " port 번호로 서버 구동 실패\n");
			}			
		}
	}
	
	class InputStreamProcThread extends Thread {
		private BufferedReader input;		
		public InputStreamProcThread() {		
			
		}
		public void run() {
			if( input == null ) 
				return;			
			String msg = "";
			try {
				while((msg = input.readLine()) != null) {					
					textArea.append("C : " + msg + "\n");
				}
			} catch (IOException e) {			
				;
			} finally {
				textArea.append("클라이언트의 접속 종료\n");
				try {
					input.close();
					
					
					input = null;					
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	class SendProcListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {	
			textArea.append("Server : " + messageField.getText() + "\n");
			// 모든 클라이언트들을 순회하면서 사용자 정의 클래스가 제공하는 
			// 메소드를 통해 데이터를 출력합니다.
			for( int i = 0 ; i < clients.size() ; i++ ) {
				clients.get(i).sendMsg(messageField.getText());
			}
		}
	}

	public static void main(String[] args) {
		new Network_13_Server();
	}
}










