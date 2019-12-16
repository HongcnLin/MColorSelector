package com.hongcn.mcolorselector.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;

import com.hongcn.mcolorselector.draw.LinearGradientFontSpan;

/**
 * ---------->_<-------------
 *
 * @author : dongml1
 * date : 2019/12/10 15:45
 * --------------------------
 * Description:
 */
public class Utils {

    /**
     * 创建一个水平渐变色的Span
     */
    public static SpannableStringBuilder getGradientColorSpanString(String txt, int colorA, int colorB) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(txt);
        LinearGradientFontSpan span = new LinearGradientFontSpan(colorA, colorB);
        ssb.setSpan(span, 0, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    /**
     * 根据getResources屏幕尺寸信息，计算Dialog合适的大小
     */
    public static int getDialogSuitableSize(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();

        if (dm.widthPixels <= dm.heightPixels) {
            return (int) (dm.widthPixels * 0.85);
        } else {
            return (int) (dm.widthPixels * 0.5);
        }

    }
}
