package com.example.minicompany.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minicompany.adaptor.jobPostsAdaptor;
import com.example.minicompany.adaptor.resTagAdaptor;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.FragmentSearchBinding;
import com.example.minicompany.interfaces.PassTitleInfo;
import com.example.minicompany.models.PopularFieldsModel;
import com.example.minicompany.models.jobModel;

import java.util.ArrayList;

public class searchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private jobPostsAdaptor adaptor;
    private resTagAdaptor tagAdaptor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        updateTitle();

        adaptor = new jobPostsAdaptor(getActivity());
        binding.recViewSearch.setAdapter(adaptor);
        binding.recViewSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
//        binding.recViewSearchRes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        if (Utils.getCategory() != null) {
//            if (!Utils.getCategory().equals("shit")) {
//                adaptor.setJobModels(Utils.searchWithCategory(getActivity(), Utils.getCategory()));
//            }
//        }

        Bundle bundle = getArguments();
        String sheet = bundle.getString("lol");
        adaptor.setJobModels(Utils.searchWithCategory(getActivity(), sheet));


        tagAdaptor = new resTagAdaptor(getActivity());
        binding.recViewSearchRes.setAdapter(tagAdaptor);
        binding.recViewSearchRes.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<PopularFieldsModel> fieldsModels = Utils.getAllPopularFields(getActivity());
        ArrayList<String> tagSearch = new ArrayList<>();

        for (PopularFieldsModel m: fieldsModels) {
            String tag = m.getFieldName();
            tagSearch.add(tag);
        }

        tagAdaptor.setTags(tagSearch);

        binding.imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSearch();
            }
        });

        binding.editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                initSearch();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    private void initSearch() {

        if (!binding.editSearch.getText().toString().equals("")) {
            ArrayList<jobModel> jobs = Utils.searchItem(getActivity(), binding.editSearch.getText().toString());
            if (jobs != null) {
                adaptor.setJobModels(jobs);
            }
        }

    }

    private void updateTitle() {
        PassTitleInfo passTitleInfo;

        try {
            passTitleInfo = (PassTitleInfo) getActivity();
            passTitleInfo.title("Search");

        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

}