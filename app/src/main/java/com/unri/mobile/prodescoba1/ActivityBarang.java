package com.unri.mobile.prodescoba1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class ActivityBarang extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

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


    GoogleMap mGoogleMap;
    MapView mapView;

    GoogleApiClient mGoogleApiCLient;
    LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        Intent getData = getIntent();

        int barangId = getData.getIntExtra("position", 0);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        ImageView imageView = findViewById(R.id.imageBarang);
        TextView judulBarangTxt = findViewById(R.id.nama_barang);
        TextView judulbarangTop = findViewById(R.id.namaBarang);
        TextView deskripsiBarangTxt = findViewById(R.id.deskripsi_barang);
        //TextView hargaBarangTxt = findViewById(R.id.harga_ba);

        judulbarangTop.setText(namaBarang[barangId]);
        imageView.setImageResource(imageBarang[barangId]);
        judulBarangTxt.setText(namaBarang[barangId]);
        deskripsiBarangTxt.setText(deskripsiBarang[barangId]);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        buildGoogleApiClient();
        //mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(40.996372, -74.665473)).title("Tempat"));
        CameraPosition pos = CameraPosition.builder().target(new LatLng(40.996372, -74.665473)).zoom(16).tilt(45).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(pos));
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiCLient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        mGoogleApiCLient.connect();
    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        //LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiCLient, mLocationRequest, (LocationListener) this);
    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}