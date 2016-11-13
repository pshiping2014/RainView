package com.example.weatherview;

/**
 * 
 * @author pengshiping
 * 
 */
public class RainRandom {
	// 获得一组随机的坐标
	public int[] getLines(int width, int height) {

		int[] lines = { 0, 0, 0, 0 };
		int tempW = (int) (width * Math.random());
		int tempH = (int) (height * Math.random());
		lines[0]=tempW;
		lines[1]=tempH;
		lines[2]=tempW;
		lines[3]=tempH+30;
		
		return lines;
	}

}
