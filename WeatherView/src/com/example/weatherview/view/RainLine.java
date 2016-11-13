package com.example.weatherview.view;

/**
 * 雨滴坐标类
 * 
 * @author pengshiping
 * 
 */
public class RainLine {
	public int x1;
	public int y1;
	public int x2;
	public int y2;

	public RainLine(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void set(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

	}

	@Override
	public String toString() {
		return "RainLine [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2="
				+ y2 + "]";
	}

}
