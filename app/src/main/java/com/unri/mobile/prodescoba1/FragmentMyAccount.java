package com.unri.mobile.prodescoba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import com.unri.mobile.prodescoba1.Adapter.GridBarangAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMyAccount extends Fragment {

//    ExpandableHeightGridView gridViewBarang;
//    Button btnMore;
//    private String [] namaBarang = new String[]{"Mobil Mr. Beast", "Kursi Pewdiepie", "Sepeda Gunung Viral", "Motor Bebek"};
//    private String [] hargabarang = new String[]{"200.000", "3.990.000", "2.500.000", "9.500.000"};
//    private String [] deskripsiBarang = new String[]{"Mobil Mr. Beast yang dikasih Youtuber lain", "Floor Gang Oughh", "Ngapain Viral2 Woyy", "Motor kok bebek??"};
//    private int [] imageBarang = new int[]{R.drawable.mobilmrbeast, R.drawable.kursi, R.drawable.sepeda, R.drawable.motorbebek};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myaccount_fragment, container, false);
//
//        btnMore = view.findViewById(R.id.btn_more_setting);
//        btnMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getActivity(),SettingActivity.class);
//                startActivity(i);
//            }
//        });
//
//        gridViewBarang = (ExpandableHeightGridView) view.findViewById(R.id.profile_gridViewBarang);
//
//        gridViewBarang.setExpanded(true);
//        GridBarangAdapter adapterBarang = new GridBarangAdapter(getActivity(), namaBarang, deskripsiBarang, hargabarang, imageBarang);
//        adapterBarang.notifyDataSetChanged();
//        gridViewBarang.setAdapter(adapterBarang);

        return view;
    }
}