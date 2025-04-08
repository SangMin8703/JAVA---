// 메소드 오버라이딩
// 상속 관계에서만 구현이 가능한 문법
//  - 부모 클래스에서 물려받은 메소드를 
//    자식 클래스에서 새롭게 재정의하는 문법
// 사용법
// 부모 클래스에서 물려받은 메소드의 원형을 자식클래스에서
// 새롭게 정의합니다.
//  - 부모 클래스에서 물려받은 메소드와 동일한 메소드를 자식클래스에서 새롭게 정의하는 문법
// (메소드의 원형 -> 메소드의 리턴타입, 메소드명, 메소드의 매개변수)

class Animal_02 {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}
// Animal_02 클래스를 상속받는 
// 각각의 동물 클래스들의 구현
class Dog_02 extends Animal_02 {
	// 강아지 클래스에서는 sound 메소드의 실행 결과를 "멍멍" 으로 변경하고자 하는 목적으로
	// 메소드 오버라이딩을 구현
	public void sound() {
		System.out.println("멍멍");
	}
}
class Cat_02 extends Animal_02 {
	// 고양이 클래스에서는 sound 메소드의 실행 결과를 "야옹" 으로 변경하고자 하는 목적으로
	// 메소드 오버라이딩을 구현
	public void sound() {
		System.out.println("야옹");
	}
}
public class Class_Overriding_02 {
	public static void main(String[] args) {
		Dog_02 dog = new Dog_02();
		Cat_02 cat = new Cat_02();
		
		dog.sound();
		cat.sound();
	}
}






