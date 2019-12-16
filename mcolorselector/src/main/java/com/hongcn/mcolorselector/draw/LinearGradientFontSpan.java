package com.hongcn.mcolorselector.draw;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;

/**
 * ---------->_<-------------
 *
 * @author : Hongcn(参考网络)
 * date : 2019/12/10 15:55
 * --------------------------
 * Description: span实现字体横向渐变色
 * reference: https://blog.csdn.net/inwhites/article/details/81917086
 */
public class LinearGradientFontSpan extends ReplacementSpan {

    private int mSize;
    private int startColor;
    private int endColor;

    public LinearGradientFontSpan(int startColor, int endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mSize = (int) (paint.measureText(text, start, end));
        // 字体高度没设置
        Paint.FontMetricsInt metrics = paint.getFontMetricsInt();
        if (fm != null) {
            fm.top = metrics.top;
            fm.ascent = metrics.ascent;
            fm.descent = metrics.descent;
            fm.bottom = metrics.bottom;
        }
        return mSize;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {

        LinearGradient gradient = new LinearGradient(50, y, mSize - 20, y,
                startColor, endColor, Shader.TileMode.CLAMP);
        paint.setShader(gradient);

        canvas.drawText(String.valueOf(text), x, y, paint);
    }
}
