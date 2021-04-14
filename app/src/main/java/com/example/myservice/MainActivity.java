package com.example.myservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myservice.Fragments.WeatherFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.example.myservice.Fragments.WeatherFragment;
import com.example.myservice.Models.DayWeatherModel;
import com.example.myservice.Models.WeatherModel;
import com.example.myservice.WeatherService;

public class MainActivity extends AppCompatActivity {

    protected BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                JSONObject jsonObject = new JSONObject(intent.getStringExtra("INFO"));
                JSONArray array = jsonObject.getJSONArray("weather");

                for (int i = 0; i < array.length(); i += 4) {
                    DayWeatherModel dayWeatherModel = new DayWeatherModel(
                            array.getJSONObject(i).getString("date"),
                            new WeatherModel(array.getJSONObject(i)),
                            new WeatherModel(array.getJSONObject(i + 1)),
                            new WeatherModel(array.getJSONObject(i + 2)),
                            new WeatherModel(array.getJSONObject(i + 3))
                    );
                    dayWeatherModels.add(dayWeatherModel);
                }

                changeFragment();
            } catch (Exception e) {
                Log.e("MainActivity", e.toString());
                Toast.makeText(MainActivity.this, "Wrong JSON format", Toast.LENGTH_LONG).show();
            }
        }
    };

    List<DayWeatherModel> dayWeatherModels = new ArrayList<>();

    FrameLayout fl;
    ImageButton prevDay;
    ImageButton newDay;
    FragmentManager fm;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl = findViewById(R.id.frameLayout);
        prevDay = findViewById(R.id.prevDay);
        prevDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0) {
                    index = dayWeatherModels.size() - 1;
                } else {
                    index--;
                }
                changeFragment();
            }
        });
        newDay = findViewById(R.id.newDay);
        newDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == dayWeatherModels.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
                changeFragment();
            }
        });
        fm = getSupportFragmentManager();

        registerReceiver(broadcastReceiver, new IntentFilter("WeatherService"));

        Intent intent = new Intent(this, WeatherService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, WeatherService.class);
        stopService(intent);
    }

    void changeFragment() {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, new WeatherFragment(dayWeatherModels.get(index)));
        ft.commit();
    }
}