package collection;
import java.util.*;

// Hash 자료구조에 사용자 정의 클래스의 객체를 저장하는 경우
// 중복을 제거하기 위해서 처리해야하는 내용
// 1. Object 클래스의 hashCode 메소드를 오버라이딩
// 2. Object 클래스의 equals 메소드를 오버라이딩

// Hash 자료구조는 특정 객체를 입력하거나, 검색하고자 할 경우
// 해당 객체의 hashCode 의 값을 기준으로 필터링을 수행합니다.
// 만약 저장된 객체중에 hashCode 의 값이 중복되는 경우
// 해당 객체에 대해서 equals 메소드를 수행하여 실제 동일한 객체인지를 확인하는 과정을 거칩니다.
class Collection_08_Model {
	private String name;
	public Collection_08_Model(String name) {
		this.name = name;
	}
	public int hashCode() {
		System.out.printf("hashCode - %s, %d\n", this.name, super.hashCode());
		return 1;
	}	
	public boolean equals(Object obj) {
		System.out.println(name + " Collection_08_Model.equals 실행");
		return super.equals(obj);
	}
}
public class Collection_08 {
	public static void main(String[] args) {
		HashSet<Collection_08_Model> set = 
				new HashSet<Collection_08_Model>(); 				
		Collection_08_Model m1 = new Collection_08_Model("m1");
		Collection_08_Model m2 = new Collection_08_Model("m2");
		Collection_08_Model m3 = new Collection_08_Model("m3");
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		System.out.printf("set.size -> %d\n", set.size());
		
		m1 = new Collection_08_Model("m1");		
		set.add(m1);
		set.add(m1);
		System.out.printf("set.size -> %d\n", set.size());
		
		boolean r = set.contains(m1);
		System.out.printf("r = %b\n", r);
	}
}








