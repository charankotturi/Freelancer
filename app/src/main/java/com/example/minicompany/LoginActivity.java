package com.example.minicompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.util.Util;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityLoginBinding;
import com.example.minicompany.models.UserModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.view.View.GONE;
import static com.example.minicompany.SecondActivity.SERVICE;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "in login activity!";
    private ActivityLoginBinding binding;
    private String email;
    private String password;
    private String field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        if (intent != null) {
            field = intent.getStringExtra(SERVICE);
        }

        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                intent.putExtra("LtoR", field);
                startActivity(intent);
            }
        });

        binding.btnLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = binding.editTxtLogin.getText().toString();
                password = binding.editTxtPassword.getText().toString();
                new ProgressBar().execute();
            }
        });

    }

    private class ProgressBar extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            vollyPost();
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            binding.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            binding.progressBar.setVisibility(GONE);

        }
    }

    private void vollyPost() {

        String url = "https://auth-charan.herokuapp.com/user";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("users");
                    for (int i=0; i<array.length(); i++) {
                        JSONObject object2 = array.getJSONObject(i);
                        String username = object2.getString("username");
                        String getEmail = object2.getString("email");
                        if (email.equals(getEmail)){
                            UserModel user = new UserModel(username, email, password);
                            user.setCategory(field);
                            Utils.setUser(LoginActivity.this, user);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Email-Id not present please register first.", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        Log.d(TAG, "getInfo: >>>>>>>>>>>>>>>>>");
        queue.add(request);
        queue.start();

    }

}