package collection;
import java.util.*;
public class Collection_07 {
	public static void main(String[] args) {		
		HashSet<Integer> set = new HashSet<Integer>();
		
		set.add(10);
		set.add(20);
		set.add(30);		
		System.out.printf("set.size -> %d\n", set.size());
		
		// Hash 자료구조는 값의 중복을 허용하지 않습니다.
		// 아래의 add 메소드는 앞서 입력된 데이터와 동일한 데이터를
		// 입력하기 때문에 자료구조에 데이터가 추가되지 않습니다.
		set.add(10);
		set.add(20);		
		System.out.printf("set.size -> %d\n", set.size());
		
		Iterator<Integer> iterator = set.iterator();		
		while(iterator.hasNext()) {
			int data = iterator.next();
			System.out.printf("data = %d\n", data);
		}
	}
}





