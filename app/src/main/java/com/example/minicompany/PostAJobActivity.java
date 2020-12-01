package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityPostAJobBinding;
import com.example.minicompany.interfaces.PostEndPoint;
import com.example.minicompany.models.jobModel;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayList;

public class PostAJobActivity extends AppCompatActivity {

    private ActivityPostAJobBinding binding;
    private jobModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostAJobBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imgResumeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        model = Utils.getPostedJob(this);

        if (model != null) {
            if (model.getCategory() != null) {
                binding.txtPersonName.setText(model.getCompanyTitle());
                binding.txtPersonEdu.setText(model.getCategory());
                binding.txtPersonSkills.setText(model.getStipend());
                binding.txtPersonDes.setText(model.getCompanyDes());
                binding.txtPersonProjectDes.setText(model.getAboutJob());
                binding.txtPersonGit.setText(model.getDuration());
                binding.txtPersonWorkWnv.setText(model.getWorkEnv());
            }
        }

        binding.txtResumeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.txtResumeSave.setVisibility(View.GONE);
                binding.textResumeEdit.setVisibility(View.VISIBLE);

                String companyTitle = binding.editTxtPersonName.getText().toString();
                String companyDes = binding.editTxtPersonDes.getText().toString();
                String aboutJob = binding.editTxtPersonProjectDes.getText().toString();
                String duration = binding.editTxtPersonGit.getText().toString();
                String workEnv = binding.editTxtWorkEnv.getText().toString();
                String stipend = binding.editTxtPersonSkills.getText().toString();
                String category = binding.spinner.getSelectedItem().toString();

                ArrayList<String> skills = new ArrayList<>();
                skills.add("good");

                jobModel model = new jobModel(companyTitle, category, "", stipend, duration, workEnv, "internship", companyDes,
                        aboutJob, skills , 2,skills );

                Utils.setPostedJob(PostAJobActivity.this, model);

                binding.editTxtPersonName.setVisibility(View.GONE);
                binding.editTxtPersonDes.setVisibility(View.GONE);
                binding.editTxtPersonProjectDes.setVisibility(View.GONE);
                binding.editTxtPersonGit.setVisibility(View.GONE);
                binding.editTxtWorkEnv.setVisibility(View.GONE);
                binding.editTxtPersonSkills.setVisibility(View.GONE);
                binding.spinner.setVisibility(View.GONE);

                binding.txtPersonName.setText(companyTitle);
                binding.txtPersonEdu.setText(category);
                binding.txtPersonSkills.setText(stipend);
                binding.txtPersonDes.setText(companyDes);
                binding.txtPersonProjectDes.setText(aboutJob);
                binding.txtPersonGit.setText(duration);
                binding.txtPersonWorkWnv.setText(workEnv);

                binding.txtPersonName.setVisibility(View.VISIBLE);
                binding.txtPersonEdu.setVisibility(View.VISIBLE);
                binding.txtPersonSkills.setVisibility(View.VISIBLE);
                binding.txtPersonDes.setVisibility(View.VISIBLE);
                binding.txtPersonProjectDes.setVisibility(View.VISIBLE);
                binding.txtPersonGit.setVisibility(View.VISIBLE);
                binding.txtPersonWorkWnv.setVisibility(View.VISIBLE);

                Toast.makeText(PostAJobActivity.this, "Job Posted", Toast.LENGTH_SHORT).show();

            }
        });

        binding.textResumeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.txtResumeSave.setVisibility(View.VISIBLE);
                binding.textResumeEdit.setVisibility(View.GONE);

                binding.editTxtPersonName.setVisibility(View.VISIBLE);
                binding.editTxtPersonDes.setVisibility(View.VISIBLE);
                binding.editTxtPersonProjectDes.setVisibility(View.VISIBLE);
                binding.editTxtPersonGit.setVisibility(View.VISIBLE);
                binding.editTxtWorkEnv.setVisibility(View.VISIBLE);
                binding.editTxtPersonSkills.setVisibility(View.VISIBLE);
                binding.spinner.setVisibility(View.VISIBLE);

                binding.txtPersonName.setVisibility(View.GONE);
                binding.txtPersonEdu.setVisibility(View.GONE);
                binding.txtPersonSkills.setVisibility(View.GONE);
                binding.txtPersonDes.setVisibility(View.GONE);
                binding.txtPersonProjectDes.setVisibility(View.GONE);
                binding.txtPersonGit.setVisibility(View.GONE);
                binding.txtPersonWorkWnv.setVisibility(View.GONE);
            }
        });

    }
}