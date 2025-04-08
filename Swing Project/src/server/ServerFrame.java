package server;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import jdbc.*;
import jdbc.model.*;
import jdbc.dao.*;
import common.CommonRequiredAttributes;
import common.CommonRequiredMethods;
import common.PortNumberConstants;
import server.dialogs.LoginDialog;
import server.panels.*;
import util.ScreenSize;

public class ServerFrame extends JFrame implements CommonRequiredMethods {
	private static final String strSaveDirPath = "/data/save/";
	private static final String strDownloadDirPath = "/data/download/";

	ServerFrame frame = this;
	LoginDialog loginDialog = new LoginDialog(this);
	MemberPanel memberPanel = new MemberPanel(this);
	FileDataPanel memberFileDataPanel = new FileDataPanel(this, false, true, false);
	FileDataPanel sharedFileDataPanel = new FileDataPanel(this, true, false, true);
	MessagePanel messagePanel = new MessagePanel(this);

	ArrayList<Member> members;

	ServerSocket loginServer;
	Thread loginServerThread;
	Hashtable<String, Member> loginMemebersMap = new Hashtable<>();

	ServerSocket registServer;
	Thread registServerThread;

	ServerSocket memberListServer;
	Thread memberListServerThread;
	Hashtable<String, MemberListSocketClient> memberListClientsMap = new Hashtable<>();

	ServerSocket messageServer;
	Thread messageServerThread;

	ServerSocket messageListServer;
	Thread messageListServerThread;
	Hashtable<String, MessageListSocketClient> messageListClientsMap = new Hashtable<>();

	ServerSocket deleteMessageServer;
	Thread deleteMessageServerThread;

	ServerSocket readMessageServer;
	Thread readMessageServerThread;
	
	ServerSocket memberFileListServer;
	Thread memberFileListServerThread;
	Hashtable<String, MemberFileListSocketClient> memberFileListClientsMap = new Hashtable<>();

	ServerSocket sharedFileListServer;
	Thread sharedFileListServerThread;
	Hashtable<String, SharedFileListSocketClient> sharedFileListClientsMap = new Hashtable<>();
	
	ServerSocket deleteMemberFileServer;
	Thread deleteMemberFileServerThread;
	
	ServerSocket downloadFileServer;
	Thread downloadFileServerThread;
	
	ServerSocket uploadFileServer;
	Thread uploadFileServerThread;
	
	public ServerFrame() {
		// 프로그램의 구동 전 로그인 과정 수행
		loginDialog.setVisible(true);

		if (!loginDialog.getIsLogin())
			System.exit(0);

		this.setTitle("Server - (" + loginDialog.getId() + " )");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 현재 모니터의 크기를 기준으로 FRAME 의 크기를 설정
		this.setSize(ScreenSize.getScreenWidth() / 2, ScreenSize.getScreenHeight());
		this.setLocation(0, 0);

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

		setEventListener();

		createLoginServer();
		createRegistServer();

		createMemberListServer();

		createMessageServer();

		createMessageListServer();

		createDeleteMessageServer();
		createReadMessageServer();
		
		createMemberFileListServer();
		createSharedFileListServer();
		
		createDeleteMemberFileServer();
		
		createDownloadFileServer();
		
		createUploadFileServer();

		this.setVisible(true);
	}

	private void setEventListener() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				logoutForAllMember();
				
