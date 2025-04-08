package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 외부에 리스너 클래스를 작성하는 이벤트 처리의 코드에 제약이 생길수 있습니다.
// 그 이유는 이벤트 객체를 사용해 접근할 수 있는 컴포넌트는 이벤트가 발생된 컴포넌트에
// 한정되기 때문입니다.
// 만약 버튼 위에 마우스의 커서가 이동하여 이벤트가 발생한 경우
// Swing_03 클래스의 JTextField 의 값을 변경하려면
// 접근할 수 있는 방법이 제공되지 않습니다.

// 이러한 문제를 해결하기 위해서는 이벤트가 발생하는 JFrame 객체를 참조할 수 있어야만 합니다.
// 1. 이벤트 리스너 클래스의 내부에 JFrame 클래스의 레퍼런스를 사용
// 2. 내부 클래스, 익명 클래스를 사용하여 리스너를 작성
class ExternalListener implements MouseListener {
	private Swing_03 frame;
	public ExternalListener(Swing_03 frame) {
		this.frame = frame;
	}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}	
	public void mouseReleased(MouseEvent e) {}	
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setText("마우스 커서 ENTER");
		// textField 멤버는 private 멤버이기 때문에 직접적인 접근이 제한됩니다.
		// this.frame.textField.setText("마우스 커서 ENTER");
		this.frame.getTextField().setText("마우스 커서 ENTER");
	}
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		btn.setText("마우스 커서 OUT");		
		// textField 멤버는 private 멤버이기 때문에 직접적인 접근이 제한됩니다.
		// this.frame.textField.setText("마우스 커서 OUT");
		this.frame.getTextField().setText("마우스 커서 OUT");
	}
}
public class Swing_03 extends JFrame {
	private JButton btn;
	private JTextField textField;
	
	public Swing_03() {
		this.setTitle("이벤트 리스너 처리(외부 클래스를 사용)");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.btn = new JButton("Mouse Event 처리 버튼");	
		this.btn.addMouseListener(new ExternalListener(this));
		this.textField = new JTextField();
		this.textField.setColumns(10);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(this.btn);
		c.add(this.textField);
		
		this.setSize(500, 150);
		this.setVisible(true);
	}	
	public JButton getBtn() {
		return btn;
	}
	public JTextField getTextField() {
		return textField;
	}
	public static void main(String[] args) {
		new Swing_03();
	}
}


