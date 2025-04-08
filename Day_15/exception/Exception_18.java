package exception;

import java.util.InputMismatchException;

public class Exception_18 {
	public static void main(String[] args) {
		// 현재 프로그램에서 강제로 발생시키고자 하는 예외처리 클래스의 객체를 생성
		// (예외처리 클래스의 객체를 생성해도, 예외가 발생되는 것이 아닙니다.)
		NullPointerException n1 = new NullPointerException();
		ArithmeticException a1 = new ArithmeticException();
		InputMismatchException i1 = new InputMismatchException();
		
		// 예외의 강제적 발생 방법
		// throw 예외객체;
		//throw n1;
		//throw a1;
		throw i1;
	}
}
