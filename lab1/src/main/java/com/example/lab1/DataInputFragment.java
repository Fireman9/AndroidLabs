package com.example.lab1;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;


public class DataInputFragment extends Fragment {

    interface OnFragmentSendDataListener {
        void onSendData(String mobileType, String company);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    String[] mobileTypes = {"Monoblock with numeric keypad", "Monoblock with flip", "Slider",
            "Clamshells", "Monoblock with QWERTY-keyboard", "Touchscreen phone"};
    String[] companies = {"Samsung", "Nokia", "Meizu", "Xiaomi", "Google", "Apple"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_input, container, false);

        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item, mobileTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        for (int i = 0; i < companies.length; i++) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setId(i);
            radioButton.setText(companies[i]);
            radioGroup.addView(radioButton);
        }

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (spinner.getSelectedItem() != null && radioGroup.getCheckedRadioButtonId() != -1) {
                    RadioButton radioButton = view.findViewById(radioGroup.getCheckedRadioButtonId());
                    saveData(spinner.getSelectedItem().toString(), (String) radioButton.getText());
                    fragmentSendDataListener.onSendData(spinner.getSelectedItem().toString(), (String) radioButton.getText());
                } else {
                    Toast toast = Toast.makeText(getContext(),
                            "Fill in all fields", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        return view;
    }

    public void saveData(String mobileType, String company) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(getContext().openFileOutput("data.txt",
                    Context.MODE_APPEND | Context.MODE_PRIVATE));
            outputStreamWriter.write(mobileType + ", " + company + "\n");
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
