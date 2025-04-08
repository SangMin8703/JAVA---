package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 버튼에 마우스의 커서가 진입하고 벗어날때를 처리하기 위한 이벤트 리스너 클래스
class CustomMouseEventListener_A implements MouseListener {
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}	
	public void mouseReleased(MouseEvent e) {}	
	// 마우스 커서가 특정 컴포넌트의 영역에 진입했을 때 호출
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.RED);
	}
	// 마우스 커서가 특정 컴포넌트의 영역에서 벗어날 때 호출
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.BLUE);		
	}
}
class CustomMouseEventListener_B implements MouseListener {
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}	
	public void mouseReleased(MouseEvent e) {}	
	// 마우스 커서가 특정 컴포넌트의 영역에 진입했을 때 호출
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setText("마우스 커서 ENTER");
	}
	// 마우스 커서가 특정 컴포넌트의 영역에서 벗어날 때 호출
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setText("마우스 커서 OUT");		
	}
}
public class Swing_02 extends JFrame {
	private JButton btn;
	
	public Swing_02() {
		this.setTitle("MOUSE EVENT 처리");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.btn = new JButton("Mouse Event 처리 버튼");
		this.btn.setBackground(Color.BLUE);
		this.btn.addMouseListener(new CustomMouseEventListener_A());
		this.btn.addMouseListener(new CustomMouseEventListener_B());
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(btn);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {		
		new Swing_02();
	}
}










