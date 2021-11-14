package com.example.lab1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Result extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    public void setData(String mobileType, String company) {
        TextView textTypeResult = getView().findViewById(R.id.TextTypeResult);
        TextView textCompanyResult = getView().findViewById(R.id.TextCompanyResult);
        textTypeResult.setText(String.format("Type: %s", mobileType));
        textCompanyResult.setText(String.format("Company: %s", company));
    }
}
