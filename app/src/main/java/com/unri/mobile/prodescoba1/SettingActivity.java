package com.unri.mobile.prodescoba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.unri.mobile.prodescoba1.Adapter.ListAdapterSetting;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {

    Button btnBack;
    private ListView navList;
    String[] settingListTitle ={
            "FAQ","Kebijakan Privasi",
            "Blog","Hubungi Kami",
            "Keluar",
    };

    Integer[] settingListImage ={
            R.drawable.ic_faq2,
            R.drawable.ic_kebijakan_privasi,
            R.drawable.ic_blog,
            R.drawable.ic_hubungi_kami,
            R.drawable.ic_logout,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        navList = findViewById(R.id.navListSetting);

        btnBack = findViewById(R.id.btn_back_setting);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListAdapterSetting adapter = new ListAdapterSetting(SettingActivity.this,settingListTitle,settingListImage);
        navList.setAdapter(adapter);

        navList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
