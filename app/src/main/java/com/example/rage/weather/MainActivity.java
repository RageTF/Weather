package com.example.rage.weather;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private ApiOpenWeather apiOpenWeather;


    private String baseURL = "http://api.openweathermap.org";
    private String appID = "199e51a7251d81ae172475ea5b313f94";
    private String id = "524901";

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

        Retrofit client = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
        apiOpenWeather = client.create(ApiOpenWeather.class);

    }

    @Override
    public void onClick(View v) {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Call<AllWeather> weatherCall = apiOpenWeather.getWeather(inputNameCity.getText().toString(), id, appID);

        weatherCall.enqueue(new Callback<AllWeather>() {
            @Override
            public void onResponse(Call<AllWeather> call, Response<AllWeather> response) {
                if (response.isSuccessful()) {
                    String city = response.body().getCity().getName();
                    nameCity.setText(city);
                    temperaturesAdapter.setData(response.body().getList());
                } else {
                    Toast.makeText(MainActivity.this, "City is not exist!", Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<AllWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });
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
