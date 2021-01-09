package com.moringa.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FAQActivity extends AppCompatActivity {
    @BindView(R.id.MostCommonSymptomslistView) ListView mMostCommonSymptomslistView;
    @BindView(R.id.lessCommonSymptomslistView) ListView mLessCommonSymptomslistView;
    @BindView(R.id.seriousSymptomslistView) ListView mSeriousSymptomslistView;
    private final String[] mostCommonSymptoms = new String[] {"fever", "dry cough", "tiredness"};
    private final String[] lessCommonSymptoms = new String[] {"aches and pains", "sore throat", "diarrhoea","conjunctivitis","headache","loss of taste or smell","a rash on skin, or discolouration of fingers or toes"};
    private final String[] seriousSymptoms = new String[] {"difficulty breathing or shortness of breath","chest pain or pressure", "loss of speech or movement"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mostCommonSymptoms);
        mMostCommonSymptomslistView.setAdapter(adapter);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lessCommonSymptoms);
        mLessCommonSymptomslistView.setAdapter(adapter2);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lessCommonSymptoms);
        mSeriousSymptomslistView.setAdapter(adapter3);
    }
}