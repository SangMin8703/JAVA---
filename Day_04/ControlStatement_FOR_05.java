
public class ControlStatement_FOR_05 {

	public static void main(String[] args) {
		// for 반복문의 기준 변수 사용
		// for 반복문에서 생성된 기준 변수는 
		// 해당 for 문 내부에서만 사용이 가능합니다.
		
		for( int i = 1 ; i <= 10 ; i++ )
			System.out.printf("i = %d\n", i);
		
		// for 문에서 생성된 i 변수는 
		// 해당 for 문이 종료되면 메모리에서 소멸되기 때문에
		// for 문의 외부에서는 사용할 수 없습니다.
		// System.out.printf("i = %d\n", i);
				
		// for 문에서 사용된 기준 변수는 for 문이 종료되는 순간 소멸되기 때문에
		// 다른 for 문에서 동일한 이름의 기준 변수를 사용할 수 있습니다.
		for( int i = 1 ; i <= 10 ; i++ )
			System.out.printf("i = %d\n", i);
		

	}

}



