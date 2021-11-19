package com.alexdevp.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alexdevp.starwars.R;
import com.alexdevp.starwars.model.People;
import com.alexdevp.starwars.ui.adapters.PeopleAdapter;
import com.alexdevp.starwars.ui.adapters.local.Repository.DatabaseRepositoryPeople;

public class PeopleActivity extends AppCompatActivity implements DatabaseRepositoryPeople.OnDataAvailableCallBack {

    private PeopleAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        recyclerView = findViewById(R.id.recycler_view_people);

        adapter = new PeopleAdapter(this, new PeopleAdapter.ItemClickListener() {
            @Override
            public void onItemClick(People people) {
                Intent intent = new Intent(PeopleActivity.this, PeopleDetailsActivity.class);
                intent.putExtra("People", people);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseRepositoryPeople.getPeople(this, this);
    }

    @Override
    public void onSuccess(final Object people) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                PeopleActivity.this.adapter.updateList((People[]) people);
            }
        });
    }

    @Override
    public void onError(String Error) {
        Log.e("MainActivity", Error);
    }
}