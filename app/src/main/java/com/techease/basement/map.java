package com.techease.basement;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.techease.basement.R.layout.promptscreen;

public class map extends AppCompatActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;
    private Button button;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in TechEase and move the camera
        LatLng TechEase = new LatLng(34.004050, 71.503576);
        mMap.addMarker(new MarkerOptions().position(TechEase).title("Marker in TechEase"));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(promptscreen);
                dialog.setTitle("Basement");
                dialog.setCancelable(true);
                TextView txt = (TextView) dialog.findViewById(R.id.txt);
                txt.setText("This is a plain text for you");
                Button button2 = (Button) dialog.findViewById(R.id.dialogButton2);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return true;
            }
        });
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TechEase));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
    @Override
    public boolean onSupportNavigateUp(){
        Intent intent=new Intent(map.this,NavigationDrawer.class);
        startActivity(intent);
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(map.this,NavigationDrawer.class);
        startActivity(intent);
        finish();
    }
}
