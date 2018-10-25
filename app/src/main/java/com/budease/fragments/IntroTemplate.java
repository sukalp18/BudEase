package com.budease.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.budease.R;

/**
 * A simple {@link Fragment} subclass.
 */


public class IntroTemplate extends Fragment {

    private int introPic;
    private ImageView fragBg;

    public static IntroTemplate getInstance(int introPic){
        IntroTemplate introTemplate = new IntroTemplate();
        Bundle args = new Bundle();
        args.putInt("introPic",introPic);
        introTemplate.setArguments(args);
        return introTemplate;
    }

    public IntroTemplate() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        introPic = getArguments().getInt("introPic");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intro_template, container, false);
        fragBg.setImageResource(introPic);
        return view;
    }

}
