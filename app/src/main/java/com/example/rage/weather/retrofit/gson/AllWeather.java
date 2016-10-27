
package com.example.rage.weather.retrofit.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllWeather {

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("cnt")
    @Expose
    private long cnt;
    //@SerializedName("weather_item")
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = new java.util.ArrayList<List>();

    /**
     * 
     * @return
     *     The city
     */
    public City getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    public AllWeather withCity(City city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * @return
     *     The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * 
     * @param cod
     *     The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    public AllWeather withCod(String cod) {
        this.cod = cod;
        return this;
    }

    /**
     * 
     * @return
     *     The message
     */
    public double getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(double message) {
        this.message = message;
    }

    public AllWeather withMessage(double message) {
        this.message = message;
        return this;
    }

    /**
     * 
     * @return
     *     The cnt
     */
    public long getCnt() {
        return cnt;
    }

    /**
     * 
     * @param cnt
     *     The cnt
     */
    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public AllWeather withCnt(long cnt) {
        this.cnt = cnt;
        return this;
    }

    /**
     * 
     * @return
     *     The weather_item
     */
    public java.util.List<List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The weather_item
     */
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public AllWeather withList(java.util.List<List> list) {
        this.list = list;
        return this;
    }

}
