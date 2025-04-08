class Casting_05_Super {}
class Casting_05_Sub1 extends Casting_05_Super {}
class Casting_05_Sub2 extends Casting_05_Super {}
class Casting_05_Sub3 extends Casting_05_Super {}
public class Class_Casting_05 {	
	// 클래스의 현변환 활용
	// 메소드 매개변수에 활용하는 예제
	// 메소드의 매개변수를 부모클래스의 타입으로 지정하여
	// 모든 자식클래스의 객체를 참조할 수 있도록 하는 방법
	public static void castingTest(Casting_05_Super obj) {	
		// 이런 경우 매개변수로 전달되는 타입이 고정되어 있지 않기 때문에
		// 아래와 같이 instanceof 연산자를 사용하여
		// 비교한 후 실제 로직을 수행하도록 구현합니다.
		
		// 주의사항 
		// instanceof 연산자를 사용하여 객체의 타입을 확인하고자 하는경우
		// 부모의 타입 비교는 항상 가장 마지막에 위치해야만 합니다.
		// (부모 타입의 instanceof 연산자의 비교는 항상 참이 나오기때문에
		// 아래의 분기문으로 이동할 수 없습니다.)
		//if( obj instanceof Casting_05_Super )
			//System.out.println("Casting_05_Super 타입이 매개변수로 전달");			
		if( obj instanceof Casting_05_Sub1 )
			System.out.println("Casting_05_Sub1 타입이 매개변수로 전달");
		else if( obj instanceof Casting_05_Sub2 )
			System.out.println("Casting_05_Sub2 타입이 매개변수로 전달");
		else if( obj instanceof Casting_05_Sub3 )
			System.out.println("Casting_05_Sub3 타입이 매개변수로 전달");
		else if( obj instanceof Casting_05_Super )
			System.out.println("Casting_05_Super 타입이 매개변수로 전달");
	}
	/*
	// 각각의 자식 클래스로 메소드의 매개변수를 지정하여 처리하는 방법
	public static void castingTest(Casting_05_Sub1 sub1) {}	
	public static void castingTest(Casting_05_Sub2 sub2) {}	
	public static void castingTest(Casting_05_Sub3 sub3) {}
	*/	
	public static void main(String[] args) {
		Casting_05_Sub1 sub1 = new Casting_05_Sub1();
		Casting_05_Sub2 sub2 = new Casting_05_Sub2();
		Casting_05_Sub3 sub3 = new Casting_05_Sub3();
		
		castingTest(sub1);
		castingTest(sub2);
		castingTest(sub3);
		
		Casting_05_Super super1 = new Casting_05_Super();
		castingTest(super1);
	}
}





