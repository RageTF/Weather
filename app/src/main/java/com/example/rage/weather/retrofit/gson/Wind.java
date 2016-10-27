
package com.example.rage.weather.retrofit.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private double speed;
    @SerializedName("deg")
    @Expose
    private double deg;

    /**
     * 
     * @return
     *     The speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * 
     * @param speed
     *     The speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Wind withSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    /**
     * 
     * @return
     *     The deg
     */
    public double getDeg() {
        return deg;
    }

    /**
     * 
     * @param deg
     *     The deg
     */
    public void setDeg(long deg) {
        this.deg = deg;
    }

    public Wind withDeg(long deg) {
        this.deg = deg;
        return this;
    }

}
