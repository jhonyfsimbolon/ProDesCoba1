package com.unri.mobile.prodescoba1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String TAG="MainActivity";

    Button btnplus, btnx, btnjual;
    RelativeLayout bgplus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnplus = findViewById(R.id.btn_plus);
        btnx = findViewById(R.id.btn_x);
        btnjual = findViewById(R.id.btn_jual);
        bgplus = findViewById(R.id.bgplus);

        loadFragment(new FragmentAll());
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Plus ditekan",Toast.LENGTH_SHORT).show();
                findViewById(R.id.btn_plus).setVisibility(View.GONE);
                findViewById(R.id.btn_x).setVisibility(View.VISIBLE);
                findViewById(R.id.bgplus).setVisibility(View.VISIBLE);
                findViewById(R.id.btn_jual).setVisibility(View.VISIBLE);
            }
        });
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"X ditekan",Toast.LENGTH_SHORT).show();
                findViewById(R.id.btn_x).setVisibility(View.GONE);
                findViewById(R.id.bgplus).setVisibility(View.GONE);
                findViewById(R.id.btn_jual).setVisibility(View.GONE);
                findViewById(R.id.btn_plus).setVisibility(View.VISIBLE);
            }
        });
        bgplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Background ditekan",Toast.LENGTH_SHORT).show();
                findViewById(R.id.btn_x).setVisibility(View.GONE);
                findViewById(R.id.bgplus).setVisibility(View.GONE);
                findViewById(R.id.btn_jual).setVisibility(View.GONE);
                findViewById(R.id.btn_plus).setVisibility(View.VISIBLE);
            }
        });
        btnjual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SellingFormActivity.class);
                startActivity(i);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.explore_menu:
                fragment = new FragmentAll();
                break;
            case R.id.chat_menu:
                fragment = new FragmentChat();
                break;
            case R.id.sell_menu:
                fragment = new FragmentSell();
                break;
            case R.id.myads_menu:
                fragment = new FragmentMyAds();
                break;
            case R.id.myaccount_menu:
                fragment = new FragmentMyAccount();
                break;
        }
        return loadFragment(fragment);
    }
}