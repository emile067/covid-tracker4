package com.moringa.covidtracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.moringa.covidtracker.R;
import com.moringa.covidtracker.models.Country;
import com.moringa.covidtracker.util.ItemTouchHelperAdapter;
import com.moringa.covidtracker.util.OnStartDragListener;

public class FirebaseCountryListAdapter extends FirebaseRecyclerAdapter<Country, FirebaseCountryViewHolder>{
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseCountryListAdapter(FirebaseRecyclerOptions<Country> options,
                                      DatabaseReference ref,
                                      Context context){
        super(options);
        mRef = ref.getRef();
        mContext = context;
    }

    @NonNull
    @Override
    public FirebaseCountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new FirebaseCountryViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull FirebaseCountryViewHolder firebaseCountryViewHolder, int i, @NonNull Country country) {
        firebaseCountryViewHolder.bindCountry(country);
    }
}
