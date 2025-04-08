import java.util.Scanner;
public class ControlStatement_SWITCH_03 {

	public static void main(String[] args) {
		// 사용자에게 메뉴번호를 입력받아
		// 선택된 메뉴가 어떤 것인지 출력하세요.
		// switch 문법을 사용해서 구현하세요.
		// 메뉴 번호 -> 1.한식 2.양식 3.중식
		
		// 변수 선언
		// 입력에 관련된 변수를 선언
		Scanner sc = new Scanner(System.in);
		int menu;
		
		// 입력 과정 수행
		System.out.println("메뉴를 선택하세요");
		System.out.println("1. 한식");
		System.out.println("2. 양식");
		System.out.println("3. 중식");
		System.out.print("메뉴 번호 입력 : ");
		menu = sc.nextInt();
		sc.close();
		
		// 처리와 출력 과정
		switch( menu ) {
			case 1:
				System.out.println("한식을 선택하셨습니다.");
				break;
			case 2:
				System.out.println("양식을 선택하셨습니다.");
				break;
			case 3:
				System.out.println("중식을 선택하셨습니다.");
				break;
			default:
				System.out.println("잘못된 번호를 선택하셨습니다.");
		}

	}

}










