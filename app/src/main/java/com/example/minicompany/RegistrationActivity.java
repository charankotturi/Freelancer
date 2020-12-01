package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.util.Util;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityRegistrationBinding;
import com.example.minicompany.interfaces.PostEndPoint;
import com.example.minicompany.models.UserModel;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationActivity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;
    private String email, password, username,x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Gson gson = new Gson();

        Intent intent = getIntent();
        if (intent != null) {
            x = intent.getStringExtra("LtoR");
        }

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = binding.editTxtEmailId.getText().toString();
                password = binding.editTxtPassword.getText().toString();
                username = binding.editTxtUserName.getText().toString();

                String url = "https://auth-charan.herokuapp.com/user/";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                PostEndPoint postEndPoint = retrofit.create(PostEndPoint.class);

                UserModel model = new UserModel(username, email, password);

                Call<UserModel> call = postEndPoint.newPost(model);
                call.enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        if (response.isSuccessful()) {
                            model.setCategory(x);
                            Utils.setUser(RegistrationActivity.this, model);
                            startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(RegistrationActivity.this, "Please check your email id.", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {

                    }
                });

            }
        });

    }
}