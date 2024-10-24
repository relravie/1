package com.example.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCount, textViewOptionSelected;
    private Button buttonIncrement;
    private EditText editTextInput;
    private CheckBox checkBoxOption;
    private Switch switchTheme;
    private int count = 0;

    private StateViewModel stateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        buttonIncrement = findViewById(R.id.buttonIncrement);
        editTextInput = findViewById(R.id.editTextInput);
        checkBoxOption = findViewById(R.id.checkBoxOption);
        switchTheme = findViewById(R.id.switchTheme);
        textViewOptionSelected = findViewById(R.id.textViewOptionSelected);

        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);

        updateUI();

        buttonIncrement.setOnClickListener(v -> {
            stateViewModel.incrementCount();
            updateCountText();
        });

        checkBoxOption.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stateViewModel.setCheckBoxChecked(isChecked);
            textViewOptionSelected.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        switchTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stateViewModel.setSwitchChecked(isChecked);
            if (isChecked) {
                setTheme(R.style.Theme_AppCompat);
            } else {
                setTheme(R.style.Theme_AppCompat_Light);
            }
            recreate(); 
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        stateViewModel.setInputText(editTextInput.getText().toString());
    }

    private void updateUI() {
        editTextInput.setText(stateViewModel.getInputText());
        updateCountText();

        checkBoxOption.setChecked(stateViewModel.isCheckBoxChecked());
        textViewOptionSelected.setVisibility(stateViewModel.isCheckBoxChecked() ? View.VISIBLE : View.GONE);

        switchTheme.setChecked(stateViewModel.isSwitchChecked());
    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + stateViewModel.getCount());
    }
}
