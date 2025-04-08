
public class Operator_05 {

	public static void main(String[] args) {
		// 변수의 값을 증가/감소시킬 수 있는 연산자
		// ++ (증가 연산자) / -- (감소 연산자)
		// 특정 변수의 값을 1 증가하거나, 감소할 수 있는 연산자
		
		// 증가/감소 연산자는 위치에 따라서 
		// 전위, 후위로 분류됩니다.
		// (변수명의 앞에 위치한 경우 전위, 변수명의 뒤에 위치한 경우 후위)
		// 위치에 따라서 특정 변수의 값이 변경되는 시점이 달라집니다.
		
		int num;
		
		num = 10;
		System.out.printf("num = %d\n", num);
		
		// 후위 증가 연산자를 사용한 값의 증가	
		// 후위 증가 연산자는 연산의 시점을 한단계 늦춰서 실행합니다.
		// num 변수의 값이 10으로 출력되지만, 출력된 이 후 값이 증가되어
		// 실제 num 변수의 값은 11이 됩니다.
		System.out.printf("num = %d\n", num++);		
		System.out.printf("num = %d\n", num);
		
		// 전위 증가 연산자를 사용한 값의 증가
		// 전위 증가 연산자는 즉시 연산을 실행합니다.
		// num 변수의 값을 출력하기전에 먼저 증가시킨 후, 값을 출력합니다.
		System.out.printf("num = %d\n", ++num);
		System.out.printf("num = %d\n", num);

		num = 10;
		System.out.printf("%d %d %d %d %d\n", 
							++num, num--, num++, --num, ++num);
	}
}









