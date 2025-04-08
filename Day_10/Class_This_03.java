// 클래스의 멤버 필드의 초기화
// this 키워드를 사용
class T_3 {
	int n1;
	int n2;
	int n3;
	int n4;
	int n5;
	
	public T_3(int n1) {		
		this.n1 = n1;
	}

	public T_3(int n1, int n2, int n3, int n4, int n5) {		
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
		this.n5 = n5;
	}	
	
	/*
	// 클래스 생성자를 통한 멤버필드의 초기화	
	// 클래스의 멤버필드를 초기화하기 위해서
	// 메소드의 매개변수를 선언할 때, 일반적으로 멤버필드들과 동일한 이름으로 선언합니다.
	// (직관적으로 어떠한 멤버필드에 값을 대입할 것이지를 알려주기 위해서)
	public T_3(int n1, int n2, int n3, int n4, int n5) {
		// 하지만 지역변수와 멤버필드의 이름이 동일한 경우
		// 지역변수명이 우선시 되기 떄문에
		// 반드시 this 키워드와 함께 멤버필드를 지정해야만 합니다.
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
		this.n5 = n5;
	}
	*/
}
public class Class_This_03 {
	public static void main(String[] args) {
		// 

	}
}
