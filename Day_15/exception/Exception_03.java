package exception;

import java.util.Scanner;

public class Exception_03 {
	public static void main(String[] args) {
		// 예외가 발생하는 프로그램 3	
		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		int age;
		
		System.out.print("당신의 나이는?");
		age = sc.nextInt();
		
		System.out.printf("입력한 나이는 %d 세 입니다.\n", age);
		sc.close();
		
		System.out.println("프로그램 종료");
	}
}
