package com.example.weatherview.view;

import com.example.weatherview.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * 自定义雨滴类
 * @author pengshiping
 *
 */
public class RainView  extends View{
	
	private static final int RAIN_NUM=100;//雨滴数量

	private static final int DELAY=1;//延时
	private Rain[] mRains;//雨滴集合
	public RainView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public RainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public RainView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		if (w!=oldw||h!=oldh) {
			initShow(w,h);
			
		}
		
	}

	//视图初始化
	private void initShow(int width,int height) {
		// TODO Auto-generated method stub
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
		paint.setColor(getResources().getColor(R.color.raincolor));
		paint.setStyle(Paint.Style.FILL);
		mRains=new Rain[RAIN_NUM];
		for (int i = 0; i < RAIN_NUM; i++) {
		mRains[i]=Rain.create(paint, width, height);
			
		}
		
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		for (Rain rain : mRains) {
			rain.draw(canvas);
		}
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				//延时自动刷新
				   invalidate();
			}
		}, DELAY);
	}

}
