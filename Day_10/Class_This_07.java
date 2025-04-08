class T_7 {
	public T_7() {
		System.out.println("T_7()");
	}
	public T_7(int i) {
		this(); 
		System.out.println("T_7(int i)");
	}
	public T_7(int i, int j) {
		this(i);
		System.out.println("T_7(int i, int j)");
	}
	public T_7(double d) {
		this(1, 0);
		System.out.println("T_7(double d)");
	}
	public T_7(double d1, double d2) {
		this(d1);
		System.out.println("T_7(double d1, double d2)");
	}
}
public class Class_This_07 {
	public static void main(String[] args) {		
		T_7 t = new T_7(10.1, 11.5);
	}
}
