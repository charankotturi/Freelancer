package com.example.minicompany.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minicompany.MainActivity;
import com.example.minicompany.MyApplicationActivity;
import com.example.minicompany.PostAJobActivity;
import com.example.minicompany.R;
import com.example.minicompany.ResumeActivity;
import com.example.minicompany.SavedActivity;
import com.example.minicompany.SecondActivity;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.FragmentProfileBinding;
import com.example.minicompany.interfaces.PassTitleInfo;
import com.example.minicompany.models.UserModel;

import static android.content.ContentValues.TAG;
import static com.example.minicompany.MainActivity.SERVICE_MAIN;

public class profileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private String TAG = "shit >>>>>>>>>>>>>>>>";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        updateTitle();

        UserModel model = Utils.getUser(getActivity());

        if (model != null) {
            if (model.getCategory() != null) {
                String category = model.getCategory();
                if (category.equalsIgnoreCase( "Service Consumer")) {
                    binding.textPService.setVisibility(View.GONE);
                    binding.ProviderList.setVisibility(View.GONE);
                    binding.buyingList.setVisibility(View.VISIBLE);
                    binding.textPBuying.setVisibility(View.VISIBLE);
                }
                else if (category.equalsIgnoreCase("Service Provider")) {
                    binding.buyingList.setVisibility(View.GONE);
                    binding.textPBuying.setVisibility(View.GONE);
                    binding.textPService.setVisibility(View.VISIBLE);
                    binding.ProviderList.setVisibility(View.VISIBLE);
                }
            }

            binding.txtUserName.setText(model.getUsername());
        }

        binding.layPSavedTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SavedActivity.class));
            }
        });

        binding.layPResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResumeActivity.class));
            }
        });

        binding.layPMyApplications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyApplicationActivity.class));
            }
        });

        binding.layPSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment).navigate(R.id.itmSearch);
            }
        });

        binding.layPLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SecondActivity.class));
                Utils.clearSharedPreferences(getActivity());
            }
        });

        binding.layPWorkDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PostAJobActivity.class));
            }
        });
        
        return view;
    }

    private void updateTitle(){
        PassTitleInfo passTitleInfo;

        try {
            passTitleInfo = (PassTitleInfo) getActivity();
            passTitleInfo.title("Profile");

        }catch (ClassCastException e){
            e.printStackTrace();
        }

    }
}
