package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ExternalListener_07 implements ActionListener {	
	public void actionPerformed(ActionEvent e) {
		// 독립된 클래스를 정의하여 이벤트를 처리하는 방법
		JButton btn = (JButton)e.getSource();
		btn.setText("버튼 클릭~!");
	}	
}

public class Swing_07 extends JFrame {
	private JButton btn;
	public Swing_07() {
		this.setTitle("익명클래스를 사용한 이벤트 처리");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		this.btn = new JButton("버튼 입니다.");
		//this.btn.addActionListener(new ExternalListener_07());
		//this.btn.addActionListener(new InnerListener_07());
		this.btn.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 익명 클래스를 정의하여 이벤트를 처리하는 방법			
						btn.setText("버튼 클릭~!");
					}	
				}				
			);
		c.add(btn);
		
		this.setSize(200, 100);
		this.setVisible(true);
	}
	
	class InnerListener_07 implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			// 내부 클래스를 정의하여 이벤트를 처리하는 방법			
			btn.setText("버튼 클릭~!");
		}	
	}

	public static void main(String[] args) {		
		new Swing_07();
	}
}







