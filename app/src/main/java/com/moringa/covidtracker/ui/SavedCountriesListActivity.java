package com.moringa.covidtracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private DatabaseReference mRef;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
    @BindView(R.id.countriesRecyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_countries_list);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COUNTRIES).child(uid);
        FirebaseRecyclerOptions<String> options =
                new FirebaseRecyclerOptions.Builder<String>()
                        .setQuery(mRef, String.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<String, FirebaseCountryViewHolder>(options) {
            @NonNull
            @Override
            public FirebaseCountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
                return new FirebaseCountryViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FirebaseCountryViewHolder firebaseCountryViewHolder, int i, @NonNull String s) {
                firebaseCountryViewHolder.nameTextView.setText(s);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseAdapter.startListening();
        mRecyclerView.setAdapter(mFirebaseAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private void setUpFirebaseAdapter(){
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
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
}
