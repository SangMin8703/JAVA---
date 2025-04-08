import java.util.Random;
import java.util.Scanner;
// 실행 과정
// 구입할 로또의 개수를 입력하세요 : 2
// 1 : 1 2 3 4 5 6
// 2 : 7 8 9 10 11 12
class Lotto {
	private int index;
	private int [] numbers;	
	public Lotto(int index, Random random) {
		this.index = index;
		this.numbers = new int[6];		
		int tempNumber;
		for( int i = 0 ; i < numbers.length ; i++ ) {
			do {
				tempNumber = random.nextInt(45) + 1;
			} while( !isValidNumber(i+1, tempNumber) );
			
			numbers[i] = tempNumber;
		}		
		sorting();
	}	
	// 로또 번호의 중복 제거를 위한 메소드
	private boolean isValidNumber(int limit, int number) {
		boolean result = true;
		for( int i = 0 ; i < limit ; i++ ) {
			if( number == numbers[i] ) {
				result = false;
				break;
			}
		}
		return result;
	}	
	// 로또 번호의 정렬을 위한 메소드
	private void sorting() {
		for( int i = 0 ; i < numbers.length - 1 ; i++ ) {
			for( int j = i + 1 ; j < numbers.length ; j++ ) {
				if( numbers[i] > numbers[j] ) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}	
	private String toConvertString(int number) {
		String result = "";
		
		if( number < 10 )
			result = " ";
		
		result += number;
		
		return result;
	}
	public String toString() {
		String msg = this.index + " :";
		for( int i = 0 ; i < this.numbers.length ; i++ ) {
			msg += " " + toConvertString(numbers[i]);
		}
		return msg;
	}	
}
public class Class_Object_ToString_05 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		// 출력할 로또의 개수
		int count;
		// 난수를 사용하여 로또 숫자를 발생시키고 저장하는 Lotto 클래스의 배열
		Lotto [] lottos;
		// 난수를 발생시키기 위한 Random 클래스의 객체 생성
		Random random = new Random();
		
		System.out.print("구입할 로또의 개수를 입력하세요 : ");
		count = sc.nextInt();
		
		lottos = new Lotto[count];
		for( int i = 0 ; i < lottos.length ; i++ ) {
			lottos[i] = new Lotto(i+1, random);
			System.out.println(lottos[i]);
		}
	}
}












