package com.moringa.covidtracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.covidtracker.Constants;
import com.moringa.covidtracker.R;
import com.moringa.covidtracker.adapters.CovidCasesAdapter;
import com.moringa.covidtracker.models.All;
import com.moringa.covidtracker.models.Cases;
import com.moringa.covidtracker.network.CovidApi;
import com.moringa.covidtracker.network.CovidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryActivity extends AppCompatActivity {
    @BindView(R.id.casesRecyclerView) RecyclerView mCasesRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private Cases mCases;
    private List<Cases> mCasesList = new ArrayList<Cases>();
    private CovidCasesAdapter mCasesAdapter;

    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        //Set title of the activity on the menu bar
        getSupportActionBar().setTitle("Covid Stats");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");
        String welcomeText= "Welcome to TrackCovid " + country;
        Toast.makeText(CountryActivity.this, welcomeText, Toast.LENGTH_LONG).show();

        if(country != null){
            getCountryCases(country);
        }
    }

    //creating the additional menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    //setting functions for the menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(CountryActivity.this, FAQActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
                return true;
            case R.id.action_logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(CountryActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
    //function for showing the recycler view
    private void showCases() {
        mCasesRecyclerView.setVisibility(View.VISIBLE);
    }

    private void getCountryCases(String country){
        CovidApi client = CovidClient.getCases();
        Call<Cases> call = client.getCases(country);
        call.enqueue(new Callback<Cases>(){
            @Override
            public void onResponse(Call<Cases> call, Response<Cases> response){
                All all = response.body().getAll();
                mCases = new Cases(all);
                mCasesList.add(mCases);
                CountryActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mCasesAdapter = new CovidCasesAdapter(getApplicationContext(), mCasesList);
                        mCasesRecyclerView.setAdapter(mCasesAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CountryActivity.this);
                        mCasesRecyclerView.setLayoutManager(layoutManager);
                        mCasesRecyclerView.setHasFixedSize(true);

                        showCases();
                    }
                });
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                showUnsuccessfulMessage();
            }
        });
    }

    //unsuccessful message for when the response fails
    private void showUnsuccessfulMessage() {
        mErrorTextView.setVisibility(View.VISIBLE);
    }
}