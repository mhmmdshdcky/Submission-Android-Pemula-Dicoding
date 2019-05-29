package com.bitskylab.submission;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bitskylab.submission.Adapter.CardViewAvengerAdapter;
import com.bitskylab.submission.Adapter.GridAvengerAdapter;
import com.bitskylab.submission.Adapter.ListAvengerAdapter;
import com.bitskylab.submission.Data.Avenger;
import com.bitskylab.submission.Data.AvengerData;
import com.bitskylab.submission.Item.ItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    ImageView imgView;

    private ArrayList<Avenger> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(AvengerData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Avenger> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewAvengerAdapter cardViewAvengerAdapter = new CardViewAvengerAdapter(this);
        cardViewAvengerAdapter.setListAvenger(list);
        rvCategory.setAdapter(cardViewAvengerAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                openDetailActivity(list.get(position));
            }
        });
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void initRecycleCardview() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewAvengerAdapter cardviewCharactersAdapter = new CardViewAvengerAdapter(this);
        cardviewCharactersAdapter.setListAvenger(list);
        rvCategory.setAdapter(cardviewCharactersAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                openDetailActivity(list.get(position));
            }
        });
    }

    private void openDetailActivity(Avenger avenger) {
        Class destinationClass = DetailActivity.class;
        Context context = MainActivity.this;
        Intent openDetailActivity = new Intent(context, destinationClass);
        openDetailActivity.putExtra(DetailActivity.EXTRA_NAMA, avenger.getName());
        openDetailActivity.putExtra(DetailActivity.EXTRA_DESKRIPSI, avenger.getDescription());
        openDetailActivity.putExtra(DetailActivity.EXTRA_JUDUL, avenger.getRemarks());
        openDetailActivity.putExtra(DetailActivity.EXTRA_GAMBAR, avenger.getPhoto());
        startActivity(openDetailActivity);
    }

    private void showSelectedAvenger(Avenger avenger) {
        Toast.makeText(this, "Kamu memilih " + avenger.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAvengerAdapter listAvengerAdapter = new ListAvengerAdapter(this);
        listAvengerAdapter.setListAvenger(list);
        rvCategory.setAdapter(listAvengerAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                openDetailActivity(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridAvengerAdapter gridAvengerAdapter = new GridAvengerAdapter(this);
        gridAvengerAdapter.setListAvenger(list);
        rvCategory.setAdapter(gridAvengerAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                openDetailActivity(list.get(position));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}