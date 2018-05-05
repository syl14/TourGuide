package com.example.szilvi.tour_guide_bp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsInNewPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_info);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        String placeName = bundle.getString(getString(R.string.place));
        final String placeAddress = bundle.getString(getString(R.string.address));
        final String placeInfo = bundle.getString(getString(R.string.info));
        final int placeImage = bundle.getInt(getString(R.string.picture));
        final String placePhone = bundle.getString(getString(R.string.phone));
        final String placeWeb = bundle.getString(getString(R.string.web));
        final String placeGps = bundle.getString((getString(R.string.gps)));

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(placeName);

        //Setting the styles to expanded and collapsed toolbar
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);


        //Set the place name to the TextView
        TextView namePlaceView = findViewById(R.id.nameDetail);
        namePlaceView.setText(placeName);

        //Set the place address to the TextView
        TextView addressPlaceView = findViewById(R.id.placeDetail);
        addressPlaceView.setText(placeAddress);

        //Set the place info to the TextView
        TextView infoPlaceView = findViewById(R.id.textInfo);
        infoPlaceView.setText(placeInfo);

        //Set proper image
        ImageView imagePlaceView = findViewById(R.id.bigPicture);
        imagePlaceView.setImageResource(placeImage);

        ImageButton phonePlaceView = findViewById(R.id.telephone);

        phonePlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int REQUEST_PHONE_CALL = 1;

                String callNumber = getString(R.string.telefon) + placePhone;

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(callNumber));

                // check for permission
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(DetailsInNewPage.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(DetailsInNewPage.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                    } else {
                        startActivity(callIntent);
                    }
                }
            }
        });

        //open web page with onClickListener
        ImageButton webPlaceView = findViewById(R.id.web);

        webPlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(placeWeb));
                if (web.resolveActivity(getPackageManager()) != null) {
                    startActivity(web);
                }
            }
        });

        ImageButton gpsPlaceView = findViewById(R.id.location);
        final String goToAddress = getString(R.string.goTo) + placeAddress;

        gpsPlaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gps = new Intent(Intent.ACTION_VIEW);
                gps.setData(Uri.parse(goToAddress));
                if (gps.resolveActivity(getPackageManager()) != null) {
                    startActivity(gps);
                }
            }
        });

    }
}
