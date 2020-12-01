package com.example.minicompany.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minicompany.MainActivity;
import com.example.minicompany.MyApplicationActivity;
import com.example.minicompany.R;
import com.example.minicompany.adaptor.applicationsAdaptor;
import com.example.minicompany.adaptor.jobPostsAdaptor;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.FragmentHomeApplicationBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home_application_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home_application_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home_application_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home_application_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static home_application_Fragment newInstance(String param1, String param2) {
        home_application_Fragment fragment = new home_application_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentHomeApplicationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeApplicationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.imgBackAppActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        binding.btnClickMeToExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        applicationsAdaptor applicationsAdaptor = new applicationsAdaptor(getActivity());
        if (Utils.getAllApplications(getActivity()) != null) {

            binding.emptyRelLayout.setVisibility(View.GONE);
            binding.recViewApplications.setVisibility(View.VISIBLE);
            binding.recViewApplications.setAdapter(applicationsAdaptor);
            binding.recViewApplications.setLayoutManager(new LinearLayoutManager(getActivity()));
            applicationsAdaptor.setJobModels(Utils.getAllApplications(getActivity()));

        }else {
            binding.emptyRelLayout.setVisibility(View.VISIBLE);
            binding.recViewApplications.setVisibility(View.GONE);
        }
        binding.btnApplicationResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.fragment2).navigate(R.id.action_home_application_to_bottomSheet);
            }
        });

        return view;
    }

}