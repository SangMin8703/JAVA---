package collection;
import java.util.*;
class Collection_12_Key {
	public int hashCode() {
		System.out.println("Collection_12_Key.hashCode");
		return super.hashCode();
	}
	public boolean equals(Object obj) {
		System.out.println("Collection_12_Key.equals");
		return super.equals(obj);
	}	
}
class Collection_12_Value {
	public int hashCode() {
		System.out.println("Collection_12_Value.hashCode");
		return super.hashCode();
	}
	public boolean equals(Object obj) {
		System.out.println("Collection_12_Value.equals");
		return super.equals(obj);
	}	
}
public class Collection_12 {
	public static void main(String[] args) {		
		HashMap<Collection_12_Key, Collection_12_Value> map = 
				new HashMap<Collection_12_Key, Collection_12_Value>();
				
		Collection_12_Key key01 = new Collection_12_Key();
		Collection_12_Key key02 = new Collection_12_Key();
		
		Collection_12_Value value01 = new Collection_12_Value();
		Collection_12_Value value02 = new Collection_12_Value();
		
		// Map 타입의 컬렉션 클래스들은
		// 키값의 중복을 허용하지 않기때문에
		// put 메소드로 전달되는 키에 대해서
		// hashCode 메소드와 equals 메소드를 호출하여
		// 중복을 제거합니다.
		// 만약 사용자 정의 클래스를 사용하여 Map 컬렉션에 데이터를 입력한다면
		// 반드시 hashCode 와 equals 메소드를 오버라이딩 해야합니다.
		// (VALUE 클래스는 hashCode 와 equals 가 실행되지 않습니다.)		
		map.put(key01, value01);
		map.put(key02, value02);
	}
}
















