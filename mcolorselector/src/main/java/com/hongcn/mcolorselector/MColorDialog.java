package com.hongcn.mcolorselector;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.hongcn.mcolorselector.MaterialColorPolicy.ColorGamut;
import com.hongcn.mcolorselector.adapter.ColorGamutLvAdapter;
import com.hongcn.mcolorselector.adapter.ColorGvAdapter;
import com.hongcn.mcolorselector.draw.ColorItemDrawable;
import com.hongcn.mcolorselector.draw.HonItemDrawFactory;
import com.hongcn.mcolorselector.draw.ItemDrawFactory;
import com.hongcn.mcolorselector.utils.Utils;

import java.util.List;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/4 17:21
 * --------------------------
 * Description: Color Selecor Dialog Mode
 */
public class MColorDialog extends Dialog implements View.OnClickListener {

    private static final String DIALOG_TITLE = "Color Selector";

    private Context mContext;
    /**
     * color gamut listview adapter，at none gamut unused;
     */
    private ColorGamutLvAdapter gamutLvAdapter;
    /**
     * color item gridview adapter
     */
    private ColorGvAdapter colorGvAdapter;
    private TextView tvGamut;
    private ListView gamutListView;

    //默认显示色阶为Material 500. less和whole都包含Material 500！！
    private int defaultGamut = ColorGamut.MATERIAL_500;
    private static final String defaultGamutName = "Material 500";


    /**
     * 选择颜色后回调事件
     */
    private OnSelectCallback mSelectCallback;


    private MColorDialog(Builder builder) {
        super(builder.context);
        mContext = builder.context;
        initAdapter();
        initViews();

        if (builder.gamutType > 0 || builder.customColos == null) {
            setGamutType(builder.gamutType,
                    builder.currentGamut >= 0 ? builder.currentGamut : defaultGamut);
        }

        if (builder.itemDrawFactory != null) {
            setColorItemDrawable(builder.itemDrawFactory);
        }
        if (builder.customColos != null) {
            setCustomColors(builder.customColos);
        }
        mSelectCallback = builder.callback;
    }


    public static Builder builder(Context context, OnSelectCallback callback) {
        return new Builder(context, callback);
    }


    private void initAdapter() {
        colorGvAdapter = new ColorGvAdapter(mContext);
        gamutLvAdapter = new ColorGamutLvAdapter(mContext);
    }

    private void initViews() {
        setContentView(R.layout.item_color_dialog);
        findViewById(R.id.dialog_ok_tv).setOnClickListener(this);
        findViewById(R.id.dialog_cancel_tv).setOnClickListener(this);
        GridView colorGridView = findViewById(R.id.dialog_gridview);
        tvGamut = findViewById(R.id.dialog_gamut_tv);
        gamutListView = findViewById(R.id.dialog_gamut_listview);

        int width = Utils.getDialogSuitableSize(mContext);
        //设置屏幕百分比的Dialog尺寸
        if (getWindow() != null && getWindow().getAttributes() != null) {
            getWindow().getAttributes().width = width;
            //noinspection SuspiciousNameCombination
            getWindow().getAttributes().height = width;
        }

        colorGridView.setAdapter(colorGvAdapter);
        gamutListView.setAdapter(gamutLvAdapter);

        tvGamut.setOnClickListener(this);
        gamutListView.setOnItemClickListener(this::gamutListItemClick);
        colorGridView.setOnItemClickListener(this::colorGirdItemClick);
        getTitleTv().setText(Utils.getGradientColorSpanString(DIALOG_TITLE, Color.RED, Color.BLUE));

        setOnCancelListener(dialog -> gamutListView.setVisibility(View.GONE));
    }


    /**
     * 设置color gamut 模式，并且指定一个色阶。
     * 指定的currentGamut只有在single模式才生效！
     */
    public void setGamutType(int gamutType, int currentGamut) {
        if (gamutType == MaterialColorPolicy.GAMUT_MAT_LESS
                || gamutType == MaterialColorPolicy.GAMUT_MAT_WHOLE) {
            gamutLvAdapter.setColorGamuts(gamutType);
            colorGvAdapter.setColorGamut(defaultGamut);
            getMaterialGamutTv().setVisibility(View.VISIBLE);
            getMaterialGamutTv().setText(defaultGamutName);

        } else if (gamutType == MaterialColorPolicy.GAMUT_MAT_SINGLE) {
            colorGvAdapter.setColorGamut(currentGamut);
            getMaterialGamutTv().setVisibility(View.GONE);
        }
    }

