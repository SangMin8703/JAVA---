package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class GraphicsDrawLineEx extends JFrame {
	Container contentPane;
	GraphicsDrawLineEx() {
		setTitle("drawLine 사용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		MyPanel panel = new MyPanel();
		//panel.addMouseListener(panel);
		//panel.addMouseMotionListener(panel);
		
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(200, 150);
		setVisible(true);
	}
	class MyPanel extends JPanel 
		implements MouseListener, MouseMotionListener {
		
		private boolean isStart = false;
		private Point start = null;
		private Point end = null;
		
		public MyPanel() {
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if( this.start == null || this.end == null )
				return;
			
			Color color = null;
			if( this.isStart )
				color = Color.GRAY;
			else
				color = Color.RED;
			g.setColor(color);
			
			g.drawLine((int)start.getX(), (int)start.getY(), 
					(int)end.getX(), (int)end.getY());			
		}
		public void mouseClicked(MouseEvent e) {			
			if( isStart ) {
				// 마우스 클릭이 2번 들어온 경우(마무리)
				isStart = false;
				this.end = new Point(e.getX(), e.getY());	
			} else {
				// 마우스 클릭이 처음 이뤄진 경우
				isStart = true;
				this.start = new Point(e.getX(), e.getY());
			}				
		}
		public void mouseMoved(MouseEvent e) {		
			if( isStart && this.start != null ) {
				this.end = new Point(e.getX(), e.getY());
				super.repaint();
			}
		}
		public void mouseDragged(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}		
	}

	public static void main(String [] args) {
		new GraphicsDrawLineEx();
	}
} 







