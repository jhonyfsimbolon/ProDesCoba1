package com.unri.mobile.prodescoba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;
import com.unri.mobile.prodescoba1.Adapter.GridAdapter;
import com.unri.mobile.prodescoba1.Adapter.GridBarangAdapter;
import com.unri.mobile.prodescoba1.Adapter.RekomendasiImageAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class FragmentAll extends Fragment {

    GridView gridViewKategori;
    ExpandableHeightGridView gridViewBarang;
    private int[] mImageId = new int[]{R.drawable.air, R.drawable.pantai, R.drawable.rumah};
    private String [] text = new String[] {"Wisata", "Kuliner", "Kriya", "Lainnya"};

    //Array Barang Sementara

    private String [] namaBarang = new String[]{"Mobil Mr. Beast", "Kursi Pewdiepie", "Sepeda Gunung Viral", "Motor Bebek"};
    private String [] hargabarang = new String[]{"200.000", "3.990.000", "2.500.000", "9.500.000"};
    private String [] deskripsiBarang = new String[]{"Mobil Mr. Beast yang dikasih Youtuber lain", "Floor Gang Oughh", "Ngapain Viral2 Woyy", "Motor kok bebek??"};
    private int [] imageBarang = new int[]{R.drawable.mobilmrbeast, R.drawable.kursi, R.drawable.sepeda, R.drawable.motorbebek};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_fragment, container, false);

        ViewPager viewPagerBanner = (ViewPager) view.findViewById(R.id.viewPager);
        ViewPager viewPagerRekomendasi = (ViewPager) view.findViewById(R.id.rekomenBanner);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        TabLayout tabLayoutRekomendasi = (TabLayout) view.findViewById(R.id.tabLayoutRekomendasi);
        gridViewKategori = (GridView) view.findViewById(R.id.grid_view);
        gridViewBarang = (ExpandableHeightGridView) view.findViewById(R.id.gridViewBarang);

        //dotsLayout = (RelativeLayout) view.findViewById(R.id.layoutDots);

        //Implementasi ViewPager Banner
        viewPagerBanner.setClipToPadding(false);
        viewPagerBanner.setPadding(0, 0, 100, 0);
        viewPagerBanner.setPageTransformer(true, new ZoomOutPageTransformer());

        ImageAdapterBanner adapter = new ImageAdapterBanner(getActivity());
        viewPagerBanner.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPagerBanner);

        //Implementasi Gridview Kategori
        gridViewKategori.setAdapter(new GridAdapter(getActivity(), text));
        gridViewKategori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 4) {
                    Intent i = new Intent(getActivity(), KategoriActivity.class);
                    startActivity(i);
                }
            }
        });

        //Implementasi ViewPager Banner
        viewPagerRekomendasi.setClipToPadding(false);
        viewPagerRekomendasi.setPadding(0, 0, 175, 0);
        viewPagerRekomendasi.setPageTransformer(true, new ZoomOutPageTransformer());

        RekomendasiImageAdapter rekomendasiImageAdapter = new RekomendasiImageAdapter(getActivity(), namaBarang, hargabarang, imageBarang);
        viewPagerRekomendasi.setAdapter(rekomendasiImageAdapter);
        tabLayoutRekomendasi.setupWithViewPager(viewPagerRekomendasi);

        //Implementasi gridview Barang
        gridViewBarang.setExpanded(true);
        GridBarangAdapter adapterBarang = new GridBarangAdapter(getActivity(), namaBarang, deskripsiBarang, hargabarang, imageBarang);
        adapterBarang.notifyDataSetChanged();
        gridViewBarang.setAdapter(adapterBarang);

        return view;
    }
}