				/*
				frame.loginDialog.logout();

				// 서버 프로그램의 종료 시,
				// 현재 접속한 모든 멤버들에 대해서 로그아웃 과정을 수행
				Set<String> loginMemberSet = loginMemebersMap.keySet();
				Iterator<String> iter = loginMemberSet.iterator();
				while (iter.hasNext()) {
					String key_Member_id = iter.next();
					Member member = loginMemebersMap.get(key_Member_id);
					logoutForLoginMember(member);
				}
				*/
			}
		});
	}
	
	private void logoutForAllMember() {
		Connection conn = JDBC_Util_Connection.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.update(conn);

		JDBC_Util_Close.close(conn);
	}

	private void logoutForLoginMember(Member member) {
		Connection conn = JDBC_Util_Connection.getConnection();
		MemberDAO dao = MemberDAO.getInstance();

		member.setLogin_status(false);
		dao.update(conn, member);

		JDBC_Util_Close.close(conn);
	}

	public JFrame getInstance() {
		return this;
	}

	public String getServerIP() {
		return null;
	}

	public String getLoginID() {
		return this.loginDialog.getId();
	}

	public String getSaveDirPath() {
		// return strSaveDirPath + this.loginDialog.getId() + File.separator;
		return strSaveDirPath;
	}

	public String getDownloadDirPath() {
		return strDownloadDirPath;
	}

	public void setMemberListTable() {
		Connection conn = JDBC_Util_Connection.getConnection();
		MemberDAO dao = MemberDAO.getInstance();

		members = dao.select(conn);
		JDBC_Util_Close.close(conn);

		memberPanel.setTableRecords(members);

		// 멤버 상태의 변경 시,
		// 현재 접속한 모든 멤버들에 대해서 현재 멤버 상태값을 전송
		Set<String> loginMemberSet = memberListClientsMap.keySet();
		Iterator<String> iter = loginMemberSet.iterator();
		while (iter.hasNext()) {
			String key_Member_id = iter.next();
			MemberListSocketClient member = memberListClientsMap.get(key_Member_id);
			try {
				member.getOut().writeObject(members);
				member.getOut().flush();
			} catch (IOException e) {
				e.printStackTrace();
				
				loginMemebersMap.remove(key_Member_id);
				memberListClientsMap.remove(key_Member_id).close();
				messageListClientsMap.remove(key_Member_id).close();
				memberFileListClientsMap.remove(key_Member_id).close();
				sharedFileListClientsMap.remove(key_Member_id).close();
			}
		}
	}

	public void setMemberFileDataTable(String member_id) {
		Connection conn = JDBC_Util_Connection.getConnection();
		Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();

		ArrayList<Data_File_Info> list = dao.select(conn, member_id);
		memberFileDataPanel.setTableRecords(list);

		JDBC_Util_Close.close(conn);
	}

	public void setSharedFileDataTable(String member_id) {
		Connection conn = JDBC_Util_Connection.getConnection();
		Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();

		ArrayList<Data_File_Info> list = dao.select(conn, member_id);
		sharedFileDataPanel.setTableRecords(list);

		JDBC_Util_Close.close(conn);
		
		Set<String> sharedFileListSet = sharedFileListClientsMap.keySet();
		Iterator<String> iter = sharedFileListSet.iterator();
		while (iter.hasNext()) {
			String key_Member_id = iter.next();
			SharedFileListSocketClient member = sharedFileListClientsMap.get(key_Member_id);
			try {
				member.getOut().writeObject(list);
				member.getOut().flush();
			} catch (IOException e) {
				e.printStackTrace();
				
				loginMemebersMap.remove(key_Member_id);
				memberListClientsMap.remove(key_Member_id).close();
				messageListClientsMap.remove(key_Member_id).close();
				memberFileListClientsMap.remove(key_Member_id).close();
				sharedFileListClientsMap.remove(key_Member_id).close();
			}
		}
	}

	public void setMessageListTable(String r_member_id) {
		Connection conn = JDBC_Util_Connection.getConnection();
		Message_InfoDAO dao = Message_InfoDAO.getInstance();

		ArrayList<Message_Info> list = dao.select(conn, r_member_id);
		messagePanel.setTableRecords(list);

		JDBC_Util_Close.close(conn);
	}

	private void createLoginServer() {

		try {
			this.loginServer = new ServerSocket(PortNumberConstants.LOGIN_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		loginServerThread = new Thread() {
			public void run() {
				try {
					while (true) {
						Socket client = loginServer.accept();

						PrintWriter out = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

						// 1. ID 문자열 수신
						String id = in.readLine();
						// 2. PW 문자열 수신
						String pw = in.readLine();
						// 3. 결과값 반환
						int result = 1;

						Connection conn = null;
						MemberDAO dao = null;
						Member loginMember = null;
						// 현재 로그인된 아이디라면, 로그인 거부
						if (loginMemebersMap.containsKey(id))
							result = 2;
						else {
							conn = JDBC_Util_Connection.getConnection();
							dao = MemberDAO.getInstance();
							loginMember = dao.select(conn, id);

							if (loginMember == null)
								result = 0;
							else if (!loginMember.getPassword().equals(pw))
								result = 0;
						}

						if (result == 0 || result == 2) {
							// 로그인이 실패한 경우
							out.close();
							in.close();
							client.close();
						} else {
							// 로그인이 성공한 경우
							loginMember.setLogin_status(true);
							dao.update(conn, loginMember);

							// 현재 접속한 사용자의 로그인 상태가 변경되었기 떄문에
							// 멤버 리스트 화면을 갱신할 수 있는 메소드를 호출
							setMemberListTable();
							// 현재 로그인된 사용자를 저장
							// (로그인에 사용된 아이디를 키값으로 지정하여 저장)
							loginMemebersMap.put(loginMember.getMember_id(), loginMember);

							new LoginMemberCheckThread(loginMember, client, in, out).start();
						}

						JDBC_Util_Close.close(conn);

						out.println(Integer.toString(result));
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		this.loginServerThread.start();
	}

	class LoginMemberCheckThread extends Thread {
		private Member loginMember;
		Socket loginClient;
		private BufferedReader in;
		private PrintWriter out;

		public LoginMemberCheckThread(Member loginMember, Socket loginClient, BufferedReader in, PrintWriter out) {
			this.loginMember = loginMember;
			this.loginClient = loginClient;
			this.in = in;
			this.out = out;
		}

		public void run() {
			try {
				// 클라이언트의 접속이 종료되었는지 확인하기 위해 입력을 대기함
				in.readLine();
			} catch (IOException e) {
				logoutForLoginMember(loginMember);

				loginMemebersMap.remove(loginMember.getMember_id());
				memberListClientsMap.remove(loginMember.getMember_id()).close();
				messageListClientsMap.remove(loginMember.getMember_id()).close();
				memberFileListClientsMap.remove(loginMember.getMember_id()).close();
				sharedFileListClientsMap.remove(loginMember.getMember_id()).close();
				
				setMemberListTable();

				try {
					in.close();
					out.close();
					loginClient.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void createRegistServer() {
		try {
			this.registServer = new ServerSocket(PortNumberConstants.REGIST_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		registServerThread = new Thread() {
			public void run() {
				try {
					while (true) {
						Socket client = registServer.accept();
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
						ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

						Member registMember = (Member) in.readObject();

						Connection conn = JDBC_Util_Connection.getConnection();
						MemberDAO dao = MemberDAO.getInstance();

						int result;
						if (dao.isExist(conn, registMember.getMember_id()))
							result = -1;
						else {
							result = dao.insert(conn, registMember);
							JDBC_Util_Close.close(conn);
						}

						out.println(Integer.toString(result));

						out.close();
						in.close();
						client.close();

						if (result == 1)
							setMemberListTable();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		this.registServerThread.start();
	}

	class MemberListSocketClient {
		private Socket client;
		private BufferedReader in;
		private ObjectOutputStream out;

		public Socket getClient() {
			return client;
		}

		public void setClient(Socket client) {
			this.client = client;
		}

		public BufferedReader getIn() {
			return in;
		}

		public void setIn(BufferedReader in) {
			this.in = in;
		}

		public ObjectOutputStream getOut() {
			return out;
		}

		public void setOut(ObjectOutputStream out) {
			this.out = out;
		}

		public void close() {
			try {
				this.in.close();
				this.out.close();
				this.client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void createMemberListServer() {
		try {
			this.memberListServer = new ServerSocket(PortNumberConstants.MEMBER_LIST_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.memberListServerThread = new Thread() {
			public void run() {
				try {
					while (true) {
						Socket memberListClient = memberListServer.accept();

						ObjectOutputStream out = new ObjectOutputStream(
								new BufferedOutputStream(memberListClient.getOutputStream()));

						BufferedReader in = new BufferedReader(
								new InputStreamReader(memberListClient.getInputStream()));

						String member_id = in.readLine();

						out.writeObject(members);
						out.flush();

						MemberListSocketClient client = new MemberListSocketClient();
						client.setClient(memberListClient);
						client.setIn(in);
						client.setOut(out);

						memberListClientsMap.put(member_id, client);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		this.memberListServerThread.start();
	}

	private void createMessageServer() {
		try {
			this.messageServer = new ServerSocket(PortNumberConstants.SEND_MESSAGE_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		messageServerThread = new Thread() {
			public void run() {
				while (true) {
					Connection conn = null;
					try {
						Socket client = messageServer.accept();
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
						ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

						Message_Info message = (Message_Info) in.readObject();

						conn = JDBC_Util_Connection.getConnection();
						Message_InfoDAO dao = Message_InfoDAO.getInstance();

						int result = dao.insert(conn, message);
						out.println(Integer.toString(result));

						out.close();
						in.close();
						client.close();

						if (result == 1 && message.getR_member_id().equals(getLoginID()))
							setMessageListTable(getLoginID());
						else if ( result == 1 && messageListClientsMap.containsKey(message.getR_member_id())) {

							MessageListSocketClient messageClient = messageListClientsMap.get(message.getR_member_id());

							ArrayList<Message_Info> list = dao.select(conn, message.getR_member_id());
							messageClient.getOut().writeObject(list);
							messageClient.getOut().flush();
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}
				}
			}
		};

		this.messageServerThread.start();
	}

	class MessageListSocketClient {
		private Socket client;
		private BufferedReader in;
		private ObjectOutputStream out;

		public Socket getClient() {
			return client;
		}

		public void setClient(Socket client) {
			this.client = client;
		}

		public BufferedReader getIn() {
			return in;
		}

		public void setIn(BufferedReader in) {
			this.in = in;
		}

		public ObjectOutputStream getOut() {
			return out;
		}

		public void setOut(ObjectOutputStream out) {
			this.out = out;
		}

		public void close() {
			try {
				this.in.close();
				this.out.close();
				this.client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void createMessageListServer() {
		try {
			this.messageListServer = 
					new ServerSocket(PortNumberConstants.MESSAGE_LIST_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.messageListServerThread = new Thread() {
			public void run() {

				Connection conn = null;
				while (true) {
					try {
						Socket messageListClient = messageListServer.accept();

						BufferedReader in = new BufferedReader(
								new InputStreamReader(messageListClient.getInputStream()));

						String member_id = in.readLine();

						ObjectOutputStream out = new ObjectOutputStream(
								new BufferedOutputStream(messageListClient.getOutputStream()));

						conn = JDBC_Util_Connection.getConnection();
						Message_InfoDAO dao = Message_InfoDAO.getInstance();

						ArrayList<Message_Info> list = dao.select(conn, member_id);
						out.writeObject(list);
						out.flush();

						MessageListSocketClient client = new MessageListSocketClient();
						client.setClient(messageListClient);
						client.setIn(in);
						client.setOut(out);

						messageListClientsMap.put(member_id, client);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}

				}

			}
		};

		this.messageListServerThread.start();
	}

	private void createDeleteMessageServer() {
		try {
			this.deleteMessageServer = 
					new ServerSocket(PortNumberConstants.DELETE_MESSAGE_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		deleteMessageServerThread = new Thread() {
			public void run() {

				Connection conn = null;

				while (true) {
					try {
						Socket client = deleteMessageServer.accept();
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
						ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

						Message_Info message = (Message_Info) in.readObject();

						conn = JDBC_Util_Connection.getConnection();
						Message_InfoDAO dao = Message_InfoDAO.getInstance();

						int result = dao.delete(conn, message);
						out.println(Integer.toString(result));

						out.close();
						in.close();
						client.close();

						if (result == 1) {
							MessageListSocketClient messageClient = 
									messageListClientsMap.get(message.getR_member_id());
							if (messageClient != null) {
								ArrayList<Message_Info> list = dao.select(conn, message.getR_member_id());
								messageClient.getOut().writeObject(list);
								messageClient.getOut().flush();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}
				}

			}
		};

		this.deleteMessageServerThread.start();
	}

	private void createReadMessageServer() {
		try {
			this.readMessageServer = new ServerSocket(PortNumberConstants.READ_MESSAGE_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		readMessageServerThread = new Thread() {
			public void run() {
				Connection conn = null;

				while (true) {
					try {
						Socket client = readMessageServer.accept();
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
						ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

						Message_Info message = (Message_Info) in.readObject();

						conn = JDBC_Util_Connection.getConnection();
						Message_InfoDAO dao = Message_InfoDAO.getInstance();

						int result = dao.update(conn, message);
						out.println(Integer.toString(result));

						out.close();
						in.close();
						client.close();

						if (result == 1) {
							MessageListSocketClient messageClient = messageListClientsMap.get(message.getR_member_id());
							if (messageClient != null) {
								ArrayList<Message_Info> list = dao.select(conn, message.getR_member_id());
								messageClient.getOut().writeObject(list);
								messageClient.getOut().flush();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}

				}

			}
		};

		this.readMessageServerThread.start();
	}	
	
	class MemberFileListSocketClient {
		private Socket client;
		private BufferedReader in;
		private ObjectOutputStream out;

		public Socket getClient() {
			return client;
		}

		public void setClient(Socket client) {
			this.client = client;
		}

		public BufferedReader getIn() {
			return in;
		}

		public void setIn(BufferedReader in) {
			this.in = in;
		}

		public ObjectOutputStream getOut() {
			return out;
		}

		public void setOut(ObjectOutputStream out) {
			this.out = out;
		}

		public void close() {
			try {
				this.in.close();
				this.out.close();
				this.client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void createMemberFileListServer() {
		try {
			this.memberFileListServer = 
					new ServerSocket(PortNumberConstants.MEMBER_FILE_LIST_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.memberFileListServerThread = new Thread() {
			public void run() {

				Connection conn = null;
				while (true) {
					try {
						Socket memberFileListClient = memberFileListServer.accept();

						BufferedReader in = new BufferedReader(
								new InputStreamReader(memberFileListClient.getInputStream()));

						String member_id = in.readLine();

						ObjectOutputStream out = new ObjectOutputStream(
								new BufferedOutputStream(memberFileListClient.getOutputStream()));

						conn = JDBC_Util_Connection.getConnection();
						Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();

						ArrayList<Data_File_Info> list = dao.select(conn, member_id);
						out.writeObject(list);
						out.flush();

						MemberFileListSocketClient client = new MemberFileListSocketClient();
						client.setClient(memberFileListClient);
						client.setIn(in);
						client.setOut(out);

						memberFileListClientsMap.put(member_id, client);						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}
				}
			}
		};

		this.memberFileListServerThread.start();
	}
	
	class SharedFileListSocketClient {
		private Socket client;
		private BufferedReader in;
		private ObjectOutputStream out;

		public Socket getClient() {
			return client;
		}

		public void setClient(Socket client) {
			this.client = client;
		}

		public BufferedReader getIn() {
			return in;
		}

		public void setIn(BufferedReader in) {
			this.in = in;
		}

		public ObjectOutputStream getOut() {
			return out;
		}

		public void setOut(ObjectOutputStream out) {
			this.out = out;
		}

		public void close() {
			try {
				this.in.close();
				this.out.close();
				this.client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void createSharedFileListServer() {
		try {
			this.sharedFileListServer = 
					new ServerSocket(PortNumberConstants.SHARED_FILE_LIST_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.sharedFileListServerThread = new Thread() {
			public void run() {

				Connection conn = null;
				while (true) {
					try {
						Socket sharedFileListClient = sharedFileListServer.accept();

						BufferedReader in = new BufferedReader(
								new InputStreamReader(sharedFileListClient.getInputStream()));

						String member_id = in.readLine();

						ObjectOutputStream out = new ObjectOutputStream(
								new BufferedOutputStream(sharedFileListClient.getOutputStream()));

						conn = JDBC_Util_Connection.getConnection();
						Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();

						ArrayList<Data_File_Info> list = dao.select(conn, getLoginID());
						out.writeObject(list);
						out.flush();

						SharedFileListSocketClient client = new SharedFileListSocketClient();
						client.setClient(sharedFileListClient);
						client.setIn(in);
						client.setOut(out);

						sharedFileListClientsMap.put(member_id, client);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}
				}
			}
		};

		this.sharedFileListServerThread.start();
	}
	
	private void createDeleteMemberFileServer() {
		try {
			this.deleteMemberFileServer = 
					new ServerSocket(PortNumberConstants.DELETE_MEMBER_FILE_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		deleteMemberFileServerThread = new Thread() {
			public void run() {
				Connection conn = null;

				while (true) {
					try {
						Socket client = deleteMemberFileServer.accept();
						PrintWriter out = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
						ObjectInputStream in = 
								new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

						Data_File_Info info = (Data_File_Info)in.readObject();

						conn = JDBC_Util_Connection.getConnection();
						Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();

						int result = dao.delete(conn, info);
						out.println(Integer.toString(result));

						out.close();
						in.close();
						client.close();

						if (result == 1) {
							MemberFileListSocketClient memberFileListClient = 
									memberFileListClientsMap.get(info.getMember_id());
							if (memberFileListClient != null) {
								ArrayList<Data_File_Info> list = dao.select(conn, info.getMember_id());
								memberFileListClient.getOut().writeObject(list);
								memberFileListClient.getOut().flush();
							}
							
							File file = new File(info.getFile_path());
							file.delete();
							
							if( memberPanel.getSelectedMember_Id() != null ) {
								boolean flag = memberPanel.getSelectedMember_Id().equals(info.getMember_id());					
								if( flag ) {
									setMemberFileDataTable(info.getMember_id());
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						JDBC_Util_Close.close(conn);
					}

				}

			}
		};

		this.deleteMemberFileServerThread.start();
	}	
	
	private class FileTransferThread extends Thread {
		private Socket client;
		private BufferedOutputStream out;
		private ObjectInputStream in;
		
		private BufferedInputStream sourceBuf;
		
		public FileTransferThread(Socket client) {			
			this.client = client;
		}

		public void run() {
			Connection conn = null;
			try {
				out = new BufferedOutputStream(client.getOutputStream());
				in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
	
				Data_File_Info info = (Data_File_Info)in.readObject();
				
				File file = new File(info.getFile_path());
				if( !file.exists() ) {
					out.close();
					in.close();
					client.close();
				}
					
				byte [] buf = new byte[CommonRequiredAttributes.FILE_BUFFER_SIZE];
				sourceBuf = new BufferedInputStream(new FileInputStream(file));
				int readSize = 0;
				while( (readSize = sourceBuf.read(buf, 0, CommonRequiredAttributes.FILE_BUFFER_SIZE)) != -1 ) {
					out.write(buf, 0, readSize);
				}
				
				sourceBuf.close();
				out.close();
				in.close();
				client.close();
	
				conn = JDBC_Util_Connection.getConnection();
				Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();
	
				int result = dao.update(conn, info);
				
				if( result > 0 && info.getMember_id().equals(getLoginID()) ) {
					setSharedFileDataTable(getLoginID());
				} else if( result > 0 && memberFileListClientsMap.containsKey(info.getMember_id()) ) {					
					MemberFileListSocketClient memberFileListClient = 
							memberFileListClientsMap.get(info.getMember_id());
					if (memberFileListClient != null) {						
						ArrayList<Data_File_Info> list = dao.select(conn, info.getMember_id());
						memberFileListClient.getOut().writeObject(list);
						memberFileListClient.getOut().flush();
					}
				}
				
				if( result > 0 && memberPanel.getSelectedMember_Id() != null ) {
					boolean flag = memberPanel.getSelectedMember_Id().equals(info.getMember_id());					
					if( flag ) {
						setMemberFileDataTable(info.getMember_id());
					}
				}
			} catch( Exception e) {
				e.printStackTrace();
			} finally {
				JDBC_Util_Close.close(conn);
			}
		}
	}
	
	private void createDownloadFileServer() {
		try {
			this.downloadFileServer = 
					new ServerSocket(PortNumberConstants.DOWNLOAD_FILE_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		downloadFileServerThread = new Thread() {
			public void run() {
				while (true) {
					try {
						
						Socket client = downloadFileServer.accept();						
						new FileTransferThread(client).start();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};

		this.downloadFileServerThread.start();
	}	
	
	private class FileDownloadThread extends Thread {
		private Socket client;
		private ObjectInputStream in;
		//private BufferedReader br;
		//private BufferedInputStream sourceBuf;		
		
		private BufferedOutputStream targetBuf;
		
		public FileDownloadThread(Socket client) {			
			this.client = client;
		}

		public void run() {
			Connection conn = null;			
			try {
				Calendar cal = Calendar.getInstance();
				
				in = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
				//br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				//sourceBuf = new BufferedInputStream(client.getInputStream());
	
				/*
				String member_id = br.readLine();
				String sourceFileName = br.readLine();
				String targetFileName = br.readLine();
				*/
				String member_id = (String)in.readObject();
				String sourceFileName = (String)in.readObject();
				String targetFileName = (String)in.readObject();
				
				File dir = new File(getSaveDirPath() + member_id);
				if (!dir.exists())
					dir.mkdirs();
						
				File targetFile = new File(dir, targetFileName);			
					
				byte [] buf = new byte[CommonRequiredAttributes.FILE_BUFFER_SIZE];
				targetBuf = new BufferedOutputStream(new FileOutputStream(targetFile));
				
				int readSize = 0;
				while( (readSize = in.read(buf, 0, CommonRequiredAttributes.FILE_BUFFER_SIZE)) != -1 ) {
					targetBuf.write(buf, 0, readSize);
				}
				targetBuf.close();
				
				//sourceBuf.close();
				//br.close();	
				in.close();
				client.close();
				
	
				conn = JDBC_Util_Connection.getConnection();
				Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();
				
				Data_File_Info info = new Data_File_Info();
				info.setFile_name(sourceFileName);
				info.setFile_path(targetFile.getAbsolutePath());
				info.setMember_id(member_id);

				int result = dao.insert(conn, info);
	
				if( result > 0 && memberFileListClientsMap.containsKey(member_id) ) {					
					MemberFileListSocketClient memberFileListClient = 
							memberFileListClientsMap.get(member_id);
					if (memberFileListClient != null) {						
						ArrayList<Data_File_Info> list = dao.select(conn, member_id);
						memberFileListClient.getOut().writeObject(list);
						memberFileListClient.getOut().flush();
					}
				}
				
				if( result > 0 && memberPanel.getSelectedMember_Id() != null ) {
					boolean flag = memberPanel.getSelectedMember_Id().equals(member_id);					
					if( flag ) {
						setMemberFileDataTable(member_id);
					}
				}
			} catch( Exception e) {
				e.printStackTrace();
			} finally {
				JDBC_Util_Close.close(conn);
			}
		}
	}
	
	private void createUploadFileServer() {
		try {
			this.uploadFileServer = 
					new ServerSocket(PortNumberConstants.UPLOAD_FILE_PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		uploadFileServerThread = new Thread() {
			public void run() {
				while (true) {
					try {
						
						Socket client = uploadFileServer.accept();						
						new FileDownloadThread(client).start();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};

		this.uploadFileServerThread.start();
	}	
	
	
	
	public static void main(String[] args) {
		new ServerFrame();
	}
}












