package com.example.myservice.Models;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherModel {
    enum TimeTable{
        Ночь,
        Утро,
        День,
        Вечер
    }

    String date;
    String tod;
    String pressure;
    String temp;
    String feel;
    String humidity;
    String wind;
    String cloud;
    String tid;

    public WeatherModel(String date, String tod, String pressure, String temp, String feel, String humidity, String wind, String cloud, String tid) {
        this.date = date;
        this.tod = tod;
        this.pressure = pressure;
        this.temp = temp;
        this.feel = feel;
        this.humidity = humidity;
        this.wind = wind;
        this.cloud = cloud;
        this.tid = tid;
    }

    public WeatherModel(JSONObject data) {
        try {
            this.date = data.getString("date");
            this.tod = TimeTable.values()[Integer.parseInt(data.getString("tod"))].toString();
            this.pressure = data.getString("pressure");
            this.temp = data.getString("temp").replace("&minus;", "-");
            this.feel = data.getString("feel").replace("&minus;", "-");
            this.humidity = data.getString("humidity");
            this.wind = data.getString("wind");
            this.cloud = data.getString("cloud");
            this.tid = data.getString("tid");
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

    }

    public String getDate() {
        return date;
    }

    public String getTod() {
        return tod;
    }

    public String getPressure() {
        return pressure;
    }

    public String getTemp() {
        return temp;
    }

    public String getFeel() {
        return feel;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWind() {
        return wind;
    }

    public String getCloud() {
        return cloud;
    }

    public String getTid() {
        return tid;
    }

    @NonNull
    @Override
    public String toString() {
        return "Дата: " + this.date + "\n"
                + "Время суток: " + this.tod + "\n"
                + "Давление: " + this.pressure + "\n"
                + "Температура: " + this.temp + "C\n"
                + "Ощущается как: " + this.feel + "C\n"
                + "Влажность: " + this.humidity + "\n"
                + "Ветер: " + this.wind + "\n"
                + "Осадки: " + this.cloud;
    }
}