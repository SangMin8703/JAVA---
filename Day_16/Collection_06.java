package collection;

// Hash 자료구조
// 1. 중복을 허용하지 않습니다.
// 2. 자료구조 내부의 데이터를 빠른 속도로 검색하기 위해 사용되는 자료구조 
// 3. HashSet, Hashtable, HashMap 클래스로 제공됩니다.
import java.util.*;
public class Collection_06 {
	public static void main(String[] args) {
		// HashSet 클래스는 집합을 저장할 수 있는 자료구조 클래스 입니다.
		// 순서를 유지하지 않는 데이터의 모음을 저장하기 위해 사용되는 자료구조 클래스
		HashSet<Integer> set = new HashSet<Integer>();
		
		// add 메소드
		// HashSet 내부에 데이터를 추가하는 메소드
		
		// 아래의 코드는 자동형변환 기능으로 인해
		// set.add(new Integer(10)); 과 동일하게 동작합니다.
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		
		// Iterator 인터페이스
		// 자료구조 내부를 순회할 수 있는 기능을 제공하기 위해서
		// 사용되는 인터페이스
		// 자료구조를 순회할 수 있는 기능이 제공되는 클래스들은
		// Iterator 인터페이스를 구현한 객체를 반환할 수 있습니다.
		// HashSet 클래스는 List 구조의 자료구조와는 달리
		// 순서를 유지하지 않기 때문에, get 메소드의 사용이 불가능합니다.
		// Hash 구조의 자료구조는 Iterator 타입을 구현하여
		// 해당 자료구조 내부를 순회할 수 있도록 지원합니다.
		
		// iterator 메소드
		// HashSet 자료구조 내부를 순회할 수 있는 Iterator를
		// 반환하는 메소드
		// HashSet 클래스의 객체에 대해서 iterator 메소드를 호출하면
		// 자동으로 생성되기 때문에 필요할 때에 호출하여 사용합니다.
		Iterator<Integer> iterator = set.iterator();
		// hasNext 메소드
		// Iterator 객체를 사용하여 다음에 접근할 데이터가 존재하는지의 여부를 반환
		// 마지막 데이터까지 순회해야만 false 의 값을 반환
		// hasNext 메소드는 다음에 접근할 요소의 유무만을 확인
		// (실제 접근은 하지 않습니다.)
		while(iterator.hasNext()) {
			// next 메소드
			// Iterator 객체를 사용하여 실제 데이터로 이동하는 메소드
			// hasNext 메소드의 결과가 true 라면
			// 다음에 접근할 데이터가 있다는 의미이므로
			// next 메소드를 사용하여 데이터에 접근합니다.
			int data = iterator.next();
			System.out.printf("data = %d\n", data);
		}
	}
}








