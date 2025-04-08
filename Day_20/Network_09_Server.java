package network;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

// 다수 개의 클라이언트를 처리할 수 있는 서버측의 구현
// 기존의 1:1 통신에서는 멤버필드로 Socket 타입을 하나만 지정했지만
// 다수 개의 클라이언트를 처리하기 위해서는 컬렉션 타입의 객체가 필요합니다.
// 각각의 클라이언트는 서버 소켓의 accept 메소드에 의해서 접속이 일어났음을 
// 확인할 수 있습니다.
// 기존의 1:1 방식의 통신에서는 한번의 accept 메소드가 싱핻되면 다시 실행되지 않았지만
// 다수 개의 클라이언트를 처리하기 위해서는 accept 메소드가 반복해서 수행되야 합니다. 
public class Network_09_Server extends JFrame {
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
	private ArrayList<Socket> clients = new ArrayList<>();	
	
	public Network_09_Server() {
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
							// 1:N 방식의 통신을 구현하기 위해서는 
							// 서버 소켓의 accept 메소드가 반복해서 수행되야 합니다.							
							while( true ) {
								textArea.append(
									port + " port 번호로 서버 대기 중...\n");
								Socket client = server.accept();
								// 새로운 클라이언트가 접속되면
								// ArrayList 에 저장합니다.
								clients.add(client);
								textArea.append(
						"클라이언트의 접속이 확인됨 - " + clients.size() + "\n");
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
			
		}		
	}

	public static void main(String[] args) {
		new Network_09_Server();
	}
}










