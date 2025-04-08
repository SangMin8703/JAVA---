import java.util.Random;
import java.util.Scanner;

class Lotto_Equals {
	private int index;
	private int [] numbers;	
	public Lotto_Equals(int index, Random random) {
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
	// Lotto 의 정보를 가지고 있는 배열 객체를 매개변수로 받아
	// 해당 배열 객체 내부의 모든 Lotto 객체들과 비교하여 
	// 같은 번호의 Lotto 가 없는 경우에 참을 반환하도록 구현하세요.
	public boolean isValidLotto(Lotto_Equals [] lottos) {
		boolean result = true;
		for( int i = 0 ; i < lottos.length ; i++ ) {
			if( this.equals(lottos[i]) ) {
				result = false;
				break;
			}				
		}
		return result;
	}	
	public boolean equals(Object obj) {
		if( !(obj instanceof Lotto_Equals) )
			return false;
		
		Lotto_Equals source = (Lotto_Equals)obj;
		
		boolean result = true;		
		for( int i = 0 ; i < numbers.length ; i++ ) {			
			if( !findNumber(numbers[i], source.numbers) ) {
				result = false;
				break;
			}				
		}		
		return result;
	}
	private boolean findNumber(int target, int [] source) {
		boolean result = false;
		
		for( int i = 0 ; i < source.length ; i++ ) {
			if( source[i] == target ) {
				result = true;
				break;
			}
		}
		
		return result;		
	}	
}
public class Class_Object_Equals_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 출력할 로또의 개수
		int count;
		// 난수를 사용하여 로또 숫자를 발생시키고 저장하는 Lotto 클래스의 배열
		Lotto_Equals [] lottos;
		// 난수를 발생시키기 위한 Random 클래스의 객체 생성
		Random random = new Random();
		
		System.out.print("구입할 로또의 개수를 입력하세요 : ");
		count = sc.nextInt();		
		
		lottos = new Lotto_Equals[count];
		Lotto_Equals tempLotto;
		for( int i = 0 ; i < lottos.length ; i++ ) {
			
			do {
				tempLotto = new Lotto_Equals(i+1, random);
			} while( !tempLotto.isValidLotto(lottos) );
			
			lottos[i] = tempLotto;
			System.out.println(lottos[i]);
		}
	}
}






