package com.example.rage.weather;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.rage.weather.retrofit.ApiOpenWeather;
import com.example.rage.weather.retrofit.gson.AllWeather;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rage on 16.11.2016.
 */

public class AsyncFragment extends Fragment {

    private String baseURL = "http://api.openweathermap.org";
    private String appID = "199e51a7251d81ae172475ea5b313f94";
    private String id = "524901";

    private AsyncTask<String,Void,Response<AllWeather>> weatherTask;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.v("fr1","oncreta");
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void startGetWeatherTask(String nameCity){
        if(weatherTask==null){
            weatherTask=new GetWeather();
            weatherTask.execute(nameCity);
        }
    }

    public void onUpdateWeather(String nameCity, List<com.example.rage.weather.retrofit.gson.List> weather){
        MainActivity mainActivity=(MainActivity) getActivity();
        mainActivity.updateData(nameCity,weather);
    }

    public class GetWeather extends AsyncTask<String,Void,Response<AllWeather>> {

        ApiOpenWeather apiOpenWeather;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Retrofit client = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();
            apiOpenWeather = client.create(ApiOpenWeather.class);
        }

        @Override
        protected Response<AllWeather> doInBackground(String ... param) {

            String nameCity=param[0];
            Response<AllWeather> allWeatherResponse=null;

            Call<AllWeather> weatherCall = apiOpenWeather.getWeather(nameCity, id, appID);
            
            /*weatherCall.enqueue(new Callback<AllWeather>() {
                @Override
                public void onResponse(Call<AllWeather> call, Response<AllWeather> response) {
                    if (response.isSuccessful()) {
                        String city = response.body().getCity().getName();
                        nameCity.setText(city);
                        temperaturesAdapter.setData(response.body().getList());
                    } else {

                    }
                }

                @Override
                public void onFailure(Call<AllWeather> call, Throwable t) {
                    t.printStackTrace();
                }
            });*/

            try {
                allWeatherResponse = weatherCall.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return allWeatherResponse;
        }

        @Override
        protected void onPostExecute(Response<AllWeather> allWeatherResponse) {
            super.onPostExecute(allWeatherResponse);
            if(allWeatherResponse!=null) {
                String responseCity = allWeatherResponse.body().getCity().getName();
                List<com.example.rage.weather.retrofit.gson.List> weather = allWeatherResponse.body().getList();
                AsyncFragment.this.onUpdateWeather(responseCity, weather);
                AsyncFragment.this.weatherTask=null;
            }else{

            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
