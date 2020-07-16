package com.unri.mobile.prodescoba1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.unri.mobile.prodescoba1.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class RekomendasiImageAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater layoutInflater;
    private String [] namaBarang;
    private String [] hargaBarang;
    private int[] barang;

    public RekomendasiImageAdapter(Context mContext, String[] namaBarang, String [] hargaBarang, int[] barang) {
        this.mContext = mContext;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.barang = barang;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_kategori_viewpager, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageBarang);
        TextView judul = (TextView) view.findViewById(R.id.judulBarang);
        TextView harga = (TextView) view.findViewById(R.id.hargaBarang);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.judulBarang_layout);

        imageView.setImageResource(barang[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        layout.setAlpha(.7f);
        judul.setText(namaBarang[position]);
        harga.setText("Rp. " + hargaBarang[position]);

        container.addView(view);

        return view;

    }

    @Override
    public int getCount() {
        return namaBarang.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}