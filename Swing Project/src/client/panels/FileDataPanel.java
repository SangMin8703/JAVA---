package client.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import common.CommonRequiredAttributes;
import common.CommonRequiredMethods;
import common.PortNumberConstants;
import jdbc.JDBC_Util_Close;
import jdbc.JDBC_Util_Connection;
import jdbc.JDBC_Util_Transaction;
import jdbc.dao.Data_File_InfoDAO;
import jdbc.model.*;

public class FileDataPanel extends JPanel implements DropTargetListener {
	CommonRequiredMethods parents;

	private JScrollPane scrollPane;
	private JTable table;
	
	private ArrayList<Data_File_Info> tableDataList = null;

	DropTarget dt;

	public FileDataPanel(
			CommonRequiredMethods parents, 
			boolean isDnd, boolean isDownload, boolean isPopupMenu) {
		this.parents = parents;

		this.setLayout(new BorderLayout());

		Vector<String> columns = new Vector<String>();
		columns.addElement("업로더");
		columns.addElement("파일명");
		columns.addElement("업로드 날자");
		columns.addElement("다운로드 횟수");

		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.table = new JTable(model);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		
		if( isPopupMenu ) {
			JPopupMenu popupMenu = new JPopupMenu();
	        JMenuItem deleteItem = new JMenuItem("파일 삭제");
	        deleteItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int selectionRowNumber = table.getSelectedRow(); 
					Data_File_Info info = tableDataList.get(selectionRowNumber);					
					
					Socket deleteMemberFileSocket = null;
					BufferedReader in = null;
					ObjectOutputStream out = null;
					try {
						deleteMemberFileSocket = 
							new Socket(parents.getServerIP(), 
									PortNumberConstants.DELETE_MEMBER_FILE_PORT_NUMBER);
						
						out = new ObjectOutputStream(
								new BufferedOutputStream(deleteMemberFileSocket.getOutputStream()));
						
						out.writeObject(info);
						out.flush();
						
						in = new BufferedReader(
								new InputStreamReader(deleteMemberFileSocket.getInputStream()));
						int result = Integer.parseInt(in.readLine());
						
						in.close();
						out.close();
						deleteMemberFileSocket.close();
						
						if( result > 0 ) {
							JOptionPane.showMessageDialog(
									parents.getInstance(), "파일 삭제 성공", "사용자 파일 삭제", 
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(
									parents.getInstance(), "파일 삭제 실패\n(관리자에게 확인하세요)", "사용자 파일 삭제", 
									JOptionPane.ERROR_MESSAGE);
						}					
					} catch (Exception ex) {
						ex.printStackTrace();
					}                
	            }
	        });
	        popupMenu.add(deleteItem);
	        this.table.setComponentPopupMenu(popupMenu);
		}

		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.getViewport().setBackground(Color.WHITE);

		this.add(this.scrollPane, BorderLayout.CENTER);

		if (isDnd) {
			dt = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, this, true, null);
		}

		if( isDownload ) {
			setEventListener();
		}
		
		this.setVisible(true);
	}
	
	private void setEventListener() {
		this.table.addMouseListener(new MouseAdapter() {				
			public void mouseClicked(MouseEvent e) {
				if( e.getClickCount() < 2 || tableDataList == null )
					return;
				
				int selectionRowNumber = table.getSelectedRow(); 
				Data_File_Info info = tableDataList.get(selectionRowNumber);									
				
				File dir = new File(parents.getDownloadDirPath() + info.getMember_id());
				if (!dir.exists())
					dir.mkdirs();
				
				String targetFileName = info.getFile_name();				
				File targetFile = new File(dir, targetFileName);				
				
				BufferedOutputStream targetBos;				
				byte [] buf = new byte[CommonRequiredAttributes.FILE_BUFFER_SIZE];
				
				Socket downloadFileSocket = null;
				BufferedInputStream in = null;
				ObjectOutputStream out = null;				
				
				int readSize = 0;
				try {
					targetBos = new BufferedOutputStream(new FileOutputStream(targetFile));
					
					downloadFileSocket = 
						new Socket(parents.getServerIP(), 
								PortNumberConstants.DOWNLOAD_FILE_PORT_NUMBER);
					
					out = new ObjectOutputStream(
							new BufferedOutputStream(downloadFileSocket.getOutputStream()));
					
					out.writeObject(info);
					out.flush();
					
					in = new BufferedInputStream(downloadFileSocket.getInputStream());
					
					while( (readSize = in.read(buf, 0, CommonRequiredAttributes.FILE_BUFFER_SIZE)) != -1 ) {
						targetBos.write(buf, 0, readSize);
					}
					
					targetBos.close();
					
					in.close();
					out.close();
					downloadFileSocket.close();
					
					JOptionPane.showMessageDialog(
							parents.getInstance(), "파일 다운로드 성공", "파일 다운로드", 
							JOptionPane.INFORMATION_MESSAGE);						
				} catch (Exception ex) {
					ex.printStackTrace();
					
					JOptionPane.showMessageDialog(
							parents.getInstance(), "파일 다운로드 실패\n(관리자에게 확인하세요)", "파일 다운로드", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void initTableRecords() {
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		removeAllRows(model);
		repaint();
	}

	public void setTableRecords(ArrayList<Data_File_Info> list) {
		this.tableDataList = list;
		Vector<String> row = null;
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();

		removeAllRows(model);

		for (int i = 0; i < list.size(); i++) {
			row = new Vector<String>();
			row.addElement(list.get(i).getMember_name());
			row.addElement(list.get(i).getFile_name());

			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strUpload_date = null;
			strUpload_date = transFormat.format(list.get(i).getUpload_date());

			row.addElement(strUpload_date);
			row.addElement(Integer.toString(list.get(i).getDownload_count()));

			model.addRow(row);
		}

		resizeColumnWidth(this.table);
		repaint();
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

	public void removeAllRows(DefaultTableModel model) {
		int cntRow = model.getRowCount();
		for (int i = 0; i < cntRow; i++)
			model.removeRow(0);
	}

	@Override
	public void drop(DropTargetDropEvent dtde) {
		// System.out.println("dragDrop");
		if ((dtde.getDropAction() & DnDConstants.ACTION_COPY_OR_MOVE) != 0) {
			dtde.acceptDrop(dtde.getDropAction());
			Transferable tr = dtde.getTransferable();

			Connection conn = JDBC_Util_Connection.getConnection();
			Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();

			try {
				Calendar cal = Calendar.getInstance();
				// 파일명 얻어오기
				java.util.List list = (java.util.List) tr.getTransferData(DataFlavor.javaFileListFlavor);
								
				byte [] buf = new byte[CommonRequiredAttributes.FILE_BUFFER_SIZE];
				int readSize = 0;
				for (int i = 0; i < list.size(); i++) {					
					String sourceFileName = list.get(i).toString();
					String targetFileName = cal.getTime().getTime() + "-" + i;
					File sourceFile = new File(sourceFileName);				
									
					Socket fileUploadclient = 
						new Socket(parents.getServerIP(), PortNumberConstants.UPLOAD_FILE_PORT_NUMBER);
					
					ObjectOutputStream out = 
						new ObjectOutputStream(
							new BufferedOutputStream(
								fileUploadclient.getOutputStream()));
					
					out.writeObject(parents.getLoginID());
					out.writeObject(sourceFile.getName());
					out.writeObject(targetFileName);
					/*
					PrintWriter pw = new PrintWriter(
							new BufferedWriter(
								new OutputStreamWriter(
									fileUploadclient.getOutputStream())), true);
					pw.println(parents.getLoginID());
					pw.println(sourceFile.getName());
					pw.println(targetFileName);
					
					BufferedOutputStream bos = 
							new BufferedOutputStream(fileUploadclient.getOutputStream());
					*/
					
					BufferedInputStream sourceBuf = new BufferedInputStream(new FileInputStream(sourceFile));
					
					while( (readSize = sourceBuf.read(buf, 0, CommonRequiredAttributes.FILE_BUFFER_SIZE)) != -1 ) {
						out.write(buf, 0, readSize);						
					}
					out.close();									
					//pw.close();
					fileUploadclient.close();
					
					sourceBuf.close();
				}

				// 파일명 출력
				/*
				 * for(int i=0;i < list.size();i++) {
				 * System.out.println(list.size() + "-" + list.get(i)); }
				 */
				JOptionPane.showMessageDialog(
						parents.getInstance(), "파일 업로드 성공", "파일 업로드", 
						JOptionPane.INFORMATION_MESSAGE);						
			} catch (Exception ex) {
				ex.printStackTrace();
				
				JOptionPane.showMessageDialog(
						parents.getInstance(), "파일 업로드 실패\n(관리자에게 확인하세요)", "파일 업로드", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// System.out.println("dragEnter");
	}
	@Override
	public void dragExit(DropTargetEvent dte) {
		// System.out.println("dragExit");
	}
	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// System.out.println("dragOver");
	}
	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// System.out.println("dragActionChanged");
	}
}
