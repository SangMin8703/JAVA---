import java.util.Random;

class Dice {
	private int value;
	
	public Dice(Random random) {
		// Random 클래스는 난수를 사용하여 
		// 임의의 수를 반환할 수 있는 클래스입니다.
		// 난수 -> 0 과 1 사이의 값
		
		// Random 클래스의 nextInt 메소드는
		// 매개변수로 전달된 정수의 값을 기준으로
		// 임의의 수를 반환하는 메소드입니다.
		// 만약 아래와 같이 6 이 입력된 경우
		// 0 에서 5까지의 정수를 임의로 반환합니다.
		//this.value = random.nextInt(6);
		
		// 주사위의 값은 1 에서 6의 범위를 가지기 때문에
		// 아래와 같이 nextInt 메소드를 사용해야 합니다.
		this.value = random.nextInt(6) + 1;
	}	
	public int getValue() {
		return this.value;
	}	
	// toString 메소드의 오버라이딩
	// 주사위의 값을 문자열로 반환하도록 수정
	public String toString() {
		String msg = "주사위의 값 " + this.value;
		return msg;
	}
}
public class Class_Object_ToString_04 {
	public static void main(String[] args) {
		// 난수를 발생시키기 위한 Random 클래스의 객체 생성
		Random random = new Random();
		// 주사위의 값을 저장하기 위한 Dice 클래스의 배열 생성
		Dice [] dices = new Dice[100];
		
		for( int i = 0 ; i < dices.length ; i++ ) {
			dices[i] = new Dice(random);
			//System.out.printf("주사위의 값 %d\n", dices[i].getValue());
			System.out.println(dices[i]);
		}
	}
}






