package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DBViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbview);

        GridView gridView = findViewById(R.id.gridView);
        List<String> mobileTypes = new ArrayList<String>();
        List<String> companies = new ArrayList<String>();
        readFromFile(mobileTypes, companies);

        CustomAdapter adapter = new CustomAdapter(this, mobileTypes, companies);
        gridView.setAdapter(adapter);
        if (gridView.getAdapter().isEmpty()) {
            Toast toast = Toast.makeText(getBaseContext(),
                    "Empty selections", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void readFromFile(List<String> mobileTypes, List<String> countries) {
        try {
            InputStream inputStream = getBaseContext().openFileInput("data.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(",");
                    mobileTypes.add(values[0]);
                    countries.add(values[1]);
                }
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void returnToMainActivity(View view) {
        finish();
    }
}