package com.yfz.download_progressbar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class ProgressBarStyleOneView extends View {
    private Paint mPaint;
    //背景颜色
    private int mColorBackground = Color.parseColor("#FF9966");
    //当前进度颜色
    private int mColorFront = Color.parseColor("#FF3300");
    //文字颜色
    private int mFontColor = Color.parseColor("#000000");
    //文字大小
    private int mFontSize = 10;

    public ProgressBarStyleOneView(Context context) {
        super(context);
        initial(context);
    }
    public ProgressBarStyleOneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initial(context);
    }
    private void initial(Context context){
        mFontSize = px2sp(context,mFontSize);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mColorBackground);
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),mPaint);
        mPaint.setColor(mColorFront);
        canvas.drawRect(0,0,canvas.getWidth()/2,canvas.getHeight(),mPaint);
    }

    /**
     * 将文字大小转换为sp
     */
    private int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * task模仿下载进度
     */
    private class startDownloadTask extends AsyncTask<String,Integer,Boolean>{

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            return null;
        }
    }
}
