package com.moringa.covidtracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.covidtracker.R;
import com.moringa.covidtracker.models.Cases;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CovidCasesAdapter extends RecyclerView.Adapter<CovidCasesAdapter.CasesViewHolder> implements Filterable {

    private List<Cases> mCases;
    private Context mContext;

    public CovidCasesAdapter(Context mContext, List<Cases> mCases) {
        this.mContext = mContext;
        this.mCases = mCases;
    }

    @NonNull
    @Override
    public CovidCasesAdapter.CasesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_case_item, parent, false);
        CasesViewHolder viewHolder = new CasesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CovidCasesAdapter.CasesViewHolder holder, int position) {
        holder.bindCases(mCases.get(position));
    }

    @Override
    public int getItemCount() {
        return mCases.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public class CasesViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.countryTextView) TextView mCountryTextView;
        @BindView(R.id.casesTextView) TextView mCasesTextView;
        @BindView(R.id.recoveredTextView) TextView mRecoveredTextView;
        @BindView(R.id.deathsTextView) TextView mDeathsTextView;
        private Context mContext;

        public CasesViewHolder(@NonNull View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCases( Cases mCases){
            mCountryTextView.setText(mCases.getAll().getCountry());
            mCasesTextView.setText(String.valueOf(mCases.getAll().getConfirmed()));
            mRecoveredTextView.setText(String.valueOf(mCases.getAll().getRecovered()));
            mDeathsTextView.setText(String.valueOf(mCases.getAll().getDeaths()));
        }
    }
}
