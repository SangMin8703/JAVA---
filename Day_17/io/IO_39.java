package io;
import java.io.*;
// File 클래스의 객체가 디렉토리를 참조하는 경우
// 해당 디렉토리의 메타 정보외에도
// 해당 디렉토리의 하위 파일들, 하위 디렉토리들에 이름을 접근할 수 있습니다.

public class IO_39 {
	public static void main(String[] args) {
		String strPath = ".." + File.separator;
		
		// 현재 프로그램이 구동중인 경로의 상위 디렉토리를 참조하는 파일 객체 생성
		File parents = new File(strPath);
		
		// 만약 File 객체가 참조하는 대상이 디렉토리라면
		// list 메소드를 사용하여 하위 파일, 디렉토리들의 이름을
		// String 의 배열로 반환받을 수 있습니다.
		String [] subList = parents.list();
		
		for( int i = 0 ; i < subList.length ; i++ ) {
			//System.out.println(subList[i]);
			
			File subFile = new File(parents, subList[i]);
			
			if( subFile.isDirectory() ) {
				System.out.printf("%s - D <%d>\n", 
						subList[i], subFile.list().length);
			} else if( subFile.isFile() ) {
				System.out.printf("%s - F <%d bytes>\n", 
						subList[i], subFile.length());
			}
		}

	}
}








