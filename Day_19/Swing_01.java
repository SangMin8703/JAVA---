package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// JFrame 클래스를 상속받는 클래스는 화면에 GUI 형태로 출력될 수 있는 클래스입니다.
public class Swing_01 extends JFrame {
	
	public Swing_01() {
		// X 버튼이 클릭될 경우 GUI 프로그램을 완전히 종료합니다.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("JFram 클래스를 사용한 GUI 구현");		
		this.setSize(300,300);
		
		// GUI 요소를 포함시킬 수 있는 컨테이너 객체를 반환
		Container c = this.getContentPane();
		
		JButton btn = new JButton("Click");
		c.add(btn);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {		
		Swing_01 gui = new Swing_01();
	}
}






