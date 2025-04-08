package network;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

import java.io.*;
import java.net.*;

public class Network_15_Client extends JFrame {
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JScrollPane west = new JScrollPane();
	private JScrollPane center = new JScrollPane();
	
	private JLabel ipLabel = new JLabel("IP"); 
	private JTextField ipField = new JTextField(15);
	private JLabel portLabel = new JLabel("PORT"); 
	private JTextField portNumberField = new JTextField(5);
	private JButton btnExec = new JButton("접속");
	
	private JList connectedList = new JList();
	private Border border = BorderFactory.createTitledBorder("접속중인 클라이언트");   
	
	private JTextArea textArea = new JTextArea();
	
	private JTextField messageField = new JTextField();
	private JButton btnSend = new JButton("전송");
	
	// 네트워크 처리를 위한 멤버를 선언
	private Socket client;
	private ObjectOutputStream output;
	
	public Network_15_Client() {
		this.setTitle("Client");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		
		//this.north.setLayout(new GridLayout(1, 5, 5, 7));
		this.ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.north.add(ipLabel);
		this.north.add(ipField);
		this.north.add(portLabel);
		this.north.add(portNumberField);
		this.north.add(btnExec);
		        
		connectedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		this.west.setViewportView(connectedList);
		this.west.setBorder(border);		
		
		this.textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret)this.textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		this.center.getViewport().add(textArea);
		
		this.south.setLayout(new BorderLayout(5, 7));
		this.south.add(messageField, BorderLayout.CENTER);
		this.south.add(btnSend, BorderLayout.EAST);
		
		c.add(north, BorderLayout.NORTH);
		c.add(west, BorderLayout.WEST);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		this.btnExec.addActionListener(new SocketConnectListener());
		this.btnSend.addActionListener(new SendProcListener());
		
		this.messageField.addKeyListener(new KeyAdapter() {			
			public void keyReleased(KeyEvent e) {
				if( e.getKeyCode() == KeyEvent.VK_ENTER ) {
					if( output == null ) {
						textArea.append("서버의 연결이 확인된 후 실행하세요\n");				
						return;
					}
					SendData msg = new SendData(messageField.getText().trim());
					try {
						output.writeObject(msg);
						output.flush();
					} catch (IOException e1) {				
						e1.printStackTrace();
					}					
					textArea.append("My : " + msg.getMsg() + "\n");
					messageField.setText("");
				}					
			}
		});
		
		this.addWindowListener(new WindowAdapter() {			
			public void windowClosing(WindowEvent e) {
				try {
					if( client != null )	client.close();	
					if( output != null ) 	output.close();
				} catch (IOException e1) {					
					e1.printStackTrace();
				}
			}
		});
		
		this.ipField.setText("localhost");
		this.portNumberField.setText("7777");
		
		this.setSize(550, 500);
		this.setVisible(true);
	}
	
	class SocketConnectListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			String strIP = ipField.getText().trim();
			String strPort = portNumberField.getText().trim();
			int port = Integer.parseInt(strPort);
			
			try {
				
				textArea.append(strIP + ":" +  port + " 로 연결 준비 중\n");
				client = new Socket(strIP, port);
				textArea.append(strIP + ":" +  port + " 로 연결 성공\n");			
				
				// 네트워크를 사용해서 객체를 입출력하는 경우
				// 출력 스트림을 생성한 후 입력 스트림을 생성해야 합니다.
				output = new ObjectOutputStream(
							new BufferedOutputStream(									
								client.getOutputStream()));
				
				new InputStreamProcThread().start();
				
				
			} catch (IOException e1) {				
				textArea.append(strIP + ":" +  port + " 로 연결 실패\n");
			}
		}		
	}
	
	class InputStreamProcThread extends Thread {
		private ObjectInputStream input;		
		public InputStreamProcThread() {
		}
		public void run() {
			if( input == null ) {
				try {
					input = 
						new ObjectInputStream(
							new BufferedInputStream(
								client.getInputStream()));
				} catch (IOException e) {
					textArea.append("서버의 입력 스트림 객체 생성 실패\n");
				}			
			}
			SendData msg = null;
			try {
				while((msg = (SendData)input.readObject()) != null) {	
					if( msg.getDataType() == 1 )
						textArea.append(msg.getMsg() + "\n");
					else if( msg.getDataType() == 2 ) {
						DefaultListModel listModel = new DefaultListModel();
						for( int i = 0 ; i < msg.getList().size() ; i++ )
							listModel.addElement(msg.getList().get(i));									
			            connectedList.setModel(listModel);
					}
				}
			} catch (Exception e) {
				;
			} finally {
				textArea.append("서버와의 접속 종료\n");
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
				textArea.append("서버의 연결이 확인된 후 실행하세요\n");				
				return;
			}
			
			SendData msg = new SendData(messageField.getText().trim());
			try {
				output.writeObject(msg);
				output.flush();
			} catch (IOException e1) {				
				e1.printStackTrace();
			}
			textArea.append("My : " + msg.getMsg() + "\n");
			messageField.setText("");
		}		
	}

	public static void main(String[] args) {
		new Network_15_Client();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
