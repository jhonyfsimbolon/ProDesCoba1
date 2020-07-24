package com.unri.mobile.prodescoba1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.unri.mobile.prodescoba1.R;

import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterListKategori extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] judul;

    public AdapterListKategori(Activity context, String[] judul) {
        super(context, R.layout.setting_list, judul);
        this.context = context;
        this.judul = judul;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_list_kategori, null, true);

        TextView judulKategori = (TextView) view.findViewById(R.id.textjudul);
        judulKategori.setText(judul[position]);

        return view;

    }
}
