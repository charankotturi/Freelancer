package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityPreferencesBinding;

import java.util.ArrayList;

public class PreferencesActivity extends AppCompatActivity {

    private ActivityPreferencesBinding binding;
    private ArrayList<String> popularList = new ArrayList<>();
    private static final String TAG = "shit just got real";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreferencesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imgBackPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.txtSavePreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.androidApp.isChecked()) {
                    popularList.add(binding.androidApp.getText().toString());
                }
                if (binding.reactNativeApp.isChecked()) {
                    popularList.add(binding.reactNativeApp.getText().toString());
                }
                if (binding.flutterApp.isChecked()) {
                    popularList.add(binding.flutterApp.getText().toString());
                }
                if (binding.webDev.isChecked()) {
                    popularList.add(binding.webDev.getText().toString());
                }
                if (binding.wordPressWeb.isChecked()) {
                    popularList.add(binding.wordPressWeb.getText().toString());
                }
                if (binding.contentWriting.isChecked()) {
                    popularList.add(binding.contentWriting.getText().toString());
                }
                if (binding.iosApp.isChecked()) {
                    popularList.add(binding.iosApp.getText().toString());
                }
                Utils.updatePopularFields(PreferencesActivity.this, popularList);
                Utils.updateJobs(PreferencesActivity.this, popularList);
                startActivity(new Intent(PreferencesActivity.this, MainActivity.class));
                //TODO:add it to utils class.
                Log.d(TAG, "onClick: " + popularList);

            }
        });

    }
}