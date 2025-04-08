package collection;

// 컬렉션 (자료구조)
// 대량의 데이터를 저장하기 위한 방법을 구현한 클래스의 모음
// 기존의 자료구조에서 정의된 많은 구조들을 Java의 클래스로 구현
// 1. 리스트(List)
//   - Vector, ArrayList, LinkedList, Stack
//   - 데이터의 중복을 허용, 데이터 저장의 순서가 유지됨
//   - 동적 배열을 구현하고 있는 Vector(동기화를 지원), ArrayList
//   - 링크드리스트 구조를 구현하는 LinkedList(데이터의 삽입과 삭제에 유리함)
//	 - 스택 구조를 구현하는 Stack(First In Last Out)
// 2. 집합(Set)
//	 - HashSet	
//	 - 데이터 중복이 허용되지 않음, 저장의 순서도 유지하지 않음(특정 클래스에서는 가능)
// 3. 맵(Map)
//	 - Hashtable(동기화 지원), HashMap
//	 - 데이터 중복이 허용되지 않음, 저장의 순서도 유지하지 않음(특정 클래스에서는 가능)

// 모든 컬렉션 클래스들은 java.util 패키지에서 제공됩니다.
import java.util.*;

class Collection_01_A {}

public class Collection_01 {
	public static void main(String[] args) {		
		// ArrayList 클래스의 사용
		
		// ArrayList 클래스의 객체 생성
		ArrayList list = new ArrayList();
		
		// ArrayList 클래스의 객체에 데이터를 추가
		// add 메소드를 사용하여 추가
		// 제네릭을 구현하지 않은 경우 Object 타입을
		// 매개변수로 사용하기 때문에 타입에 상관없이 저장
		list.add("문자열 데이터");	// String 타입을 저장
		list.add(10.1);			// Double 타입을 저장
		list.add(10);			// Integer 타입을 저장
		list.add(1.1f);			// Float 타입을 저장
		list.add(new Collection_01_A());	// 사용자 정의 클래스도 저장이 가능
		
		// 아래의 반복문을 사용하여 ArrayList 내부의 데이터를 순회하면서
		// 타입을 출력하면, 데이터를 추가시킨 순서대로 출력됩니다.
		// (저장 순서가 유지되는 특징)
		
		// 컬렉션 클래스의 size 메소드를 사용하면
		// 해당 컬렉션 내부에 저장된 데이터의 개수를 반환
		for( int i = 0 ; i < list.size() ; i++ ) {
			// ArrayList 의 저장된 데이터에 접근하기 위해
			// get 메소드를 사용합니다.
			// ArrayList 는 동적배열을 구현하는 클래스이므로
			// get 메소드의 매개변수로는 인덱스의 값을 입력합니다.
			// (시작은 0)
			System.out.println(list.get(i).getClass());
		}
		
		// List 타입의 클래스들은 중복을 허용합니다.
		int size;
		// 현재까지 입력된 데이터의 개수를 출력
		size = list.size();
		System.out.printf("size = %d\n", size);
		
		// 동일한 데이터를 ArrayList 에 추가
		list.add(10);
		
		// 동일한 데이터를 입력한 후 현재까지 입력된 데이터의 개수를 출력
		size = list.size();
		System.out.printf("size = %d\n", size);
		
		// List 컬렉션 내부에 저장된 데이터의 삭제
		// remove 메소드 사용
		list.remove(10.1);
		
		// 데이터를 삭제한 후, 입력된 데이터의 개수를 출력
		size = list.size();
		System.out.printf("size = %d\n", size);
		
		// 만약 중복된 데이터가 있는 경우
		// 제거되는 데이터는 앞쪽의 1개만 제거됩니다.
		list.remove(new Integer(10));
		
		// 데이터를 삭제한 후, 입력된 데이터의 개수를 출력
		size = list.size();
		System.out.printf("size = %d\n", size);
		
		// 10 의 데이터는 두개 이므로 
		// 한번 더 remove 를 사용하여 제거합니다.
		list.remove(new Integer(10));
		
		// 데이터를 삭제한 후, 입력된 데이터의 개수를 출력
		size = list.size();
		System.out.printf("size = %d\n", size);
		
		// List 내부의 데이터를 검색할 수 있는 기능을 구현
		// contains 메소드를 사용하여 내부의 데이터가 존재하는지 확인할 수 있습니다.
		boolean b = list.contains(1.1f);
		System.out.printf("1.1f -> %b\n", b);
	}
}

















