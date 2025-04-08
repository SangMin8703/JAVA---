package generic;

// Generic 문법
// 타입을 지정하지 않고 클래스를 선언할 수 있는 문법
// C++ 템플릿과 유사한 문법

// 동일한 기능을 제공하는 클래스가 멤버 필드나, 멤버 메소드의 타입에 따라서
// 여러 개를 구현해야하는 경우에 유용하게 사용될 수 있습니다.

// 아래의 두 Model 클래스의 경우
// 완전히 동일한 기능을 제공하는 클래스들이지만
// 멤버필드의 타입이 다르기 때문에
// 서로 다른 클래스로 선언해야만 합니다.

// 이러한 경우 Generic 을 사용하면
// 하나의 클래스를 선언하여 다양한 타입으로 사용될 수 있습니다.
class Generic_01_Model_A {
	private int data;
	public Generic_01_Model_A(int data) {
		this.data = data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return this.data;
	}
}
class Generic_01_Model_B {
	private String data;
	public Generic_01_Model_B(String data) {
		this.data = data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return this.data;
	}
}
// Generic을 사용한 클래스의 선언
// class 클래스명<제네릭타입>
//  - 제네릭타입 : 타입이 객체를 생성할 때 지정되는 것으로
//              제네릭 타입은 어떠한 타입도 올 수 있습니다.
//  - 제네릭타입으로 지정된 키워드(T)는 클래스의 내부에서
//    멤버필드의 타입이나, 메소드의 매개변수, 메소드의 리턴값의 타입등에 사용됩니다.
class Generic_01_Model<T> {
	// 제네릭타입을 사용한 멤버 필드의 선언
	// 객체가 생성될 때 형이 정해집니다.
	private T data;
	// 생성자의 매개변수에 제네릭타입을 사용
	public Generic_01_Model(T data) {
		this.data = data;
	}
	// 일반 메소드의 매개변수에 제네릭타입을 사용
	public void setData(T data) {
		this.data = data;
	}
	// 메소드의 리턴값의 타입에 제네릭타입을 사용
	public T getData() {
		return this.data;
	}
}
public class Generic_01 {
	public static void main(String[] args) {		
		// 제네릭타입을 지정한 클래스의 객체 생성
		// 클래스명<제네릭타입> 레퍼런스변수명 = new 클래스명<제네릭타입>(생성자의 매개변수);
		Generic_01_Model<Double> model01;
		Generic_01_Model<String> model02;
		
		// 제네릭 타입을 지정한 클래스의 객체 생성
		// 1. 레퍼런스 변수명 = new 클래스명<제네릭타입>(생성자 매개변수);
		// 2. 레퍼런스 변수명 = new 클래스명<>(생성자 매개변수);
		// 2번을 사용하여 객체를 생성하는 경우가 많습니다.
		
		// 제네릭 타입을 지정한 클래스는 
		// 클래스의 변수 선언시 지정한 제네릭타입으로 자동 변환됩니다.
		// 아래의 생성자 호출 코드는 T의 자리가 Double 로 변경되어 처리됩니다.
		model01 = new Generic_01_Model<Double>(1.1);
		// 아래의 생성자 호출 코드는 T의 자리가 String 로 변경되어 처리됩니다.
		model02 = new Generic_01_Model<>("Generic");
		
		System.out.printf("model01.data = %.2f\n", model01.getData());
		System.out.printf("model02.data = %s\n", model02.getData());
	}
}











