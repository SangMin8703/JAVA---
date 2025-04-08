import java.util.Scanner;

interface Color {
	public static final int RED = 1;
	int BLUE = 2;
	int GREEN = 3;
}

public class Class_Interface_07 {
	public static void main(String[] args) {
		// 색상을 입력받아
		// 입력받은 색을 출력하세요.
		Scanner sc = new Scanner(System.in);		
		int color;

		System.out.println("1. 빨간색");
		System.out.println("2. 파란색");
		System.out.println("3. 초록색");
		System.out.print("색상 번호를 선택하세요 : ");
		color = sc.nextInt();
		
		String strColor;
		switch(color) {
			// case 상수:
			// case 1:
		
			// 인터페이스의 멤버 필드를 활용한 
			// switch ~ case 구문
			case Color.RED :
				strColor = "빨강";
				break;
			// case 2:
			case Color.BLUE :
				strColor = "파랑";
				break;
			// case 3:
			case Color.GREEN :
				strColor = "초록";
				break;
			default:
				strColor = null;
		}
		
		if( strColor != null )
			System.out.printf("%s 색으로 배경을 칠합니다.\n", strColor);
		else
			System.out.println("잘못된 색상 번호를 입력했습니다.");
	}
}









