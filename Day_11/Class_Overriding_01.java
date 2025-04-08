// 상속을 구현하는 경우 문제점
// 상속이란 다른 클래스의 기능을 다른 클래스에게 물려주는 문법입니다.
// 상속을 구현하는 경우, 다수 개의 자식클래스들의 공통기능 묶어서 
// 부모클래스로 정의하고 각각의 자식클래스는 
// 공통되는 속성, 기능을 부모클래스로부터 물려받아 사용하게 됩니다.

// 이러한 경우에 각각의 자식 클래스들은 독립되는(개별적인) 성격의 기능을 수행할 수 없게 됩니다.
class Animal_01 {
	// 모든 동물들은 소리를 낼 수 있기 때문에
	// 부모클래스인 Animal_01 클래스에
	// 공통 기능인 sound 메소드를 정의합니다.
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}
// Animal_01 클래스를 상속받는 
// 각각의 동물 클래스들의 구현
class Dog_01 extends Animal_01 {}
class Cat_01 extends Animal_01 {}

public class Class_Overriding_01 {
	public static void main(String[] args) {		
		Dog_01 dog = new Dog_01();
		Cat_01 cat = new Cat_01();
		
		dog.sound();
		cat.sound();
	}
}










