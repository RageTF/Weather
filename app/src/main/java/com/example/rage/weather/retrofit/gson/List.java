
package com.example.rage.weather.retrofit.gson;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("dt")
    @Expose
    private long dt;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("snow")
    @Expose
    private Snow snow;
    @SerializedName("sys")
    @Expose
    private Sys_ sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    /**
     * 
     * @return
     *     The dt
     */
    public long getDt() {
        return dt;
    }

    /**
     * 
     * @param dt
     *     The dt
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    public List withDt(long dt) {
        this.dt = dt;
        return this;
    }

    /**
     * 
     * @return
     *     The main
     */
    public Main getMain() {
        return main;
    }

    /**
     * 
     * @param main
     *     The main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    public List withMain(Main main) {
        this.main = main;
        return this;
    }

    /**
     * 
     * @return
     *     The weather
     */
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public List withWeather(java.util.List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    /**
     * 
     * @return
     *     The clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public List withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    /**
     * 
     * @return
     *     The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    /**
     * 
     * @return
     *     The snow
     */
    public Snow getSnow() {
        return snow;
    }

    /**
     * 
     * @param snow
     *     The snow
     */
    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public List withSnow(Snow snow) {
        this.snow = snow;
        return this;
    }

    /**
     * 
     * @return
     *     The sys
     */
    public Sys_ getSys() {
        return sys;
    }

    /**
     * 
     * @param sys
     *     The sys
     */
    public void setSys(Sys_ sys) {
        this.sys = sys;
    }

    public List withSys(Sys_ sys) {
        this.sys = sys;
        return this;
    }

    /**
     * 
     * @return
     *     The dtTxt
     */
    public String getDtTxt() {
        return dtTxt;
    }

    /**
     * 
     * @param dtTxt
     *     The dt_txt
     */
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public List withDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
        return this;
    }

}
