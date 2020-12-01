package com.example.minicompany.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.minicompany.interfaces.PassTitleInfo;
import com.example.minicompany.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link inboxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class inboxFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public inboxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment inboxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static inboxFragment newInstance(String param1, String param2) {
        inboxFragment fragment = new inboxFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        PassTitleInfo passTitleInfo;

        try {
            passTitleInfo = (PassTitleInfo) getActivity();
            passTitleInfo.title("Chat");

        }catch (ClassCastException e){
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        return view;

    }
}