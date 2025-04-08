// 인터페이스의 활용
// 1. 다중 상속의 특징을 활용한 다중 부모자식관계의 형성
// 2. 인터페이스의 멤버 필드를 다수개의 클래스에서 공유변수로서 활용

// 다중 상속의 특징을 활용한 다중 부모자식관계의 형성
interface MouseFunction {
	public abstract void mouseMove();
	public abstract void mouseClick();
	public abstract void mouseDbClick();
}
interface KeyboardFunction {
	public abstract void keyPress();
}
class MyApp implements MouseFunction, KeyboardFunction {	
	public void keyPress() {	
		System.out.println("키보드의 버튼이 클릭되었습니다.");
	}
	public void mouseMove() {		
		System.out.println("마우스의 커서가 이동합니다.");
	}	
	public void mouseClick() {		
		System.out.println("마우스의 버튼이 클릭되었습니다.");
	}	
	public void mouseDbClick() {		
		System.out.println("마우스의 버튼이 더블클릭되었습니다.");
	}	
}
public class Class_Interface_06 {
	public static void main(String[] args) {
		// MyApp 클래스는 다중 부모자식관계를 구현한 클래스로
		// 키보드와 마우스의 이벤트를 처리할 수 있도록 구현되었습니다.
		MyApp app = new MyApp();		
		
		// 키보드 이벤트 처리
		// MyApp 클래스는 KeyboardFunction 인터페이스를 구현하고 있기때문에
		// KeyboardFunction 인터페이스의 타입으로 
		// keyPress 메소드를 실행할 수 있습니다.
		KeyboardFunction keyboard = app;
		keyboard.keyPress();
		
		// 마우스 이벤트 처리
		// MyApp 클래스는 MouseFunction 인터페이스를 구현하고 있기때문에
		// MouseFunction 인터페이스의 타입으로 
		// mouseMove, mouseClick, mouseDbClick 메소드를 실행할 수 있습니다.
		MouseFunction mouse = app;
		mouse.mouseMove();
		mouse.mouseClick();
		mouse.mouseDbClick();
	}
}







