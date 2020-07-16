package com.unri.mobile.prodescoba1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unri.mobile.prodescoba1.R;

public class GridBarangAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater layoutInflater;
    private String[] namaBarang;
    private String[] deskripsiBarang;
    private String[] hargaBarang;
    private int[] imageBarang;

    public GridBarangAdapter(Context mContext, String[] namaBarang,  String[]deskripsiBarang, String[]hargaBarang, int[] imageBarang) {
        this.mContext = mContext;
        this.namaBarang = namaBarang;
        this.deskripsiBarang = deskripsiBarang;
        this.hargaBarang = hargaBarang;
        this.imageBarang = imageBarang;
    }

    @Override
    public int getCount() {
        return 4;
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
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_barang_gridview, null);

        view.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 400));

        ImageView imageView = (ImageView) view.findViewById(R.id.imageBarang);
        TextView judul = (TextView) view.findViewById(R.id.judulBarang);
        TextView harga = (TextView) view.findViewById(R.id.hargaBarang);
        TextView deskripsi = (TextView) view.findViewById(R.id.deskripsiBarang);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.judulBarang_layout);

        imageView.setImageResource(imageBarang[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        layout.setAlpha(.7f);
        judul.setText(namaBarang[position]);
        deskripsi.setText(deskripsiBarang[position]);
        harga.setText("Rp. " + hargaBarang[position]);

        return view;
    }
}
