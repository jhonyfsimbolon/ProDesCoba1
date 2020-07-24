package com.unri.mobile.prodescoba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.unri.mobile.prodescoba1.Adapter.AdapterListKategori;

public class KategoriActivity extends AppCompatActivity {
    ListView listView;
    private String[] judul = new String[]{"proNews", "proMart", "proBisa", "proJasa", "proRaga", "ruteDesa", "kopiDesa", "kaplingDesa", "lainNya"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        listView = (ListView) findViewById(R.id.listViewKategori);
        listView.setAdapter(new AdapterListKategori(this, judul));


    }
}