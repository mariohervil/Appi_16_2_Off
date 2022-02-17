package com.example.appi_16_2_off;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AmplifiedImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amplified_image);
           ImageView imageView = findViewById(R.id.myZoomageView);
        Glide.with(this)
                .load(getIntent().getStringExtra("image"))
                .into(imageView);

    }
}