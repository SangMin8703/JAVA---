package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Swing_05 extends JFrame {
	private JLabel label;	
	private JTextField num1;
	private JTextField num2;
	private JTextField buho;
	private JTextField result;	
	private JButton btn;
	
	public Swing_05() {
		this.setTitle("사칙연산 계산기");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// UI 를 구성하는 컴포넌트의 객체를 생성
		label = new JLabel("=");		
		num1 = new JTextField(5);
		num2 = new JTextField(5);
		buho = new JTextField(1);
		result = new JTextField(7);
		btn = new JButton("계산 실행");
		btn.addActionListener(new CalculatorListener());
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(2, 1));
		
		// JPanel 클래스
		// 컨테이너의 일종으로 하나의 프레임 내부에 복잡한 UI를 구성하는 경우
		// 다수개의 JPanel 객체를 생성하여 각 화면을 구현할 수 있습니다.
		JPanel panel_Up = new JPanel();
		GridLayout grid = new GridLayout(1, 5);
		grid.setHgap(3);		
		panel_Up.setLayout(grid);
		
		JPanel panel_Label = new JPanel();
		panel_Label.add(label);
		
		panel_Up.add(num1); panel_Up.add(buho); panel_Up.add(num2);
		panel_Up.add(panel_Label); panel_Up.add(result);
		
		JPanel panel_Down = new JPanel();
		panel_Down.add(btn);
		
		c.add(panel_Up);
		c.add(panel_Down);
		
		this.setSize(350, 100);
		this.setVisible(true);
	}
	
	class CalculatorListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			
			String strNum1 = num1.getText().trim();
			double nNum1 = Double.parseDouble(strNum1);
			
			String strNum2 = num2.getText().trim();
			double nNum2 = Double.parseDouble(strNum2);
			
			String strBuho = buho.getText().trim();
			
			double dResult = 0;
			if( strBuho.equals("+") )
				dResult = nNum1 + nNum2;
			else if( strBuho.equals("-") )
				dResult = nNum1 - nNum2;
			else if( strBuho.equals("*") )
				dResult = nNum1 * nNum2;
			else if( strBuho.equals("/") )
				dResult = nNum1 / nNum2;
			
			result.setText(Double.toString(dResult));
		}		
	}
	
	public static void main(String[] args) {		
		new Swing_05();
	}
}









