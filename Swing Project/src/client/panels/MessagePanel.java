package client.panels;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import client.dialogs.SendMessageDialog;

import java.util.*;

import common.CommonRequiredMethods;
import common.PortNumberConstants;
import jdbc.JDBC_Util_Close;
import jdbc.JDBC_Util_Connection;
import jdbc.dao.Data_File_InfoDAO;
import jdbc.dao.Message_InfoDAO;
import jdbc.model.*;

public class MessagePanel extends JPanel {
	CommonRequiredMethods parents;

	private JScrollPane messageListScrollPane;
	private JTable messageListTable;
	private JScrollPane messageContentScrollPane;
	private JTextArea messageArea;

	private ArrayList<Message_Info> tableDataList = null;

	public MessagePanel(CommonRequiredMethods parents) {
		this.parents = parents;

		this.setLayout(new BorderLayout());

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 1));

		Vector<String> columns = new Vector<String>();
		columns.addElement("보낸사람");
		columns.addElement("내용");
		columns.addElement("발신날자");
		columns.addElement("확인날자");

		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		this.messageListTable = new JTable(model);
		this.messageListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem deleteItem = new JMenuItem("메세지 삭제");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectionRowNumber = messageListTable.getSelectedRow();
				Message_Info info = tableDataList.get(selectionRowNumber);

				Socket deleteMessagesocket;
				BufferedReader in;
				ObjectOutputStream out;

				try {
					deleteMessagesocket = new Socket(parents.getServerIP(),
							PortNumberConstants.DELETE_MESSAGE_PORT_NUMBER);
					out = new ObjectOutputStream(new BufferedOutputStream(deleteMessagesocket.getOutputStream()));
					in = new BufferedReader(new InputStreamReader(deleteMessagesocket.getInputStream()));

					out.writeObject(info);
					out.flush();

					int result = Integer.parseInt(in.readLine());

					out.close();
					in.close();
					deleteMessagesocket.close();

					if (result == 0) {
						JOptionPane.showMessageDialog(parents.getInstance(), "메세지 삭제 실패\n(관리자에게 확인하세요)", "메세지 삭제",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					JOptionPane.showMessageDialog(parents.getInstance(), "메세지 삭제 성공", "메세지 삭제",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		popupMenu.add(deleteItem);
		this.messageListTable.setComponentPopupMenu(popupMenu);

		this.messageListScrollPane = new JScrollPane(this.messageListTable);
		this.messageListScrollPane.getViewport().setBackground(Color.WHITE);

		this.messageArea = new JTextArea();
		this.messageContentScrollPane = new JScrollPane(this.messageArea);
		this.messageContentScrollPane.getViewport().setBackground(Color.WHITE);

		center.add(messageListScrollPane);
		center.add(messageContentScrollPane);

		this.add(center, BorderLayout.CENTER);

		setEventListener();

		this.setVisible(true);
	}

	private void setEventListener() {
		this.messageListTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (tableDataList == null || tableDataList.size() == 0)
					return;

				int selectionRowNumber = messageListTable.getSelectedRow();
				Message_Info info = tableDataList.get(selectionRowNumber);

				messageArea.setText(info.getContent());

				if (info.getRead_date() == null) {
					Socket readMessagesocket;
					ObjectOutputStream out;

					try {
						readMessagesocket = new Socket(parents.getServerIP(),
								PortNumberConstants.READ_MESSAGE_PORT_NUMBER);
						out = new ObjectOutputStream(new BufferedOutputStream(readMessagesocket.getOutputStream()));

						out.writeObject(info);
						out.flush();

						out.close();
						readMessagesocket.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		
		this.messageListTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if( e.getClickCount() < 2 )
					return;
				
				int selectionRowNumber = messageListTable.getSelectedRow();				
				String s_member_id = parents.getLoginID();
				String r_member_id = tableDataList.get(selectionRowNumber).getS_member_id();
				String r_member_name = tableDataList.get(selectionRowNumber).getS_member_name(); 
				
				if( s_member_id.equals(r_member_id) )
					return;
				
				Message_Info info = new Message_Info();
				info.setS_member_id(s_member_id);				
				info.setR_member_id(r_member_id);
				info.setR_member_name(r_member_name);
				 
				SendMessageDialog messageDialog = 
						new SendMessageDialog(parents.getInstance(), info, parents.getServerIP());
				messageDialog.setVisible(true);				
			}		
		});
	}

	public void initTableRecords() {
		DefaultTableModel model = (DefaultTableModel) this.messageListTable.getModel();
		removeAllRows(model);
		repaint();
	}

	public void setTableRecords(ArrayList<Message_Info> list) {
		this.tableDataList = list;

		Vector<String> row = null;
		DefaultTableModel model = (DefaultTableModel) this.messageListTable.getModel();

		removeAllRows(model);

		for (int i = 0; i < list.size(); i++) {
			row = new Vector<String>();
			row.addElement(list.get(i).getS_member_name());
			row.addElement(list.get(i).getContent());

			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strCreate_date = null;
			String strRead_date = null;
			strCreate_date = transFormat.format(list.get(i).getCreate_date());

			if (list.get(i).getRead_date() == null)
				strRead_date = "확인안함";
			else
				strRead_date = transFormat.format(list.get(i).getRead_date());

			row.addElement(strCreate_date);
			row.addElement(strRead_date);

			model.addRow(row);
		}

		resizeColumnWidth(this.messageListTable);
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
}
