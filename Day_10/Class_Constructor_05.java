// 생성자 오버로딩
// 생성자는 메소드입니다.
// 일반 메소드와는 용도가 다른 메소드
//  - 리턴값의 타입이 존재하지 않는 메소드
//  - 메소드 이름이 클래스 명과 일치해야 합니다.
//  - 각 객체의 생성 시, 단 한번만 실행이 되고 
//    그 이후에는 명시적인 호출이 불가능합니다

// 생성자는 일반 메소드와 다른 몇몇 특징들을 가지고 있지만
// 메소드의 일종이기 때문에, 메소드의 오버로딩이 가능합니다.

// 하나의 클래스는 다수 개의 생성자를 포함할 수 있습니다. 
class Constructor_E {
	// 매개변수를 사용하지 않는 디폴트 생성자
	public Constructor_E() {		
		System.out.println("Constructor_E() 생성자 호출");
	}
	// int 타입 한개를 매개변수로 사용하는 생성자
	public Constructor_E(int i) {		
		System.out.println("Constructor_E(int i) 생성자 호출");
	}	
}
public class Class_Constructor_05 {
	public static void main(String[] args) {
		// 디폴트 생성자를 사용하여 객체를 생성
		Constructor_E c1 = new Constructor_E();		
		// int 타입의 매개변수를 사용하는 생성자를 통한 객체의 생성
		Constructor_E c2 = new Constructor_E(10);
	}
}






