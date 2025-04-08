package swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// 익명클래스
// 객체의 생성 시, 객체의 원형(클래스의 형태 - 클래스의 멤버필드, 멤버 메소드)을 지정하는 방법
// 일반적으로 추상클래스, 인터페이스의 객체를 직접 생성하고자 하는 경우에 사용될 수 있습니다. 
interface Inter_06 {
	public void print();
}
public class Swing_06 {
	public static void main(String[] args) {	
		// 인터페이스는 자신의 객쳇를 생성할 수 없습니다.
		// Inter_06 inter = new Inter_06();
		// 익명클래스를 사용환 인터페이스 객체의 생성
		
		/*
		익명클래스의 작성방법		
		new 클래스/인터페이스명() {
			생성하고자 하는 클래스/인터페이스의 멤버필드 ...
			생성하고자 하는 클래스/인터페이스의 멤버 메소드 ...
		}
		*/
		// 익명 클래스의 사용용도
		// 쓰레드를 생성하기 위해 Runnable 인터페이스를 구현하는 경우
		// 간단한 로직의 쓰레드라면 굳이 새로운 클래스를 생성하는 것이 아닌
		// 익명클래스를 사용하는 방식이 좀 더 편리합니다.
		// 또는 GUI 의 이벤트 리스너를 구현하는 경우
		// 해당 이벤트 리스너의 실행 로직이 간단한 경우
		// 새로운 클래스로 정의하지 않고 익명클래스를 사용하여 코드를 간소화할 수 있습니다.	
		Inter_06 inter = new Inter_06(){
			public void print() {
				System.out.println("익명 클래스를 사용한 인터페이스 객체 생성");
			}
		};
		inter.print();
	}
}













