package com.example.myservice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import org.json.JSONException;
import org.json.JSONObject;

public class NowWeather extends Fragment {
    static int Pressure= 0;
    static String temp =  "подождите";
    static String feel = "подождите";
    static String wind = "подождите";
    static String cloud = "подождите";


    static TextView PressureView;
    static TextView tempView;
    static TextView feelView;
    static TextView windView;
    static TextView cloudView;

    private static NowWeather instance;

    public static NowWeather getInstance() {
        if (instance == null) {
            instance = new NowWeather();
        }
        return instance;
    }

    public void setNowWeather(JSONObject json){
        System.out.println(json);
        try {
            Pressure = json.getInt("pressure");
            temp = json.getString("temp");
            feel = json.getString("feel");
            wind = json.getString("wind");
            cloud = json.getString("cloud");
        }catch(JSONException e){
            System.out.println("ERROR");
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.today, container, false);
        PressureView = (TextView) view.findViewById(R.id.pressure);
        tempView = (TextView) view.findViewById(R.id.temp);
        feelView = (TextView) view.findViewById(R.id.feel);
        windView = (TextView) view.findViewById(R.id.wind);
        cloudView = (TextView) view.findViewById(R.id.cloud);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public static void update(){
        PressureView.setText(Pressure);
        tempView.setText(temp);
        feelView.setText(feel);
        windView.setText(wind);
        cloudView.setText(cloud);
    }
}
