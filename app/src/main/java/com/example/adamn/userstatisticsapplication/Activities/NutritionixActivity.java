package com.example.adamn.userstatisticsapplication.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.adamn.userstatisticsapplication.API.SteamAPI.HttpHandler;
import com.example.adamn.userstatisticsapplication.Adapters.NutritionAdapter;
import com.example.adamn.userstatisticsapplication.Adapters.WeatherAdapter;
import com.example.adamn.userstatisticsapplication.Models.NutritionObject;
import com.example.adamn.userstatisticsapplication.Models.WeatherObject;
import com.example.adamn.userstatisticsapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
/**
 * This Class represents the nutritionix activity which is one of the three views that handles
 * an API. This class uses the Nutritionix API in order to allow the user to gather information
 * regarding various food items.
 * API used from this activity can be found on https://www.nutritionix.com/business/api
 *
 * @author Adam Nowak
 */

public class NutritionixActivity extends AppCompatActivity implements View.OnClickListener {

    private List<NutritionObject> nutritionObjects;
    private String itemInput;
    private ListView lv;
    private EditText input;
    private Button submitButton;
    private NutritionAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritionix);
        getSupportActionBar().hide();
        nutritionObjects = new ArrayList<>();
        initviews();
        initListeners();
        adapter = new NutritionAdapter(getApplicationContext(),nutritionObjects);
        lv.setAdapter(adapter);

    }


    private void initviews() {
        lv = (ListView) findViewById(R.id.nutritionListView);
        input = (EditText) findViewById(R.id.nutritionEnterFood);
        submitButton = (Button) findViewById(R.id.nutritionSubmit);
    }
    private void initListeners() {
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.nutritionSubmit){
            if (nutritionObjects != null){
                nutritionObjects.clear();
                adapter.notifyDataSetChanged();
            }
            adapter.notifyDataSetChanged();
            itemInput = input.getText().toString().trim();
            new JSONTASKNutrition().execute();
        }
    }

    public class JSONTASKNutrition extends AsyncTask<Object, Object, String> {
        private String name;
        private String brand;
        private String calories;
        private String fat;
        private String serving;


        @Override
        protected String doInBackground(Object... params) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String url = "https://api.nutritionix.com/v1_1/search/" + itemInput + "?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=05727e6c&appKey=70674ad7c8a998b7914c0e9f29040138";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray hits = jsonObject.getJSONArray("hits");
                    for (int i = 0; i < hits.length(); i++) {
                        JSONObject incrementedObject = hits.getJSONObject(i);
                        JSONObject fields = incrementedObject.getJSONObject("fields");
                        name = fields.getString("item_name");
                        brand = fields.getString("brand_name");
                        calories = fields.getString("nf_calories");
                        fat = fields.getString("nf_total_fat");
                        serving = fields.getString("nf_serving_size_qty");
                        nutritionObjects.add(new NutritionObject(name,brand,calories,fat,serving));
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
