package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] mobileTypes = {"Monoblock with numeric keypad", "Monoblock with flip", "Slider",
            "Clamshells", "Monoblock with QWERTY-keyboard", "Touchscreen phone"};
    String[] companies = {"Samsung", "Nokia", "Meizu", "Xiaomi", "Google", "Apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, mobileTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        for (int i = 0; i < companies.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(i);
            radioButton.setText(companies[i]);
            radioGroup.addView(radioButton);
        }
    }

    public void showResult(View view) {
        Spinner spinner = findViewById(R.id.spinner);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        if (spinner.getSelectedItem() != null && radioGroup.getCheckedRadioButtonId() != -1) {
            TextView textTypeResult = findViewById(R.id.TextTypeResult);
            TextView textCompanyResult = findViewById(R.id.TextCompanyResult);
            textTypeResult.setText(String.format("Type: %s", spinner.getSelectedItem().toString()));
            RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
            textCompanyResult.setText(String.format("Company: %s", radioButton.getText()));
        } else {
            Toast toast = Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
