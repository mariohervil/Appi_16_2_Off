package com.example.appi_16_2_off;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appi_16_2_off.Model.ImageModel;
import com.example.appi_16_2_off.Model.Search;


import org.jetbrains.annotations.Nullable;

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
    private String queried = "";
    final static int REQUEST_CODE = 1;
    private static boolean hasSearched = false;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        Toast.makeText(this, "Welcome to Unsplash Appi!", Toast.LENGTH_LONG).show();
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
        searchData("flowers");
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
                if (!isLoading && !isLastPage) {
                    if ((visibleItem + firstVisibleItemPosition >= totalItems) && firstVisibleItemPosition >= 0 && totalItems >= pageSize) {
                        page++;
                        searchData("flowers");



                    }
                }
            }
        });


      /*
      *
      *
      *   String secretKey = "WeN7foTBeRPiDo5cLQW_d97IcN9tzKlNkN3CxbRrIkw";
        String accessKey = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";
        UnsplashPhotoPicker.INSTANCE.init(this.getApplication(), accessKey, secretKey, 20);
        boolean isMultipleSelection = false;
        this.startActivityForResult(UnsplashPickerActivity.Companion.getStartingIntent((Context) this, isMultipleSelection), REQUEST_CODE);
      *
      *searchData("flowers");
      * */
        //
// Create connection
    }

    /**
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
     *
     */



    /**
     * private void getData2() {
     *
     *         isLoading = true;
     *         ApiUtil.getApiInterface().getSearch(queried, page, 30)
     *                 .enqueue(new Callback<List<ImageModel>>() {
     *
     *                     @Override
     *                     public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
     *                         if (response.body() != null) {
     *                             //searchData(queried);
     *                             list.addAll(response.body());
     *                             adapter.notifyDataSetChanged();
     *                         }
     *
     *                         isLoading = false;
     *                         dialog.dismiss();
     *                         if (list.size() > 0) {
     *                             isLastPage = list.size() < pageSize;
     *                         } else isLastPage = true;
     *                     }
     *
     *                     @Override
     *                     public void onFailure(Call<List<ImageModel>> call, Throwable t) {
     *                         dialog.dismiss();
     *                         Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
     *                     }
     *                 });
     *     }
     *
     */


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                hasSearched = true;
                dialog.show();
                searchData2(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    private void searchData(String query) {
        queried = query;
        ApiUtil.getApiInterface().searchImage(query, page, 30)
                .enqueue(new Callback<Search>() {
                    @Override
                    public void onResponse(Call<Search> call, Response<Search> response) {

                        list.addAll(response.body().getResults());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Search> call, Throwable t) {

                    }
                });

    }
    private void searchData2(String query) {

        ApiUtil.getApiInterface().searchImage(query, page, 21)
                .enqueue(new Callback<Search>() {
                    @Override
                    public void onResponse(Call<Search> call, Response<Search> response) {
                        list.clear();
                        list.addAll(response.body().getResults());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Search> call, Throwable t) {

                    }
                });

    }




}
