package com.example.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel {
    private int count = 0;
    private String inputText = "";
    private boolean checkBoxChecked = false;
    private boolean switchChecked = false;

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public boolean isCheckBoxChecked() {
        return checkBoxChecked;
    }

    public void setCheckBoxChecked(boolean checkBoxChecked) {
        this.checkBoxChecked = checkBoxChecked;
    }

    public boolean isSwitchChecked() {
        return switchChecked;
    }

    public void setSwitchChecked(boolean switchChecked) {
        this.switchChecked = switchChecked;
    }
}
