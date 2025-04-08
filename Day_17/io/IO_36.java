package io;

// 파일 클래스(java.io.File)
// 파일(파일과 디렉토리)에 관련된 메타 정보를 확인할 수 있는 클래스
// 메타정보 : 대상에 관련된 속성 정보(생성날자, 수정날자, 크기 등등의)
import java.io.*;
public class IO_36 {
	public static void main(String[] args) {		
		String filePath = "C:\\Windows\\explorer.exe";
		String directoryPath = "C:\\work\\sources\\java\\Day_17";
		
		// 파일 클래스의 객체 생성
		// 1. 문자열 1개를 매개변수로 사용하는 파일 클래스의 생성자
		//   - 접근할 파일의 경로를 문자열로 전달합니다.
		
		// 파일의 메타정보를 확인하기 위한 File 클래스의 객체 생성
		File file = new File(filePath);		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		System.out.println(file.lastModified());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		
		// 디렉토리의 메타정보를 확인하기 위한 File 클래스의 객체 생성
		File directory = new File(directoryPath);		
		System.out.println(directory.getAbsolutePath());
		System.out.println(directory.length());
		System.out.println(directory.lastModified());
		System.out.println(directory.isDirectory());
		System.out.println(directory.isFile());
		
		// 2. 문자열 2개를 매개변수로 사용하는 파일 클래스의 생성자
		//   - 접근할 파일의 부모 디렉토리 경로와 파일명을 문자열로 전달합니다.
		File file02 = new File("C:\\Windows", "explorer.exe");
		System.out.println(file02.getAbsolutePath());
		System.out.println(file02.length());
		System.out.println(file02.lastModified());
		System.out.println(file02.isDirectory());
		System.out.println(file02.isFile());
		
		File directory02 = new File("C:\\work\\sources\\java", "Day_17");
		System.out.println(directory02.getAbsolutePath());
		System.out.println(directory02.length());
		System.out.println(directory02.lastModified());
		System.out.println(directory02.isDirectory());
		System.out.println(directory02.isFile());
		
		// 3. 파일 객체와 문자열 1개를 매개변수로 사용하는 파일 클래스의 생성자
		//   - 접근할 파일의 부모 디렉토리를 참조하는 파일 객체와 파일명을 문자열로 전달합니다.
		File parents01 = new File("C:\\Windows");
		File file03 = new File(parents01, "explorer.exe");
		System.out.println(file03.getAbsolutePath());
		System.out.println(file03.length());
		System.out.println(file03.lastModified());
		System.out.println(file03.isDirectory());
		System.out.println(file03.isFile());
		
		File parents02 = new File("C:\\work\\sources\\java");
		File directory03 = new File(parents02, "Day_17");
		System.out.println(directory03.getAbsolutePath());
		System.out.println(directory03.length());
		System.out.println(directory03.lastModified());
		System.out.println(directory03.isDirectory());
		System.out.println(directory03.isFile());
	}
}














