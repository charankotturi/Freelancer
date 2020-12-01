package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Toast;

import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityResumeBinding;
import com.example.minicompany.models.resumeModel;

public class ResumeActivity extends AppCompatActivity {

    private ActivityResumeBinding binding;
    private resumeModel model = new resumeModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResumeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        alreadyExistsForm();

        binding.txtResumeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtResumeEdit.setVisibility(View.GONE);
                binding.txtResumeSave.setVisibility(View.VISIBLE);

                resumeFormVisibility();

                binding.txtResumeSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!binding.editTxtPersonName.getText().toString().equals("") && !binding.editTxtPersonEdu.getText().toString().equals("")
                        && !binding.editTxtPersonSkills.getText().toString().equals("") && !binding.editTxtPersonDes.getText().toString().equals("")) {

                            binding.txtResumeEdit.setVisibility(View.VISIBLE);
                            binding.txtResumeSave.setVisibility(View.GONE);

                            binding.txtPersonName.setText(binding.editTxtPersonName.getText());
                            binding.txtPersonDes.setText(binding.editTxtPersonDes.getText());
                            binding.txtPersonEdu.setText(binding.editTxtPersonEdu.getText());
                            binding.txtPersonSkills.setText(binding.editTxtPersonSkills.getText());

                            model.setResName(binding.editTxtPersonName.getText().toString());
                            model.setResDes(binding.editTxtPersonDes.getText().toString());
                            model.setResEdu(binding.editTxtPersonEdu.getText().toString());
                            model.setResSkills(binding.editTxtPersonSkills.getText().toString());

                            if (!binding.editTxtPersonGit.getText().toString().equals("") && !binding.editTxtPersonProjectDes.getText().toString().equals("")){
                                binding.txtPersonGit.setText(binding.editTxtPersonGit.getText());
                                binding.txtPersonProjectDes.setText(binding.editTxtPersonProjectDes.getText());

                                model.setResGitLink(binding.editTxtPersonGit.getText().toString());
                                model.setResProjectDes(binding.editTxtPersonGit.getText().toString());

                            }
                            if (model != null) {
                                Utils.addResume(ResumeActivity.this, model);
                            }

                            resume();

                        }else {
                            Toast.makeText(ResumeActivity.this, "Please fill the fields with a star.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

        binding.imgResumeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void alreadyExistsForm() {
        resume();

        model = Utils.getResume(this);

        binding.txtPersonName.setText(model.getResName());
        binding.txtPersonEdu.setText(model.getResEdu());
        binding.txtPersonSkills.setText(model.getResSkills());
        binding.txtPersonDes.setText(model.getResDes());
        binding.txtPersonProjectDes.setText(model.getResProjectDes());
        binding.txtPersonGit.setText(model.getResGitLink());

    }

    private void resumeFormVisibility(){
        binding.editTxtPersonName.setVisibility(View.VISIBLE);
        binding.editTxtPersonEdu.setVisibility(View.VISIBLE);
        binding.editTxtPersonSkills.setVisibility(View.VISIBLE);
        binding.editTxtPersonDes.setVisibility(View.VISIBLE);
        binding.editTxtPersonProjectDes.setVisibility(View.VISIBLE);
        binding.editTxtPersonGit.setVisibility(View.VISIBLE);

        binding.txtPersonName.setVisibility(View.GONE);
        binding.txtPersonEdu.setVisibility(View.GONE);
        binding.txtPersonSkills.setVisibility(View.GONE);
        binding.txtPersonDes.setVisibility(View.GONE);
        binding.txtPersonProjectDes.setVisibility(View.GONE);
        binding.txtPersonGit.setVisibility(View.GONE);
    }
    private void resume() {
        binding.txtPersonName.setVisibility(View.VISIBLE);
        binding.txtPersonEdu.setVisibility(View.VISIBLE);
        binding.txtPersonSkills.setVisibility(View.VISIBLE);
        binding.txtPersonDes.setVisibility(View.VISIBLE);
        binding.txtPersonProjectDes.setVisibility(View.VISIBLE);
        binding.txtPersonGit.setVisibility(View.VISIBLE);

        binding.editTxtPersonName.setVisibility(View.GONE);
        binding.editTxtPersonEdu.setVisibility(View.GONE);
        binding.editTxtPersonSkills.setVisibility(View.GONE);
        binding.editTxtPersonDes.setVisibility(View.GONE);
        binding.editTxtPersonProjectDes.setVisibility(View.GONE);
        binding.editTxtPersonGit.setVisibility(View.GONE);

    }
}