
public class ControlStatement_DOWHILE_03 {

	public static void main(String[] args) {
		// do ~ while 반복문을 사용하여 구구단을 출력하세요.
		
		// 구구단의 단수 제어를 위한 변수
		int i;
		// 구구단에서 단수에 곱해지는 수를 제어하기 위한 변수
		int j;
		
		i = 2;		
		do {
			System.out.printf("%d 단을 출력합니다.\n\n", i);
			
			j = 1;
			do {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
				j++;
			} while( j < 10 );
			
			System.out.println();
			i++;
		} while( i < 10 );

	}

}
