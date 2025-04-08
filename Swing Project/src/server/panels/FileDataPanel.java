package server.panels;

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

import common.CommonRequiredMethods;
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
	            	
					Connection conn = JDBC_Util_Connection.getConnection();
					try {
						// JDBC 클래스를 활용한 트랜잭션 처리
						// setAutoCommit 메소드의 매개변수에 false 를 전달하면
						// 이후에 처리되는 DML 작업은 commit, rollback 에 의해서 
						// 적용되거나, 일괄 취소될 수 있습니다.
						conn.setAutoCommit(false);
						Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();						
						dao.delete(conn, info);
						
						File file = new File(info.getFile_path());
						file.delete();
						
						// 데이터베이스 테이블에 현재까지 작업한 내용을 일괄 적용시킴
						JDBC_Util_Transaction.commit(conn);
						
					} catch (SQLException e1) {		
						// 예외가 발생한 경우
						// 예외가 발생하기 전까지 진행한 모든 작업을 일괄 취소시킴
						JDBC_Util_Transaction.rollback(conn);
						
						e1.printStackTrace();
						
					} finally {
						JDBC_Util_Close.close(conn);			
					}					
							
					parents.setSharedFileDataTable(parents.getLoginID());                
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
	
	public ArrayList<Data_File_Info> getTableDataList() {
		return tableDataList;
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

				String sourceFileName = info.getFile_path();
				String targetFileName = info.getFile_name();
				File sourceFile = new File(sourceFileName);
				File targetFile = new File(dir, targetFileName);

				long fsize = sourceFile.length();

				FileInputStream fis;
				Connection conn = null;
				try {
					fis = new FileInputStream(sourceFile);
					FileOutputStream fos = new FileOutputStream(targetFile);
					FileChannel fc = fis.getChannel();
					FileChannel fo = fos.getChannel();
					fc.transferTo(0, fsize, fo);

					fis.close();
					fos.close();
					fc.close();
					fo.close();			
					
					conn = JDBC_Util_Connection.getConnection();
					Data_File_InfoDAO dao = Data_File_InfoDAO.getInstance();
					
					dao.update(conn, info);
					
				} catch (Exception ex) {						
					ex.printStackTrace();
				} finally {
					JDBC_Util_Close.close(conn);
				}
				
				parents.setMemberFileDataTable(info.getMember_id());
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

				File dir = new File(parents.getSaveDirPath() + parents.getLoginID());
				if (!dir.exists())
					dir.mkdirs();

				for (int i = 0; i < list.size(); i++) {
					String sourceFileName = list.get(i).toString();
					String targetFileName = cal.getTime().getTime() + "-" + i;
					File sourceFile = new File(sourceFileName);
					File targetFile = new File(dir, targetFileName);

					long fsize = sourceFile.length();

					FileInputStream fis = new FileInputStream(sourceFile);
					FileOutputStream fos = new FileOutputStream(targetFile);
					FileChannel fc = fis.getChannel();
					FileChannel fo = fos.getChannel();
					fc.transferTo(0, fsize, fo);

					fis.close();
					fos.close();
					fc.close();
					fo.close();

					Data_File_Info info = new Data_File_Info();
					info.setFile_name(sourceFile.getName());
					info.setFile_path(targetFile.getAbsolutePath());
					info.setMember_id(parents.getLoginID());

					dao.insert(conn, info);
				}

				// 파일명 출력
				/*
				 * for(int i=0;i < list.size();i++) {
				 * System.out.println(list.size() + "-" + list.get(i)); }
				 */
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBC_Util_Close.close(conn);
			}

			parents.setSharedFileDataTable(parents.getLoginID());
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
