class Animal_04 {
	public void sound() {
		System.out.println("소리를 냅니다.");
	}
}
class Dog_04 extends Animal_04 {	
	public void sound() {
		System.out.println("멍멍");
	}
}
class Cat_04 extends Animal_04 {
	public void sound() {
		System.out.println("야옹");
	}
}
public class Class_Overriding_04 {
	public static void main(String[] args) {
		// 클래스 레퍼런스의 형변환과 오버라이딩 메소드
		// 부모 클래스의 레퍼런스는 자식 클래스의 객체를 참조할 수 있습니다.
		// 이때, 부모 클래스의 레퍼런스를 사용하여 자식 클래스에서
		// 오버라이딩한 메소드를 호출할 수 있습니다.
		
		// 부모 클래스의 레퍼런스는 자식 클래스의 객체를 참조할 수 있습니다.
		Animal_04 animal = new Dog_04();
		// 부모 클래스의 레퍼런스를 사용하여 자식 클래스에서 오버라이딩한
		// sound 메소드를 호출하는 예제
		animal.sound();
		
		animal = new Cat_04();
		// 부모 클래스의 레퍼런스를 사용하여 자식 클래스에서 오버라이딩한
		// sound 메소드를 호출하는 예제
		animal.sound();
	}

}

















