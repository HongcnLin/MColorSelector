package com.hongcn.mcolorselector;

import android.graphics.Color;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/11 15:10
 * --------------------------
 * Description:
 */
public class MColor {

    private int color;
    private String colorHtml;
    private Color colorRBG;

    public MColor(String colorHtml) {
        this.colorHtml = colorHtml;
    }

    public int getColor() {
        return Color.parseColor(colorHtml);
    }

    public String getColorHtml() {
        return colorHtml;
    }

    private Color getColorRBG() {
        return colorRBG;
    }
}
