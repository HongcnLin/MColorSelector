package com.hongcn.mcolorselector.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hongcn.mcolorselector.MaterialColor;
import com.hongcn.mcolorselector.MaterialColorPolicy;
import com.hongcn.mcolorselector.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/10 14:20
 * --------------------------
 * Description: Material color gamut choose list adapter
 */
public class ColorGamutLvAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<MaterialColor.ColorGamut> datas;


    public ColorGamutLvAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        datas = new ArrayList<>(Arrays.asList(MaterialColorPolicy
                .getGamut(MaterialColorPolicy.GAMUT_MAT_WHOLE)));
    }

    public void setColorGamuts(int gamutType) {
        if (datas == null) {
            datas = new ArrayList<>(Arrays.asList(MaterialColorPolicy.getGamut(gamutType)));
        } else {
            datas.clear();
            datas.addAll(Arrays.asList(MaterialColorPolicy.getGamut(gamutType)));
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public MaterialColor.ColorGamut getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_color_gamut_lv, parent, false);
        }
        TextView tv = convertView.findViewById(R.id.item_lv_gamut_tv);
        tv.setText(datas.get(position).name);

        return convertView;
    }
}
