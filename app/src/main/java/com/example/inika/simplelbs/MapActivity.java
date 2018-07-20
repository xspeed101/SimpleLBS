package com.example.inika.simplelbs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    //CN Tower geocoordinates
    static final LatLng TORONTO = new LatLng(43.6426, -79.3871);
    private GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        String contactName = extras.getString("activityName");

        this.getSupportActionBar().setTitle(contactName);
        MapFragment mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
        //
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Marker Toronto = gMap.addMarker(new MarkerOptions().position(TORONTO)
                .title("Toronto - Fall 2017"));

        // Move the camera instantly to toronto with a zoom of 15.
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TORONTO, 10));

        // Zoom in, animating the camera.
        gMap.animateCamera(CameraUpdateFactory.zoomTo(20), 5000, null);

    }



}
