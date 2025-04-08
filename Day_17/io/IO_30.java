package io;

import java.io.*;

// Externalizable 인터페이스
// Serializable 인터페이스와 마찬가지로 직렬화를 구현하기 위한 인터페이스
// Serializable 인터페이스와 달리 직렬화의 과정을 직접 구현할 수 있는 인터페이스입니다.
// Externalizable 인터페이스는 두 개의 추상메소드를 포함하고 있으며,
// 두 개의 추상 메소드를 오버라이딩하여 직렬화를 구현할 수 있습니다.
// 1. writeExternal
//  - 해당 객체가 외부로 출력될 때 실행되는 메소드
//  - ObjectOutputStream 클래스의 writeObject 메소드가 실행될 때 자동 호출
// 2. readExternal
//  - 해당 객체가 외부로부터 입력될 때 실행되는 메소드
//  - ObjectInputStream 클래스의 readObject 메소드가 실행될 때 자동 호출

// Externalizable 과 Serializable 의 차이점
// Serializable 인터페이스는 객체 자체의 정보를 함께 외부로 출력하는 반면
// Externalizable 인터페이스는 writeExternal 메소드의 실행 결과만을 외부에 출력합니다.
// 이런 이유로, Serializable 에 의해서 출력된 결과에는 
// 해당 클래스의 멤버필드등의 정보가 같이 출력되고
// Externalizable 에 의해서 출력된 결과는 멤버필드들의 정보가 보이지 안습니다.

// Externalizable 인터페이스를 구현하는 경우 주의사항
// 반드시 디폴트 생성자를 제공해야만 합니다.
// 그 이유는 Externalizable 인터페이스가 구현 클래스의 객체가
// Object Input 으로 처리되는 됭우(readObject 메소드의 호출에 의해서)
// JVM 해당 클래스의 객체를 생성한 후, 해당 객체의 readExternal 을 호출하여
// 값을 설정하는 방법을 취합니다.
// 이때 JVM 이 해당 클래스의 객체를 생성할 때, 디폴트 생성자를 사용하여
// 객체를 생성하므로 반드시 디폴트 생성자가 존재해야만 합니다.
class IO_30_Model implements Externalizable {
	public int num1;
	public int num2;
	// 해당 클래스의 객체가 입력될 때를 대비한
	// 디폴트 생성자의 제공
	public IO_30_Model(){}
	public IO_30_Model(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("IO_30_Model.writeExternal");
		// 해당 객체의 멤버를 외부로 출력하는 기능을 구현
		out.writeInt(this.num2);
		out.writeInt(this.num1);
	}
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("IO_30_Model.readExternal");
		// 해당 객체의 멤버를 외부로부터 입력받는 기능을 구현
		// writeExternal 메소드에서 구현시킨 내용을 역으로 반환받는 내용을 구현합니다.
		this.num2 = in.readInt();
		this.num1 = in.readInt();
	}	
	public void printMembers() {
		System.out.printf("num1 = %d\n", this.num1);
		System.out.printf("num2 = %d\n", this.num2);
	}
}
public class IO_30 {
	public static void main(String[] args) {
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_externalizable.txt";

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(strFileName)));

			IO_30_Model model = new IO_30_Model(10, 20);
			model.printMembers();

			// 직렬화가 구현된 클래스의 객체는
			// 외부로 출력될 수 있습니다.
			oos.writeObject(model);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
