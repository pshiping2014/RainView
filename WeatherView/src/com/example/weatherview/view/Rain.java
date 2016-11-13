package com.example.weatherview.view;

import com.example.weatherview.RainRandom;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 雨滴类
 * 
 * @author pengshiping
 * 
 */
public class Rain {

	private static final float RAIN_SPEED = 18f;
	private static final float RAIN_SIZE = 2f;

	private RainLine mLine;// 雨滴坐标类
	private Paint mPaint;// 画笔
	private float mRainSpeed;// 雨滴下落的增量（速度）
	private float mRainSize;// 雨滴大小
	
	private RainRandom mRandom;

	

	public Rain(RainLine mLine, Paint mPaint, float mRainSpeed,
			float mRainSize, RainRandom mRandom) {
		super();
		this.mLine = mLine;
		this.mPaint = mPaint;
		this.mRainSpeed = mRainSpeed;
		this.mRainSize = mRainSize;
		this.mRandom = mRandom;
	}

	/**
	 * 创建雨滴类
	 * 
	 * @param paint
	 *            画笔
	 * @param width
	 *            横坐标
	 * @param height
	 *            纵坐标
	 * @return Rain
	 */
	public static Rain create(Paint paint, int width, int height) {

		RainRandom random = new RainRandom();
		int[] lines;
		lines = random.getLines(width, height);
		float rainSpeed = RAIN_SPEED;
		float rainSize = RAIN_SIZE;

		RainLine line = new RainLine(lines[0], lines[1], lines[2], lines[3]);

		return new Rain(line, paint, rainSpeed, rainSize,random);

	}

	/**
	 * 绘制雨滴类
	 * 
	 * @param canvas
	 */
	public void draw(Canvas canvas) {
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		drawLine(canvas,width, height);

	}

	// 画线条
	private void drawLine(Canvas canvas, int width, int height) {
		// TODO Auto-generated method stub
		mPaint.setStrokeWidth(RAIN_SIZE);
		int y1 = (int) (mLine.y1 + (mRainSpeed));
		int y2 = (int) (mLine.y2 + (mRainSpeed));
		mLine.set(mLine.x1, y1, mLine.x2, y2);
		if (!isInsideRain(height)) {
			resetRainLine(width,height);
		}

		canvas.drawLine(mLine.x1, mLine.y1, mLine.x2, mLine.y2, mPaint);

	}
	//重置雨滴坐标
	private void resetRainLine(int width,int height) {
		int[] lines;
		lines=mRandom.getLines(width, height);
		mLine.x1 = lines[0];
		mLine.y1 = lines[1];
		mLine.x2 = lines[2];
		mLine.y2 = lines[3];
		// TODO Auto-generated method stub
		
	}

	// 雨滴是否在视图中
	private boolean isInsideRain(int height) {
		// TODO Auto-generated method stub
		return mLine.y1 < height && mLine.y2 < height;
	}

}
