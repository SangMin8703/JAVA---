package collection;
import java.util.*;

// List 타입의 컬렉션 클래스들이 contains와 remove 를 수행과정
// 1. 해당 컬렉션 객체가 저장하고 있는 첫번째 요소 부터 마지막 요소까지 equals 메소드를 호출
// 2. equasl 메소드가 true 를 반환하는 경우 해당 메소드의 기능을 수행
// 3. 모든 요소들으 equals 메소드가 false 를 반환하면 해당 메소드의 기능을 수행하지 않음
class Collection_04_Model {	
	public int hashCode() {
		System.out.println("Collection_04_Model.hashCode 메소드 호출");
		return super.hashCode();
	}
	public boolean equals(Object obj) {
		System.out.println("Collection_04_Model.equals 메소드 호출");
		return obj instanceof Collection_04_Model;
	}	
}
public class Collection_04 {
	public static void main(String[] args) {		
		ArrayList<Collection_04_Model> list = 
				new ArrayList<Collection_04_Model>();
		
		list.add(new Collection_04_Model());
		list.add(new Collection_04_Model());
		list.add(new Collection_04_Model());
		
		Collection_04_Model model = new Collection_04_Model();
		
		boolean b = list.contains(model);
		System.out.printf("contains 메소드의 결과 : %b\n", b);
		
		int size = list.size();
		System.out.printf("size = %d\n", size);
		
		list.remove(model);
		
		size = list.size();
		System.out.printf("size = %d\n", size);
	}
}













