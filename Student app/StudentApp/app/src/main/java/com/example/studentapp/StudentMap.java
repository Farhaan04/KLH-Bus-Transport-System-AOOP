package com.example.studentapp;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.studentapp.databinding.ActivityStudentMapBinding;

public class StudentMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityStudentMapBinding binding;
    private FusedLocationProviderClient fusedLocationProviderclients;
    SupportMapFragment mapFragment;
    Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStudentMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Route1 = new LatLng(17.348380, 78.341007);

        mMap.addMarker(new MarkerOptions().position(Route1).title("Route1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Route1));

        LatLng userLating = new LatLng(17.34859,78.339833 );
        mMap.addMarker(new MarkerOptions().position(userLating).title("you"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLating, 18f));

        //LatLng userLating1 = new LatLng(location.getLatitude(),location.getLongitude() );
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLating1, 18f));
    }

}