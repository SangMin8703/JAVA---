package collection;
import java.util.*;

public class Collection_05 {
	public static void main(String[] args) {		
		// 멀티 쓰레드 환경에서 사용할 수 있는 리스트 객체의 생성
		// 1. 동기화가 지원되는 Vector 클래스의 사용
		//   - ArrayList 클래스에 비해 성능이 떨어지기 때문에 
		//     많이 사용되지는 않습니다.
		Vector<String> vector = new Vector<String>();
		// 2. Collections 클래스를 활용한 동기화 지원의 ArrayList 객체 생성
		List<String> syncArrayList = 
				Collections.synchronizedList(new ArrayList<String>());
	}
}
