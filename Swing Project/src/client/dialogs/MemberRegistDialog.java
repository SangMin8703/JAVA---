package client.dialogs;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

import common.PortNumberConstants;
import jdbc.model.Member;
import util.ScreenSize;

public class MemberRegistDialog extends JDialog {
	private JDialog instance = this;
	
	private JLabel ipLabel = new JLabel("서버 주소를 입력하세요", SwingConstants.RIGHT);
	private JTextField ipField = new JTextField("localhost");
	
	private JLabel idLabel = new JLabel("아이디를 입력하세요", SwingConstants.RIGHT);
	private JTextField idField = new JTextField();	
	
	private JLabel passwordLabel = new JLabel("패스워드를 입력하세요", SwingConstants.RIGHT);
	private JPasswordField passwordField = new JPasswordField();
	
	private JLabel nameLabel = new JLabel("이름을 입력하세요", SwingConstants.RIGHT);
	private JTextField nameField = new JTextField();
	
	private JLabel telLabel = new JLabel("연락처를 입력하세요", SwingConstants.RIGHT);
	private JTextField telField = new JTextField();
	
	private JButton btnRegist = new JButton("회원가입");
	private JButton btnCancle = new JButton("회원가입 취소");	
	
	public MemberRegistDialog(JDialog owner, String strServerIp) {
		super(owner, "회원가입", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.ipField.setText(strServerIp);
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(6, 1, 5, 5));
		
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
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1, 2, 5, 5));
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(new GridLayout(1, 2, 5, 5));
		telPanel.add(telLabel);
		telPanel.add(telField);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 2, 10, 10));
		btnPanel.add(btnRegist);
		btnPanel.add(btnCancle);	
		
		c.add(ipPanel);
		c.add(idPanel);
		c.add(passwordPanel);
		c.add(namePanel);
		c.add(telPanel);
		c.add(btnPanel);
		
		setEventListener();
		
		this.setSize(300, 350);
		this.setLocation(ScreenSize.getScreenWidth() / 2 - this.getSize().width / 2, 
				ScreenSize.getScreenHeight() / 2 - this.getSize().height / 2);
	}
	
	private void setEventListener() {
		this.btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Socket registsocket;
				BufferedReader in;
				ObjectOutputStream out;
				
				try {
					registsocket = 
							new Socket(
								ipField.getText().trim(), 
								PortNumberConstants.REGIST_PORT_NUMBER);					
					out = new ObjectOutputStream(
							new BufferedOutputStream(							
									registsocket.getOutputStream()));
					in = new BufferedReader(
							new InputStreamReader(
									registsocket.getInputStream()));
					
					Member member = new Member(
							idField.getText().trim(), passwordField.getText().trim(), 
							nameField.getText().trim(), telField.getText().trim(), false);
					out.writeObject(member);
					out.flush();
					
					int result = Integer.parseInt(in.readLine());
					
					if( result == -1 ) {
						JOptionPane.showMessageDialog(
								instance, "입력한 아이디는 현재 사용 중입니다.\n다른 아이디를 입력하세요.", 
								"회원가입", JOptionPane.ERROR_MESSAGE);						
					} else if( result == 0 ) {
						JOptionPane.showMessageDialog(
								instance, "회원가입 실패\n(관리자에게 확인하세요)", "회원가입", 
								JOptionPane.ERROR_MESSAGE);
					} 
										
					out.close();
					in.close();
					registsocket.close();
					
					if( result != 1 )
						return;
					
					JOptionPane.showMessageDialog(
							instance, "회원가입 성공", "회원가입", 
							JOptionPane.INFORMATION_MESSAGE);
					instance.setVisible(false);
					instance.dispose();					
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}												
			}
		});
		this.btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				instance.dispose();
			}
		});		
	}
}
