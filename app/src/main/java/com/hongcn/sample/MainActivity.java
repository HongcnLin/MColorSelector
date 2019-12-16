package com.hongcn.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hongcn.mcolorselector.MColorDialog;
import com.hongcn.mcolorselector.MaterialColorPolicy;
import com.hongcn.mcolorselector.OnSelectCallback;
import com.hongcn.mcolorselector.draw.ColorItemDrawable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MColorDialog colorDialog;


    private TextView clickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    OnSelectCallback callback = color -> {
        if (clickView.getId() == R.id.main_tv1 || clickView.getId() == R.id.main_tv3) {
            clickView.setText(color.getColorHtml());
        } else {
            clickView.setText("" + color.getColor());
        }
        clickView.setBackgroundColor(color.getColor());
    };

    @Override
    public void onClick(View v) {
        clickView = (TextView) v;
        switch (v.getId()) {
            case R.id.main_tv1:
                colorDialog = MColorDialog.builder(this, callback)
                        .setGamutType(MaterialColorPolicy.GAMUT_MAT_WHOLE).create();
                break;
            case R.id.main_tv2:
                colorDialog = MColorDialog.builder(this, callback)
                        .setGamutType(MaterialColorPolicy.GAMUT_MAT_LESS)
                        .setItemDrawFactory(ColorItemDrawable.SHAPE_CIRCLE)
                        .create();
                break;
            case R.id.main_tv3:
                colorDialog = MColorDialog.builder(this, callback)
                        .setGamutType(MaterialColorPolicy.GAMUT_MAT_SINGLE,
                                MaterialColorPolicy.ColorGamut.MATERIAL_600)
                        .create();
                break;
            case R.id.main_tv4:
                colorDialog = MColorDialog.builder(this, callback)
                        .customColos(createMyColor())
                        .create();
                break;
        }

        colorDialog.show();
    }

    private List<String> createMyColor() {
        return new ArrayList<String>() {{
            add("#ff0000");
            add("#00ff00");
            add("#0000ff");
            add("#ffff00");
            add("#00ffff");
            add("#ff00ff");
            add("#ff8000");
            add("#ff0080");
            add("#80ff00");
            add("#00ff80");
            add("#0080ff");
            add("#8000ff");
        }};
    }
}
