package io;

// File 객체를 사용하여 파일 입출력 스트림을 생성할 수 있습니다.
// 문자열 사용하는 경우보다 프로그램의 수정이 용이하기 때문에 
// 일반적인 경우 File 객체를 사용하여 파일 입출력 스트림을 생성합니다.
import java.io.*;
public class IO_40 {
	public static void main(String[] args) {
		String parentsPath = "." + File.separator;
		String fileName = "file_A.txt";
		
		File parents = new File(parentsPath);
		// 현재 경로 위치한 file_A.txt 을 참조하는 File 객체 생성		
		File file = new File(parents, fileName);
		
		try {
			// 파일 입출력 스트림의 생성자는 File 객체를 사용할 수 있습니다.
			FileOutputStream fos = new FileOutputStream(file);
			FileWriter fw = new FileWriter(file);
			
			FileInputStream fis = new FileInputStream(file);
			FileReader fr = new FileReader(file);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}










