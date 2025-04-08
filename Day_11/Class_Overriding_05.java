import java.util.Scanner;

// 도형 클래스 부모 클래스 선언
class Figure {
	// 도형을 그리는 기능을 정의
	// 모든 개별적인 도형 클래스들은 Figure 클래스의 draw 메소드를
	// 오버라이딩하여 각가의 도형을 그립니다.
	public void draw() {}
}
// 각각의 도형 클래스들을 선언
class Rectangle extends Figure {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}
class Circle extends Figure {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}
class Triangle extends Figure {
	public void draw() {
		System.out.println("삼각형을 그립니다.");
	}
}
public class Class_Overriding_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사용자로부터 입력받을 도형의 배열을 선언
		Figure [] figure = new Figure[10];
		
		for( int i = 0 ; i < figure.length ; i++ ) {
			System.out.println("1. 사각형");
			System.out.println("2. 삼각형");
			System.out.println("3. 원");
			System.out.printf("%d 번째 도형을 입력하세요 : ", i+1);
			
			switch( sc.nextInt() ) {
				case 1:
					figure[i] = new Rectangle();
					break;
				case 2:
					figure[i] = new Triangle();
					break;
				case 3:
					figure[i] = new Circle();
					break;
				default:
					i--;	// 배열의 인덱스 조정
					continue;
			}
		}
		
		for( int i = 0 ; i < figure.length ; i++ ) {
			// 다형성의 구현
			// 동일한 실행코드의 결과가
			// 실행되는 대상(객체)에 따라서 서로 다른 결과를 보이는 것.
			figure[i].draw();
		}
	}
}













