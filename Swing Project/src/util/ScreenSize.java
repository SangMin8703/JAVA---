package util;

import java.awt.GraphicsEnvironment;

public class ScreenSize {	
	public static int getScreenWidth() {
		/*
		// 전체 화면의 크기를 구하는 코드(작업 표시줄 포함)
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		// 현재 모니터 크기
		int width = screenSize.width;
		int height = screenSize.height;		
		*/
		
		// 전체 화면의 크기를 구하는 코드(작업 표시줄 제외)
		GraphicsEnvironment ge = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		// 현재 모니터 크기
		int width = (int) ge.getMaximumWindowBounds().getWidth();
        int height = (int) ge.getMaximumWindowBounds().getHeight();
        
        return width;
	}
	public static int getScreenHeight() {
		/*
		// 전체 화면의 크기를 구하는 코드(작업 표시줄 포함)
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		// 현재 모니터 크기
		int width = screenSize.width;
		int height = screenSize.height;		
		*/
		
		// 전체 화면의 크기를 구하는 코드(작업 표시줄 제외)
		GraphicsEnvironment ge = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		// 현재 모니터 크기
		int width = (int) ge.getMaximumWindowBounds().getWidth();
        int height = (int) ge.getMaximumWindowBounds().getHeight();
        
        return height;
	}
}