    private void setCustomColors(List<String> colos) {
        getMaterialGamutTv().setVisibility(View.GONE);
        colorGvAdapter.setCustomColos(colos);
    }


    private void setColorItemDrawable(ItemDrawFactory factory) {
        if (colorGvAdapter != null && factory != null) {
            colorGvAdapter.setmItemDrawFactory(factory);
        }
    }

    private TextView getTitleTv() {
        return (TextView) findViewById(R.id.dialog_title_tv);
    }

    private TextView getMaterialGamutTv() {
        return (TextView) findViewById(R.id.dialog_gamut_tv);
    }

    public void setOnSelectedCallback(OnSelectCallback mSelectCallback) {
        this.mSelectCallback = mSelectCallback;
    }

    /**
     * Color GridView  item 点击事件
     */
    private void colorGirdItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("aaa", "select color：" + colorGvAdapter.getItem(position));
        if (position == colorGvAdapter.getSelectIndex()) {
            onSelect();
        } else {
            colorGvAdapter.setSelectIndex(position);
        }
    }

    /**
     * Material 色阶选择item 点击事件
     */
    private void gamutListItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvGamut.setText(gamutLvAdapter.getItem(position).name);
        gamutListView.setVisibility(View.GONE);
        colorGvAdapter.setColorGamut(gamutLvAdapter.getItem(position).index);
    }


    private void onSelect() {
        String color = colorGvAdapter.getItem(colorGvAdapter.getSelectIndex());
        mSelectCallback.onSelected(new MColor(color));
        gamutListView.setVisibility(View.GONE);
        cancel();
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.dialog_ok_tv) {
            onSelect();
        } else if (i == R.id.dialog_cancel_tv) {
            gamutListView.setVisibility(View.GONE);
            cancel();
        } else if (i == R.id.dialog_gamut_tv) {
            if (gamutListView.getVisibility() == View.VISIBLE) {
                gamutListView.setVisibility(View.GONE);
            } else {
                gamutListView.setVisibility(View.VISIBLE);
            }
        }
    }

    public static class Builder {
        private List<String> customColos;
        private ItemDrawFactory itemDrawFactory;
        private int gamutType;
        private int currentGamut;
        private Context context;
        private OnSelectCallback callback;

        private Builder(Context context, OnSelectCallback callback) {
            this.context = context;
            this.callback = callback;
            customColos = null;
            itemDrawFactory = null;
            gamutType = -1;
            currentGamut = -1;
        }

        /**
         * 使用自定义的颜色数据，它将代替Material的颜色。
         *
         * @param customColos color data for list type.
         */
        public Builder customColos(List<String> customColos) {
            this.customColos = customColos;
            return this;
        }

        /**
         * 设置color item的drawable factory.
         *
         * @param itemDrawFactory your factory
         * @see ItemDrawFactory
         */
        public Builder setItemDrawFactory(ItemDrawFactory itemDrawFactory) {
            this.itemDrawFactory = itemDrawFactory;
            return this;
        }

        /**
         * 设置color item的drawable，我会提供几种可直接使用的，当然你也可通过
         * 实现{ItemDrawFactory} 来创建自己的drawable！！
         *
         * @param shape ColorItemDrawable 可直接用的几种drawable
         * @see ColorItemDrawable
         */
        public Builder setItemDrawFactory(int shape) {
            this.itemDrawFactory = new HonItemDrawFactory(shape);
            return this;
        }

        /**
         * 设置Color Gamut Mode.
         */
        public Builder setGamutType(int gamutType) {
            this.gamutType = gamutType;
            return this;
        }

        /**
         * 设置gamut为single模式，并且指定一个色阶。
         * 其他模式currentGamut无效！
         */
        public Builder setGamutType(int gamutType, int currentGamut) {
            this.gamutType = gamutType;
            this.currentGamut = currentGamut;
            return this;
        }

        public MColorDialog create() {
            return new MColorDialog(this);
        }
    }
}
