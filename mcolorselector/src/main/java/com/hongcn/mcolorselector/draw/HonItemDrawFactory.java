package com.hongcn.mcolorselector.draw;

import android.graphics.drawable.ShapeDrawable;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/12 15:55
 * --------------------------
 * Description: hongcn提供的几种item drawable
 */
public class HonItemDrawFactory implements ItemDrawFactory {

    private int mShape;

    public HonItemDrawFactory(int shape) {
        this.mShape = shape;
    }

    @Override
    public ShapeDrawable createItemDrawable(int color, boolean isCheck) {
        return new ColorItemDrawable(color, mShape, isCheck);
    }
}
