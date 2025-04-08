// HEAP 메모리
// 동적 메모리를 생성하는 메모리 공간으로 프로그램의 구동 중에 생성되는 메모리를 관리합니다.
// new 연산자를 사용해 생성할 수 있습니다.
// 1. 동적 메모리를 저장( 배열 ... )
// 2. 초기화 지원(쓰레기 값이 없습니다.)
// 3. 자동 해제 지원( 단 시기는...??? ) : 가비지컬렉터
//  - 참조 더 이상없는 경우
public class Variable04_HEAP {	
	public static void main(String[] args) {
		int [] arr;
		arr = new int[2];
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}






