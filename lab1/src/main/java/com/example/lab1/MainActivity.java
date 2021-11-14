package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DataInput.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String mobileType, String company) {
        Result fragment = (Result) getSupportFragmentManager()
                .findFragmentById(R.id.resultFragmentContainerView);
        if (fragment != null)
            fragment.setData(mobileType, company);
    }
}
