package com.example.minicompany;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.ActivityMainBinding;
import com.example.minicompany.interfaces.PassTitleInfo;
import com.example.minicompany.models.UserModel;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import static com.example.minicompany.SecondActivity.SERVICE;

public class MainActivity extends AppCompatActivity implements PassTitleInfo {

    public static final String SERVICE_MAIN = "halwa!";
    private static final String TAG = "fuck face!";
    private ActivityMainBinding binding;
    private ImageView btnBackNav;
    private NavController navigationController;
    private TextView navUserName;
    private TextView navEmailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Utils.initialiseData(this);
        //Utils.clearSharedPreferences(this);

        updateNavView();

        updateNavigationView();

        Log.d(TAG, "onCreate: " + Utils.getUser(MainActivity.this));

        navigationController = Navigation.findNavController(MainActivity.this, R.id.fragment);

        NavigationUI.setupWithNavController(binding.bottomNavView, navigationController);

        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.navMenuApplication:
                        Intent intent = new Intent(MainActivity.this, MyApplicationActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navMenuChat:
                        navigationController.navigate(R.id.itmInbox);
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        break;

                    case R.id.navMenuResume:
                        startActivity(new Intent(MainActivity.this, ResumeActivity.class));
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        break;

                    case R.id.navMenuLogOut:
                        startActivity(new Intent(MainActivity.this, SecondActivity.class));
                        Utils.clearSharedPreferences(MainActivity.this);
                        UserModel model = new UserModel("none", "none", "none");
                        Utils.setUser(MainActivity.this, model);
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        break;
                    case R.id.navMenuPreferences:
                        startActivity(new Intent(MainActivity.this, PreferencesActivity.class));
                        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                            binding.drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        break;

                    default:
                        break;
                }
                return true;
            }
        });

        binding.shit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        Log.d(TAG, "onCreate: " + getIntent().getStringExtra(SERVICE)+">>>>>>>>>>>>>>>>>>");

    }

    private void updateNavigationView(){
        View view = binding.navView.getHeaderView(0);
        initNavView(view);

        btnBackNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });

    }

    private void updateNavView() {
        View view = binding.navView.getHeaderView(0);
        initNavigationView(view);

        UserModel model = Utils.getUser(MainActivity.this);
        navUserName.setText(model.getUsername());
        navEmailId.setText(model.getEmail());

    }

    private void initNavigationView(View view) {
        navUserName = view.findViewById(R.id.navUserName);
        navEmailId = view.findViewById(R.id.navEmailId);
    }

    private void initNavView(View view) {
        btnBackNav = view.findViewById(R.id.navBtnBack);
    }

    @Override
    public void title(String string) {
        if (string != null){
            binding.toolBarTitle.setText(string);
        }
    }
}