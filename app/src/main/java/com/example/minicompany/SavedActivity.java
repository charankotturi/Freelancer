package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.minicompany.adaptor.saveJobsAdaptor;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivitySavedAcitvityBinding;

public class SavedActivity extends AppCompatActivity {

    private ActivitySavedAcitvityBinding binding;
    private saveJobsAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySavedAcitvityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imgBackSavedAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        if (Utils.getSavedJobs(this) != null) {
            adaptor = new saveJobsAdaptor(SavedActivity.this);
            binding.savedRecView.setLayoutManager(new LinearLayoutManager(this));
            binding.savedRecView.setAdapter(adaptor);
            adaptor.setJobModels(Utils.getSavedJobs(this));
        }else{
            binding.savedRecView.setVisibility(View.GONE);
            //TODO: add a intent to send them home so that they save any activity.
        }


    }
}