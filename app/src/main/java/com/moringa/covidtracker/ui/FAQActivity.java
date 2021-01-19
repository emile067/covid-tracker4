package com.moringa.covidtracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.moringa.covidtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FAQActivity extends AppCompatActivity {
    @BindView(R.id.MostCommonSymptomslistView) ListView mMostCommonSymptomslistView;
    @BindView(R.id.lessCommonSymptomslistView) ListView mLessCommonSymptomslistView;
    @BindView(R.id.seriousSymptomslistView) ListView mSeriousSymptomslistView;
    @BindView(R.id.preventionListView) ListView mPreventionListView;
    private final String[] mostCommonSymptoms = new String[] {"fever", "dry cough", "tiredness"};
    private final String[] lessCommonSymptoms = new String[] {"aches and pains", "sore throat", "diarrhoea","conjunctivitis","headache","loss of taste or smell","a rash on skin, or discolouration of fingers or toes"};
    private final String[] seriousSymptoms = new String[] {"difficulty breathing or shortness of breath","chest pain or pressure", "loss of speech or movement"};
    private final String[] prevention = new String[] {"Clean your hands often., Use soap and water, or an alcohol-based hand rub.",
            "Maintain a safe distance from anyone who is coughing or sneezing.",
            "Wear a mask when physical distancing is not possible.",
            "Don’t touch your eyes, nose or mouth.",
            "Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.",
            "Stay home if you feel unwell.",
            "If you have a fever, cough and difficulty breathing, seek medical attention."};

    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        country = intent.getStringExtra("country");

        //setting title of the page
        getSupportActionBar().setTitle("FAQ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String welcomeText= "Welcome to TrackCovid " + country;
        Toast.makeText(FAQActivity.this, welcomeText, Toast.LENGTH_LONG).show();

        //creating adapters to pass the arrays onto the the list views
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mostCommonSymptoms);
        mMostCommonSymptomslistView.setAdapter(adapter);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lessCommonSymptoms);
        mLessCommonSymptomslistView.setAdapter(adapter2);
        ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, seriousSymptoms);
        mSeriousSymptomslistView.setAdapter(adapter3);
        ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, prevention);
        mPreventionListView.setAdapter(adapter4);
    }
}