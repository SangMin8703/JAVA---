package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Swing_10 extends JFrame {
	private JLabel msg = new JLabel("실행된 메뉴의 이름이 출력됩니다.");
	
	public Swing_10() {
		this.setTitle("메뉴 기능 실행 테스트");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(msg);
		
		createMenu();
		
		this.setSize(300, 200);
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem [] fileItems = new JMenuItem[4];
		String [] fileItemNames = {"New", "Open", "Save", "Close"};
		
		for( int i = 0 ; i < fileItems.length ; i++ ) {
			fileItems[i] = new JMenuItem(fileItemNames[i]);			
			// 메뉴의 클릭시 이벤트 처리를 위한 리스너 등록
			fileItems[i].addActionListener(new InnerMenuItemListener());			
			fileMenu.add(fileItems[i]);
		}
		bar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		bar.add(editMenu);
		bar.add(sourceMenu);		
		this.setJMenuBar(bar);		
	}	
	class InnerMenuItemListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			// ActionEvent 클래스의 getActionCommand 메소드
			// 선택된 메뉴의 문자열을 반환하는 메소드
			String menuName = e.getActionCommand();
			msg.setText(menuName);
		}
	}
	
	public static void main(String[] args) {
		new Swing_10();
	}
}





