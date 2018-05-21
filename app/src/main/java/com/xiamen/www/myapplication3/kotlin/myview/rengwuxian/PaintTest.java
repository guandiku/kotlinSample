package com.xiamen.www.myapplication3.kotlin.myview.rengwuxian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by White on 2018/5/19.
 */

public class PaintTest extends View {
    //    private Paint paint = new Paint();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);//开启抗锯齿

    Path path = new Path();//初始化Path对象

    public PaintTest(Context context) {
        super(context);
    }

    public PaintTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PaintTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);//线条宽度为20像素
        //绘制一个圆
        //参数分别代表 x坐标，y坐标，半径(radius)，画笔用谁画
//        canvas.drawCircle(300,300,200,paint);

//        canvas.drawColor(Color.parseColor("#88880000"));

//        canvas.drawRect(500,500,1000,1000,paint);

        //drawPoint(float x,float y,Paint paint) 画点

        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawPoint(50,50,paint);


        paint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawPoint(50,50,paint);

        paint.setStyle(Paint.Style.FILL);
//        canvas.drawOval(50,50,350,200,paint);

        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawOval(400,50,700,200,paint);

        @SuppressLint("DrawAllocation")
        RectF rectF = new RectF();
//        canvas.drawOval(rectF,paint);

        //画线
//        canvas.drawLine(200,200,800,500,paint);
        //画弧形

        paint.setStyle(Paint.Style.FILL);
//        canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint);//绘制扇形
//        canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint);//绘制弧形
//
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint);


        //drawPath(Path path,Paint paint)画自定义图形
        //这个方法有点复杂，需要展开说一下
        //Path方法第一类：直接描述路径
        //这一类方法还可以细分为两组：添加字图形和画线(直线或曲线)
        paint.setStyle(Paint.Style.FILL);
        path.addCircle(300,300,200,Path.Direction.CW);
//        canvas.drawPath(path,paint);


        //第二组： xxxTo() -----画线(直线或者曲线)
        path.lineTo(100,100);
        path.rLineTo(100,0);


        canvas.drawText("呵呵",200,100,paint);
        //插播5：Paint.setTextSize(float textSize)
        //通过Paint.setTextSize(textSize) , 可以设置文字的大小
        paint.setTextSize(19);
        canvas.drawText("呵呵",100,200,paint);

    }
}
