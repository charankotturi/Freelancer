package com.example.minicompany.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.minicompany.R;
import com.example.minicompany.ResumeActivity;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.FragmentBottomSheetBinding;
import com.example.minicompany.models.resumeModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bottomSheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bottomSheetFragment extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bottomSheetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bottomSheetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static bottomSheetFragment newInstance(String param1, String param2) {
        bottomSheetFragment fragment = new bottomSheetFragment();
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
    private FragmentBottomSheetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottomSheetBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.txtEditResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResumeActivity.class));
            }
        });

        resumeModel model = Utils.getResume(getActivity());
        if (model != null) {
            if (model.getResName().equalsIgnoreCase("none")){
                Toast.makeText(getActivity(), "Add a resume!", Toast.LENGTH_SHORT).show();
            }
            binding.txtPersonName.setText(model.getResName().toString());
            binding.txtPersonEdu.setText(model.getResEdu().toString());
            binding.txtPersonSkills.setText(model.getResSkills().toString());
            binding.txtPersonDes.setText(model.getResDes().toString());
            binding.txtPersonProjectDes.setText(model.getResProjectDes().toString());
            binding.txtPersonGit.setText(model.getResGitLink().toString());
        }else {
            Toast.makeText(getActivity(), "Add a resume!", Toast.LENGTH_SHORT).show();
        }

        Log.d(TAG, "onCreateView: " + Utils.getResume(getActivity()));

        return view;
    }
}

