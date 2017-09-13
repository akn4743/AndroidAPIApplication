package com.example.adamn.userstatisticsapplication.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adamn.userstatisticsapplication.Models.WeatherObject;
import com.example.adamn.userstatisticsapplication.R;

import java.util.List;

/**
 * This Class acts as an adapter class for the Wunderground Activity. This class allows the use
 * of a listview within the activity.
 *
 * @author Adam Nowak
 */
public class WeatherAdapter extends BaseAdapter {

    private Context context;
    private List<WeatherObject> wObjects;

    public WeatherAdapter(Context context, List<WeatherObject> wObjects) {
        this.context = context;
        this.wObjects = wObjects;
    }

    @Override
    public int getCount() {
        return wObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return wObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context,R.layout.custom_weather_view,null);
        TextView nameText = (TextView) v.findViewById(R.id.weatherTitle);
        TextView descriptionText = (TextView) v.findViewById(R.id.weatherDescription);
        ImageView weatherImage = (ImageView) v.findViewById(R.id.weatherPhoto);

        nameText.setText(wObjects.get(position).getName());
        descriptionText.setText(wObjects.get(position).getDescription());
        switch(wObjects.get(position).getWeatherimage()){
            case "clear":
                weatherImage.setImageResource(R.drawable.clear);
                break;
            case "nt_clear":
                weatherImage.setImageResource(R.drawable.nt_clear);
                break;
            case "chancerain":
                weatherImage.setImageResource(R.drawable.chancerain);
                break;
            case "nt_chancerain":
                weatherImage.setImageResource(R.drawable.nt_chancerain);
                break;
            case "partlycloudy":
                weatherImage.setImageResource(R.drawable.partlycloudy);
                break;
            case "nt_partlycloudy":
                weatherImage.setImageResource(R.drawable.nt_partlycloudy);
                break;
            case "rain":
                weatherImage.setImageResource(R.drawable.rain);
                break;
            case "nt_rain":
                weatherImage.setImageResource(R.drawable.rain);
                break;
            case "tstorms":
                weatherImage.setImageResource(R.drawable.tstorms);
                break;
            case "nt_tstorms":
                weatherImage.setImageResource(R.drawable.tstorms);
                break;
            default:
                weatherImage.setImageResource(R.drawable.clear);
                break;
        }
        return v;
    }
}
