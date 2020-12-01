package com.example.minicompany.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.util.Util;
import com.example.minicompany.R;
import com.example.minicompany.data.Utils;
import com.example.minicompany.databinding.FragmentSearchBinding;
import com.example.minicompany.models.UserModel;

public class navigationFragment extends Fragment {

    private ImageView btnBackNav;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_header, container, false);

        return view;

    }

}
