package com.example.myservice.Models;

import androidx.annotation.NonNull;

public class DayWeatherModel {
    String date;

    WeatherModel night;
    WeatherModel morning;
    WeatherModel day;
    WeatherModel evening;

    public DayWeatherModel(String date, WeatherModel night, WeatherModel morning, WeatherModel day, WeatherModel evening) {
        this.date = date;
        this.night = night;
        this.morning = morning;
        this.day = day;
        this.evening = evening;
    }

    public String getDate() {
        return date;
    }

    public WeatherModel getNight() {
        return night;
    }

    public WeatherModel getMorning() {
        return morning;
    }

    public WeatherModel getDay() {
        return day;
    }

    public WeatherModel getEvening() {
        return evening;
    }

    @NonNull
    @Override
    public String toString() {
        return "Дата: " + this.date
                + "\n\n"
                + "Время суток: " + night.tod + "\n"
                + "Давление: " + night.pressure + "\n"
                + "Температура: " + night.temp + "C\n"
                + "Ощущается как: " + night.feel + "C\n"
                + "Влажность: " + night.humidity + "\n"
                + "Ветер: " + night.wind + "\n"
                + "Осадки: " + night.cloud
                + "\n\n"
                + "Время суток: " + morning.tod + "\n"
                + "Давление: " + morning.pressure + "\n"
                + "Температура: " + morning.temp + "C\n"
                + "Ощущается как: " + morning.feel + "C\n"
                + "Влажность: " + morning.humidity + "\n"
                + "Ветер: " + morning.wind + "\n"
                + "Осадки: " + morning.cloud
                + "\n\n"
                + "Время суток: " + day.tod + "\n"
                + "Давление: " + day.pressure + "\n"
                + "Температура: " + day.temp + "C\n"
                + "Ощущается как: " + day.feel + "C\n"
                + "Влажность: " + day.humidity + "\n"
                + "Ветер: " + day.wind + "\n"
                + "Осадки: " + day.cloud
                + "\n\n"
                + "Время суток: " + evening.tod + "\n"
                + "Давление: " + evening.pressure + "\n"
                + "Температура: " + evening.temp + "C\n"
                + "Ощущается как: " + evening.feel + "C\n"
                + "Влажность: " + evening.humidity + "\n"
                + "Ветер: " + evening.wind + "\n"
                + "Осадки: " + evening.cloud;
    }
}