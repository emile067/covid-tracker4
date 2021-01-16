package com.moringa.covidtracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.moringa.covidtracker.R;
import com.moringa.covidtracker.adapters.CovidCasesAdapter;
import com.moringa.covidtracker.models.All;
import com.moringa.covidtracker.models.Cases;
import com.moringa.covidtracker.network.CovidApi;
import com.moringa.covidtracker.network.CovidClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class CountryActivity extends AppCompatActivity {
    @BindView(R.id.casesRecyclerView) RecyclerView mCasesRecyclerView;

    private List<All> mCases;
    private CovidCasesAdapter mCasesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Covid Stats");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String welcomeText= "Welcome to TrackCovid " + userName;
        Toast.makeText(CountryActivity.this, welcomeText, Toast.LENGTH_LONG).show();

        CovidApi client = CovidClient.getCases().create(CovidApi.class);
        Call<Cases> call = client.getCases("Rwanda");

    }
}