package com.example.appi_16_2_off;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appi_16_2_off.Model.ImageModel;
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker;
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity;

import org.jetbrains.annotations.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ImageModel> list;
    private GridLayoutManager gridLayoutManager;
    private ImageAdapter adapter;
    private int page = 1;
    private ProgressDialog dialog;
    private int pageSize = 30;
    private boolean isLoading;
    private boolean isLastPage;
    final static int REQUEST_CODE = 1;

    @SuppressWarnings("deprecation")
    @SuppressLint("ResourceType")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, list);
        gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading . . .");
        dialog.setCancelable(false);
        dialog.show();
        getData();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItem = gridLayoutManager.getChildCount();
                int totalItems = gridLayoutManager.getItemCount();
                int firstVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                if (!isLoading && !isLastPage){
                    if ((visibleItem + firstVisibleItemPosition >= totalItems) && firstVisibleItemPosition>=0 && totalItems >= pageSize){
                        page++;
                        getData();
                    }
                }
            }
        });


        String secretKey = "WeN7foTBeRPiDo5cLQW_d97IcN9tzKlNkN3CxbRrIkw";
        String accessKey = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";
        UnsplashPhotoPicker.INSTANCE.init(this.getApplication(), accessKey, secretKey, 20);
        boolean isMultipleSelection = false;
        this.startActivityForResult(UnsplashPickerActivity.Companion.getStartingIntent((Context) this, isMultipleSelection), REQUEST_CODE);
        //
// Create connection
    }

    private void getData() {
        isLoading = true;
        ApiUtil.getApiInterface().getImages(page, 30)
                .enqueue(new Callback<List<ImageModel>>() {
                    @Override
                    public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                        if (response.body() != null) {
                            list.addAll(response.body());
                            adapter.notifyDataSetChanged();

                        }
                        isLoading = false;
                        dialog.dismiss();
                        if (list.size() > 0) {
                            isLastPage = list.size() < pageSize;
                        } else isLastPage = true;
                    }

                    @Override
                    public void onFailure(Call<List<ImageModel>> call, Throwable t) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}


