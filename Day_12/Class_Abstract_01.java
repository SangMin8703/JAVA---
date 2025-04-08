// 객체지향 언어의 다형성 구현
// 동일한 실행코드의 실행 결과가 실행되는 대상(객체)에 따라서 
// 서로다른 결과를 보이는 것

// Java 언어에서 다형성을 구현하기 위해서 
// 1. 상속( 부모와 자식 클래스의 선언 )
// 2. 메소드 오버라이딩( 자식 클래스에서 부모 클래스의 메소드를 새롭게 재정의 )
// 3. 형변환( 부모 클래스의 레퍼런스를 사용하여 자식 클래스의 객체를 참조 )
// 4. 부모 클래스의 레퍼런스를 사용하여 자식 클래스의 오버라이딩된 메소드 호출

// 상속과 메소드 오버라이딩을 사용한 다형성 구현의 문제점
//  - 메소드 오버라이딩은 강제성의 부재
//  - 자식 클래스에서 부모 클래스의 메소드를 오버라이딩하지 않아도 
//    문법상 문제점이 없음.
//  - 오버라이딩의 구현이 되지않은 것은 프로그램을 실행한 이후에 확인할 수 있음.

// 다형성 구현을 위한 부모 클래스 선언
class Figure_01 {
	// 자식 클래스에서 오버라이딩을 구현해야하는 메소드의 선언
	public void draw() {
		System.out.println("오버라이딩을 구현해야 하는 draw 메소드");
	}
}
// Figure 클래스를 상속받는 자식 클래스의 선언
class Rectangle_01 extends Figure_01 {
	// 다형성 구현을 위한 메소드 오버라이딩 구현
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}
// Figure 클래스를 상속받는 자식 클래스의 선언
class Circle_01 extends Figure_01 {
	// 다형성 구현을 위한 메소드 오버라이딩을 구현하지 않음
}

public class Class_Abstract_01 {
	public static void main(String[] args) {
		Figure_01 [] figure = new Figure_01[5];
		
		figure[0] = new Rectangle_01();
		figure[1] = new Circle_01();
		figure[2] = new Rectangle_01();
		figure[3] = new Circle_01();
		figure[4] = new Rectangle_01();
		
		for( int i = 0 ; i < figure.length ; i++ )
			figure[i].draw();
	}
}
















