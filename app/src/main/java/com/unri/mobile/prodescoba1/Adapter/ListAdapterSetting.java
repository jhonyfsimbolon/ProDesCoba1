package com.unri.mobile.prodescoba1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.unri.mobile.prodescoba1.R;

import java.util.ArrayList;

public class ListAdapterSetting extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgList;

    public ListAdapterSetting(Activity context, String[] maintitle, Integer[] imgList) {
        super(context, R.layout.setting_list, maintitle);
        // TODO Auto-generated constructor stub

        this.context= context;
        this.maintitle=maintitle;
        this.imgList=imgList;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.setting_list, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.setting_list_title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.setting_list_img);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgList[position]);

        return rowView;

    };
}