package com.budease.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.budease.R;

public class GetNumber extends Fragment {

    private OnNumberEnteredListener onNumberEnteredListener;
    View view;
    private EditText userPhoneNumber;

    public GetNumber() {
        // Required empty public constructor
    }

    public interface OnNumberEnteredListener{
        public void onNumberFetched(String number);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_get_number, container, false);
            userPhoneNumber = (EditText) view.findViewById(R.id.userPhoneNumber);
            userPhoneNumber.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) { }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length()==10){
                        String phoneNumber = s.toString();
                        onNumberEnteredListener.onNumberFetched(phoneNumber);
                    }
                }
            });
            return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onNumberEnteredListener = (OnNumberEnteredListener) context;
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
        }
    }
}
