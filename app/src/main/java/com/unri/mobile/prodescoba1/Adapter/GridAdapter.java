package com.unri.mobile.prodescoba1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.unri.mobile.prodescoba1.R;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private final String [] text;

    public GridAdapter(Context mContext, String[] text) {
        this.mContext = mContext;
        this.text = text;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view;
        view = layoutInflater.inflate(R.layout.item, null);

        TextView textView = (TextView) view.findViewById(R.id.itemName);
        textView.setText(text[position]);
        return view;
    }
}