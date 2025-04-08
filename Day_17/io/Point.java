package io;

import java.io.Serializable;

// 점의 좌표를 저장할 수 있는 Point 클래스의 선언
public class Point implements Serializable {
	private int x;
	private int y;	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void print() {
		System.out.printf("X : %d, Y : %d\n", this.x, this.y);
	}	
}








