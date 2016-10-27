
package com.example.rage.weather.retrofit.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("sea_level")
    @Expose
    private double seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private double grndLevel;
    @SerializedName("humidity")
    @Expose
    private long humidity;
    @SerializedName("temp_kf")
    @Expose
    private double tempKf;

    /**
     * 
     * @return
     *     The temp
     */
    public double getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Main withTemp(double temp) {
        this.temp = temp;
        return this;
    }

    /**
     * 
     * @return
     *     The tempMin
     */
    public double getTempMin() {
        return tempMin;
    }

    /**
     * 
     * @param tempMin
     *     The temp_min
     */
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public Main withTempMin(double tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    /**
     * 
     * @return
     *     The tempMax
     */
    public double getTempMax() {
        return tempMax;
    }

    /**
     * 
     * @param tempMax
     *     The temp_max
     */
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public Main withTempMax(double tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Main withPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    /**
     * 
     * @return
     *     The seaLevel
     */
    public double getSeaLevel() {
        return seaLevel;
    }

    /**
     * 
     * @param seaLevel
     *     The sea_level
     */
    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Main withSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
        return this;
    }

    /**
     * 
     * @return
     *     The grndLevel
     */
    public double getGrndLevel() {
        return grndLevel;
    }

    /**
     * 
     * @param grndLevel
     *     The grnd_level
     */
    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Main withGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
        return this;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public long getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public Main withHumidity(long humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * 
     * @return
     *     The tempKf
     */
    public double getTempKf() {
        return tempKf;
    }

    /**
     * 
     * @param tempKf
     *     The temp_kf
     */
    public void setTempKf(long tempKf) {
        this.tempKf = tempKf;
    }

    public Main withTempKf(long tempKf) {
        this.tempKf = tempKf;
        return this;
    }

}
