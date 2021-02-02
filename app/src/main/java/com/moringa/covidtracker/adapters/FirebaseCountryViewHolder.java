package com.moringa.covidtracker.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringa.covidtracker.Constants;
import com.moringa.covidtracker.R;
import com.moringa.covidtracker.models.Country;
import com.moringa.covidtracker.ui.CountryActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseCountryViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;
    public ImageView reorderImageView;
    public TextView nameTextView = mView.findViewById(R.id.countryTextView);

    public FirebaseCountryViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCountry(Country country){
        nameTextView.setText(country.getName());
    }

    @Override
    public void onClick(View v) {
    }
}
