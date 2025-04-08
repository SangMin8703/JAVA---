package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Dialog : 간단한 입력 창을 생성하는 경우 사용되는 윈도우 창
// JDialog 클래스를 상속받아 사용자 정의 다이어로그를 생성할 수 있습니다.
// 각각의 다이어로그 객체들을 setVisible 메소드에 의해서
// 화면에 보이거나 감춰질 수 있습니다.(최상위 컨테이너이기 때문에 가능)
// SWING 의 최상위 컨테이너들은 다른 컨테이너에 속하지 않고
// 자신의 윈도우를 화면에 보일수 있습니다.
class Swing_11_Dialog extends JDialog {
	private JLabel nameLabel = new JLabel("이름을 입력하세요 : ");
	private JTextField nameTextFiled = new JTextField(10);
	private JButton okBtn = new JButton("확인");
	
	// 다이어로그 클래스의 생성자 작성 방법
	// 만약 다이어로그가 단독으로 실행되지 않고,
	// 특정 윈도우로부터 실행되는 경우, 해당 부모 컨테이너의 레퍼런스 값을 생성자에 
	// 전달받습니다.
	// 전달받은 부모 윈도우의 레퍼런스는 JDialog 클래스가 제공하는 생성자로 초기화 할 수 있습니다.	
	public Swing_11_Dialog(JFrame parents, String title) {
		// 모달이 아닌 다이어로그 클래스의 객체 생성
		// super(parents, title);
		// 모달 다이어로그 클래스의 객체 생성
		super(parents, title, true);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(nameLabel);
		c.add(nameTextFiled);
		c.add(okBtn);
		
		// OK 버튼을 클릭하면 다이어로그를 화면에서 감춥니다.
		// 다이어로그의 setVisible 메소드에 false 를 전달하면
		// 해당 다이어로그가 화면에서 숨겨지고,
		// 부모 윈도우가 활성화됩니다.
		okBtn.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 다이어로그를 감추는 기능을 구현
						setVisible(false);
					}
				});
				
		this.setSize(300, 100);
	}
}
public class Swing_11 extends JFrame {
	private JFrame frame;
	private JButton dialogBtn = new JButton("다이어로그 실행 버튼");
	
	public Swing_11() {
		this.frame = this;
		this.setTitle("다이어로그 테스트");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());		
		
		c.add(dialogBtn);		
		
		dialogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Swing_11_Dialog dialog = 
						new Swing_11_Dialog(frame, "Swing_11 의 자식 다이어로그");
				dialog.setVisible(true);
				
				// 다이어로그의 객체를 생성한 후 해당 다이어로그의
				// setVisible(true) 메소드를 실행하면
				// 모달이 아닌 다이어로그의 경우 
				// 다음 실행문이 즉시 실행됩니다.
				// 반면 모달 다이어로그의 경우
				// 해당 다이어로그가 종료되지 전까지(setVisible(false) 가 호출)				
				// 다음의 실행문이 실행되지 않습니다.
				System.out.println("다이어로그 실행 완료");
			}
		});		
		
		this.setSize(300, 200);
		this.setVisible(true);
	}	
	
	public static void main(String[] args) {
		new Swing_11();
	}
}









