package com.example.appi_16_2_off;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker;
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public final class MainActivity extends AppCompatActivity {

    private String accessKey = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";

    private String secretKey = "WeN7foTBeRPiDo5cLQW_d97IcN9tzKlNkN3CxbRrIkw";
    private boolean isMultipleSelection = false;
    final static int REQUEST_CODE = 1;

    @SuppressWarnings("deprecation")
    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intrinsics.checkNotNullExpressionValue(this.getApplication(), "this.application");
        UnsplashPhotoPicker.INSTANCE.init(this.getApplication(), this.accessKey, this.secretKey, 20);
        this.startActivityForResult(UnsplashPickerActivity.Companion.getStartingIntent((Context)this, this.isMultipleSelection), REQUEST_CODE);
        URL unsplashEndpoint = null;
        try {
            unsplashEndpoint = new URL("https://api.unsplash.com/");
            HttpsURLConnection myConnection =
                    (HttpsURLConnection) unsplashEndpoint.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

// Create connection






    }
}


