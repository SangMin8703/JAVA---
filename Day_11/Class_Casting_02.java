// 클래스 레퍼런스 변수간의 형변환
class Casting_02_A {
	public int num;
}
class Casting_02_B {
	public int num;
}
public class Class_Casting_02 {
	public static void main(String[] args) {
		Casting_02_A c1 = new Casting_02_A();
		Casting_02_B c2;
		
		// 클래스의 레퍼런스 변수 사이에는 형변환이 허용되지 않습니다.
		// (동일한 형태의 클라스라도 허용되지 않음)
		
		// 자동 형변환이 안되는 예쩨
		// c2 = c1;
		// 강제 형변환이 안되는 예제
		// c2 = (Casting_02_B)c1;
	}
}
