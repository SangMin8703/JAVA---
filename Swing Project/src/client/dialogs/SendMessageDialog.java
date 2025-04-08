package client.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import java.net.*;

import common.PortNumberConstants;
import jdbc.model.*;
import util.ScreenSize;

public class SendMessageDialog extends JDialog {
	private JDialog instance = this;
	
	private String strServerIp;
	
	private JLabel receiveMemberIDLabel;
	
	private JTextArea messageArea = new JTextArea();
	private JScrollPane messageContentScrollPane;
	
	private JButton btnSend = new JButton("전송");
	private JButton btnCancle = new JButton("취소");
	
	private Message_Info info;
	
	public SendMessageDialog(JFrame owner, Message_Info info, String strServerIp) {
		super(owner, "쪽지보내기", true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.strServerIp = strServerIp;
		this.info = info;
		
		Container c = this.getContentPane();		
		
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());		
		receiveMemberIDLabel = 
			new JLabel("받는 사람 " + info.getR_member_name() + 
					"(" + info.getR_member_id() + ")", SwingConstants.CENTER);
		north.add(receiveMemberIDLabel);		
		
		this.messageContentScrollPane = new JScrollPane(this.messageArea);
		this.messageContentScrollPane.getViewport().setBackground(Color.WHITE);
		
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1, 2, 3, 3));
		south.add(btnSend);
		south.add(btnCancle);	
		
		c.add(north, BorderLayout.NORTH);
		c.add(messageContentScrollPane, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);		
		
		setEventListener();
		
		this.setSize(300, 350);
		this.setLocation(ScreenSize.getScreenWidth() / 2 - this.getSize().width / 2, 
				ScreenSize.getScreenHeight() / 2 - this.getSize().height / 2);
	}
	
	private void setEventListener() {
		this.btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setContent(messageArea.getText());
				
				Socket messageSocket = null;
				BufferedReader in = null;
				ObjectOutputStream out = null;
				try {
					messageSocket = 
						new Socket(strServerIp, PortNumberConstants.SEND_MESSAGE_PORT_NUMBER);
					
					out = new ObjectOutputStream(
							new BufferedOutputStream(messageSocket.getOutputStream()));
					
					out.writeObject(info);
					out.flush();
					
					in = new BufferedReader(
							new InputStreamReader(messageSocket.getInputStream()));
					int result = Integer.parseInt(in.readLine());
					
					if( result > 0 ) {
						JOptionPane.showMessageDialog(
								instance, "쪽지 전송 성공", "쪽지보내기", 
								JOptionPane.INFORMATION_MESSAGE);
						instance.setVisible(false);
						instance.dispose();
					} else {
						JOptionPane.showMessageDialog(
								instance, "쪽지 전송 실패\n(관리자에게 확인하세요)", "쪽지보내기", 
								JOptionPane.ERROR_MESSAGE);
					}				
					
					in.close();
					out.close();
					messageSocket.close();
					
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
