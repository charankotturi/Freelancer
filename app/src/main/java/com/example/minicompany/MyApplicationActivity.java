package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.minicompany.adaptor.jobPostsAdaptor;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityJobBinding;
import com.example.minicompany.databinding.ActivityMyApplicationBinding;
import com.example.minicompany.models.jobModel;

public class MyApplicationActivity extends AppCompatActivity {

    private ActivityMyApplicationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyApplicationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MyApplicationActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}