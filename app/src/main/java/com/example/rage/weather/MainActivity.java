package com.example.rage.weather;

import android.app.FragmentManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rage.weather.retrofit.ApiOpenWeather;
import com.example.rage.weather.retrofit.gson.AllWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView temperaturesList;
    private TemperaturesAdapter temperaturesAdapter;
    private ImageButton searchCity;
    private EditText inputNameCity;
    private Typeface type;
    private TextView nameCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        type = Typeface.createFromAsset(getAssets(), "type.ttf");

        temperaturesAdapter = new TemperaturesAdapter();
        temperaturesList = (RecyclerView) findViewById(R.id.listWeather);
        temperaturesList.setLayoutManager(new LinearLayoutManager(this));
        temperaturesList.setAdapter(temperaturesAdapter);

        searchCity = (ImageButton) findViewById(R.id.button);
        searchCity.setOnClickListener(this);

        inputNameCity = (EditText) findViewById(R.id.input_name_city);
        inputNameCity.setTypeface(type);
        inputNameCity.setTextSize(20);

        nameCity = (TextView) findViewById(R.id.name_city);
        nameCity.setTypeface(type);
        nameCity.setTextSize(25);
    }

    public AsyncFragment getAsyncFragment(){

        FragmentManager fragmentManager = getFragmentManager();
        AsyncFragment fragment =
                (AsyncFragment) fragmentManager.
                        findFragmentByTag(AsyncFragment.class.getName());

        if (fragment == null) {
            Log.v("fr1","creFrag");
            fragment = new AsyncFragment();
            fragmentManager.
                    beginTransaction().
                    add(fragment, AsyncFragment.class.getName()).
                    commit();
        }
        return  fragment;
    }

    public void updateData(String city, List<com.example.rage.weather.retrofit.gson.List> weather){
        nameCity.setText(city);
        temperaturesAdapter.setData(weather);
    }

    @Override
    public void onClick(View v) {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getAsyncFragment().startGetWeatherTask(inputNameCity.getText().toString());

    }

    private class TemperaturesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<com.example.rage.weather.retrofit.gson.List> weather;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new DayWeather(LayoutInflater.from(MainActivity.this).inflate(R.layout.weather_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((DayWeather) holder).bind(position);
        }

        @Override
        public int getItemCount() {
            if (weather != null) {
                return weather.size();
            }
            return 0;
        }

        public void setData(List<com.example.rage.weather.retrofit.gson.List> weather) {
            this.weather = weather;
            notifyDataSetChanged();
        }

        private class DayWeather extends RecyclerView.ViewHolder {

            TextView tempWeather;
            TextView dateWeather;

            public DayWeather(View itemView) {
                super(itemView);

                tempWeather = (TextView) itemView.findViewById(R.id.temp_weather);
                tempWeather.setTypeface(type);
                tempWeather.setTextSize(20);

                dateWeather = (TextView) itemView.findViewById(R.id.date_weather);
                dateWeather.setTypeface(type);
                dateWeather.setTextSize(25);
            }

            public void bind(int position) {
                com.example.rage.weather.retrofit.gson.List listWeather = weather.get(position);
                String date = listWeather.getDtTxt();
                double temp = listWeather.getMain().getTemp();
                dateWeather.setText(date);
                tempWeather.setText(String.valueOf((int) (temp - 274)) + " C");

            }
        }
    }
}
