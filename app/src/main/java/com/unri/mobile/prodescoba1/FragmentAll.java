package com.unri.mobile.prodescoba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

    private String [] namaBarang = new String[]{"Gayung Batok Kelapa Asli",
            "Kerajinan Sendal",
            "Dudung Ikan Enak",
            "Pupuk Kiloan",
            "Sabun Cuci Tangan Berbahan Alami",
            "Kaos Rute Desa",
            "Benang Tenun"};
    private String [] hargabarang = new String[]{"20.000", "39.000", "50.000", "5.000", "20.000", "80.000", "20.000"};
    private String [] deskripsiBarang = new String[]{"Gayung tradisional yang terbuat dari batok kelapa. Bahan berkualitas dan awet"
            ,"Sendal terbaru dari kerajinan anyaman yang stylish dan nyaman dikenakan sehari - hari"
            ,"Dudung ikan asli tanpa bahan pengawet dan pewarna, nikmat untuk disantap bersama keluarga"
            ,"Pupuk yang dapat menyuburkan tanaman dan tentunya organik tanpa bahan kimia berbahaya",
            "Sabun cuci tangan anti Corona yang berbahan alami dan tentunya halal untuk digunakan"
            ,"Kaos keren dengan cetakan Rute desa. Sablon rapi dan berkualitas, tidak mudah lepas saat dicuci",
            "Benang tenun yang tahan lama, kuat dan mudah digunakan. memiliki berbagai pilihan warna menarik"
    };
    private int [] imageBarang = new int[]{R.drawable.gayng_batok,
            R.drawable.kereajinan_sendakl,
            R.drawable.dudung_ikan,
            R.drawable.pupuk,
            R.drawable.sabun_cuci_tangan,
            R.drawable.kaos_rute_desa,
            R.drawable.benang_alami
    };

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
                if (position == 3) {
                    Intent i = new Intent(getActivity(), KategoriActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getActivity(),  String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Implementasi ViewPager Banner
        viewPagerRekomendasi.setClipToPadding(false);
        viewPagerRekomendasi.setPadding(0, 0, 175, 0);
        viewPagerRekomendasi.setPageTransformer(true, new ZoomOutPageTransformer());

        //Implementas  Rekomendasi BArnag
        RekomendasiImageAdapter rekomendasiImageAdapter = new RekomendasiImageAdapter(getActivity(), namaBarang, hargabarang, imageBarang);
        viewPagerRekomendasi.setAdapter(rekomendasiImageAdapter);
        tabLayoutRekomendasi.setupWithViewPager(viewPagerRekomendasi);


        //Implementasi gridview Barang
        gridViewBarang.setExpanded(true);
        GridBarangAdapter adapterBarang = new GridBarangAdapter(getActivity(), namaBarang, deskripsiBarang, hargabarang, imageBarang);
        adapterBarang.notifyDataSetChanged();
        gridViewBarang.setAdapter(adapterBarang);

        gridViewBarang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), ActivityBarang.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });



        return view;
    }
}