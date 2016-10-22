package com.example.rage.weather;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import apiopenweathermap.DayWeather;


/**
 * Created by Rage on 05.07.2016.
 */

public class TemperaturesAdapter extends BaseAdapter {

    private DayWeather[] dayWeathers;
    private Context context;
    private LayoutInflater inflater;
    private Typeface type;

    TemperaturesAdapter(Context context,Typeface type, DayWeather[] dayWeathers){
        if(dayWeathers==null) dayWeathers= new DayWeather[]{};
        this.dayWeathers=dayWeathers;
        this.context=context;
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.type=type;
    }



    public TemperaturesAdapter setDayWeathers(DayWeather[] dayWeathers) {
        this.dayWeathers = dayWeathers;
        return this;
    }

    @Override
    public int getCount() {
        return dayWeathers.length;
    }

    @Override
    public Object getItem(int position) {

        if(position>=getCount()){
            return null;
        }

        return dayWeathers[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        if(convertView==null){
            view=inflater.inflate(R.layout.list, null);
        }
        ImageView image=(ImageView) view.findViewById(R.id.image);
        TextView text=(TextView) view.findViewById(R.id.text);
        text.setTypeface(type);
        text.setTextSize(20);
        if(dayWeathers[position].getRain()!=0){
            image.setImageResource(R.drawable.raining);
        }else if(dayWeathers[position].getClouds()>1){
            image.setImageResource(R.drawable.cloudy);
        }else{
            image.setImageResource(R.drawable.sunny);
        }
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        int[] date=dayWeathers[position].getDate();
        text.setText(date[3]+"."+date[4]+"0"+"       "+date[2]+"."+date[1]+"       "+dayWeathers[position].getTemperature()+((char)176)+"C");
        return view;
    }
}