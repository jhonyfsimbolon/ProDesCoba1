package com.unri.mobile.prodescoba1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMyAccount extends Fragment {

    Button btnMore;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myaccount_fragment, container, false);

        btnMore = view.findViewById(R.id.btn_more_setting);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),SettingActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}