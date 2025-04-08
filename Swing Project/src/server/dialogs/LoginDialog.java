package server.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.sql.*;

import jdbc.*;
import jdbc.dao.MemberDAO;
import jdbc.model.Member;
import util.ScreenSize;

public class LoginDialog extends JDialog {
	private JDialog instance = this;
	private Member loginMember = null;  
	
	private JLabel idLabel = new JLabel("아이디를 입력하세요", SwingConstants.RIGHT);
	private JTextField idField = new JTextField("supervisor");
	private JLabel passwordLabel = new JLabel("패스워드를 입력하세요", SwingConstants.RIGHT);
	private JPasswordField passwordField = new JPasswordField("manager");
	private JButton btnLogin = new JButton("로그인");
	private JButton btnExit = new JButton("프로그램 종료");
	private JButton btnRegist = new JButton("회원가입");
	
	private boolean isLogin = false;
	
	public LoginDialog(JFrame owner) {
		super(owner, "로그인", true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3, 1, 5, 5));
		
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
		Connection conn = JDBC_Util_Connection.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		
		boolean flag = false;		
		Member member = dao.select(conn, idField.getText().trim());		
		
		if( member == null ) {
			JOptionPane.showMessageDialog(
					instance, "아이디를 확인하세요", "로그인 에러", 
					JOptionPane.ERROR_MESSAGE);		
			flag = true;
		} else if( !member.getPassword().equals(passwordField.getText().trim()) ) {
			JOptionPane.showMessageDialog(
					instance, "아이디와 패스워드를 확인하세요", "로그인 에러", 
					JOptionPane.ERROR_MESSAGE);
			flag = true;
		}					
		
		if( flag ) {
			JDBC_Util_Close.close(conn);
			return;
		}
		
		member.setLogin_status(true);
		dao.update(conn, member);
		JDBC_Util_Close.close(conn);
		
		loginMember = member;
		isLogin = true;
		instance.setVisible(false);
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
						new MemberRegistDialog(instance);
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
	
	public void logout() {
		if( !this.isLogin || this.loginMember == null || !this.loginMember.getLogin_status() )
			return;		
		
		Connection conn = JDBC_Util_Connection.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		
		this.loginMember.setLogin_status(false);
		dao.update(conn, this.loginMember);
		JDBC_Util_Close.close(conn);		
	}
}
