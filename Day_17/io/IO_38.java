package io;

import java.io.*;

// 경로 구분자와 절대 경로, 상대 경로
// Java 언어는 운영체제에 독립적인 특징을 가지기 때문에
// 특정 파일의 경로를 정적으로 기술할 시, 경로 구분자에서 문자가 발생할 수 있습니다.
// 이런 경우 File 클래스의 static 필드를 사용하여 동적으로 처리할 수 있습니다. 
public class IO_38 {
	public static void main(String[] args) {	
		// File.separator 는 현재 Java 프로그램이 구동주인 운영체제의
		// 경로 구분자의 값을 문자열로 제공합니다.
		String rootPath = 
			"C:" + File.separator + "work" + 
				File.separator + "sources" + 
				File.separator + "java" + 
				File.separator + "Day_17";		
		System.out.println(rootPath);
		
		// 파일의 절대 경로
		// 절대 경로는 접근하고자 하는 파일, 디렉토리의 전체 경로를 직접 기술하는 방식입니다.
		// 앞서 생성한 rootPath 변수의 문자열 값과 같은 경우가 절대 경로로 기술하는 방식입니다.
		
		// 절대 경로 방식을 사용하면 특정한 위치를 고정하여 사용할 수 있고
		// 다른 실행 환경에서도 명확한 위치를 보장할 수 있습니다.
		// 하지만 경로의 기술시 복잡한 측면이 있고
		// 프로그램의 실행 시 문제가 발생할 수 있습니다.
		// (위의 rootPath 변수의 값의 경우 c 드라이브를 기준으로 절대 경로를 작성했지만
		//  다른 컴퓨터에서 구동할 경우 만약 c 드라이브가 없다면 실행 시 에러가 발생됩니다.)
		
		// 파일의 상대 경로
		// 현재 프로그램이 구동 중인 경로를 기준으로 파일의 위치를 기술하는 방식
		// 상대 경로를 기술할 때는 . 과 .. 을 사용하여 파일의 경로를 기술합니다.
		// . : 현재 위치를 나타내는 문자
		// .. : 현재 위치에서 한단계위의 디렉토리를 의미
		
		// 아래의 변수는 현재 프로그램이 실행중인 위치의 path.txt 를 참조하는 경로입니다.
		String pathTest = "." + File.separator + "path.txt";
		File file = new File(pathTest);
		System.out.println(file.getAbsolutePath());
		try {
			file.createNewFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		String pathTest2 = ".." + File.separator + 
				"Day_01" + File.separator + "path.txt";
		File file2 = new File(pathTest2);
		System.out.println(file2.getAbsolutePath());
		try {
			file2.createNewFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}










