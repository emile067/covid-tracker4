package com.moringa.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FAQActivity extends AppCompatActivity {
    private String[] mostCommonSymptoms = new String[] {"fever", "dry cough", "tiredness"};
    private String[] lessCommonSymptoms = new String[] {"aches and pains", "sore throat", "diarrhoea","conjunctivitis","headache","loss of taste or smell","a rash on skin, or discolouration of fingers or toes"};
    private String[] seriousSymptoms = new String[] {"difficulty breathing or shortness of breath","chest pain or pressure", "loss of speech or movement"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);
    }
}