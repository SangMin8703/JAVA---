// getter/setter 메소드
// 정보은닉의 개념을 적용하여 클래스를 선언하면
// 대다수의 멤버필드는 private 접근지정자를 사용하여
// 외부의 접근이 차단되게 됩니다.
// 이런 경우 각각의 멤버필드의 값을 수정하거나, 추출하기 위해서
// 메소드를 제공해줘야합니다.

// 객체지향 언어에서는 위에서 언급한 내용의 메소드를
// getter / setter 라는이름으로 명칭하며
// 메소드의 이름은 get멤버필드명, set멤버필드명 으로 선언합니다.
class T_4 {
	private String name;
	private int num;
	private int tot;
	private double avg;
	
	// name 멤버필드의 값을 수정하기 위한 setter 메소드의 선언
	// set멤버필드명 -> setName
	// setter 메소드의 매개변수는 값을 수정하고자 하는 멤버필드의 타입과 이름을 동일하게 작성합니다. 
	public void setName(String name) {
		// 지역변수명과 멤버필드의 이름이 동일하기 때문에
		// this 키워드를 사용하여 멤버필드를 명시적으로 지정합니다.
		this.name = name;
	}	
	// name 멤버필드의 값을 추출하기 위한  getter 메소드의 선언
	// get멤버필드명 -> getName
	// getter 메소드의 경우 멤버필드의 값을 반환하는 메소드이기 때문에
	// 해당 멤버필드의 타입을 리턴형으로 지정합니다.
	public String getName() {
		return this.name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}

public class Class_This_04 {
	public static void main(String[] args) {
		// 

	}
}









