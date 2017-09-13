package com.example.adamn.userstatisticsapplication.Helpers.Login;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 *This class is a helper class that determines if inputed email and password
 * matches of that is in the database.
 *
 * @author Adam Nowak
 */

public class InputValidation {
    private Context context;

    public InputValidation(Context context){
        this.context = context;
    }

    public boolean isInputFilled(EditText InputEditText, TextInputLayout InputLayout,String message){
        String input = InputEditText.getText().toString().trim();
        if(input.isEmpty()){
            InputLayout.setError(message);
            hideKeyboardFrom(InputEditText);
            return false;
        }else{
            InputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEmail(EditText textInputEditText, TextInputLayout textInputLayout, String message){
        String value = textInputEditText.getText().toString().trim();
        if(value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        }else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private void hideKeyboardFrom(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
