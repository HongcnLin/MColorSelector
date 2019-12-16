package com.hongcn.mcolorselector.draw;

import android.graphics.drawable.ShapeDrawable;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/12 14:18
 * --------------------------
 * Description: 实现它来创建你的item drawable.
 */
public interface ItemDrawFactory {


    /**
     * 创建一个Drawable，它将用于color grid item.
     * @param color item primary color
     * @param isCheck ture:selected,else fsale
     * @return drawable
     */
    ShapeDrawable createItemDrawable(int color, boolean isCheck);

}
