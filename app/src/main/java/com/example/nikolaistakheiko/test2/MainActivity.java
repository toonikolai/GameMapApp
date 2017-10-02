package com.example.nikolaistakheiko.test2;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, GoogleMap.OnInfoWindowLongClickListener {

    GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;


    /*Marker Progression
    *    Location Type              TYPE                RESOURCE            Rank
    * 1. Park                       Mat                 Lumber              1
    * 2. Restaurant                 Mat                 Food                1
    * 3. Cafe                       Perk                Mining Speed        2
    * 4. School                     Perk                R&D                 2
    * 5. Gym                        People              Warrior             2
    * 6. Electronics Store          Mat                 Electronics         1
    * 7. Pharmacy                   Mat                 Metal               1
    * 8. Convenience Store          Mat                 Plastic             1
    * 9. Church                     People              Normal person       2
    * 10. General Contractor        People              Labourer            2
    *
    * */


    //Park Markers
    Marker m1;
    Marker m2;
    Marker m3;
    Marker m4;
    Marker m5;
    Marker m6;
    Marker m7;
    Marker m8;
    Marker m9;
    Marker m10;

    String m1name = null;
    String m2name = null;
    String m3name = null;
    String m4name = null;
    String m5name = null;
    String m6name = null;
    String m7name = null;
    String m8name = null;
    String m9name = null;
    String m10name = null;

    int m1i = 0;
    int m2i = 0;
    int m3i = 0;
    int m4i = 0;
    int m5i = 0;
    int m6i = 0;
    int m7i = 0;
    int m8i = 0;
    int m9i = 0;
    int m10i = 0;


    //Resto Markers
    Marker mResto1;
    Marker mResto2;
    Marker mResto3;
    Marker mResto4;
    Marker mResto5;
    Marker mResto6;
    Marker mResto7;
    Marker mResto8;
    Marker mResto9;
    Marker mResto10;

    String mResto1name = null;
    String mResto2name = null;
    String mResto3name = null;
    String mResto4name = null;
    String mResto5name = null;
    String mResto6name = null;
    String mResto7name = null;
    String mResto8name = null;
    String mResto9name = null;
    String mResto10name = null;

    int mResto1i = 0;
    int mResto2i = 0;
    int mResto3i = 0;
    int mResto4i = 0;
    int mResto5i = 0;
    int mResto6i = 0;
    int mResto7i = 0;
    int mResto8i = 0;
    int mResto9i = 0;
    int mResto10i = 0;

    //Cafe Markers
    Marker mCafe1;
    Marker mCafe2;
    Marker mCafe3;
    Marker mCafe4;
    Marker mCafe5;
    Marker mCafe6;
    Marker mCafe7;
    Marker mCafe8;
    Marker mCafe9;
    Marker mCafe10;

    String mCafe1name = null;
    String mCafe2name = null;
    String mCafe3name = null;
    String mCafe4name = null;
    String mCafe5name = null;
    String mCafe6name = null;
    String mCafe7name = null;
    String mCafe8name = null;
    String mCafe9name = null;
    String mCafe10name = null;

    int mCafe1i = 0;
    int mCafe2i = 0;
    int mCafe3i = 0;
    int mCafe4i = 0;
    int mCafe5i = 0;
    int mCafe6i = 0;
    int mCafe7i = 0;
    int mCafe8i = 0;
    int mCafe9i = 0;
    int mCafe10i = 0;



    //School Markers
    Marker mSch1;
    Marker mSch2;
    Marker mSch3;
    Marker mSch4;
    Marker mSch5;
    Marker mSch6;
    Marker mSch7;
    Marker mSch8;
    Marker mSch9;
    Marker mSch10;

    String mSch1name = null;
    String mSch2name = null;
    String mSch3name = null;
    String mSch4name = null;
    String mSch5name = null;
    String mSch6name = null;
    String mSch7name = null;
    String mSch8name = null;
    String mSch9name = null;
    String mSch10name = null;

    int mSch1i = 0;
    int mSch2i = 0;
    int mSch3i = 0;
    int mSch4i = 0;
    int mSch5i = 0;
    int mSch6i = 0;
    int mSch7i = 0;
    int mSch8i = 0;
    int mSch9i = 0;
    int mSch10i = 0;

    //Gym Markers
    Marker mGym1;
    Marker mGym2;
    Marker mGym3;
    Marker mGym4;
    Marker mGym5;
    Marker mGym6;
    Marker mGym7;
    Marker mGym8;
    Marker mGym9;
    Marker mGym10;

    String mGym1name = null;
    String mGym2name = null;
    String mGym3name = null;
    String mGym4name = null;
    String mGym5name = null;
    String mGym6name = null;
    String mGym7name = null;
    String mGym8name = null;
    String mGym9name = null;
    String mGym10name = null;

    int mGym1i = 0;
    int mGym2i = 0;
    int mGym3i = 0;
    int mGym4i = 0;
    int mGym5i = 0;
    int mGym6i = 0;
    int mGym7i = 0;
    int mGym8i = 0;
    int mGym9i = 0;
    int mGym10i = 0;

    //Electronics Markers
    Marker mElec1;
    Marker mElec2;
    Marker mElec3;
    Marker mElec4;
    Marker mElec5;
    Marker mElec6;
    Marker mElec7;
    Marker mElec8;
    Marker mElec9;
    Marker mElec10;

    String mElec1name = null;
    String mElec2name = null;
    String mElec3name = null;
    String mElec4name = null;
    String mElec5name = null;
    String mElec6name = null;
    String mElec7name = null;
    String mElec8name = null;
    String mElec9name = null;
    String mElec10name = null;

    int mElec1i = 0;
    int mElec2i = 0;
    int mElec3i = 0;
    int mElec4i = 0;
    int mElec5i = 0;
    int mElec6i = 0;
    int mElec7i = 0;
    int mElec8i = 0;
    int mElec9i = 0;
    int mElec10i = 0;

    //Pharmacy Markers
    Marker mDrg1;
    Marker mDrg2;
    Marker mDrg3;
    Marker mDrg4;
    Marker mDrg5;
    Marker mDrg6;
    Marker mDrg7;
    Marker mDrg8;
    Marker mDrg9;
    Marker mDrg10;

    String mDrg1name = null;
    String mDrg2name = null;
    String mDrg3name = null;
    String mDrg4name = null;
    String mDrg5name = null;
    String mDrg6name = null;
    String mDrg7name = null;
    String mDrg8name = null;
    String mDrg9name = null;
    String mDrg10name = null;

    int mDrg1i = 0;
    int mDrg2i = 0;
    int mDrg3i = 0;
    int mDrg4i = 0;
    int mDrg5i = 0;
    int mDrg6i = 0;
    int mDrg7i = 0;
    int mDrg8i = 0;
    int mDrg9i = 0;
    int mDrg10i = 0;

    //Convenience Store Markers
    Marker mCnv1;
    Marker mCnv2;
    Marker mCnv3;
    Marker mCnv4;
    Marker mCnv5;
    Marker mCnv6;
    Marker mCnv7;
    Marker mCnv8;
    Marker mCnv9;
    Marker mCnv10;

    String mCnv1name = null;
    String mCnv2name = null;
    String mCnv3name = null;
    String mCnv4name = null;
    String mCnv5name = null;
    String mCnv6name = null;
    String mCnv7name = null;
    String mCnv8name = null;
    String mCnv9name = null;
    String mCnv10name = null;

    int mCnv1i = 0;
    int mCnv2i = 0;
    int mCnv3i = 0;
    int mCnv4i = 0;
    int mCnv5i = 0;
    int mCnv6i = 0;
    int mCnv7i = 0;
    int mCnv8i = 0;
    int mCnv9i = 0;
    int mCnv10i = 0;

    //Church Markers
    Marker mChr1;
    Marker mChr2;
    Marker mChr3;
    Marker mChr4;
    Marker mChr5;
    Marker mChr6;
    Marker mChr7;
    Marker mChr8;
    Marker mChr9;
    Marker mChr10;

    String mChr1name = null;
    String mChr2name = null;
    String mChr3name = null;
    String mChr4name = null;
    String mChr5name = null;
    String mChr6name = null;
    String mChr7name = null;
    String mChr8name = null;
    String mChr9name = null;
    String mChr10name = null;

    int mChr1i = 0;
    int mChr2i = 0;
    int mChr3i = 0;
    int mChr4i = 0;
    int mChr5i = 0;
    int mChr6i = 0;
    int mChr7i = 0;
    int mChr8i = 0;
    int mChr9i = 0;
    int mChr10i = 0;

    //General Contractor Markers
    Marker mJob1;
    Marker mJob2;
    Marker mJob3;
    Marker mJob4;
    Marker mJob5;
    Marker mJob6;
    Marker mJob7;
    Marker mJob8;
    Marker mJob9;
    Marker mJob10;

    String mJob1name = null;
    String mJob2name = null;
    String mJob3name = null;
    String mJob4name = null;
    String mJob5name = null;
    String mJob6name = null;
    String mJob7name = null;
    String mJob8name = null;
    String mJob9name = null;
    String mJob10name = null;

    int mJob1i = 0;
    int mJob2i = 0;
    int mJob3i = 0;
    int mJob4i = 0;
    int mJob5i = 0;
    int mJob6i = 0;
    int mJob7i = 0;
    int mJob8i = 0;
    int mJob9i = 0;
    int mJob10i = 0;



    /*
    Above has the following progression:
        if (mNi == 0) {
            Property not yet claimed, out of range - cant claim
            }
        if (mNi == 1) {
            Property not yet claimed, within range - can claim
            }
        if (mNi == 2) {
            Property is claimed, adds +1 to empire size
            }
     */


    //Empire Counter
    int EmpireCounter = 0;

    //Trait Points
    int StrengthPoints = 0;
    int IntelligencePoints = 0;
    int CharismaPoints = 0;
    int EndurancePoints = 0;

    //Material Resources
    int lumber = 0;
    int plastic = 0;
    int cement = 0;
    int elec = 0;
    int metal = 0;
    int food = 0;

    //Perks
    int coffeeP = 0;
    int researchP = 0;

    //People
    int normalH = 0;
    int warriorH = 0;
    int workerH = 0;

    //Radius
    int rad = 900;

    //See if markers set
    int parkSet = 0;
    int restoSet = 0;
    int cafeSet = 0;
    int schSet = 0;
    int gymSet = 0;
    int elecSet = 0;
    int drgSet = 0;
    int cnvSet = 0;
    int chrSet = 0;
    int jobSet = 0;

    int propertyToken = 4;

    //Time Variables
    int timeCtr1 = 0;
    int minutesSpawn = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(googleServicesAvailable()){
            setContentView(R.layout.activity_main);
            initMap();
        } else {
            Toast.makeText(this, "Cant Connect", Toast.LENGTH_SHORT).show();

        }
    }

    private void initMap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        } else if (api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Cant Connect to GS", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style));

            if (!success) {
                Log.e("MapsActivityRaw", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapsActivityRaw", "Can't find style.", e);
        }
        mMap.setBuildingsEnabled(false);
        mMap.setIndoorEnabled(false);
        if(mMap != null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.marker_window, null);

                    TextView name = (TextView) v.findViewById(R.id.texto1);
                    name.setText(marker.getTitle());

                    TextView loctype = (TextView) v.findViewById(R.id.texto2);
                    loctype.setText(marker.getSnippet());
                    if(loctype.getText() == getResources().getString(R.string.can_claim_park)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_resto)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_cafe)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_sch)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_gym)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_elec)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_drg)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_cnv)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_chr)) {
                        loctype.setTextSize(26);
                    } else if(loctype.getText() == getResources().getString(R.string.can_claim_job)) {
                        loctype.setTextSize(26);
                    }

                    TextView distance = (TextView) v.findViewById(R.id.texto3);
                    float distance1 = getDistance1(marker, locLat, locLng);
                    distance.setText("Distance: " + distance1 + "m");


                    ImageView symbol = (ImageView) v.findViewById(R.id.imageView1);
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype1))) {
                        symbol.setImageResource(R.drawable.tree_far_2);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_park))) {
                        symbol.setImageResource(R.drawable.park_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_park))) {
                        symbol.setImageResource(R.drawable.park_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype2))) {
                        symbol.setImageResource(R.drawable.resto_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_resto))) {
                        symbol.setImageResource(R.drawable.resto_symbol_2);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_resto))) {
                        symbol.setImageResource(R.drawable.resto_symbol_2);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype3))) {
                        symbol.setImageResource(R.drawable.cafe_far_2);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_cafe))) {
                        symbol.setImageResource(R.drawable.cafe_symbol_2);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_cafe))) {
                        symbol.setImageResource(R.drawable.cafe_symbol_2);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype4))) {
                        symbol.setImageResource(R.drawable.school_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_sch))) {
                        symbol.setImageResource(R.drawable.school_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_sch))) {
                        symbol.setImageResource(R.drawable.school_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype5))) {
                        symbol.setImageResource(R.drawable.gym_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_gym))) {
                        symbol.setImageResource(R.drawable.gym_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_gym))) {
                        symbol.setImageResource(R.drawable.gym_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype6))) {
                        symbol.setImageResource(R.drawable.elec_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_elec))) {
                        symbol.setImageResource(R.drawable.elec_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_elec))) {
                        symbol.setImageResource(R.drawable.elec_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype7))) {
                        symbol.setImageResource(R.drawable.metal_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_drg))) {
                        symbol.setImageResource(R.drawable.metal_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_drg))) {
                        symbol.setImageResource(R.drawable.metal_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype8))) {
                        symbol.setImageResource(R.drawable.plastic_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_cnv))) {
                        symbol.setImageResource(R.drawable.plastic_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_cnv))) {
                        symbol.setImageResource(R.drawable.plastic_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype9))) {
                        symbol.setImageResource(R.drawable.church_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_chr))) {
                        symbol.setImageResource(R.drawable.church_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_chr))) {
                        symbol.setImageResource(R.drawable.church_symbol_1);
                    } else
                    if(loctype.getText().toString().contentEquals(getResources().getString(R.string.loctype10))) {
                        symbol.setImageResource(R.drawable.labour_far_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.can_claim_job))) {
                        symbol.setImageResource(R.drawable.labour_symbol_1);
                    } else if(loctype.getText().toString().contentEquals(getResources().getString(R.string.claimed_job))) {
                        symbol.setImageResource(R.drawable.labour_symbol_1);
                    }

                    return v;
                }
            });
        }

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        mMap.setOnInfoWindowLongClickListener(this);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                goToLocationZoomTilt(locLat, locLng,18,60);
                StringBuilder sbValue = new StringBuilder(sbMethod("park", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 3000);

        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("restaurant", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 6000);

        final Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("cafe", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 9000);

        final Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("school", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 12000);

        final Handler handler5 = new Handler();
        handler5.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("gym", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 15000);

        final Handler handler6 = new Handler();
        handler6.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("electronics_store", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 18000);

        final Handler handler7 = new Handler();
        handler7.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("pharmacy", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 21000);

        final Handler handler8 = new Handler();
        handler8.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("convenience_store", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 25000);

        final Handler handler9 = new Handler();
        handler9.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("church", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 27000);

        final Handler handler10 = new Handler();
        handler10.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sbValue = new StringBuilder(sbMethod("general_contractor", 1000));
                PlacesTask placesTask = new PlacesTask();
                placesTask.execute(sbValue.toString());
            }
        }, 30000);

    }


    private void goToLocationZoomTilt(double lat, double lng, float zoom, float tilt) {
        LatLng ll = new LatLng(lat, lng);
//        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
//        mMap.animateCamera(update);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(ll)      // Sets the center of the map to Mountain View
                .zoom(zoom)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                .tilt(tilt)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setInterval(3000);
        request.setFastestInterval(1000);
        //Surround this with thing for Marshmallow+ or something...
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, request, this);


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    double locLat;
    double locLng;

    @Override
    public void onLocationChanged(Location location) {
        if(location == null) {
            Toast.makeText(this, "Cant get location", Toast.LENGTH_LONG).show();
        }
//        LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());
//        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, 14);
//        mMap.animateCamera(update);
        locLat = location.getLatitude();
        locLng = location.getLongitude();
        if (mMap != null) {
            locoMarkers(location);
        }
        if (timeCtr1 == (20)*minutesSpawn) {
            timeCtr1 = 0;
        } else {
            timeCtr1++;
        }
    }


    void locoMarkers(Location location) {

        //Parks
        if (m1 != null) {
            m1i = locoMarkerPark(location, m1, m1i);
        }

        if (m2 != null) {
            m2i = locoMarkerPark(location, m2, m2i);
        }

        if (m3 != null) {
            m3i = locoMarkerPark(location, m3, m3i);
        }

        if (m4 != null) {
            m4i = locoMarkerPark(location, m4, m4i);
        }

        if (m5 != null) {
            m5i = locoMarkerPark(location, m5, m5i);
        }

        if (m6 != null) {
            m6i = locoMarkerPark(location, m6, m6i);
        }

        if (m7 != null) {
            m7i = locoMarkerPark(location, m7, m7i);
        }

        if (m8 != null) {
            m8i = locoMarkerPark(location, m8, m8i);
        }

        if (m9 != null) {
            m9i = locoMarkerPark(location, m9, m9i);
        }

        if (m10 != null) {
            m10i = locoMarkerPark(location, m10, m10i);
        }

        //Restaurants
        if (mResto1 != null) {
            mResto1i = locoMarkerResto(location, mResto1, mResto1i);
        }

        if (mResto2 != null) {
            mResto2i = locoMarkerResto(location, mResto2, mResto2i);
        }

        if (mResto3 != null) {
            mResto3i = locoMarkerResto(location, mResto3, mResto3i);
        }

        if (mResto4 != null) {
            mResto4i = locoMarkerResto(location, mResto4, mResto4i);
        }

        if (mResto5 != null) {
            mResto5i = locoMarkerResto(location, mResto5, mResto5i);
        }

        if (mResto6 != null) {
            mResto6i = locoMarkerResto(location, mResto6, mResto6i);
        }

        if (mResto7 != null) {
            mResto7i = locoMarkerResto(location, mResto7, mResto7i);
        }

        if (mResto8 != null) {
            mResto8i = locoMarkerResto(location, mResto8, mResto8i);
        }

        if (mResto9 != null) {
            mResto9i = locoMarkerResto(location, mResto9, mResto9i);
        }

        if (mResto10 != null) {
            mResto10i = locoMarkerResto(location, mResto10, mResto10i);
        }

        //Cafes
        if (mCafe1 != null) {
            mCafe1i = locoMarkerCafe(location, mCafe1, mCafe1i);
        }

        if (mCafe2 != null) {
            mCafe2i = locoMarkerCafe(location, mCafe2, mCafe2i);
        }

        if (mCafe3 != null) {
            mCafe3i = locoMarkerCafe(location, mCafe3, mCafe3i);
        }

        if (mCafe4 != null) {
            mCafe4i = locoMarkerCafe(location, mCafe4, mCafe4i);
        }

        if (mCafe5 != null) {
            mCafe5i = locoMarkerCafe(location, mCafe5, mCafe5i);
        }

        if (mCafe6 != null) {
            mCafe6i = locoMarkerCafe(location, mCafe6, mCafe6i);
        }

        if (mCafe7 != null) {
            mCafe7i = locoMarkerCafe(location, mCafe7, mCafe7i);
        }

        if (mCafe8 != null) {
            mCafe8i = locoMarkerCafe(location, mCafe8, mCafe8i);
        }

        if (mCafe9 != null) {
            mCafe9i = locoMarkerCafe(location, mCafe9, mCafe9i);
        }

        if (mCafe10 != null) {
            mCafe10i = locoMarkerCafe(location, mCafe10, mCafe10i);
        }

        //Schools
        if (mSch1 != null) {
            mSch1i = locoMarkerSch(location, mSch1, mSch1i);
        }

        if (mSch2 != null) {
            mSch2i = locoMarkerSch(location, mSch2, mSch2i);
        }

        if (mSch3 != null) {
            mSch3i = locoMarkerSch(location, mSch3, mSch3i);
        }

        if (mSch4 != null) {
            mSch4i = locoMarkerSch(location, mSch4, mSch4i);
        }

        if (mSch5 != null) {
            mSch5i = locoMarkerSch(location, mSch5, mSch5i);
        }

        if (mSch6 != null) {
            mSch6i = locoMarkerSch(location, mSch6, mSch6i);
        }

        if (mSch7 != null) {
            mSch7i = locoMarkerSch(location, mSch7, mSch7i);
        }

        if (mSch8 != null) {
            mSch8i = locoMarkerSch(location, mSch8, mSch8i);
        }

        if (mSch9 != null) {
            mSch9i = locoMarkerSch(location, mSch9, mSch9i);
        }

        if (mSch10 != null) {
            mSch10i = locoMarkerSch(location, mSch10, mSch10i);
        }

        //Gyms
        if (mGym1 != null) {
            mGym1i = locoMarkerGym(location, mGym1, mGym1i);
        }

        if (mGym2 != null) {
            mGym2i = locoMarkerGym(location, mGym2, mGym2i);
        }

        if (mGym3 != null) {
            mGym3i = locoMarkerGym(location, mGym3, mGym3i);
        }

        if (mGym4 != null) {
            mGym4i = locoMarkerGym(location, mGym4, mGym4i);
        }

        if (mGym5 != null) {
            mGym5i = locoMarkerGym(location, mGym5, mGym5i);
        }

        if (mGym6 != null) {
            mGym6i = locoMarkerGym(location, mGym6, mGym6i);
        }

        if (mGym7 != null) {
            mGym7i = locoMarkerGym(location, mGym7, mGym7i);
        }

        if (mGym8 != null) {
            mGym8i = locoMarkerGym(location, mGym8, mGym8i);
        }

        if (mGym9 != null) {
            mGym9i = locoMarkerGym(location, mGym9, mGym9i);
        }

        if (mGym10 != null) {
            mGym10i = locoMarkerGym(location, mGym10, mGym10i);
        }

        //Electrical Stores
        if (mElec1 != null) {
            mElec1i = locoMarkerElec(location, mElec1, mElec1i);
        }

        if (mElec2 != null) {
            mElec2i = locoMarkerElec(location, mElec2, mElec2i);
        }

        if (mElec3 != null) {
            mElec3i = locoMarkerElec(location, mElec3, mElec3i);
        }

        if (mElec4 != null) {
            mElec4i = locoMarkerElec(location, mElec4, mElec4i);
        }

        if (mElec5 != null) {
            mElec5i = locoMarkerElec(location, mElec5, mElec5i);
        }

        if (mElec6 != null) {
            mElec6i = locoMarkerElec(location, mElec6, mElec6i);
        }

        if (mElec7 != null) {
            mElec7i = locoMarkerElec(location, mElec7, mElec7i);
        }

        if (mElec8 != null) {
            mElec8i = locoMarkerElec(location, mElec8, mElec8i);
        }

        if (mElec9 != null) {
            mElec9i = locoMarkerElec(location, mElec9, mElec9i);
        }

        if (mElec10 != null) {
            mElec10i = locoMarkerElec(location, mElec10, mElec10i);
        }

        //Pharmacies
        if (mDrg1 != null) {
            mDrg1i = locoMarkerDrg(location, mDrg1, mDrg1i);
        }

        if (mDrg2 != null) {
            mDrg2i = locoMarkerDrg(location, mDrg2, mDrg2i);
        }

        if (mDrg3 != null) {
            mDrg3i = locoMarkerDrg(location, mDrg3, mDrg3i);
        }

        if (mDrg4 != null) {
            mDrg4i = locoMarkerDrg(location, mDrg4, mDrg4i);
        }

        if (mDrg5 != null) {
            mDrg5i = locoMarkerDrg(location, mDrg5, mDrg5i);
        }

        if (mDrg6 != null) {
            mDrg6i = locoMarkerDrg(location, mDrg6, mDrg6i);
        }

        if (mDrg7 != null) {
            mDrg7i = locoMarkerDrg(location, mDrg7, mDrg7i);
        }

        if (mDrg8 != null) {
            mDrg8i = locoMarkerDrg(location, mDrg8, mDrg8i);
        }

        if (mDrg9 != null) {
            mDrg9i = locoMarkerDrg(location, mDrg9, mDrg9i);
        }

        if (mDrg10 != null) {
            mDrg10i = locoMarkerDrg(location, mDrg10, mDrg10i);
        }

        //Convenience Stores
        if (mCnv1 != null) {
            mCnv1i = locoMarkerCnv(location, mCnv1, mCnv1i);
        }

        if (mCnv2 != null) {
            mCnv2i = locoMarkerCnv(location, mCnv2, mCnv2i);
        }

        if (mCnv3 != null) {
            mCnv3i = locoMarkerCnv(location, mCnv3, mCnv3i);
        }

        if (mCnv4 != null) {
            mCnv4i = locoMarkerCnv(location, mCnv4, mCnv4i);
        }

        if (mCnv5 != null) {
            mCnv5i = locoMarkerCnv(location, mCnv5, mCnv5i);
        }

        if (mCnv6 != null) {
            mCnv6i = locoMarkerCnv(location, mCnv6, mCnv6i);
        }

        if (mCnv7 != null) {
            mCnv7i = locoMarkerCnv(location, mCnv7, mCnv7i);
        }

        if (mCnv8 != null) {
            mCnv8i = locoMarkerCnv(location, mCnv8, mCnv8i);
        }

        if (mCnv9 != null) {
            mCnv9i = locoMarkerCnv(location, mCnv9, mCnv9i);
        }

        if (mCnv10 != null) {
            mCnv10i = locoMarkerCnv(location, mCnv10, mCnv10i);
        }

        //Churches
        if (mChr1 != null) {
            mChr1i = locoMarkerChr(location, mChr1, mChr1i);
        }

        if (mChr2 != null) {
            mChr2i = locoMarkerChr(location, mChr2, mChr2i);
        }

        if (mChr3 != null) {
            mChr3i = locoMarkerChr(location, mChr3, mChr3i);
        }

        if (mChr4 != null) {
            mChr4i = locoMarkerChr(location, mChr4, mChr4i);
        }

        if (mChr5 != null) {
            mChr5i = locoMarkerChr(location, mChr5, mChr5i);
        }

        if (mChr6 != null) {
            mChr6i = locoMarkerChr(location, mChr6, mChr6i);
        }

        if (mChr7 != null) {
            mChr7i = locoMarkerChr(location, mChr7, mChr7i);
        }

        if (mChr8 != null) {
            mChr8i = locoMarkerChr(location, mChr8, mChr8i);
        }

        if (mChr9 != null) {
            mChr9i = locoMarkerChr(location, mChr9, mChr9i);
        }

        if (mChr10 != null) {
            mChr10i = locoMarkerChr(location, mChr10, mChr10i);
        }

        //General Contractors
        if (mJob1 != null) {
            mJob1i = locoMarkerJob(location, mJob1, mJob1i);
        }

        if (mJob2 != null) {
            mJob2i = locoMarkerJob(location, mJob2, mJob2i);
        }

        if (mJob3 != null) {
            mJob3i = locoMarkerJob(location, mJob3, mJob3i);
        }

        if (mJob4 != null) {
            mJob4i = locoMarkerJob(location, mJob4, mJob4i);
        }

        if (mJob5 != null) {
            mJob5i = locoMarkerJob(location, mJob5, mJob5i);
        }

        if (mJob6 != null) {
            mJob6i = locoMarkerJob(location, mJob6, mJob6i);
        }

        if (mJob7 != null) {
            mJob7i = locoMarkerJob(location, mJob7, mJob7i);
        }

        if (mJob8 != null) {
            mJob8i = locoMarkerJob(location, mJob8, mJob8i);
        }

        if (mJob9 != null) {
            mJob9i = locoMarkerJob(location, mJob9, mJob9i);
        }

        if (mJob10 != null) {
            mJob10i = locoMarkerJob(location, mJob10, mJob10i);
        }

        TextView tv1 = (TextView) findViewById(R.id.uitvp1);
//        tv1.setText("Int: " + IntelligencePoints +" End: "+ EndurancePoints +" Str: "+ StrengthPoints+" Chr: " + CharismaPoints);
        tv1.setText("Metal: " + metal +" Plastic: "+ plastic +" Wood: "+ lumber+" Electronics: " + elec + " Food: " + food/* + " PT: " + propertyToken*/);
        TextView empCtr = (TextView) findViewById(R.id.uitvp2);
//        empCtr.setText("Empire Size: " + EmpireCounter);
        empCtr.setText("Citizens: " + normalH + " Workers: " + workerH + " Warriors: " + warriorH + " Research: " + researchP + " Empire Size: " + EmpireCounter);
    }

    private int locoMarkerPark(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_park))) { //User has claimed this property
            if (markeri == 1) { //Location just got claimed, update and add resources
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                lumber+=3;
                markeri = 2; //Update marker rank
            } else if (markeri == 2) { //Location already claimed
                if (timeCtr1==19) {
                    lumber++; //Give +1 resource
                }
            }

        } else {  //User has not claimed this property
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) { //User just got within property radius, uprank marker
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("park_symbol_1",80,110)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_park));

            } else if (distance <= rad && markeri == 1) { //User is still within property radius

            } else if (distance > rad && markeri == 1) { //User just got outside property radius, downrank marker
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("tree_far_2",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype1));

            } else if (distance > rad && markeri == 0) { //User has been outside rank for a while

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerResto(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_resto))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                food+=3;
                markeri = 2;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    food++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("resto_symbol_2",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_resto));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("resto_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype2));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerCafe(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_cafe))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                coffeeP+=3;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    coffeeP++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cafe_symbol_2",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_cafe));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cafe_far_2",125,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype3));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerSch(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_sch))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                researchP=+3;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    researchP++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("school_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_sch));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("school_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype4));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerGym(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_gym))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                warriorH+=3;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    warriorH++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("gym_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_gym));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("gym_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype5));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerElec(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_elec))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                elec+=1;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    elec++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("elec_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_elec));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("elec_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype6));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerDrg(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_drg))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                metal++;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    metal++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("metal_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_drg));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("metal_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype7));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerCnv(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_cnv))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                plastic=+3;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    plastic++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("plastic_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_cnv));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("plastic_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype8));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerChr(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_chr))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                normalH=+3;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    normalH++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("church_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_chr));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("church_far_1",100,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype9));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    private int locoMarkerJob(Location location, Marker marker, int markeri) {
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_job))) {
            if (markeri == 1) {
                marker.setVisible(true);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("borat_1",125,100)));
                markeri = 2;
                workerH=+3;
            } else if (markeri == 2) {
                if (timeCtr1==19) {
                    workerH++;
                }
            }

        } else {
            final float distance = getDistance(marker, location);

            if (distance <= rad && markeri == 0) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("labour_symbol_1",100,100)));
                markeri = 1;
                marker.setSnippet(getResources().getString(R.string.can_claim_job));

            } else if (distance <= rad && markeri == 1) {

            } else if (distance > rad && markeri == 1) {
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("labour_far_1",125,100)));
                markeri = 0;
                marker.setSnippet(getResources().getString(R.string.loctype10));

            } else if (distance > rad && markeri == 0) {

            } else Toast.makeText(this, "locoMarker_ Error", Toast.LENGTH_SHORT).show();
        }
        return markeri;
    }

    public Bitmap resizeMapIcons(String image_name, int w, int h) {
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(image_name, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, w, h, false);
        return resizedBitmap;
    }

    private float getDistance(Marker m, Location location) {
        Location l1 = new Location("M1");
        l1.setLatitude(m.getPosition().latitude);
        l1.setLongitude(m.getPosition().longitude);
        return l1.distanceTo(location);
    }

    private float getDistance1(Marker m, double Lat, double Lng) {
        Location l1 = new Location("M1");
        l1.setLatitude(m.getPosition().latitude);
        l1.setLongitude(m.getPosition().longitude);
        Location location = new Location("M2");
        location.setLatitude(Lat);
        location.setLongitude(Lng);
        return l1.distanceTo(location);
    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {

        //Claiming a property
        if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_park))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_park));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_resto))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_resto));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_cafe))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_cafe));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_sch))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_sch));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_gym))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_gym));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_elec))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_elec));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_drg))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_drg));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_cnv))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_cnv));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_chr))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_chr));
            EmpireCounter++;
            propertyToken--;
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.can_claim_job))) {
            Toast.makeText(this, "Very nice",
                    Toast.LENGTH_SHORT).show();
            marker.setVisible(false);
            marker.setSnippet(getResources().getString(R.string.claimed_job));
            EmpireCounter++;
            propertyToken--;
        }

        //Working with claimed property
        else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_park))) {
            Toast.makeText(this, "Opening park activity",
                    Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(MainActivity.this,ParkActivity.class);
            //Sending stuff to Park Activity
            intent.putExtra("Lumber", lumber);
            intent.putExtra("Metal", metal);
            intent.putExtra("Plastic", plastic);
            intent.putExtra("Electronics", elec);
            intent.putExtra("Energy", food);
            intent.putExtra("Citizens", normalH);
            intent.putExtra("Workers", workerH);
            intent.putExtra("Warriors", warriorH);
            intent.putExtra("Clock", timeCtr1);

            intent.putExtra("ParkName", marker.getTitle());


            startActivity(intent);
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_resto))) {
            Toast.makeText(this, "Opening restaurant activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_cafe))) {
            Toast.makeText(this, "Opening cafe activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_sch))) {
            Toast.makeText(this, "Opening school activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_gym))) {
            Toast.makeText(this, "Opening gym activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_elec))) {
            Toast.makeText(this, "Opening elec activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_drg))) {
            Toast.makeText(this, "Opening drug activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_cnv))) {
            Toast.makeText(this, "Opening 7-11 activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_chr))) {
            Toast.makeText(this, "Opening church activity",
                    Toast.LENGTH_SHORT).show();
        } else if (marker.getSnippet().contentEquals(getResources().getString(R.string.claimed_job))) {
            Toast.makeText(this, "Opening contractor activity",
                    Toast.LENGTH_SHORT).show();
        }
    }



    // Marker Initializing Stuff

    public StringBuilder sbMethod(String string1, float string2) {

        //use your current location here
        double mLatitude = locLat;
        double mLongitude = locLng;

        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        sb.append("location=" + mLatitude + "," + mLongitude);
        sb.append("&radius=" + string2);
        sb.append("&types=" + string1);
        sb.append("&sensor=true");
        sb.append("&key=AIzaSyAqpxCImvXIKlzPrgyS1J2L9E_RUm6m_k4");

        Log.d("Map", "api: " + sb.toString());
//        Toast.makeText(this, "Coordinates: " + mLatitude + " + " + mLongitude, Toast.LENGTH_LONG).show();

        return sb;

    }

    private class PlacesTask extends AsyncTask<String, Integer, String> {

        String data = null;

        // Invoked by execute() method of this object
        @Override
        protected String doInBackground(String... url) {
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executed after the complete execution of doInBackground() method
        @Override
        protected void onPostExecute(String result) {
            ParserTask parserTask = new ParserTask();

            // Start parsing the Google places in JSON format
            // Invokes the "doInBackground()" method of the class ParserTask
            parserTask.execute(result);
        }
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while url dwl", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

        JSONObject jObject;

        // Invoked by execute() method of this object
        @Override
        protected List<HashMap<String, String>> doInBackground(String... jsonData) {

            List<HashMap<String, String>> places = null;
            Place_JSON placeJson = new Place_JSON();

            try {
                jObject = new JSONObject(jsonData[0]);

                places = placeJson.parse(jObject);

            } catch (Exception e) {
                Log.d("Exception", e.toString());
            }
            return places;
        }

        // Executed after the complete execution of doInBackground() method
        @Override
        protected void onPostExecute(List<HashMap<String, String>> list) {

            Log.d("Map", "list size: " + list.size());
            // Clears all the existing markers;
            if (parkSet == 0) {
                mMap.clear();
            }
            int listSize = list.size();
            if (listSize > 10) {
                listSize = 10;
            }

            for (int i = 0; i < list.size(); i++) {

                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();

                // Getting a place from the places list
                HashMap<String, String> hmPlace = list.get(i);


                // Getting latitude of the place
                double lat = Double.parseDouble(hmPlace.get("lat"));

                // Getting longitude of the place
                double lng = Double.parseDouble(hmPlace.get("lng"));

                // Getting name
                String name = hmPlace.get("place_name");

                Log.d("Map", "place: " + name);

                // Getting vicinity
                String vicinity = hmPlace.get("vicinity");

                LatLng latLng = new LatLng(lat, lng);

                // Setting the position for the marker
                markerOptions.position(latLng);

                markerOptions.title(name/* + " : " + vicinity*/);


                // Placing a marker on the touched position
                if (parkSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("tree_far_2",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype1));
                    if (i == 0) {
                        m1 = mMap.addMarker(markerOptions);
                        m1name = name;
                    } else if (i == 1) {
                        m2 = mMap.addMarker(markerOptions);
                        m2name = name;
                    } else if (i == 2) {
                        m3 = mMap.addMarker(markerOptions);
                        m3name = name;
                    } else if (i == 3) {
                        m4 = mMap.addMarker(markerOptions);
                        m4name = name;
                    } else if (i == 4) {
                        m5 = mMap.addMarker(markerOptions);
                        m5name = name;
                    } else if (i == 5) {
                        m6 = mMap.addMarker(markerOptions);
                        m6name = name;
                    } else if (i == 6) {
                        m7 = mMap.addMarker(markerOptions);
                        m7name = name;
                    } else if (i == 7) {
                        m8 = mMap.addMarker(markerOptions);
                        m8name = name;
                    } else if (i == 8) {
                        m9 = mMap.addMarker(markerOptions);
                        m9name = name;
                    } else if (i == 9) {
                        m10 = mMap.addMarker(markerOptions);
                        m10name = name;
                    }
                } else if (restoSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("resto_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype2));
                    if (i == 0) {
                        mResto1 = mMap.addMarker(markerOptions);
                        mResto1name = name;
                    } else if (i == 1) {
                        mResto2 = mMap.addMarker(markerOptions);
                        mResto2name = name;
                    } else if (i == 2) {
                        mResto3 = mMap.addMarker(markerOptions);
                        mResto3name = name;
                    } else if (i == 3) {
                        mResto4 = mMap.addMarker(markerOptions);
                        mResto4name = name;
                    } else if (i == 4) {
                        mResto5 = mMap.addMarker(markerOptions);
                        mResto5name = name;
                    } else if (i == 5) {
                        mResto6 = mMap.addMarker(markerOptions);
                        mResto6name = name;
                    } else if (i == 6) {
                        mResto7 = mMap.addMarker(markerOptions);
                        mResto7name = name;
                    } else if (i == 7) {
                        mResto8 = mMap.addMarker(markerOptions);
                        mResto8name = name;
                    } else if (i == 8) {
                        mResto9 = mMap.addMarker(markerOptions);
                        mResto9name = name;
                    } else if (i == 9) {
                        mResto10 = mMap.addMarker(markerOptions);
                        mResto10name = name;
                    }
                } else if (cafeSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("cafe_far_2",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype3));
                    if (i == 0) {
                        mCafe1 = mMap.addMarker(markerOptions);
                        mCafe1name = name;
                    } else if (i == 1) {
                        mCafe2 = mMap.addMarker(markerOptions);
                        mCafe2name = name;
                    } else if (i == 2) {
                        mCafe3 = mMap.addMarker(markerOptions);
                        mCafe3name = name;
                    } else if (i == 3) {
                        mCafe4 = mMap.addMarker(markerOptions);
                        mCafe4name = name;
                    } else if (i == 4) {
                        mCafe5 = mMap.addMarker(markerOptions);
                        mCafe5name = name;
                    } else if (i == 5) {
                        mCafe6 = mMap.addMarker(markerOptions);
                        mCafe6name = name;
                    } else if (i == 6) {
                        mCafe7 = mMap.addMarker(markerOptions);
                        mCafe7name = name;
                    } else if (i == 7) {
                        mCafe8 = mMap.addMarker(markerOptions);
                        mCafe8name = name;
                    } else if (i == 8) {
                        mCafe9 = mMap.addMarker(markerOptions);
                        mCafe9name = name;
                    } else if (i == 9) {
                        mCafe10 = mMap.addMarker(markerOptions);
                        mCafe10name = name;
                    }
                } else if (schSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("school_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype4));
                    if (i == 0) {
                        mSch1 = mMap.addMarker(markerOptions);
                        mSch1name = name;
                    } else if (i == 1) {
                        mSch2 = mMap.addMarker(markerOptions);
                        mSch2name = name;
                    } else if (i == 2) {
                        mSch3 = mMap.addMarker(markerOptions);
                        mSch3name = name;
                    } else if (i == 3) {
                        mSch4 = mMap.addMarker(markerOptions);
                        mSch4name = name;
                    } else if (i == 4) {
                        mSch5 = mMap.addMarker(markerOptions);
                        mSch5name = name;
                    } else if (i == 5) {
                        mSch6 = mMap.addMarker(markerOptions);
                        mSch6name = name;
                    } else if (i == 6) {
                        mSch7 = mMap.addMarker(markerOptions);
                        mSch7name = name;
                    } else if (i == 7) {
                        mSch8 = mMap.addMarker(markerOptions);
                        mSch8name = name;
                    } else if (i == 8) {
                        mSch9 = mMap.addMarker(markerOptions);
                        mSch9name = name;
                    } else if (i == 9) {
                        mSch10 = mMap.addMarker(markerOptions);
                        mSch10name = name;
                    }
                } else if (gymSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("gym_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype5));
                    if (i == 0) {
                        mGym1 = mMap.addMarker(markerOptions);
                        mGym1name = name;
                    } else if (i == 1) {
                        mGym2 = mMap.addMarker(markerOptions);
                        mGym2name = name;
                    } else if (i == 2) {
                        mGym3 = mMap.addMarker(markerOptions);
                        mGym3name = name;
                    } else if (i == 3) {
                        mGym4 = mMap.addMarker(markerOptions);
                        mGym4name = name;
                    } else if (i == 4) {
                        mGym5 = mMap.addMarker(markerOptions);
                        mGym5name = name;
                    } else if (i == 5) {
                        mGym6 = mMap.addMarker(markerOptions);
                        mGym6name = name;
                    } else if (i == 6) {
                        mGym7 = mMap.addMarker(markerOptions);
                        mGym7name = name;
                    } else if (i == 7) {
                        mGym8 = mMap.addMarker(markerOptions);
                        mGym8name = name;
                    } else if (i == 8) {
                        mGym9 = mMap.addMarker(markerOptions);
                        mGym9name = name;
                    } else if (i == 9) {
                        mGym10 = mMap.addMarker(markerOptions);
                        mGym10name = name;
                    }
                } else if (elecSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("elec_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype6));
                    if (i == 0) {
                        mElec1 = mMap.addMarker(markerOptions);
                        mElec1name = name;
                    } else if (i == 1) {
                        mElec2 = mMap.addMarker(markerOptions);
                        mElec2name = name;
                    } else if (i == 2) {
                        mElec3 = mMap.addMarker(markerOptions);
                        mElec3name = name;
                    } else if (i == 3) {
                        mElec4 = mMap.addMarker(markerOptions);
                        mElec4name = name;
                    } else if (i == 4) {
                        mElec5 = mMap.addMarker(markerOptions);
                        mElec5name = name;
                    } else if (i == 5) {
                        mElec6 = mMap.addMarker(markerOptions);
                        mElec6name = name;
                    } else if (i == 6) {
                        mElec7 = mMap.addMarker(markerOptions);
                        mElec7name = name;
                    } else if (i == 7) {
                        mElec8 = mMap.addMarker(markerOptions);
                        mElec8name = name;
                    } else if (i == 8) {
                        mElec9 = mMap.addMarker(markerOptions);
                        mElec9name = name;
                    } else if (i == 9) {
                        mElec10 = mMap.addMarker(markerOptions);
                        mElec10name = name;
                    }
                } else if (drgSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("metal_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype7));
                    if (i == 0) {
                        mDrg1 = mMap.addMarker(markerOptions);
                        mDrg1name = name;
                    } else if (i == 1) {
                        mDrg2 = mMap.addMarker(markerOptions);
                        mDrg2name = name;
                    } else if (i == 2) {
                        mDrg3 = mMap.addMarker(markerOptions);
                        mDrg3name = name;
                    } else if (i == 3) {
                        mDrg4 = mMap.addMarker(markerOptions);
                        mDrg4name = name;
                    } else if (i == 4) {
                        mDrg5 = mMap.addMarker(markerOptions);
                        mDrg5name = name;
                    } else if (i == 5) {
                        mDrg6 = mMap.addMarker(markerOptions);
                        mDrg6name = name;
                    } else if (i == 6) {
                        mDrg7 = mMap.addMarker(markerOptions);
                        mDrg7name = name;
                    } else if (i == 7) {
                        mDrg8 = mMap.addMarker(markerOptions);
                        mDrg8name = name;
                    } else if (i == 8) {
                        mDrg9 = mMap.addMarker(markerOptions);
                        mDrg9name = name;
                    } else if (i == 9) {
                        mDrg10 = mMap.addMarker(markerOptions);
                        mDrg10name = name;
                    }
                } else if (cnvSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("plastic_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype8));
                    if (i == 0) {
                        mCnv1 = mMap.addMarker(markerOptions);
                        mCnv1name = name;
                    } else if (i == 1) {
                        mCnv2 = mMap.addMarker(markerOptions);
                        mCnv2name = name;
                    } else if (i == 2) {
                        mCnv3 = mMap.addMarker(markerOptions);
                        mCnv3name = name;
                    } else if (i == 3) {
                        mCnv4 = mMap.addMarker(markerOptions);
                        mCnv4name = name;
                    } else if (i == 4) {
                        mCnv5 = mMap.addMarker(markerOptions);
                        mCnv5name = name;
                    } else if (i == 5) {
                        mCnv6 = mMap.addMarker(markerOptions);
                        mCnv6name = name;
                    } else if (i == 6) {
                        mCnv7 = mMap.addMarker(markerOptions);
                        mCnv7name = name;
                    } else if (i == 7) {
                        mCnv8 = mMap.addMarker(markerOptions);
                        mCnv8name = name;
                    } else if (i == 8) {
                        mCnv9 = mMap.addMarker(markerOptions);
                        mCnv9name = name;
                    } else if (i == 9) {
                        mCnv10 = mMap.addMarker(markerOptions);
                        mCnv10name = name;
                    }
                } else if (chrSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("church_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype9));
                    if (i == 0) {
                        mChr1 = mMap.addMarker(markerOptions);
                        mChr1name = name;
                    } else if (i == 1) {
                        mChr2 = mMap.addMarker(markerOptions);
                        mChr2name = name;
                    } else if (i == 2) {
                        mChr3 = mMap.addMarker(markerOptions);
                        mChr3name = name;
                    } else if (i == 3) {
                        mChr4 = mMap.addMarker(markerOptions);
                        mChr4name = name;
                    } else if (i == 4) {
                        mChr5 = mMap.addMarker(markerOptions);
                        mChr5name = name;
                    } else if (i == 5) {
                        mChr6 = mMap.addMarker(markerOptions);
                        mChr6name = name;
                    } else if (i == 6) {
                        mChr7 = mMap.addMarker(markerOptions);
                        mChr7name = name;
                    } else if (i == 7) {
                        mChr8 = mMap.addMarker(markerOptions);
                        mChr8name = name;
                    } else if (i == 8) {
                        mChr9 = mMap.addMarker(markerOptions);
                        mChr9name = name;
                    } else if (i == 9) {
                        mChr10 = mMap.addMarker(markerOptions);
                        mChr10name = name;
                    }
                } else if (jobSet == 0) {
                    markerOptions.icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("labour_far_1",100,100)));
                    markerOptions.snippet(getResources().getString(R.string.loctype10));
                    if (i == 0) {
                        mJob1 = mMap.addMarker(markerOptions);
                        mJob1name = name;
                    } else if (i == 1) {
                        mJob2 = mMap.addMarker(markerOptions);
                        mJob2name = name;
                    } else if (i == 2) {
                        mJob3 = mMap.addMarker(markerOptions);
                        mJob3name = name;
                    } else if (i == 3) {
                        mJob4 = mMap.addMarker(markerOptions);
                        mJob4name = name;
                    } else if (i == 4) {
                        mJob5 = mMap.addMarker(markerOptions);
                        mJob5name = name;
                    } else if (i == 5) {
                        mJob6 = mMap.addMarker(markerOptions);
                        mJob6name = name;
                    } else if (i == 6) {
                        mJob7 = mMap.addMarker(markerOptions);
                        mJob7name = name;
                    } else if (i == 7) {
                        mJob8 = mMap.addMarker(markerOptions);
                        mJob8name = name;
                    } else if (i == 8) {
                        mJob9 = mMap.addMarker(markerOptions);
                        mJob9name = name;
                    } else if (i == 9) {
                        mJob10 = mMap.addMarker(markerOptions);
                        mJob10name = name;
                    }
                }
            }

            if (parkSet == 0) {
                parkSet++;
            } else if (restoSet == 0) {
                restoSet++;
            } else if (cafeSet == 0) {
                cafeSet++;
            } else if (schSet == 0) {
                schSet++;
            } else if (gymSet == 0) {
                gymSet++;
            } else if (elecSet == 0) {
                elecSet++;
            } else if (drgSet == 0) {
                drgSet++;
            } else if (cnvSet == 0) {
                cnvSet++;
            } else if (chrSet == 0) {
                chrSet++;
            } else if (jobSet == 0) {
                jobSet++;
            }
        }
    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch(requestCode) {
//            case (ParkActivity) : {
//                if (resultCode == MainActivity.RESULT_OK) {
//                    // TODO Extract the data returned from the child Activity.
//                    String returnValue = data.getStringExtra("some_key");
//                }
//                break;
//            }
//        }
//    }

    public class Place_JSON {

        /**
         * Receives a JSONObject and returns a list
         */
        public List<HashMap<String, String>> parse(JSONObject jObject) {

            JSONArray jPlaces = null;
            try {
                /** Retrieves all the elements in the 'places' array */
                jPlaces = jObject.getJSONArray("results");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            /** Invoking getPlaces with the array of json object
             * where each json object represent a place
             */
            return getPlaces(jPlaces);
        }

        private List<HashMap<String, String>> getPlaces(JSONArray jPlaces) {
            int placesCount = jPlaces.length();
//            if (placesCount > 10) {
//                placesCount = 10;
//            }
            List<HashMap<String, String>> placesList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> place = null;

            /** Taking each place, parses and adds to list object */
            for (int i = 0; i < placesCount; i++) {
                try {
                    /** Call getPlace with place JSON object to parse the place */
                    place = getPlace((JSONObject) jPlaces.get(i));
                    placesList.add(place);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return placesList;
        }

        /**
         * Parsing the Place JSON object
         */
        private HashMap<String, String> getPlace(JSONObject jPlace) {

            HashMap<String, String> place = new HashMap<String, String>();
            String placeName = "-NA-";
            String vicinity = "-NA-";
            String latitude = "";
            String longitude = "";
            String reference = "";

            try {
                // Extracting Place name, if available
                if (!jPlace.isNull("name")) {
                    placeName = jPlace.getString("name");
                }

                // Extracting Place Vicinity, if available
                if (!jPlace.isNull("vicinity")) {
                    vicinity = jPlace.getString("vicinity");
                }

                latitude = jPlace.getJSONObject("geometry").getJSONObject("location").getString("lat");
                longitude = jPlace.getJSONObject("geometry").getJSONObject("location").getString("lng");
                reference = jPlace.getString("reference");

                place.put("place_name", placeName);
                place.put("vicinity", vicinity);
                place.put("lat", latitude);
                place.put("lng", longitude);
                place.put("reference", reference);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return place;
        }
    }


}


