package io;
import java.io.*;
// File 객체를 활용한 파일과 디렉토리 생성 방법 
//  - File 객체는 참조하는 파일의 데이터를 수정할 수는 없습니다.
//    하지만 대상 파일이나 디렉토리의 생성은 가능합니다.
public class IO_37 {
	public static void main(String[] args) {		
		String rootPath = "C:\\work\\sources\\java\\Day_17";
		String fileName = "FileClassTest.txt";
		String directoryName = "FileClassTest";
		
		File parents = new File(rootPath);
		File file = new File(parents, fileName);
		File directory = new File(parents, directoryName);
		
		// File 클래스의 exists 메소드는 해당 대상의 파일이 존재하면 true
		// 존재하지 않으면 false의 값을 반환합니다.
		if( file.exists() )
			System.out.printf("%s 파일이 존재합니다.\n", file.getAbsolutePath());
		else {
			System.out.printf("%s 파일이 존재하지 않습니다.\n", file.getAbsolutePath());
			try {
				// File 클래스의 createNewFile 메소드는
				// 실제 파일을 생성하는 기능을 제공합니다.
				// 파일 생성되면 true, 생성에 실패하면 false 의 값을 반환합니다.
				boolean flag = file.createNewFile();
				if( flag )
					System.out.printf("%s 파일을 생성했습니다.\n", 
							file.getAbsolutePath());
				else
					System.out.printf("%s 파일 생성에 실패했습니다.\n", 
							file.getAbsolutePath());
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		
		if( directory.exists() )
			System.out.printf("%s 디렉토리가 존재합니다.\n", directory.getAbsolutePath());
		else {
			System.out.printf("%s 디렉토리가 존재하지 않습니다.\n", directory.getAbsolutePath());
			// File 클래스의 mkdir 메소드는
			// 디렉토리를 생성하는 기능을 제공합니다.
			boolean flag = directory.mkdir();
			if( flag )
				System.out.printf("%s 디렉토리를 생성했습니다.\n", directory.getAbsolutePath());
			else
				System.out.printf("%s 디렉토리 생성에 실패했습니다.\n", directory.getAbsolutePath());
		}
	}
}











