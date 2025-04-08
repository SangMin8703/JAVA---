package collection;
// Map 타입의 컬렉션 클래스
// Hashtable, HashMap
// Map 타입의 컬렉션 객체들은
// 데이터의 입력 시 키와 값의 쌍을 입력받습니다.

// Map 타입의 컬렉션 클래스는 데이터의 중복을 허용하지 않습니다.
// (키 값의 중복을 허용하지 않습니다. 반면 값의 중복은 허용합니다.)

// Map 타입은 빠른 검색 속도를 보장하는 컬렉션 클래스입니다.
// KEY 값의 중복을 제거하여 보다 빠른 속도로 검색할 수 있습니다.
import java.util.*;
public class Collection_10 {
	public static void main(String[] args) {		
		// Map 타입은 키와 값의 쌍으로 입력되기 때문에
		// 제네릭의 선언 시, 타입이 2개가 사용됩니다.
		// 앞의 타입은 KEY, 뒤의 타입은 VALUE
		HashMap<String, String> map = new HashMap<String, String>();
		
		// Map 타입의 클래스들은 put 메소드를 사용하여 값을 입력할 수 있습니다.
		// put 메소드는 키와 값을 입력하여 Map 에 데이터를 추가합니다.
		// 키 값은 중복을 허용하지 않습니다.
		map.put("name", "이름");
		map.put("age", "나이");
		map.put("tel", "연락처");
		
		// Map 타입의 컬렉션은 get 메소드를 사용하여
		// 값을 추출할 수 있습니다.
		// 하지만 get 메소드의 매개변수는 key 값을 입력받아야 하기 때문에
		// key 값을 순회하면서 처리하는 경우가 일반적입니다.
		// map.get("name");
		
		// Map 타입의 클래스으 keySet 메소드를 사용하여
		// Key 값의 Set 객체를 추출할 수 있습니다.
		// 해당 Set 객체의 iterator 메소드를 사용하여
		// 모든 Key 값을 순회하면서 처리할 수 있습니다.
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			System.out.printf("key : %s, value : %s\n", key, value);
		}		
	}
}









