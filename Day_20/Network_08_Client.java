package network;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultCaret;

import java.io.*;
import java.net.*;

public class Network_08_Client extends JFrame {
	private JPanel north = new JPanel();
	private JPanel south = new JPanel();
	private JScrollPane center = new JScrollPane();
	
	private JLabel ipLabel = new JLabel("IP"); 
	private JTextField ipField = new JTextField(15);
	private JLabel portLabel = new JLabel("PORT"); 
	private JTextField portNumberField = new JTextField(5);
	private JButton btnExec = new JButton("접속");
	
	private JTextArea textArea = new JTextArea();
	
	private JTextField messageField = new JTextField();
	private JButton btnSend = new JButton("전송");
	
	// 네트워크 처리를 위한 멤버를 선언
	private Socket client;
	private PrintWriter output;
	
	public Network_08_Client() {
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
		
		this.btnExec.addActionListener(new SocketConnectListener());
		this.btnSend.addActionListener(new SendProcListener());
		
		this.messageField.addKeyListener(new KeyAdapter() {			
			public void keyReleased(KeyEvent e) {
				if( e.getKeyCode() == KeyEvent.VK_ENTER ) {
					if( output == null ) {
						textArea.append("서버의 연결이 확인된 후 실행하세요\n");				
						return;
					}
					String msg = messageField.getText().trim();
					output.println(msg);
					textArea.append("My : " + msg + "\n");
					messageField.setText("");
				}					
			}
		});
		
		this.ipField.setText("localhost");
		this.portNumberField.setText("7777");
		
		this.setSize(375, 500);
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
				
				new InputStreamProcThread().start();
				
				output = new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(
										client.getOutputStream())), true);
				
			} catch (IOException e1) {				
				textArea.append(strIP + ":" +  port + " 로 연결 실패\n");
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
				textArea.append("서버의 입력 스트림 객체 생성 실패\n");
			}
		}
		public void run() {
			if( input == null ) 
				return;			
			String msg = "";
			try {
				while((msg = input.readLine()) != null) {					
					textArea.append(msg + "\n");
				}
			} catch (IOException e) {
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
			String msg = messageField.getText().trim();
			output.println(msg);
			textArea.append("My : " + msg + "\n");
			messageField.setText("");
		}		
	}

	public static void main(String[] args) {
		new Network_08_Client();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
