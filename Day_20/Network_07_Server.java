package network;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*; 
import java.net.*;

public class Network_07_Server extends JFrame {
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
	private Socket client;
	private PrintWriter output;
	
	public Network_07_Server() {
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
							
							textArea.append(port + " port 번호로 서버 대기 중...\n");
							client = server.accept();							
							textArea.append("클라이언트의 접속이 확인됨\n");
							
							client.setKeepAlive(true);
							// 클라이언트의 입력을 처리할 쓰레드 구동
							new InputStreamProcThread().start();
							output = 
								new PrintWriter(
								new BufferedWriter(
									new OutputStreamWriter(
										client.getOutputStream())), true);
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
			try {
				input = 
					new BufferedReader(
						new InputStreamReader(
							client.getInputStream()));
			} catch (IOException e) {
				textArea.append("클라이언트의 입력 스트림 객체 생성 실패\n");
			}
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
					output.close();
					client.close();
					
					input = null;
					output = null;
					client = null;
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	class SendProcListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			if( output == null ) {
				textArea.append("클라이언트의 연결이 확인된 후 실행하세요\n");				
				return;
			}
			String msg = messageField.getText().trim();
			output.println(msg);
			textArea.append("S : " + msg + "\n");		
		}		
	}

	public static void main(String[] args) {
		new Network_07_Server();
	}
}










