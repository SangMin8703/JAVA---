package collection;

// Generic 문법
// 제네릭은 컬렉션에 저장하는 타입을 고정하여 사용할 수 있게하는 문법
// 대다수의 경우 하나의 컬렉션에는 하나의 타입을 저장하는 경우가 대부분입니다.
// 하지만 기본형으로 컬렉션의 객체를 생성할 경우 Object 타입이 기본으로 지정되므로
// 데이터의 입력에는 편리하지만, 데이터에 접근할 경우 강제 캐스팅이 필요합니다.
// 이런 불편함을 해소하기 위해서 제네릭을 구현합니다.

// 사용방법
// 컬렉션클래스<저장할타입> 레퍼런스변스 = new 컬렉션클래스<저장할타입>();
// ArrayList<String> list = new ArrayList<String>();
import java.util.*;
public class Collection_02 {
	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList();
		// 제네릭을 구현하지 않은 경우 값의 추가에는 제한이 없습니다.
		list1.add("String1");
		list1.add("String2");
		// list1.add(10);
		
		for(int i = 0 ; i < list1.size() ; i++ ) {
			// 제네릭을 구현하지 않은 경우
			// get 메소드의 리턴타입은 Object 타입이기 때문에
			// 강제 형변환이 필요합니다.
			// 또한 잘못된 형변환을 하는 경우 
			// 형변환 에러에 의해 프로그램이 강제 종료될 수 있습니다.
			String data = (String)list1.get(i);
			System.out.println(data);
		}
		
		// String 클래스 타입만을 저장할 수 있는 컬렉션 객체의 생성
		// (제네릭을 적용)
		// 제네릭이 적용된 컬렉션 객체는 해당 타입만을 저장, 접근할 수 있습니다.
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("문자열1");
		list2.add("문자열2");
		// 제네릭이 적용된 컬렉션 객체는
		// 지정한 타입만을 저장할 수 있습니다.
		// list2.add(10);
		
		for( int i = 0 ; i < list2.size() ; i++ ) {
			// 제네릭이 적용된 컬렉션 객체는 해당 타입을 반환하도록 변경되기 때문에
			// 강제 형변환이 필요없습니다.
			String data = list2.get(i);
			System.out.println(data);
		}
	}
}













