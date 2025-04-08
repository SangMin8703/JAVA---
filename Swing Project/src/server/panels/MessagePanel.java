package server.panels;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.util.*;

import common.CommonRequiredMethods;
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

				Connection conn = JDBC_Util_Connection.getConnection();
				Message_InfoDAO dao = Message_InfoDAO.getInstance();

				dao.delete(conn, info);
				JDBC_Util_Close.close(conn);

				parents.setMessageListTable(parents.getLoginID());
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
					Connection conn = JDBC_Util_Connection.getConnection();
					Message_InfoDAO dao = Message_InfoDAO.getInstance();

					dao.update(conn, info);
					JDBC_Util_Close.close(conn);

					parents.setMessageListTable(info.getR_member_id());
				}
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
