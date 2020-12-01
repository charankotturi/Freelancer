package com.example.minicompany.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minicompany.adaptor.jobProviderModelAdaptor;
import com.example.minicompany.interfaces.PassTitleInfo;
import com.example.minicompany.adaptor.jobPostsAdaptor;
import com.example.minicompany.adaptor.popularFieldsAdaptor;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.FragmentHomeBinding;
import com.example.minicompany.models.UserModel;

import static android.content.ContentValues.TAG;
import static com.example.minicompany.MainActivity.SERVICE_MAIN;


public class homeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private popularFieldsAdaptor popularFieldsAdaptor;
    private jobPostsAdaptor jobPostAdaptor;
    private jobProviderModelAdaptor providerModelAdaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initDataPoint();

        popularFieldsAdaptor = new popularFieldsAdaptor(getActivity());
        jobPostAdaptor = new jobPostsAdaptor(getActivity());
        providerModelAdaptor = new jobProviderModelAdaptor(getActivity());

        if (Utils.getAllPopularFields(getActivity()) != null){
            binding.recViewPopularFields.setAdapter(popularFieldsAdaptor);
            binding.recViewPopularFields.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
            popularFieldsAdaptor.setPopularFields(Utils.getAllPopularFields(getActivity()));
        }

        if (Utils.getAllJobs(getActivity()) != null) {
            binding.recViewActualContent.setAdapter(jobPostAdaptor);
            binding.recViewActualContent.setLayoutManager(new LinearLayoutManager(getActivity()));
            jobPostAdaptor.setJobModels(Utils.getAllJobs(getActivity()));
        }

        if (Utils.getProvider(getActivity()) != null) {
            binding.recViewBuyServices.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
            binding.recViewBuyServices.setAdapter(providerModelAdaptor);
            providerModelAdaptor.setModelAdaptors(Utils.getProvider(getActivity()));
        }

        UserModel userModel = Utils.getUser(getActivity());

        if(Utils.getProvider(getActivity()) != null) {
            if (userModel.getCategory() != null) {
                String category = userModel.getCategory();
                if (category.equalsIgnoreCase("Service Consumer")) {
                    binding.txtConsumerService.setVisibility(View.VISIBLE);
                    binding.txtProviderServices.setVisibility(View.GONE);
                    binding.recViewBuyServices.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    binding.recViewBuyServices.setAdapter(providerModelAdaptor);
                } else if (category.equalsIgnoreCase("Service Provider")) {
                    binding.txtConsumerService.setVisibility(View.GONE);
                    binding.txtProviderServices.setVisibility(View.VISIBLE);
                }
            }
        }

        return view;
    }


    private void initDataPoint(){
        PassTitleInfo passTitleInfo;

        try {
            passTitleInfo = (PassTitleInfo) getActivity();
            passTitleInfo.title("Home");

        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }
}