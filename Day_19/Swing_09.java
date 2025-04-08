package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Swing_09 extends JFrame {	
	private JPanel panel;
	private JLabel label;
	
	public Swing_09() {
		this.setTitle("마우스 이벤트를 활용한 문자열 위치 변경");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.label = new JLabel("Hello");
		this.label.setSize(50, 20);
		this.label.setLocation(10, 10);
		
		this.panel.add(label);
		/*
		this.panel.addMouseMotionListener(
				new MouseMotionAdapter() {					
					public void mouseMoved(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();
						label.setLocation(x, y - 20);
					}					
				}
			);
		*/
		
		this.panel.addMouseListener(
				new MouseAdapter() {					
					public void mouseClicked(MouseEvent e) {
						int x = e.getX();
						int y = e.getY();
						label.setLocation(x, y);
					}
				}
			);
			
		this.setContentPane(this.panel);
		
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Swing_09();
	}
}



