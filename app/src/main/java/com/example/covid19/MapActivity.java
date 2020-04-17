package com.example.covid19;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.places.Place; // "Place" is not resolved
import com.google.android.gms.location.places.ui.PlacePicker; // "ui" is not resolved

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    double lat=0;
    double lon=0;
    Location l;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(MapActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);
        GPStracker gpStracker = new GPStracker(getApplicationContext());
        l = gpStracker.getLocation();
        if (l!=null){
            lat = l.getLatitude();
            lon = l.getLongitude();
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng yourLoc = new LatLng(lat, lon);
        mapAPI.addMarker(new MarkerOptions().position(yourLoc).title("Your Localization"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(yourLoc));
        mapAPI.animateCamera(CameraUpdateFactory.zoomTo(15));

        String type = "store";
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + lat + "," + lon);
        googlePlacesUrl.append("&radius=" + 300);
        googlePlacesUrl.append("&types=" + type);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyAchZGfW4wKjer5XoCR3k2QPkDwpTaGQlc");

        GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask();
        Object[] toPass = new Object[2];
        toPass[0] = googleMap;
        toPass[1] = googlePlacesUrl.toString();
        googlePlacesReadTask.execute(toPass);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
