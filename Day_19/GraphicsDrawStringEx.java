package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GraphicsDrawStringEx extends JFrame {
	Container contentPane;
	GraphicsDrawStringEx() {
		setTitle("drawString 사용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		
		panel.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				System.out.printf("(%d, %d)\n", e.getX(), e.getY());
			}
		});
		
		contentPane.add(panel , BorderLayout.CENTER);
		setSize(250,200);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밌다.~~", 30,30);
			g.drawString("얼마나? 하늘만큼 땅만큼 !!!!", 60, 60);
		}
	}

	public static void main(String [] args) {
		new GraphicsDrawStringEx();
	}
} 
