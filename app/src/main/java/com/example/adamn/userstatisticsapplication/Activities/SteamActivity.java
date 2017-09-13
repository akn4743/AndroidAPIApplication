package com.example.adamn.userstatisticsapplication.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adamn.userstatisticsapplication.API.SteamAPI.HttpHandler;
import com.example.adamn.userstatisticsapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
/**
 * This Class represents the steam activity which is a class that uses the SteamSpy API to
 * gather statistics regarding games on steam.
 * API's used in this activity were used from http://steamspy.com/api.php?
 *
 * @author Adam Nowak
 */

public class SteamActivity extends AppCompatActivity {

    private TextView allTimeGameName1;
    private TextView allTimeGameName2;
    private TextView allTimeGameName3;
    private TextView allTimeGameName4;
    private TextView allTimeGameName5;
    private TextView allTimeGameName6;
    private TextView allTimeGameName7;
    private TextView allTimeGameName8;
    private TextView allTimeGameName9;
    private TextView allTimeGameName10;


    private TextView steamAPIMostPopularAllTimePlayerCount;
    private TextView steamAPIMostPopularAllTimePlayerCount1;
    private TextView steamAPIMostPopularAllTimePlayerCount2;
    private TextView steamAPIMostPopularAllTimePlayerCount3;
    private TextView steamAPIMostPopularAllTimePlayerCount4;
    private TextView steamAPIMostPopularAllTimePlayerCount5;
    private TextView steamAPIMostPopularAllTimePlayerCount6;
    private TextView steamAPIMostPopularAllTimePlayerCount7;
    private TextView steamAPIMostPopularAllTimePlayerCount8;
    private TextView steamAPIMostPopularAllTimePlayerCount9;
    private TextView steamAPIMostPopularAllTimePlayerCount10;


    private TextView recentGameName1;
    private TextView recentGameName2;
    private TextView recentGameName3;
    private TextView recentGameName4;
    private TextView recentGameName5;
    private TextView recentGameName6;
    private TextView recentGameName7;
    private TextView recentGameName8;
    private TextView recentGameName9;
    private TextView recentGameName10;

    private TextView steamAPIMostPopularRecentPlayerCount1;
    private TextView steamAPIMostPopularRecentPlayerCount2;
    private TextView steamAPIMostPopularRecentPlayerCount3;
    private TextView steamAPIMostPopularRecentPlayerCount4;
    private TextView steamAPIMostPopularRecentPlayerCount5;
    private TextView steamAPIMostPopularRecentPlayerCount6;
    private TextView steamAPIMostPopularRecentPlayerCount7;
    private TextView steamAPIMostPopularRecentPlayerCount8;
    private TextView steamAPIMostPopularRecentPlayerCount9;
    private TextView steamAPIMostPopularRecentPlayerCount10;


