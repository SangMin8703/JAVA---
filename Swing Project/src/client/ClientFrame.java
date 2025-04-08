package client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import java.util.*;
import java.net.*;

import client.dialogs.*;

import common.CommonRequiredMethods;
import common.PortNumberConstants;
import jdbc.model.Data_File_Info;
import jdbc.model.Member;
import jdbc.model.Message_Info;
import client.panels.*;
import util.ScreenSize;

public class ClientFrame extends JFrame implements CommonRequiredMethods {
	private static final String strDownloadDirPath = "/data/download/";
	
	private LoginDialog loginDialog = new LoginDialog(this);
	
	ClientFrame frame = this;	
	
	MemberPanel memberPanel = new MemberPanel(this);
	FileDataPanel memberFileDataPanel = new FileDataPanel(this, true, true, true);
	FileDataPanel sharedFileDataPanel = new FileDataPanel(this, false, true, false);
	MessagePanel messagePanel = new MessagePanel(this);
	
	Thread memberListThread;
	Thread messageListThread;
	Thread memberFileListThread;
	Thread sharedFileListThread;
	
	public ClientFrame() {
		// 프로그램의 구동 전 로그인 과정 수행
		loginDialog.setVisible(true);
		
		if( !loginDialog.getIsLogin() )
			System.exit(0);
				
		this.setTitle("Client - ( " + loginDialog.getId() + " )");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setSize(ScreenSize.getScreenWidth()/2, ScreenSize.getScreenHeight());
				
		this.setLocation(ScreenSize.getScreenWidth()/2, 0);		
		
		Container c = this.getContentPane();

		JPanel north = new JPanel();

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2, 1, 1));
		center.add(memberPanel);
		center.add(memberFileDataPanel);
		center.add(sharedFileDataPanel);
		center.add(messagePanel);

		this.setMemberListTable();
		this.setSharedFileDataTable(loginDialog.getId());
		this.setMessageListTable(loginDialog.getId());

		c.add(center, BorderLayout.CENTER);
		
		createSessionForMemberList();
		createSessionForMessageList();
		createSessionForMemberFileList();
		createSessionForSharedFileList();
		
		this.setVisible(true);
	}	
	
	public static void main(String[] args) {		
		new ClientFrame();
	}

	@Override
	public JFrame getInstance() {		
		return this;
	}

	public String getServerIP() {
		return this.loginDialog.getServerIP();
	}
	
	@Override
	public String getLoginID() {
		return this.loginDialog.getId();
	}

	@Override
	public String getSaveDirPath() {
		return null;
	}

	@Override
	public String getDownloadDirPath() {		
		return strDownloadDirPath;
	}

	@Override
	public void setMemberListTable() {
	}

	@Override
	public void setMemberFileDataTable(String member_id) {		
	}

	@Override
	public void setSharedFileDataTable(String member_id) {		
	}

	@Override
	public void setMessageListTable(String r_member_id) {		
	}	
	
	private void createSessionForMemberList() {		
		memberListThread = new Thread() {
			Socket memberListSocket;
			PrintWriter out;
			ObjectInputStream in;			
			public void run() {
				try {
					memberListSocket = 
							new Socket(loginDialog.getServerIP(), PortNumberConstants.MEMBER_LIST_PORT_NUMBER);
					
					out = new PrintWriter(
							new BufferedWriter(
								new OutputStreamWriter(
									memberListSocket.getOutputStream())), true);	
					out.println(getLoginID());				
					
					in = new ObjectInputStream(
							new BufferedInputStream(
								memberListSocket.getInputStream()));
					
					while( true ) {
						ArrayList<Member> list = (ArrayList<Member>)in.readObject();					
						memberPanel.setTableRecords(list);
					}					
				} catch( Exception e ) {
					e.printStackTrace();			
					
					try {
						if( out != null )
							out.close();
						if( in != null )
							in.close();
						if( memberListSocket != null )
							memberListSocket.close();
					} catch (IOException e1) {							
						e1.printStackTrace();
					}
				}
			}			
		};
		
		memberListThread.start();
	}
	
	private void createSessionForMessageList() {		
		messageListThread = new Thread() {
			Socket messageListSocket;
			PrintWriter out;
			ObjectInputStream in;			
			public void run() {
				try {
					messageListSocket = 
							new Socket(loginDialog.getServerIP(), 
									PortNumberConstants.MESSAGE_LIST_PORT_NUMBER);
					
					out = new PrintWriter(
							new BufferedWriter(
								new OutputStreamWriter(
									messageListSocket.getOutputStream())), true);	
					out.println(getLoginID());				
					
					in = new ObjectInputStream(
							new BufferedInputStream(
									messageListSocket.getInputStream()));
					
					while( true ) {
						ArrayList<Message_Info> list = (ArrayList<Message_Info>)in.readObject();					
						messagePanel.setTableRecords(list);
					}					
				} catch( Exception e ) {
					e.printStackTrace();			
					
					try {
						if( out != null )
							out.close();
						if( in != null )
							in.close();
						if( messageListSocket != null )
							messageListSocket.close();
					} catch (IOException e1) {							
						e1.printStackTrace();
					}
				}
			}			
		};
		
		messageListThread.start();
	}
		
	private void createSessionForMemberFileList() {		
		memberFileListThread = new Thread() {
			Socket memberFileListSocket;
			PrintWriter out;
			ObjectInputStream in;			
			public void run() {
				try {
					memberFileListSocket = 
							new Socket(loginDialog.getServerIP(), 
									PortNumberConstants.MEMBER_FILE_LIST_PORT_NUMBER);
					
					out = new PrintWriter(
							new BufferedWriter(
								new OutputStreamWriter(
									memberFileListSocket.getOutputStream())), true);	
					out.println(getLoginID());				
					
					in = new ObjectInputStream(
							new BufferedInputStream(
									memberFileListSocket.getInputStream()));
					
					while( true ) {
						ArrayList<Data_File_Info> list = 
								(ArrayList<Data_File_Info>)in.readObject();					
						memberFileDataPanel.setTableRecords(list);
					}					
				} catch( Exception e ) {
					e.printStackTrace();			
					
					try {
						if( out != null )
							out.close();
						if( in != null )
							in.close();						
						if( memberFileListSocket != null )
							memberFileListSocket.close();
					} catch (IOException e1) {							
						e1.printStackTrace();
					}
				}
			}			
		};
		
		memberFileListThread.start();
	}
	
	private void createSessionForSharedFileList() {		
		sharedFileListThread = new Thread() {
			Socket sharedFileListSocket;
			PrintWriter out;
			ObjectInputStream in;			
			public void run() {
				try {
					sharedFileListSocket = 
							new Socket(loginDialog.getServerIP(), 
									PortNumberConstants.SHARED_FILE_LIST_PORT_NUMBER);
					
					out = new PrintWriter(
							new BufferedWriter(
								new OutputStreamWriter(
									sharedFileListSocket.getOutputStream())), true);	
					out.println(getLoginID());				
					
					in = new ObjectInputStream(
							new BufferedInputStream(
									sharedFileListSocket.getInputStream()));
					
					while( true ) {
						ArrayList<Data_File_Info> list = 
								(ArrayList<Data_File_Info>)in.readObject();					
						sharedFileDataPanel.setTableRecords(list);
					}					
				} catch( Exception e ) {
					e.printStackTrace();			
					
					try {
						if( out != null )
							out.close();
						if( in != null )
							in.close();						
						if( sharedFileListSocket != null )
							sharedFileListSocket.close();
					} catch (IOException e1) {							
						e1.printStackTrace();
					}
				}
			}			
		};
		
		sharedFileListThread.start();
	}
}


















