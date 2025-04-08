class Animal_03 {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}
class Dog_03 extends Animal_03 {
	public void sound() {
		// 자식 클래스의 내부에서는 오버라이딩한 
		// 부모 클래스의 메소드를 호출할 수 있습니다.
		// super.오버라이딩한 메소드명();
		super.sound();
		System.out.println("멍멍");
	}
}
class Cat_03 extends Animal_03 {
	public void sound() {
		// 자식 클래스의 내부에서는 오버라이딩한 
		// 부모 클래스의 메소드를 호출할 수 있습니다.
		// super.오버라이딩한 메소드명();
		super.sound();
		System.out.println("야옹");
	}
}
public class Class_Overriding_03 {
	public static void main(String[] args) {
		Dog_03 dog = new Dog_03();
		Cat_03 cat = new Cat_03();
		
		// 부모 클래스의 메소드를 오버라이딩을 구현하여 재 정의할 경우
		// 자식 클래스의 레퍼런스 변수를 사용하여 호출할 수 없습니다.
		
		dog.sound();
		// 자식 클래스의 레퍼런스 변수를 사용하여 super 키워드를 사용할 수 없습니다.
		// super 키워드는 자식 클래스의 내부에서만 사용 가능한 키워드입니다.
		// dog.super.sound();
		
		cat.sound();
		// cat.super.sound();

	}
}










