package com.hongcn.mcolorselector.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hongcn.mcolorselector.MaterialColorPolicy;
import com.hongcn.mcolorselector.R;
import com.hongcn.mcolorselector.draw.ColorItemDrawable;
import com.hongcn.mcolorselector.draw.HonItemDrawFactory;
import com.hongcn.mcolorselector.draw.ItemDrawFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/6 16:25
 * --------------------------
 * Description:Color selector Grid apdater
 */
public class ColorGvAdapter extends BaseAdapter {

    private String[][] materialColos;
    private List<String> customColos;

    private LayoutInflater layoutInflater;

    private int colorGamut = 5;
    private int lastSelectIndex;
    private int selectIndex;

    private boolean isCustomData;

    private ItemDrawFactory mItemDrawFactory;

    public ColorGvAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        materialColos = MaterialColorPolicy.getColorData();
        customColos = new ArrayList<>(20);
        mItemDrawFactory = new HonItemDrawFactory(ColorItemDrawable.SHAPE_RECT);
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setCustomColos(List<String> colors) {
        isCustomData = true;
        customColos.clear();
        customColos.addAll(colors);
        notifyDataSetChanged();
    }

    /**
     * 设置item 的背景Drawable Factory
     *
     * @param mItemDrawFactory
     */
    public void setmItemDrawFactory(ItemDrawFactory mItemDrawFactory) {
        this.mItemDrawFactory = mItemDrawFactory;
    }

    public void setSelectIndex(int selectIndex) {
        this.lastSelectIndex = this.selectIndex;
        this.selectIndex = selectIndex;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (isCustomData) {
            return customColos.size();
        } else {
            return materialColos.length;
        }
    }

    @Override
    public String getItem(int position) {
        if (isCustomData) {
            return customColos.get(position);
        } else {
            return materialColos[position][colorGamut];
        }
    }

    public void setColorGamut(int colorGamut) {
        this.colorGamut = colorGamut;
        isCustomData = false;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_color_dialog_gv, parent, false);
        }

        View itemView = convertView.findViewById(R.id.item_gv_view);

        itemView.setBackground(mItemDrawFactory.createItemDrawable(
                Color.parseColor(getItem(position)), position == selectIndex));

        return convertView;
    }
}
