package com.example.adamn.userstatisticsapplication.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adamn.userstatisticsapplication.Models.NutritionObject;
import com.example.adamn.userstatisticsapplication.R;

import java.util.List;

/**
 * This Class acts as an adapter class for the Nutritionix Activity. This class allows the use
 * of a listview within the activity.
 *
 * @author Adam Nowak
 */
public class NutritionAdapter extends BaseAdapter{

    private Context context;
    private List<NutritionObject> nObjects;

    public NutritionAdapter(Context context, List<NutritionObject> nObjects) {
        this.context = context;
        this.nObjects = nObjects;
    }

    @Override
    public int getCount() {
        return nObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return nObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.custom_nutrition_view,null);
        TextView nameText = (TextView) v.findViewById(R.id.nutritionNameResult);
        TextView brandText = (TextView) v.findViewById(R.id.nutritionBrandResult);
        TextView caloriesText = (TextView) v.findViewById(R.id.nutritionCaloriesResult);
        TextView fatText = (TextView) v.findViewById(R.id.nutritionFatResult);
        TextView servingText = (TextView) v.findViewById(R.id.nutritionServingSizeResult);


        nameText.setText(nObjects.get(position).getName());
        brandText.setText(nObjects.get(position).getBrand());
        caloriesText.setText(nObjects.get(position).getCalories());
        fatText.setText(nObjects.get(position).getFat());
        servingText.setText(nObjects.get(position).getServing());

        return v;
    }
}
