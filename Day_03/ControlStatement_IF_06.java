import java.util.Scanner;

public class ControlStatement_IF_06 {

	public static void main(String[] args) {
		// 사용자로부터 메뉴 번호를 입력받아
		// 1 번인 경우에는 한식
		// 2 번인 경우에는 양싱
		// 3 번인 경우에은 중식
		// 으로 출력하세요.		
		Scanner sc = new Scanner(System.in);
		
		int menu;
		
		System.out.print("메뉴 번호를 입력하세요 : ");
		menu = sc.nextInt();

		if( menu == 1 )
			System.out.println("한식");
		else if( menu == 2 )
			System.out.println("양식");
		else if( menu == 3 )
			System.out.println("중식");
		else
			System.out.println("잘못된 메뉴 번호를 선택했습니다.");	
		
		sc.close();
	}
}









