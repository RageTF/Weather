package com.example.rage.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONException;

import apiopenweathermap.*;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private ListView mTemperatures;
    private TemperaturesAdapter mTemperaturesAdapter;
    private ImageButton mSearchCity;
    private EditText mNameCity;
    private DayWeather[] dayWeathers;
    private Typeface type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        type=Typeface.createFromAsset(getAssets(),"type.ttf");

        mTemperatures=(ListView) findViewById(R.id.listView);
        mTemperaturesAdapter=new TemperaturesAdapter(this, type, dayWeathers);
        mSearchCity=(ImageButton) findViewById(R.id.button);
        mNameCity=(EditText) findViewById(R.id.editText);
        mNameCity.setTypeface(type);
        mNameCity.setTextSize(20);
        mSearchCity.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


            Thread t=new Thread(){
                @Override
                public void run() {
                    try {
                        dayWeathers= ConnectWeather.getWeather(mNameCity.getText().toString());
                    } catch (JSONException e) {
                        // //incorrect name city
                        dayWeathers=null;
                        e.printStackTrace();
                        return;
                    }
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(dayWeathers==null){
                mNameCity.setText("");
                return false;
            }
            mNameCity.clearFocus();
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mSearchCity.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            mTemperatures.setAdapter(mTemperaturesAdapter.setDayWeathers(dayWeathers));
            mTemperatures.deferNotifyDataSetChanged();

        return false;
    }
}
