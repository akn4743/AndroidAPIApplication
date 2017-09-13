package com.example.adamn.userstatisticsapplication.Activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.example.adamn.userstatisticsapplication.Database.DBHandler;
import com.example.adamn.userstatisticsapplication.Helpers.Login.InputValidation;
import com.example.adamn.userstatisticsapplication.Models.User;
import com.example.adamn.userstatisticsapplication.R;

/**
 * This Class represents the register activity which can be viewed from the login activity.
 * The user creates an account to login from this activity.
 *
 * @author Adam Nowak
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private final AppCompatActivity activity = RegisterActivity.this;
    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private EditText editTextEmail;
    private EditText editTextPassword;

    private AppCompatButton buttonRegister;
    private AppCompatButton buttonBack;

    private InputValidation inputValidation;
    private DBHandler dbHandler;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        
        initviews();
        initListeners();
        initObjects();
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        dbHandler = new DBHandler(activity);
        user = new User();
    }


    private void initviews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nextedScrollView);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.RegisterEmailLayout);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.Register_Password_Layout);
        editTextEmail = (EditText) findViewById(R.id.RegisterEmail);
        editTextPassword = (EditText) findViewById(R.id.RegisterPassword);
        buttonRegister = (AppCompatButton) findViewById(R.id.RegisterCreateAccount);
        buttonBack = (AppCompatButton) findViewById(R.id.RegisterBackButton);
    }
    private void initListeners() {
        buttonRegister.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.RegisterBackButton:
                activity.finish();
                break;
            case R.id.RegisterCreateAccount:
                postDataToSQL();
                break;
        }
    }
    private void postDataToSQL(){
        if(!inputValidation.isInputEmail(editTextEmail,textInputLayoutEmail,getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputFilled(editTextEmail,textInputLayoutEmail,getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputFilled(editTextPassword,textInputLayoutPassword,getString(R.string.error_message_password))){
            return;
        }
        if(!dbHandler.checkUser(editTextEmail.getText().toString())){
            user.setEmail(editTextEmail.getText().toString());
            user.setPassword(editTextPassword.getText().toString());
            dbHandler.addUser(user);
            emptyInputEditText();
            Snackbar.make(buttonBack,getString(R.string.message_success),Snackbar.LENGTH_LONG).show();
        }else{
            Snackbar.make(buttonBack,getString(R.string.error_email_exists),Snackbar.LENGTH_LONG).show();
        }
    }
    private void emptyInputEditText(){
        editTextEmail.setText(null);
        editTextPassword.setText(null);
    }

}
