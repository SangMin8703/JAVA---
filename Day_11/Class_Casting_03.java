// 클래스 레퍼런스 변수간의 형변환
// 기본적으로 클래스의 레퍼런스 변수간에는 형변환이 허용되지 않습니다.
// 하지만 상속관계의 클래스 사이에서는 예외적으로 형변환이 허용됩니다.
class Casting_03_Super {
	int nSuper;
}
class Casting_03_Sub extends Casting_03_Super {
	int nSub;
}
public class Class_Casting_03 {
	public static void main(String[] args) {	
		// 클래스의 레퍼런스 변수의 의미
		//  - 특정 클래스의 레퍼런스 변수는
		//    해당 클래스의 모든 멤버들에 접근할 수 있는 권한을 가진 변수
		
		// 1. 부모 클래스의 객체를 자식 클래스의 레퍼런스 변수에 대입하는 경우
		//  - 자식클래스의 레퍼런스는 부모클래스의 객체를 참조할 수 없습니다.
		//   (자식클래스의 레퍼런스는 부모클래스의 멤버 + 자식클래스의 멤버에 접근할 수 있는
		//    레퍼런스 변수이기 때문에, 부모클래스의 객체만으로는 접근할 수 모든 멤버를 
		//    충족할 수 없습니다.)
		// Casting_03_Sub sub1 = new Casting_03_Super();
		
		// 2. 자식 클래스의 객체를 부모 클래스의 레퍼런스 변수에 대입하는 경우
		//  - 부모클래스의 레퍼런스는 자식클래스의 객체를 참조할 수 있습니다.
		//   (자식클래스의 객체에는 부모클래스의 모든 멤버가 포함되어 있기 때문에
		//    부모클래스의 레퍼런스가 접근할 수 있는 권한을 충족할 수 있습니다.)
		Casting_03_Super super1 = new Casting_03_Sub();
		
		// 부모클래스의 레퍼런스를 사용하여 접근할 수 있는 자식클래스의 멤버
		// a. 부모클래스의 레퍼런스를 사용하여 부모클래스의 멤버에 접근할 수 있습니다.		
		super1.nSuper = 100;
		// b. 부모클래스의 레퍼런스는 부모클래스의 멤버만을 인지하기 때문에
		//    자식클래스에서 추가시킨 멤버에는 접근할 수 없습니다.
		// super1.nSub = 200;			
		System.out.printf("super1.nSuper = %d\n", super1.nSuper);
		
		// 만약, 부모클래스의 레퍼런스 변수가 참조하는 객체의 타입이 자식클래스의 객체라면
		// 강제 형변환을 사용하여 자식클래스의 레퍼런스에 대입할 수 있습니다.
		Casting_03_Sub sub1 = (Casting_03_Sub)super1;		
		System.out.printf("sub1.nSuper = %d\n", sub1.nSuper);
		
		// 상속관계의 레퍼런스 변수간 강제 형변환시 주의점
		// 만약, 부모클래스의 레퍼런스 변수가 실제로 참조하는 객체의 타입이 
		// 자식 클래스가 아니라면 런타임 에러가 발생합니다.
		
		// 아래의 예는 부모클래스의 객체를 강제캐스팅을 사용해 
		// 자식클래스의 레퍼런스 변수에 대입하는 예제입니다.
		// 이런 경우, 문법상으로는 옳바른 표현이지만
		// 실제로 캐스팅을 하는 순간 형변환 에러가 발생되어 프로그램이 종료됩니다.
		Casting_03_Super super2 = new Casting_03_Super();
		// 에러가 발생되는 코드
		// ClassCastException 이 발생
		// Casting_03_Sub sub2 = (Casting_03_Sub)super2;
		
		// 이러한 형변환 에러를 방지하기 위해서
		// instanceof 연산자를 사용할 수 있습니다.
		// 레퍼런스변수 instanceof 클래스명
		//  - 레퍼런스변수가 실제로 참조하는 객체가 클래스명 타입이라면 true
		//    참조하는 객체가 클래스타입이 아니라면 false 를 반환합니다.
		
		//super2 = new Casting_03_Super();
		super2 = new Casting_03_Sub();
		
		Casting_03_Sub sub2 = null;
		if( super2 instanceof Casting_03_Sub ) {
			sub2 = (Casting_03_Sub)super2;
			System.out.println("정상적으로 강제 형변환을 실행");
		} else
			System.out.println("강제 형변환 실패");
		
	}
}
















