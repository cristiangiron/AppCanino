package com.example.cristiangiron.appcanino;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.cristiangiron.appcanino.Fragments.FragmentReservaciones;
import com.example.cristiangiron.appcanino.Fragments.InformacionFragment;
import com.example.cristiangiron.appcanino.Marcadores.AnimalDoctor;
import com.example.cristiangiron.appcanino.Marcadores.Animalitos;
import com.example.cristiangiron.appcanino.Marcadores.Caniches;
import com.example.cristiangiron.appcanino.Marcadores.Mascotas;
import com.example.cristiangiron.appcanino.Marcadores.Peluditos;
import com.example.cristiangiron.appcanino.Marcadores.Huellas;
import com.example.cristiangiron.appcanino.Marcadores.SalonCanino;
import com.example.cristiangiron.appcanino.databinding.ActivityMapsBinding;
import com.example.cristiangiron.appcanino.models.SimpleResponse;
import com.example.cristiangiron.appcanino.net.UserService;
import com.example.cristiangiron.appcanino.util.Data;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, GoogleMap.OnMarkerClickListener {


    ActivityMapsBinding binding;

    ActionBarDrawerToggle toggle;

    private Session session;

    SharedPreferences preferences;

    UserService service;

    private GoogleMap mMap;
    private Marker marcador, markerpel_1, markerpel_2, markerpel_3, markerpel_4, markerpel_5, markerpel_6, markerpel_7, markerpel_8;


    double lat = 0.0;
    double lng = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawer, R.string.open, R.string.close);
        binding.drawer.addDrawerListener(this);

        binding.nav.setNavigationItemSelectedListener(this);

        service = Data.retrofit.create(UserService.class);

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);

     //  session = new Session(this);
       // if(!
         //session.loggedin()){
           // logout();
        //}

    }

    //region toggle
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.ver){
            Intent intent =  new Intent(this,ListaReservaciones.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);

    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);

    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);

    }
    //endregion


    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setOnMarkerClickListener(this);

        markerpel_1 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.4436483, -76.6182652)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Huellas Peluqueria"));
        markerpel_1.showInfoWindow();
        markerpel_2 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.447232, -76.62577629999998)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Peluqueria Peluditos"));
        markerpel_2.showInfoWindow();
        markerpel_3 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.4525506, -76.59599430000003)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Animalitos Peluqueria"));
        markerpel_3.showInfoWindow();
        markerpel_4 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.4438395, -76.60801320000002)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Mascotas Peluqueria"));
        markerpel_4.showInfoWindow();
        markerpel_5 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.4460303, -76.62085669999999)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Peluqueria Caniches"));
        markerpel_5.showInfoWindow();
        markerpel_6 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.4453431, -76.6189602)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Salon Canino"));
        markerpel_6.showInfoWindow();
        markerpel_7 = googleMap.addMarker(new MarkerOptions().position(new LatLng(2.4524934, -76.60524859999998)).icon(BitmapDescriptorFactory.fromResource(R.drawable.ubicaciones)).title("Animal Doctor"));
        markerpel_7.showInfoWindow();



        mMap = googleMap;
        miUbicacion();

        // Add a marker in Sydney and move the camera
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;

        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }


    private void agregarMarcarcador(double lat, double lng) {
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);
        if (marcador != null) marcador.remove();
        marcador = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Mi Ubicación")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.placeholder)));
        marcador.showInfoWindow();


        mMap.animateCamera(miUbicacion);

    }

    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMarcarcador(lat, lng);
        }

    }

    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 15000, 0, locListener);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        boolean FragmententoSeleccionado = false;


        if (id == R.id.nav_fav) {
            fragment = new FragmentReservaciones();
            getSupportFragmentManager().beginTransaction().replace(R.id.map, fragment).commit();
        } else if (id == R.id.nav_res) {
            fragment = new FragmentReservaciones();
            getSupportFragmentManager().beginTransaction().replace(R.id.map, fragment).commit();

        } else if (id == R.id.nav_des) {
            fragment = new InformacionFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.map, fragment).commit();

        } else if (id == R.id.nav_ubicacion) {
            Intent intent1 = new Intent(MapsActivity.this, MapsActivity.class);
            startActivity(intent1);

        } else if(id == R.id.nav_log){

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("logged", false);
            editor.apply();
            finish();

            Intent intent = new Intent(MapsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            // logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.getTitle().equals("Huellas Peluqueria")) {
            markerpel_1.showInfoWindow();
            Intent intent = new Intent(MapsActivity.this, Huellas.class);
            startActivity(new Intent(this, Huellas.class));
        } else if (marker.getTitle().equals("Peluqueria Peluditos")) {
            markerpel_2.showInfoWindow();
            Intent intent2 = new Intent(MapsActivity.this, Peluditos.class);
            startActivity(new Intent(this, Peluditos.class));
        } else if (marker.getTitle().equals("Animalitos Peluqueria")) {
            markerpel_3.showInfoWindow();
            Intent intent3 = new Intent(MapsActivity.this, Animalitos.class);
            startActivity(intent3);
        } else if (marker.getTitle().equals("Mascotas Peluqueria")) {
            markerpel_4.showInfoWindow();
            Intent intent4 = new Intent(MapsActivity.this, Mascotas.class);
            startActivity(intent4);
        } else if (marker.getTitle().equals("Peluqueria Caniches")) {
            markerpel_5.showInfoWindow();
            Intent intent5 = new Intent(MapsActivity.this, Caniches.class);
            startActivity(intent5);
        } else if (marker.getTitle().equals("Salon Canino")) {
            markerpel_6.showInfoWindow();
            Intent intent6 = new Intent(MapsActivity.this, SalonCanino.class);
            startActivity(intent6);
        } else if (markerpel_7.getTitle().equals("Animal Doctor")) {
            markerpel_7.showInfoWindow();
            Intent intent7 = new Intent(MapsActivity.this, AnimalDoctor.class);
            startActivity(intent7);
        }
        return true;

    }

 // private void logout(){
   //   session.setLoggedin(false);
     // finish();
       //startActivity(new Intent(MapsActivity.this,MainActivity.class));

    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete, menu);
        return super.onCreateOptionsMenu(menu);
    }








}