    private TextView allTimeOwnedGameName1;
    private TextView allTimeOwnedGameName2;
    private TextView allTimeOwnedGameName3;
    private TextView allTimeOwnedGameName4;
    private TextView allTimeOwnedGameName5;
    private TextView allTimeOwnedGameName6;
    private TextView allTimeOwnedGameName7;
    private TextView allTimeOwnedGameName8;
    private TextView allTimeOwnedGameName9;
    private TextView allTimeOwnedGameName10;

    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount1;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount2;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount3;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount4;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount5;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount6;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount7;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount8;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount9;
    private TextView steamAPIMostPopularAllTimeOwnedPlayerCount10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steam);
        initviews();



    }


    private void initviews() {
        new JSONTASKMostPopularGamesAllTime().execute();
        new JSONTASKMostPopularRecentGames().execute();
        new JSONTASKMostPopularOwnedGames().execute();

        allTimeGameName1 = (TextView) findViewById(R.id.AllTimeGameName1);
        allTimeGameName2 = (TextView) findViewById(R.id.AllTimeGameName2);
        allTimeGameName3 = (TextView) findViewById(R.id.AllTimeGameName3);
        allTimeGameName4 = (TextView) findViewById(R.id.AllTimeGameName4);
        allTimeGameName5 = (TextView) findViewById(R.id.AllTimeGameName5);
        allTimeGameName6 = (TextView) findViewById(R.id.AllTimeGameName6);
        allTimeGameName7 = (TextView) findViewById(R.id.AllTimeGameName7);
        allTimeGameName8 = (TextView) findViewById(R.id.AllTimeGameName8);
        allTimeGameName9 = (TextView) findViewById(R.id.AllTimeGameName9);
        allTimeGameName10 = (TextView) findViewById(R.id.AllTimeGameName10);

        //steamAPIMostPopularAllTimePlayerCount = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount);
        steamAPIMostPopularAllTimePlayerCount1 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount1);
        steamAPIMostPopularAllTimePlayerCount2 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount2);
        steamAPIMostPopularAllTimePlayerCount3 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount3);
        steamAPIMostPopularAllTimePlayerCount4 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount4);
        steamAPIMostPopularAllTimePlayerCount5 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount5);
        steamAPIMostPopularAllTimePlayerCount6 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount6);
        steamAPIMostPopularAllTimePlayerCount7 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount7);
        steamAPIMostPopularAllTimePlayerCount8 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount8);
        steamAPIMostPopularAllTimePlayerCount9 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount9);
        steamAPIMostPopularAllTimePlayerCount10 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimePlayerCount10);


        recentGameName1 = (TextView) findViewById(R.id.RecentGameName1);
        recentGameName2 = (TextView) findViewById(R.id.RecentGameName2);
        recentGameName3 = (TextView) findViewById(R.id.RecentGameName3);
        recentGameName4 = (TextView) findViewById(R.id.RecentGameName4);
        recentGameName5 = (TextView) findViewById(R.id.RecentGameName5);
        recentGameName6 = (TextView) findViewById(R.id.RecentGameName6);
        recentGameName7 = (TextView) findViewById(R.id.RecentGameName7);
        recentGameName8 = (TextView) findViewById(R.id.RecentGameName8);
        recentGameName9 = (TextView) findViewById(R.id.RecentGameName9);
        recentGameName10 = (TextView) findViewById(R.id.RecentGameName10);

        steamAPIMostPopularRecentPlayerCount1 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount1);
        steamAPIMostPopularRecentPlayerCount2 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount2);
        steamAPIMostPopularRecentPlayerCount3 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount3);
        steamAPIMostPopularRecentPlayerCount4 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount4);
        steamAPIMostPopularRecentPlayerCount5 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount5);
        steamAPIMostPopularRecentPlayerCount6 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount6);
        steamAPIMostPopularRecentPlayerCount7 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount7);
        steamAPIMostPopularRecentPlayerCount8 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount8);
        steamAPIMostPopularRecentPlayerCount9 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount9);
        steamAPIMostPopularRecentPlayerCount10 = (TextView) findViewById(R.id.SteamAPIMostPopularRecentPlayerCount10);

        allTimeOwnedGameName1 = (TextView) findViewById(R.id.AllTimeOwnedGameName1);
        allTimeOwnedGameName2 = (TextView) findViewById(R.id.AllTimeOwnedGameName2);
        allTimeOwnedGameName3 = (TextView) findViewById(R.id.AllTimeOwnedGameName3);
        allTimeOwnedGameName4 = (TextView) findViewById(R.id.AllTimeOwnedGameName4);
        allTimeOwnedGameName5 = (TextView) findViewById(R.id.AllTimeOwnedGameName5);
        allTimeOwnedGameName6 = (TextView) findViewById(R.id.AllTimeOwnedGameName6);
        allTimeOwnedGameName7 = (TextView) findViewById(R.id.AllTimeOwnedGameName7);
        allTimeOwnedGameName8 = (TextView) findViewById(R.id.AllTimeOwnedGameName8);
        allTimeOwnedGameName9 = (TextView) findViewById(R.id.AllTimeOwnedGameName9);
        allTimeOwnedGameName10 = (TextView) findViewById(R.id.AllTimeOwnedGameName10);

        steamAPIMostPopularAllTimeOwnedPlayerCount1 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount1);
        steamAPIMostPopularAllTimeOwnedPlayerCount2 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount2);
        steamAPIMostPopularAllTimeOwnedPlayerCount3 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount3);
        steamAPIMostPopularAllTimeOwnedPlayerCount4 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount4);
        steamAPIMostPopularAllTimeOwnedPlayerCount5 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount5);
        steamAPIMostPopularAllTimeOwnedPlayerCount6 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount6);
        steamAPIMostPopularAllTimeOwnedPlayerCount7 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount7);
        steamAPIMostPopularAllTimeOwnedPlayerCount8 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount8);
        steamAPIMostPopularAllTimeOwnedPlayerCount9 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount9);
        steamAPIMostPopularAllTimeOwnedPlayerCount10 = (TextView) findViewById(R.id.SteamAPIMostPopularAllTimeOwnedPlayerCount10);





    }
    public class JSONTASKMostPopularGamesAllTime extends AsyncTask<Object, Object, String> {

        private String name_1;
        private String name_2;
        private String name_3;
        private String name_4;
        private String name_5;
        private String name_6;
        private String name_7;
        private String name_8;
        private String name_9;
        private String name_10;

        private String players_1;
        private String players_2;
        private String players_3;
        private String players_4;
        private String players_5;
        private String players_6;
        private String players_7;
        private String players_8;
        private String players_9;
        private String players_10;


        @Override
        protected String doInBackground(Object... params) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String url = "http://steamspy.com/api.php?request=top100forever";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    Iterator<?> keys = jsonObject.keys();
                    int i = 0;
                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        if (jsonObject.get(key) instanceof JSONObject) {
                            switch (i){
                                case 0:
                                    name_1 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_1.length() > 18){
                                        name_1 = name_1.substring(0,20) + "...";
                                    }
                                    players_1 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 1:
                                    name_2 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_2.length() > 18){
                                        name_2 = name_2.substring(0,20) + "...";
                                    }
                                    players_2 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 2:
                                    name_3 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_3.length() > 18){
                                        name_3 = name_3.substring(0,20) + "...";
                                    }
                                    players_3 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 3:
                                    name_4 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_4.length() > 18){
                                        name_4 = name_4.substring(0,20) + "...";
                                    }
                                    players_4 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 4:
                                    name_5 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_5.length() > 18){
                                        name_5 = name_5.substring(0,20) + "...";
                                    }
                                    players_5 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 5:
                                    name_6 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_6.length() > 18){
                                        name_6 = name_6.substring(0,20) + "...";
                                    }
                                    players_6 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 6:
                                    name_7 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_7.length() > 18){
                                        name_7 = name_7.substring(0,20) + "...";
                                    }
                                    players_7 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 7:
                                    name_8 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_8.length() > 18){
                                        name_8 = name_8.substring(0,20) + "...";
                                    }
                                    players_8 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 8:
                                    name_9 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_9.length() > 18){
                                        name_9 = name_9.substring(0,20) + "...";
                                    }
                                    players_9 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                                case 9:
                                    name_10 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_10.length() > 18){
                                        name_10 = name_10.substring(0,20) + "...";
                                    }
                                    players_10 = ((JSONObject) jsonObject.get(key)).getString("players_forever");
                                    break;
                            }
                            i++;
                        }
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
            allTimeGameName1.setText(name_1);
            steamAPIMostPopularAllTimePlayerCount1.setText(players_1);
            allTimeGameName2.setText(name_2);
            steamAPIMostPopularAllTimePlayerCount2.setText(players_2);
            allTimeGameName3.setText(name_3);
            steamAPIMostPopularAllTimePlayerCount3.setText(players_3);
            allTimeGameName4.setText(name_4);
            steamAPIMostPopularAllTimePlayerCount4.setText(players_4);
            allTimeGameName5.setText(name_5);
            steamAPIMostPopularAllTimePlayerCount5.setText(players_5);
            allTimeGameName6.setText(name_6);
            steamAPIMostPopularAllTimePlayerCount6.setText(players_6);
            allTimeGameName7.setText(name_7);
            steamAPIMostPopularAllTimePlayerCount7.setText(players_7);
            allTimeGameName8.setText(name_8);
            steamAPIMostPopularAllTimePlayerCount8.setText(players_8);
            allTimeGameName9.setText(name_9);
            steamAPIMostPopularAllTimePlayerCount9.setText(players_9);
            allTimeGameName10.setText(name_10);
            steamAPIMostPopularAllTimePlayerCount10.setText(players_10);

        }
    }
    public class JSONTASKMostPopularRecentGames extends AsyncTask<Object, Object, String> {

        private String name_1;
        private String name_2;
        private String name_3;
        private String name_4;
        private String name_5;
        private String name_6;
        private String name_7;
        private String name_8;
        private String name_9;
        private String name_10;

        private String players_1;
        private String players_2;
        private String players_3;
        private String players_4;
        private String players_5;
        private String players_6;
        private String players_7;
        private String players_8;
        private String players_9;
        private String players_10;


        @Override
        protected String doInBackground(Object... params) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String url = "http://steamspy.com/api.php?request=top100in2weeks";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    Iterator<?> keys = jsonObject.keys();
                    int i = 0;
                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        if (jsonObject.get(key) instanceof JSONObject) {
                            switch (i){
                                case 0:
                                    name_1 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_1.length() > 18){
                                        name_1 = name_1.substring(0,20) + "...";
                                    }
                                    players_1 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 1:
                                    name_2 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_2.length() > 18){
                                        name_2 = name_2.substring(0,20) + "...";
                                    }
                                    players_2 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 2:
                                    name_3 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_3.length() > 18){
                                        name_3 = name_3.substring(0,20) + "...";
                                    }
                                    players_3 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 3:
                                    name_4 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_4.length() > 18){
                                        name_4 = name_4.substring(0,20) + "...";
                                    }
                                    players_4 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 4:
                                    name_5 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_5.length() > 18){
                                        name_5 = name_5.substring(0,20) + "...";
                                    }
                                    players_5 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 5:
                                    name_6 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_6.length() > 18){
                                        name_6 = name_6.substring(0,20) + "...";
                                    }
                                    players_6 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 6:
                                    name_7 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_7.length() > 18){
                                        name_7 = name_7.substring(0,20) + "...";
                                    }
                                    players_7 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 7:
                                    name_8 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_8.length() > 18){
                                        name_8 = name_8.substring(0,20) + "...";
                                    }
                                    players_8 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 8:
                                    name_9 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_9.length() > 18){
                                        name_9 = name_9.substring(0,20) + "...";
                                    }
                                    players_9 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                                case 9:
                                    name_10 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_10.length() > 18){
                                        name_10 = name_10.substring(0,20) + "...";
                                    }
                                    players_10 = ((JSONObject) jsonObject.get(key)).getString("players_2weeks");
                                    break;
                            }
                            i++;
                        }
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
            recentGameName1.setText(name_1);
            steamAPIMostPopularRecentPlayerCount1.setText(players_1);
            recentGameName2.setText(name_2);
            steamAPIMostPopularRecentPlayerCount2.setText(players_2);
            recentGameName3.setText(name_3);
            steamAPIMostPopularRecentPlayerCount3.setText(players_3);
            recentGameName4.setText(name_4);
            steamAPIMostPopularRecentPlayerCount4.setText(players_4);
            recentGameName5.setText(name_5);
            steamAPIMostPopularRecentPlayerCount5.setText(players_5);
            recentGameName6.setText(name_6);
            steamAPIMostPopularRecentPlayerCount6.setText(players_6);
            recentGameName7.setText(name_7);
            steamAPIMostPopularRecentPlayerCount7.setText(players_7);
            recentGameName8.setText(name_8);
            steamAPIMostPopularRecentPlayerCount8.setText(players_8);
            recentGameName9.setText(name_9);
            steamAPIMostPopularRecentPlayerCount9.setText(players_9);
            recentGameName10.setText(name_10);
            steamAPIMostPopularRecentPlayerCount10.setText(players_10);

        }
    }
    public class JSONTASKMostPopularOwnedGames extends AsyncTask<Object, Object, String> {

        private String name_1;
        private String name_2;
        private String name_3;
        private String name_4;
        private String name_5;
        private String name_6;
        private String name_7;
        private String name_8;
        private String name_9;
        private String name_10;

        private String players_1;
        private String players_2;
        private String players_3;
        private String players_4;
        private String players_5;
        private String players_6;
        private String players_7;
        private String players_8;
        private String players_9;
        private String players_10;


        @Override
        protected String doInBackground(Object... params) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String url = "http://steamspy.com/api.php?request=top100owned";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    Iterator<?> keys = jsonObject.keys();
                    int i = 0;
                    while (keys.hasNext()) {
                        String key = (String) keys.next();
                        if (jsonObject.get(key) instanceof JSONObject) {
                            switch (i){
                                case 0:
                                    name_1 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_1.length() > 18){
                                        name_1 = name_1.substring(0,20) + "...";
                                    }
                                    players_1 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 1:
                                    name_2 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_2.length() > 18){
                                        name_2 = name_2.substring(0,20) + "...";
                                    }
                                    players_2 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 2:
                                    name_3 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_3.length() > 18){
                                        name_3 = name_3.substring(0,20) + "...";
                                    }
                                    players_3 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 3:
                                    name_4 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_4.length() > 18){
                                        name_4 = name_4.substring(0,20) + "...";
                                    }
                                    players_4 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 4:
                                    name_5 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_5.length() > 18){
                                        name_5 = name_5.substring(0,20) + "...";
                                    }
                                    players_5 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 5:
                                    name_6 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_6.length() > 18){
                                        name_6 = name_6.substring(0,20) + "...";
                                    }
                                    players_6 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 6:
                                    name_7 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_7.length() > 18){
                                        name_7 = name_7.substring(0,20) + "...";
                                    }
                                    players_7 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 7:
                                    name_8 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_8.length() > 18){
                                        name_8 = name_8.substring(0,20) + "...";
                                    }
                                    players_8 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 8:
                                    name_9 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_9.length() > 18){
                                        name_9 = name_9.substring(0,20) + "...";
                                    }
                                    players_9 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                                case 9:
                                    name_10 = ((JSONObject) jsonObject.get(key)).getString("name");
                                    if(name_10.length() > 18){
                                        name_10 = name_10.substring(0,20) + "...";
                                    }
                                    players_10 = ((JSONObject) jsonObject.get(key)).getString("owners");
                                    break;
                            }
                            i++;
                        }
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
            allTimeOwnedGameName1.setText(name_1);
            steamAPIMostPopularAllTimeOwnedPlayerCount1.setText(players_1);
            allTimeOwnedGameName2.setText(name_2);
            steamAPIMostPopularAllTimeOwnedPlayerCount2.setText(players_2);
            allTimeOwnedGameName3.setText(name_3);
            steamAPIMostPopularAllTimeOwnedPlayerCount3.setText(players_3);
            allTimeOwnedGameName4.setText(name_4);
            steamAPIMostPopularAllTimeOwnedPlayerCount4.setText(players_4);
            allTimeOwnedGameName5.setText(name_5);
            steamAPIMostPopularAllTimeOwnedPlayerCount5.setText(players_5);
            allTimeOwnedGameName6.setText(name_6);
            steamAPIMostPopularAllTimeOwnedPlayerCount6.setText(players_6);
            allTimeOwnedGameName7.setText(name_7);
            steamAPIMostPopularAllTimeOwnedPlayerCount7.setText(players_7);
            allTimeOwnedGameName8.setText(name_8);
            steamAPIMostPopularAllTimeOwnedPlayerCount8.setText(players_8);
            allTimeOwnedGameName9.setText(name_9);
            steamAPIMostPopularAllTimeOwnedPlayerCount9.setText(players_9);
            allTimeOwnedGameName10.setText(name_10);
            steamAPIMostPopularAllTimeOwnedPlayerCount10.setText(players_10);

        }
    }
}
