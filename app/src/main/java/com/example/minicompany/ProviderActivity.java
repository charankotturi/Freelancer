package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.minicompany.adaptor.tagAdaptor;
import com.example.minicompany.databinding.ActivityProviderBinding;
import com.example.minicompany.models.jobProviderModel;

import java.util.ArrayList;

import static com.example.minicompany.adaptor.jobProviderModelAdaptor.PROVIDER_JOB_MAN;

public class ProviderActivity extends AppCompatActivity {

    private ActivityProviderBinding binding;
    private tagAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProviderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        if (intent != null){
            jobProviderModel model = intent.getParcelableExtra(PROVIDER_JOB_MAN);
            if (model != null) {
                binding.txtProviderName.setText(model.getProviderName());
                binding.txtAboutProvider.setText(model.getDescription());

                ArrayList<String> skills = model.getpSkills();
                adaptor = new tagAdaptor();
                binding.recViewProviderSkills.setAdapter(adaptor);
                binding.recViewProviderSkills.setLayoutManager(new LinearLayoutManager(ProviderActivity.this, RecyclerView.HORIZONTAL, false));
                adaptor.setTags(skills);

                binding.btnSendRequest.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(ProviderActivity.this, MainActivity.class));
                        Toast.makeText(ProviderActivity.this, "Request Sent.", Toast.LENGTH_SHORT).show();
                    }
                });

                binding.txtPGitHubLink.setText(model.getGitHubLink());

                binding.imgBackProvider.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                });

            }
        }

    }
}