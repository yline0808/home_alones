package com.example.maintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity{
    SupportMapFragment mapFragment;
    GoogleMap map;
    MarkerOptions mo = new MarkerOptions();

    ArrayList<HappyHomeMap> hhl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //권한이 없을 경우 최초 권한 요청 또는 사용자에 의한 재요청 확인
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // 권한 재요청
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
                return;
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
                return;
            }
        }

        hhl = (ArrayList<HappyHomeMap>)getIntent().getSerializableExtra("mapLocation");

        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
//                Log.d("MapActivity", "GoogleMap 객체가 준비됨.");
                map = googleMap;
                map.setMyLocationEnabled(true);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.566319, 126.978048), 11));

                for(int i = 0; i < hhl.size(); i++) {
                    mo.position(new LatLng(hhl.get(i).getWd(),hhl.get(i).getGd()))
                            .title("" + hhl.get(i).getDangi())
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.home))
                            .snippet("월세:" + hhl.get(i).getMoney_mon() + ",보증금:" + hhl.get(i).getMoney_bo() + "\n계약금 : " + hhl.get(i).getMoney_contract() + "\n잔금 : " + hhl.get(i).getMoney_changes() + "\n주소 : " + hhl.get(i).getAddress() + "\n모집호수 : " + hhl.get(i).getCount());
                    map.addMarker(mo);
                }
                map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Toast.makeText(getApplicationContext(), marker.getSnippet(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
