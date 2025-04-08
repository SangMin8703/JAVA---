package collection;

// 컬렉션 클래스의 사용 시 주의할 점
// 사용자 정의 클래스의 객체 컬렉션 내부에 저장할 경우
// contains, remove 메소드가 동작하지 않습니다.
// (contains 메소드는 동일한 객체를 검색하는 메소드, 
//  remove 메소드는 동일한 객체를 삭제하는 메소드)

// 위의 메소드들을 본연의 기능을 수행하기 위해서
// 저장하고 있는 모든 객체들에 대해서 equals 메소드를 호출하여
// true 가 반환되는 경우에만 동작합니다.
// 그렇기 때문에, 사용자 정의 클래스를 사용하여 contains, remove
// 메소드가 동작하기 위해서는 반드시 equals 메소드를 오버라이딩 해야만 합니다.
import java.util.*;

class Collection_03_Model {
	public int num;

	public Collection_03_Model(int num) {
		this.num = num;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Collection_03_Model.equals 호출");
		
		if( !(obj instanceof Collection_03_Model) )
			return false;
		
		Collection_03_Model source = (Collection_03_Model)obj;
		
		boolean flag;
		flag = this.num == source.num;
		
		return flag;
	}
}
public class Collection_03 {
	public static void main(String[] args) {		
		ArrayList<Collection_03_Model> list = 
				new ArrayList<Collection_03_Model>();
		
		Collection_03_Model model1 = new Collection_03_Model(10);
		
		list.add(model1);		
		
		// contains 메소드는 해당 컬렉션 객체가 저장하고 있는 모든
		// 객체들을 순회하며 매개변수로 들어온 객체와 equals 메소스를 수행합니다.
		// 만약 컬렉션 객체에 저장된 객체가 equals 메소드를 오버라이딩 하지 않으면
		// 동일한 참조값인 경우(완전히 같은 객체)에만 참이되고,
		// 새롭게 만들어진 객체는 false 를 반환합니다.
		System.out.printf("model1 의 검색 결과 : %b\n", list.contains(model1));		
		model1 = new Collection_03_Model(10);
		// Collection_03_Model 클래스는 equals 메소드를 오버라이딩 했기때문에
		// 새로운 객체를 사용하여 비교해도 true 의 값을 반환합니다.
		System.out.printf("model1 의 검색 결과 : %b\n", list.contains(model1));
		
		int size = list.size();
		System.out.printf("size = %d\n", size);
		
		list.remove(model1);
		
		size = list.size();
		System.out.printf("size = %d\n", size);
		
	}
}










