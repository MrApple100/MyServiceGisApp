package com.example.myservice.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myservice.Models.DayWeatherModel;
import com.example.myservice.R;

public class WeatherFragment extends Fragment {

    DayWeatherModel dayWeatherModel;

    public WeatherFragment(DayWeatherModel dayWeatherModel) {
        this.dayWeatherModel = dayWeatherModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.day_weather_fragment, container, false);

        ((TextView) v.findViewById(R.id.timeNow)).setText(dayWeatherModel.getDate());

        ((TextView) v.findViewById(R.id.tempNow)).setText(dayWeatherModel.getEvening().getTemp());

        ((TextView) v.findViewById(R.id.nightTemp)).setText(dayWeatherModel.getNight().getTemp());
        ((TextView) v.findViewById(R.id.nightWind)).setText(dayWeatherModel.getNight().getWind());
        ((TextView) v.findViewById(R.id.nightCloud)).setText(dayWeatherModel.getNight().getCloud());
        ((TextView) v.findViewById(R.id.nightFeels)).setText(dayWeatherModel.getNight().getFeel());
        ((TextView) v.findViewById(R.id.nightHumidity)).setText(dayWeatherModel.getNight().getHumidity());
        ((TextView) v.findViewById(R.id.nightPressure)).setText(dayWeatherModel.getNight().getPressure());

        ((TextView) v.findViewById(R.id.morningTemp)).setText(dayWeatherModel.getMorning().getTemp());
        ((TextView) v.findViewById(R.id.morningWind)).setText(dayWeatherModel.getMorning().getWind());
        ((TextView) v.findViewById(R.id.morningCloud)).setText(dayWeatherModel.getMorning().getCloud());
        ((TextView) v.findViewById(R.id.morningFeels)).setText(dayWeatherModel.getMorning().getFeel());
        ((TextView) v.findViewById(R.id.morningHumidity)).setText(dayWeatherModel.getMorning().getHumidity());
        ((TextView) v.findViewById(R.id.morningPressure)).setText(dayWeatherModel.getMorning().getPressure());

        ((TextView) v.findViewById(R.id.eveningTemp)).setText(dayWeatherModel.getEvening().getTemp());
        ((TextView) v.findViewById(R.id.eveningWind)).setText(dayWeatherModel.getEvening().getWind());
        ((TextView) v.findViewById(R.id.eveningCloud)).setText(dayWeatherModel.getEvening().getCloud());
        ((TextView) v.findViewById(R.id.eveningFeels)).setText(dayWeatherModel.getEvening().getFeel());
        ((TextView) v.findViewById(R.id.eveningHumidity)).setText(dayWeatherModel.getEvening().getHumidity());
        ((TextView) v.findViewById(R.id.eveningPressure)).setText(dayWeatherModel.getEvening().getPressure());

        ((TextView) v.findViewById(R.id.dayTemp)).setText(dayWeatherModel.getDay().getTemp());
        ((TextView) v.findViewById(R.id.dayWind)).setText(dayWeatherModel.getDay().getWind());
        ((TextView) v.findViewById(R.id.dayCloud)).setText(dayWeatherModel.getDay().getCloud());
        ((TextView) v.findViewById(R.id.dayFeels)).setText(dayWeatherModel.getDay().getFeel());
        ((TextView) v.findViewById(R.id.dayHumidity)).setText(dayWeatherModel.getDay().getHumidity());
        ((TextView) v.findViewById(R.id.dayPressure)).setText(dayWeatherModel.getDay().getPressure());

        return v;
    }
}