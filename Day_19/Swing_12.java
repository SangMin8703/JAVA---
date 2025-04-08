package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 탭 컴포넌트에 넣어줄 패널을 작성하는 예제

// 일반적으로 JPanel 클래스를 상속받아 구현합니다.
// 첫번째 탭에 보이게 될 JPanel
class Tab1Panel extends JPanel {
	private JLabel title = new JLabel("첫번째 탭의 타이틀");
	private JTextField text = new JTextField(10);

	public Tab1Panel() {
		this.add(this.title);
		this.add(this.text);		
	}
	// JPanel 클래스를 상속받아 작성하는 자식클래스는
	// 해당 JPanel 이 화면에 보일 내용을 직접 구현해야만합니다.
	// paintComponent 메소드는
	// 해당 Component 가 어떻게 화면에 보일것이지를 구현하는 메소드입니다.
	protected void paintComponent(Graphics g) {
		// paintComponent 메소드의 첫번째 실행라인은 
		// 부모클래스인 JPanel 클래스의 paintComponent 메소드를
		// 호출합니다.
		// super.paintComponent(g); 
		// 실행라인에 의해서 기본적인 초기화 과정이 수행됩니다.
		super.paintComponent(g);
		//this.setEnabled(true);
	}	
	public String getText() {
		String r = this.text.getText();
		if( r == null )
			return null;
		else
			return r.trim();
	}
}
// 두번째 탭에 보이게 될 JPanel
class Tab2Panel extends JPanel {
	private JLabel title = new JLabel("두번째 탭의 타이틀");
	private JTextField text = new JTextField(10);

	public Tab2Panel() {
		this.add(this.title);
		this.add(this.text);		
	}
	
	// JPanel 클래스를 상속받아 작성하는 자식클래스는
	// 해당 JPanel 이 화면에 보일 내용을 직접 구현해야만합니다.
	// paintComponent 메소드는
	// 해당 Component 가 어떻게 화면에 보일것이지를 구현하는 메소드입니다.
	protected void paintComponent(Graphics g) {
		// paintComponent 메소드의 첫번째 실행라인은 
		// 부모클래스인 JPanel 클래스의 paintComponent 메소드를
		// 호출합니다.
		// super.paintComponent(g); 
		// 실행라인에 의해서 기본적인 초기화 과정이 수행됩니다.
		super.paintComponent(g);
		
	}	
	public String getText() {
		String r = this.text.getText();
		if( r == null )
			return null;
		else
			return r.trim();
	}
}
// 세번째 탭에 보이게 될 JPanel
class Tab3Panel extends JPanel {
	private JLabel title = new JLabel("세번째 탭의 타이틀");
	private JTextField text = new JTextField(10);

	public Tab3Panel() {
		this.add(this.title);
		this.add(this.text);		
	}
	// JPanel 클래스를 상속받아 작성하는 자식클래스는
	// 해당 JPanel 이 화면에 보일 내용을 직접 구현해야만합니다.
	// paintComponent 메소드는
	// 해당 Component 가 어떻게 화면에 보일것이지를 구현하는 메소드입니다.
	protected void paintComponent(Graphics g) {
		// paintComponent 메소드의 첫번째 실행라인은 
		// 부모클래스인 JPanel 클래스의 paintComponent 메소드를
		// 호출합니다.
		// super.paintComponent(g); 
		// 실행라인에 의해서 기본적인 초기화 과정이 수행됩니다.
		super.paintComponent(g);
		
	}	
	public String getText() {
		String r = this.text.getText();
		if( r == null )
			return null;
		else
			return r.trim();
	}
}
public class Swing_12 extends JFrame {
	private Tab1Panel tab1 = new Tab1Panel();
	private Tab2Panel tab2 = new Tab2Panel();
	private Tab3Panel tab3 = new Tab3Panel();
	private JTabbedPane tabPane = new JTabbedPane();	
	public Swing_12() {
		this.setTitle("TAB 컴포넌트의 사용 예쩨");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tabPane.addTab("tab1", tab1);
		tabPane.addTab("tab2", tab2);
		tabPane.addTab("tab3", tab3);
		
		Container c = this.getContentPane();		
		c.add(tabPane);	
		
		this.setSize(300, 300);
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new Swing_12();
	}
}











