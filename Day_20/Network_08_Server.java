package network;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

import java.io.*;
import java.net.*;
import java.util.*;

public class Network_08_Server extends JFrame {
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
	private HashMap<String, Client> clientsMap = new HashMap<>();
	private ArrayList<Client> clientsList = new ArrayList<>();	
	
	public Network_08_Server() {
		this.setTitle("Server");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		
		this.north.setLayout(new GridLayout(1, 3, 5, 7));
		this.portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.north.add(portLabel);
		this.north.add(portNumberField);
		this.north.add(btnExec);
		        
		this.textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret)this.textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
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
		this.messageField.addKeyListener(new KeyAdapter() {			
			public void keyReleased(KeyEvent e) {
				if( e.getKeyCode() == KeyEvent.VK_ENTER ) {
					if( clientsList.size() == 0 ) {
						textArea.append("클라이언트의 연결이 확인된 후 실행하세요\n");				
						return;
					}
					
					String msg = "Server : " + messageField.getText().trim();					
					broadcating(msg);
					messageField.setText("");
				}					
			}
		});
		
		this.portNumberField.setText("7777");
		
		this.setSize(300, 500);
		this.setVisible(true);
	}
	
	class Client {
		private Client instance;
		private Socket client;
		private PrintWriter output;
		private String hostAddress;
		public Client(Socket client) {
			this.instance = this;
			this.client = client;
			this.hostAddress = this.client.getInetAddress().getHostAddress();
			try {
				output = 
					new PrintWriter(
						new BufferedWriter(
							new OutputStreamWriter(
								client.getOutputStream())), true);
			} catch (IOException e) {				
				textArea.append("클라이언트의 출력 스트림 객체 생성 실패\n");
			}
			new InputStreamProcThread().start();
		}		
		public void printMsg(String msg) {
			output.println(msg);
		}		
		public boolean equals(Object obj) {			
			if( !(obj instanceof Client) )
				return false;
			Client source = (Client)obj;
			return this.hostAddress.equals(source.hostAddress);
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
						broadcating(instance, hostAddress + " : " + msg);
					}
				} catch (IOException e) {			
					;
				} finally {
					textArea.append(hostAddress + " 클라이언트의 접속 종료\n");
					try {
						input.close();
						output.close();
						client.close();
						
						input = null;
						output = null;
						client = null;
						//System.out.println(clientsList.size());
						clientsList.remove(instance);
						//System.out.println(clientsList.size());
						//System.out.println(clientsMap.size());
						clientsMap.remove(hostAddress);
						//System.out.println(clientsMap.size());
					} catch (IOException e) {
						e.printStackTrace();
					}				
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
						while(true) {
							try {							
								textArea.append(port + " port 번호로 서버 대기 중...\n");
								Socket s = server.accept();	
								
								Client c = new Client(s);
								InetAddress inet = s.getInetAddress();
								
								textArea.append(inet.getHostAddress() + "클라이언트의 접속이 확인됨\n");								
																
								Client search = clientsMap.get(inet.getHostAddress());
								if( search == null ) {
									clientsMap.put(inet.getHostAddress(), c);
									clientsList.add(c);
								} else
									s.close();
							} catch (IOException e) {							
								textArea.append(port + " port 번호로 서버 대기 중 문제발생\n");
							}
						}
					}
				}).start();				
			} catch (IOException e1) {				
				textArea.append(port + " port 번호로 서버 구동 실패\n");
			}			
		}
	}	
	
	class SendProcListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			if( clientsList.size() == 0 ) {
				textArea.append("클라이언트의 연결이 확인된 후 실행하세요\n");				
				return;
			}
			
			String msg = "Server : " + messageField.getText().trim();					
			broadcating(msg);
			messageField.setText("");
		}		
	}
	
	private synchronized void broadcating(String msg) {
		textArea.append(msg + "\n");		
		for( int i = 0 ; i < clientsList.size() ; i++ ) {
			clientsList.get(i).printMsg(msg);
		}		
	}
	private synchronized void broadcating(Client instance, String msg) {
		textArea.append(msg + "\n");		
		for( int i = 0 ; i < clientsList.size() ; i++ ) {
			if( !instance.equals(clientsList.get(i) ))
				clientsList.get(i).printMsg(msg);
		}		
	}

	public static void main(String[] args) {
		new Network_08_Server();
	}
}










