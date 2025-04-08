// 클래스의 선언 시, 해당 클래스의 객체들이 서로 같은지 확인해야만 한다면
// Object 클래스의 equals 메소드를 오버라이딩하여
// 서로 동일한 객체인지를 직접 확인해야 합니다.
class Equals_03 {
	public int num;
	public Equals_03(int num) {
		this.num = num;
	}
	
	// 객체의 같음을 비교할 수 있는 equals 메소드의 오버라이딩
	// 1. equals 메소드의 매개변수는 Object 타입입니다.
	//   (모든 타입의 객체들이 매개변수로 전달될 수 있습니다.)
	//    아래의 경우 Equals_03 클래스의 객체 이외에도 전달이 될 수 있습니다.
	// 2. 매개변수로 Object 타입이 전달되기 때문에 
	//    자식클래스로의 강제 형변환이 필요합니다.
	
	// 1 번과 2번의 주의 사항을 유의하여 equals 메소드를 오버라이딩 해야만 합니다. 
	public boolean equals(Object obj) {
		// 주의 사항 1번을 준수하는 코드
		// Object 타입으로 전달된 매개변수가
		// 현재 클래스의 타입인지 비교해야만 합니다.
		// (강제 형변환을 통해 현재 클래스의 타입으로 변환되는 과정에서
		// 에러가 발생될 수 있기때문에)
		
		// 매개변수로 전달된 Object 타입이 Equals_03 클래스의 
		// 객체가 아니라면 false 를 반환하고 메소드를 종료합니다.
		if( !(obj instanceof Equals_03) )
			return false;		
		
		// 주의 사항 2번을 준수하는 코드
		// Object 클래스 타입으로 전달된 매개변수를 
		// 현재 클래스의 타입으로 강제 캐스팅합니다.
		Equals_03 source = (Equals_03)obj;
		
		// 객체가 서로 동일한지 비교하는 조건식의 작성
		// (클래스마다, 조건마다 서로 상이하게 작성됩니다.)
		boolean result = this.num == source.num;
		
		return result;
	}
}
public class Class_Object_Equals_03 {
	public static void main(String[] args) {
		Equals_03 e1 = new Equals_03(100);
		Equals_03 e2 = new Equals_03(100);		
 
		// Equals_03 클래스에서 오버라이딩한 equals 메소드를 사용하여
		// 두개의 객체가 같음을 비교합니다.
		if( e1.equals(e2) )
			System.out.println("e1 변수와 e2 변수는 동일합니다.");
		else
			System.out.println("e1 변수와 e2 변수는 서로 다릅니다.");

	}
}







