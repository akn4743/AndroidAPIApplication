package com.example.adamn.userstatisticsapplication.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adamn.userstatisticsapplication.API.SteamAPI.HttpHandler;
import com.example.adamn.userstatisticsapplication.Adapters.WeatherAdapter;
import com.example.adamn.userstatisticsapplication.Models.WeatherObject;
import com.example.adamn.userstatisticsapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
/**
 * This Class represents the homepage activity which is viewed after the user logs in.
 * API and Images used to create this Activity was provided by https://www.wunderground.com/.
 * @author Adam Nowak
 */

public class WundergroundActivity extends AppCompatActivity {

    private ListView lv;
    private List<WeatherObject> weatherObjects;
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wunderground);
        getSupportActionBar().hide();
        initviews();
        weatherObjects = new ArrayList<>();
        new JSONTASKWeather().execute();
        adapter = new WeatherAdapter(getApplicationContext(),weatherObjects);
        lv.setAdapter(adapter);
    }

    private void initviews() {
        lv = (ListView) findViewById(R.id.weatherListView);
    }

    public class JSONTASKWeather extends AsyncTask<Object, Object, String> {

        private String title;
        private String text;
        private String weather;


        @Override
        protected String doInBackground(Object... params) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String url = "http://api.wunderground.com/api/b80d3b76b6975ae3/forecast10day/q/NY/New_York.json";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONObject forecast = jsonObject.getJSONObject("forecast");
                    JSONObject textforecast = forecast.getJSONObject("txt_forecast");
                    JSONArray forecastday = textforecast.getJSONArray("forecastday");
                    for (int i = 0; i < forecastday.length();i++){
                        JSONObject incrementedObject = forecastday.getJSONObject(i);
                        title = incrementedObject.getString("title");
                        text = incrementedObject.getString("fcttext");
                        weather = incrementedObject.getString("icon");

                        weatherObjects.add(new WeatherObject(title,text,weather));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return jsonStr;
        }
        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);

        }
    }
}
