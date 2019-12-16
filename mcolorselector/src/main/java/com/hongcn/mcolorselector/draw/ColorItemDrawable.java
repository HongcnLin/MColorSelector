package com.hongcn.mcolorselector.draw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.util.Log;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/12 10:29
 * --------------------------
 * Description: color selector item background drawable.
 */
public class ColorItemDrawable extends ShapeDrawable {

    public static final int SHAPE_RECT = 11;
    public static final int SHAPE_CIRCLE = 12;

    /**
     * 选中点的大小
     */
    private final int select_point_size = 16;

    private Paint mPaint;
    private int mColor;
    private boolean isChecked;

    private int mShapeVal;

    private Point centerPoint;

    public ColorItemDrawable(int color, int shape, boolean isChecked) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        this.mColor = color;
        this.isChecked = isChecked;
        this.mShapeVal = shape;
    }

    @Override
    public void draw(Canvas canvas) {
        int cx = (getBounds().right - getBounds().left) / 2;
        int cy = (getBounds().bottom - getBounds().top) / 2;

        switch (mShapeVal) {
            case SHAPE_RECT:
                drawRectItem(canvas);
                break;
            case SHAPE_CIRCLE:
                drawCirleItem(canvas, cx, cy);
                break;
            default:
                break;
        }

        if (isChecked) {
            mPaint.setColor(Color.WHITE);
            mPaint.setStrokeWidth(select_point_size);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawPoint(cx, cy, mPaint);
        }
    }

    private void drawRectItem(Canvas canvas) {
        mPaint.setColor(mColor);
        canvas.drawRect(getBounds(), mPaint);
    }

    private void drawCirleItem(Canvas canvas, int cx, int cy) {
        mPaint.setColor(mColor);
        canvas.drawCircle(cx, cy, cx, mPaint);
    }
}
