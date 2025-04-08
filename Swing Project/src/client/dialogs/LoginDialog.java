package client.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import common.PortNumberConstants;

import java.io.*;
import java.net.*;

import jdbc.model.Member;
import util.ScreenSize;

public class LoginDialog extends JDialog {
	private JDialog instance = this;
	private Member loginMember = null; 
	
	private JLabel ipLabel = new JLabel("서버 주소를 입력하세요", SwingConstants.RIGHT);
	private JTextField ipField = new JTextField("localhost");
	
	private JLabel idLabel = new JLabel("아이디를 입력하세요", SwingConstants.RIGHT);
	private JTextField idField = new JTextField("yongseong");
	private JLabel passwordLabel = new JLabel("패스워드를 입력하세요", SwingConstants.RIGHT);
	private JPasswordField passwordField = new JPasswordField("system");
	private JButton btnLogin = new JButton("로그인");
	private JButton btnExit = new JButton("프로그램 종료");
	private JButton btnRegist = new JButton("회원가입");
	
	private boolean isLogin = false;
	
	private Socket loginSocket;
	private BufferedReader in;
	private PrintWriter out;
	
	public LoginDialog(JFrame owner) {
		super(owner, "로그인", true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(4, 1, 5, 5));
		
		JPanel ipPanel = new JPanel();
		ipPanel.setLayout(new GridLayout(1, 2, 5, 5));
		ipPanel.add(ipLabel);
		ipPanel.add(ipField);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new GridLayout(1, 2, 5, 5));
		idPanel.add(idLabel);
		idPanel.add(idField);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new GridLayout(1, 2, 5, 5));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordField);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 3, 5, 5));
		btnPanel.add(btnLogin);
		btnPanel.add(btnExit);
		btnPanel.add(btnRegist);	
		
		c.add(ipPanel);
		c.add(idPanel);
		c.add(passwordPanel);
		c.add(btnPanel);
		
		//setFields();
		setEventListener();
		
		this.setSize(375, 200);
		this.setLocation(ScreenSize.getScreenWidth() / 2 - this.getSize().width / 2, 
				ScreenSize.getScreenHeight() / 2 - this.getSize().height / 2);
	}
	
	public void setFields() {
		this.idField.setText("");
		this.passwordField.setText("");
	}
	
	private void login() {		
		try {
			loginSocket = 
					new Socket(
						ipField.getText().trim(), 
						PortNumberConstants.LOGIN_PORT_NUMBER);
			
			out = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(
							loginSocket.getOutputStream())), true);
			in = new BufferedReader(
					new InputStreamReader(
						loginSocket.getInputStream()));
			
			// 1. ID 문자열 전송
			out.println(this.idField.getText());
			// 2. PW 문자열 전송
			out.println(this.passwordField.getText());
			// 3. 결과값 수신
			// 0 : 로그인 실패 / 1 : 로그인 성공
			int result = Integer.parseInt(in.readLine());
			
			if( result == 0 ) {
				JOptionPane.showMessageDialog(
						instance, "아이디와 패스워드를 확인하세요", "로그인 에러", 
						JOptionPane.ERROR_MESSAGE);				
				return;
			} else if( result == 2 ) {
				JOptionPane.showMessageDialog(
						instance, "이미 로그인 된 계정으로는 접속할 수 없습니다.", "로그인 에러", 
						JOptionPane.ERROR_MESSAGE);				
				return;
			}		
			
			isLogin = true;
			instance.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 로그인 실패한 경우 소켓을 종료합니다.
				if( !isLogin ) {
					in.close();
					out.close();
					loginSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	private void setEventListener() {
		this.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		this.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isLogin = false;
				instance.setVisible(false);
			}
		});
		this.btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberRegistDialog registDialog = 
						new MemberRegistDialog(instance, ipField.getText());
				registDialog.setVisible(true);
			}
		});
		this.passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if( e.getKeyCode() == KeyEvent.VK_ENTER )
					login();				
			}
		});
	}	
	
	public boolean getIsLogin() {
		return this.isLogin;
	}
	
	public String getId() {
		return this.idField.getText().trim();
	}
	
	public String getServerIP() {
		return this.ipField.getText().trim();
	}
	
	public void logout() {
		try {
			// 로그인 성공한 상태인 경우 소켓을 종료하여 서버 측에 로그 아웃을 알려줍니다.
			if( isLogin ) {
				in.close();
				out.close();
				loginSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
}
