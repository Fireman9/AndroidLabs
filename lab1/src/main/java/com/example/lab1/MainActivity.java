package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements DataInputFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(String mobileType, String company) {
        ResultFragment fragment = (ResultFragment) getSupportFragmentManager()
                .findFragmentById(R.id.resultFragmentContainerView);
        if (fragment != null)
            fragment.setData(mobileType, company);
    }

    public void showAllSelections(View view) {
        Intent intent = new Intent(this, DBViewActivity.class);
        startActivity(intent);
    }
}
