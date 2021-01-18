package com.moringa.covidtracker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringa.covidtracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.HomepageEnterButton) Button mHomePageEnterButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;

    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mHomePageEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                country = mNameEditText.getText().toString();
//                country = toJadenCase(country);
                Intent intent = new Intent(MainActivity.this, FAQActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                country = mNameEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                intent.putExtra("country", country);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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