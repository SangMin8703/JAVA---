package client.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.util.*;

import common.CommonRequiredMethods;
import jdbc.model.*;
import client.dialogs.SendMessageDialog;

public class MemberPanel extends JPanel {
	CommonRequiredMethods parents;
	
	private JScrollPane scrollPane;
	private JTable table;
	
	private ArrayList<Member> tableDataList = null;
	
	public MemberPanel(CommonRequiredMethods parents) {
		this.parents = parents;
		
		this.setLayout(new BorderLayout());

		Vector<String> columns = new Vector<String>();
		columns.addElement("ID");
		columns.addElement("NAME");
		columns.addElement("STATUS");

		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.table = new JTable(model);	
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.getViewport().setBackground(Color.WHITE);
		
		this.add(this.scrollPane, BorderLayout.CENTER);
		
		setEventListener();
		
		this.setVisible(true);
	}
	
	private void setEventListener() {		
		this.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if( e.getClickCount() < 2 )
					return;
				
				int selectionRowNumber = table.getSelectedRow();				
				String s_member_id = parents.getLoginID();
				String r_member_id = tableDataList.get(selectionRowNumber).getMember_id();
				String r_member_name = tableDataList.get(selectionRowNumber).getName(); 
				
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
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		removeAllRows(model);		
		repaint();
	}
	
	public void setTableRecords(ArrayList<Member> list) {	
		this.tableDataList = list;
		
		Vector<String> row = null;
		DefaultTableModel model = 
				(DefaultTableModel)this.table.getModel();		
		
		removeAllRows(model);
		
		for( int i = 0 ; i < list.size() ; i++ ) {
			row = new Vector<String>();
			row.addElement(list.get(i).getMember_id());
			row.addElement(list.get(i).getName());
			row.addElement(list.get(i).getLogin_status() ? "ON" : "OFF");
			
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
		for( int i = 0 ; i < cntRow ; i++ )
			model.removeRow(0);
	}
}









