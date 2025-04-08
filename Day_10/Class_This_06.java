class T_6 {
	int i;
	double d;
	String s;
	
	// 생성자를 오버로딩 하는경우
	// 다수개의 생성자 사이에서 코드의 중복이 발생하게 됩니다.
	// 이런 경우 this 키워드를 사용하여
	// 생성자 코드의 중복을 방지할 수 있습니다.
	public T_6(int i) {
		//this.i = i;
		this(i, 0, null);
		System.out.println("T_6(int i)");
	}
	public T_6(double d) {
		//this.d = d;
		this(0, d, null);
		System.out.println("T_6(double d)");
	}
	public T_6(String s) {
		//this.s = s;
		this(0, 0, s);
		System.out.println("T_6(String s)");
	}
	public T_6(int i, double d, String s) {
		this.i = i;
		this.d = d;
		this.s = s;
		System.out.println("T_6(int i, double d, String s)");
	}
}
public class Class_This_06 {
	public static void main(String[] args) {		 
		//T_6 t1 = new T_6(10);
		//T_6 t2 = new T_6(10.1);
		T_6 t3 = new T_6("T_6");
	}
}







