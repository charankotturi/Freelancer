package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.example.minicompany.adaptor.tagAdaptor;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityJobBinding;
import com.example.minicompany.models.jobModel;

import java.util.ArrayList;

import static com.example.minicompany.adaptor.jobPostsAdaptor.JOB_REVIEW;

public class JobActivity extends AppCompatActivity {

    private ActivityJobBinding binding;
    private jobModel jobModel;
    private tagAdaptor tagAdaptor;
    private static String TAG = "shit lol i can do this";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJobBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imgBackJobActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            jobModel = intent.getParcelableExtra(JOB_REVIEW);
            if (jobModel != null){
                binding.txtCompanyDesA.setText(jobModel.getCompanyDes());
                binding.txtJobDec.setText(jobModel.getAboutJob());
                if (jobModel.getSkills() != null) {
                    tagAdaptor = new tagAdaptor();
                    binding.txtSkillsReq.setAdapter(tagAdaptor);
                    binding.txtSkillsReq.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
                    tagAdaptor.setTags(jobModel.getSkills());
                }

                StringBuilder Wasabi = new StringBuilder();

                for (String j: jobModel.getPerks()) {
                    Wasabi.append("• ").append(j).append("\n");
                }

                binding.txtNoPerks.setText(Wasabi.toString());

                Log.d(TAG, "onCreate: " + jobModel.isSaved() + ">>>>>>>>>>>");
                if (Utils.verifySaved(JobActivity.this, jobModel)) {
                    binding.imgSave.setVisibility(View.GONE);
                    binding.imgSaveFilled.setVisibility(View.VISIBLE);
                }else {
                    binding.imgSave.setVisibility(View.VISIBLE);
                    binding.imgSaveFilled.setVisibility(View.GONE);
                }

                binding.imgSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.imgSave.setVisibility(View.GONE);
                        binding.imgSaveFilled.setVisibility(View.VISIBLE);
                        Utils.saveJob(JobActivity.this, jobModel.getId());
                        Log.d(TAG, "onClick: " + Utils.getSavedJobs(JobActivity.this));
                        Log.d(TAG, "onCreate: " + jobModel.isSaved() + ">>>>>>>>>>>");
                    }
                });

                binding.imgSaveFilled.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.imgSave.setVisibility(View.VISIBLE);
                        binding.imgSaveFilled.setVisibility(View.GONE);
                        Utils.unSaveJob(JobActivity.this, jobModel.getId());
                        Log.d(TAG, "onClick: " + "nullll>>>>>>" + Utils.getSavedJobs(JobActivity.this));
                        Log.d(TAG, "onCreate: " + jobModel.isSaved() + ">>>>>>>>>>>");
                    }
                });

                binding.txtCompanyTitleA.setText(jobModel.getCompanyTitle());

                ArrayList<jobModel> existingJobs = Utils.getAllApplications(this);
                if (existingJobs != null){
                    for (com.example.minicompany.models.jobModel j: existingJobs){
                        if (j.getId() == jobModel.getId()){
                            binding.btnApplyForJob.setEnabled(false);
                            binding.btnApplyForJob.setText("Already Applied.");
                            //Toast.makeText(this, "Already exits in your applications list!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                binding.btnApplyForJob.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Utils.addApplications(JobActivity.this, jobModel);
                        startActivity(new Intent(JobActivity.this, MyApplicationActivity.class));
                    }
                });
                binding.imgBackJobActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                });

            }
        }

    }
}