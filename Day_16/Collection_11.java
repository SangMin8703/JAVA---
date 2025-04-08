package collection;
import java.util.*;
public class Collection_11 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("One", 1);
		map.put("Two", 2);		
		System.out.printf("map.size = %d\n", map.size());	
		
		// Map 타입의 클래스는 값(VALUE)의 중복을 허용합니다.
		map.put("Three", 2);
		System.out.printf("map.size = %d\n", map.size());
		
		System.out.printf("map.get(\"One\") -> %d\n", map.get("One"));
		
		// Map 타입의 클래스는 키값의 중복을 허용하지 않습니다.
		// 주의사항
		// 키값의 중복을 허용하지 않지만, 만약 동일 키값으로 중복되어 입력이 들어오면
		// 새로운 값으로 VALUE 를 교체합니다.
		// 아래의 "One" 키 값은 1 이라는 값을 가지고 있지만
		// 중복되어 입력되었기 때문에 새롭게 입력된 11 의 값을 가지게 됩니다.
		map.put("One", 11);
		System.out.printf("map.size = %d\n", map.size());
		
		System.out.printf("map.get(\"One\") -> %d\n", map.get("One"));

	}
}











