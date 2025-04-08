class Casting_04_Super {}
class Casting_04_Sub1 extends Casting_04_Super {}
class Casting_04_Sub2 extends Casting_04_Super {}
class Casting_04_Sub3 extends Casting_04_Super {}

public class Class_Casting_04 {
	public static void main(String[] args) {		
		// 클래스의 레퍼런스 변수 사이의 형변환 사용예제
		
		// 일반적으로 특정 클래스의 객체를 저장하기 위해서
		// 해당 클래스 타입의 레퍼런스를 사용해야만 합니다.
		Casting_04_Sub1 [] arr1 = new Casting_04_Sub1[5];
		// Casting_04_Sub1 타입의 배열을 생성하여
		// 해당 클래스의 타입의 객체를 저장하는 코드
		arr1[0] = new Casting_04_Sub1();
		arr1[1] = new Casting_04_Sub1();
		arr1[2] = new Casting_04_Sub1();
		// arr1 배열의 경우 Casting_04_Sub1 타입을 저장하는 배열이기 때문에
		// 다른 클래스의 타입은 저장할 수 없습니다.
		//arr1[3] = new Casting_04_Sub2();
		//arr1[4] = new Casting_04_Sub3();
		
		Casting_04_Sub2 [] arr2 = new Casting_04_Sub2[5];
		// Casting_04_Sub2 타입의 배열을 생성하여
		// 해당 클래스의 타입의 객체를 저장하는 코드
		arr2[0] = new Casting_04_Sub2();
		arr2[1] = new Casting_04_Sub2();
		arr2[2] = new Casting_04_Sub2();
		// arr2 배열의 경우 Casting_04_Sub2 타입을 저장하는 배열이기 때문에
		// 다른 클래스의 타입은 저장할 수 없습니다.
		//arr2[3] = new Casting_04_Sub1();
		//arr2[4] = new Casting_04_Sub3();
		
		Casting_04_Sub3 [] arr3 = new Casting_04_Sub3[5];
		// Casting_04_Sub2 타입의 배열을 생성하여
		// 해당 클래스의 타입의 객체를 저장하는 코드
		arr3[0] = new Casting_04_Sub3();
		arr3[1] = new Casting_04_Sub3();
		arr3[2] = new Casting_04_Sub3();
		// arr3 배열의 경우 Casting_04_Sub3 타입을 저장하는 배열이기 때문에
		// 다른 클래스의 타입은 저장할 수 없습니다.
		//arr3[3] = new Casting_04_Sub1();
		//arr3[4] = new Casting_04_Sub2();
				
		// 만약 다수개의 클래스 타입의 객체를 하나의 타입으로 저장하여 관리하고자 한다면
		// 상속관계를 구현하여 부모의 타입으로 저장할 수 있습니다.
		
		// 부모클래스의 레퍼런스 변수는 자식 클래스의 객체를 참조할 수 있기 때문에
		// 부모클래스의 배열은 모든 자식클래스의 객체를 저장할 수 있습니다.
		Casting_04_Super [] arr = new Casting_04_Super[4];
		arr[0] = new Casting_04_Super();
		arr[1] = new Casting_04_Sub1();
		arr[2] = new Casting_04_Sub2();
		arr[3] = new Casting_04_Sub3();
	}
}












