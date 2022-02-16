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

public final class MainActivity extends AppCompatActivity {
    @NotNull
    private String accessKey = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";
    @NotNull
    private String secretKey = "WeN7foTBeRPiDo5cLQW_d97IcN9tzKlNkN3CxbRrIkw";
    private boolean isMultipleSelection;
    private int REQUEST_CODE = 1;

    @NotNull
    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.accessKey = var1;
    }

    @NotNull
    public final String getSecretKey() {
        return this.secretKey;
    }

    public final void setSecretKey(@NotNull String var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.secretKey = var1;
    }

    public final boolean isMultipleSelection() {
        return this.isMultipleSelection;
    }

    public final void setMultipleSelection(boolean var1) {
        this.isMultipleSelection = var1;
    }

    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300090);
        UnsplashPhotoPicker var10000 = UnsplashPhotoPicker.INSTANCE;
        Application var10001 = this.getApplication();
        Intrinsics.checkNotNullExpressionValue(var10001, "this.application");
        var10000.init(var10001, this.accessKey, this.secretKey, 20);
        this.startActivityForResult(UnsplashPickerActivity.Companion.getStartingIntent((Context)this, this.isMultipleSelection), this.REQUEST_CODE);
    }
}



/*
package com.example.appi_16_2kt;

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

@Metadata(
   mv = {1, 6, 0},
   k = 1,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0017"},
   d2 = {"Lcom/example/appi_16_2kt/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "REQUEST_CODE", "", "accessKey", "", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "isMultipleSelection", "", "()Z", "setMultipleSelection", "(Z)V", "secretKey", "getSecretKey", "setSecretKey", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
public final class MainActivity extends AppCompatActivity {
   @NotNull
   private String accessKey = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";
   @NotNull
   private String secretKey = "WeN7foTBeRPiDo5cLQW_d97IcN9tzKlNkN3CxbRrIkw";
   private boolean isMultipleSelection;
   private int REQUEST_CODE = 1;

   @NotNull
   public final String getAccessKey() {
      return this.accessKey;
   }

   public final void setAccessKey(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.accessKey = var1;
   }

   @NotNull
   public final String getSecretKey() {
      return this.secretKey;
   }

   public final void setSecretKey(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.secretKey = var1;
   }

   public final boolean isMultipleSelection() {
      return this.isMultipleSelection;
   }

   public final void setMultipleSelection(boolean var1) {
      this.isMultipleSelection = var1;
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(1300090);
      UnsplashPhotoPicker var10000 = UnsplashPhotoPicker.INSTANCE;
      Application var10001 = this.getApplication();
      Intrinsics.checkNotNullExpressionValue(var10001, "this.application");
      var10000.init(var10001, this.accessKey, this.secretKey, 20);
      this.startActivityForResult(UnsplashPickerActivity.Companion.getStartingIntent((Context)this, this.isMultipleSelection), this.REQUEST_CODE);
   }
}



 */


/*
package com.example.appi_16_2_off;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker;
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto;
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
String accessKey = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";
String secretKey = "WeN7foTBeRPiDo5cLQW_d97IcN9tzKlNkN3CxbRrIkw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UnsplashPhotoPicker.INSTANCE.init(this.getApplication(),accessKey,secretKey, 20);

        startActivityForResult(UnsplashPickerActivity.getStartingIntent(this, isMultipleSelection), REQUEST_CODE);



    }

    public void V(View view){

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
          ArrayList<UnsplashPhoto> photos = intent.getParcelableArrayListExtra(UnsplashPickerActivity.EXTRA_PHOTOS);
            // use your photos here
        }
    }
}

 */


