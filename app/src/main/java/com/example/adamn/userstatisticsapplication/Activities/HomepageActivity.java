package com.example.adamn.userstatisticsapplication.Activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.adamn.userstatisticsapplication.Adapters.NutritionAdapter;
import com.example.adamn.userstatisticsapplication.R;

/**
 * This Class represents the code for the homepage activity which is viewed after the user logs in.
 *
 * @author Adam Nowak
 */
public class HomepageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputLayoutHomepage;
    private LinearLayout linearLayoutHomepage;
    private TextView textViewHomepage;
    private ScrollView scrollViewHomepage;
    private Button steamAPIButton;
    private Button weatherAPIButton;
    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();

        initviews();
        initListeners();
    }

    private void initviews() {
        textInputLayoutHomepage = (TextInputLayout) findViewById(R.id.HomepageTextViewLayout);
        linearLayoutHomepage = (LinearLayout) findViewById(R.id.HomepageLinearLayout);
        textViewHomepage = (TextView) findViewById(R.id.HomepageWelcome);
        scrollViewHomepage = (ScrollView) findViewById(R.id.HomepageScrollView);
        steamAPIButton = (Button) findViewById(R.id.SteamAPIButton);
        weatherAPIButton = (Button) findViewById(R.id.WeatherAPIButton);
        button3 = (Button) findViewById(R.id.NutritionAPIButton);


    }
    private void initListeners(){
        steamAPIButton.setOnClickListener(this);
        weatherAPIButton.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.SteamAPIButton:
                Intent intentAPI1 = new Intent(getApplicationContext(),SteamActivity.class);
                startActivity(intentAPI1);
                break;
            case R.id.WeatherAPIButton:
                Intent intentAPI2 = new Intent(getApplicationContext(),WundergroundActivity.class);
                startActivity(intentAPI2);
                break;
            case R.id.NutritionAPIButton:
                Intent intentAPI3 = new Intent(getApplicationContext(),NutritionixActivity.class);
                startActivity(intentAPI3);
                break;

        }
    }
}
