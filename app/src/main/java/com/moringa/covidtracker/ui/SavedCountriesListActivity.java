package com.moringa.covidtracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringa.covidtracker.Constants;
import com.moringa.covidtracker.R;
import com.moringa.covidtracker.adapters.FirebaseCountryListAdapter;
import com.moringa.covidtracker.adapters.FirebaseCountryViewHolder;
import com.moringa.covidtracker.models.Country;
import com.moringa.covidtracker.util.OnStartDragListener;
import com.moringa.covidtracker.util.SimpleItemTouchHelperCallback;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedCountriesListActivity  extends AppCompatActivity{
    public static final String TAG = SavedCountriesListActivity.class.getSimpleName();

    private DatabaseReference mRef;
    private FirebaseCountryListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
    @BindView(R.id.countriesRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.addButton) Button mAddButton;
    @BindView(R.id.newCountryEditText) TextView mNewCountryEditText;

    private ArrayList<Country> mCountries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_countries_list);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COUNTRIES).child(uid);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    mCountries.clear();
                for (DataSnapshot dss : snapshot.getChildren()) {
                    Country country = new Country();
                    country.setName(dss.getValue(Country.class).getName());
                    mCountries.add(country);
                    Log.d("countries updated", "country: " + country.getName()); //log
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG,"Failed to add.");
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryName = toJadenCase(mNewCountryEditText.getText().toString());
                Country country = new Country(countryName);
                mCountries.add(country);
                mRef.setValue(mCountries);
            }
        });

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Country> options =
                new FirebaseRecyclerOptions.Builder<Country>()
                        .setQuery(mRef, Country.class)
                        .build();

        mFirebaseAdapter = new FirebaseCountryListAdapter(options,mRef,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        showCases();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
        mItemTouchHelper.startDrag(viewHolder);
    }
    //function for showing the recycler view
    private void showCases() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    //For converting to JadenCase which is the form that the api takes for the country input e.g: sierra leone = Sierra Leone
    public String toJadenCase(String phrase) {
        if(phrase == null || phrase.equals("")) return null;

        char[] array = phrase.toCharArray();

        for(int x = 0; x < array.length; x++) {
            if(x == 0 || array[x-1] == ' ') {
                array[x] = Character.toUpperCase(array[x]);
            }
        }

        return new String(array);
    }
}
