package com.example.adamn.userstatisticsapplication.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.example.adamn.userstatisticsapplication.Database.DBHandler;
import com.example.adamn.userstatisticsapplication.Helpers.Login.InputValidation;
import com.example.adamn.userstatisticsapplication.R;

/**
 * This class contains code for the login activity. This activity is displayed on start up and allows
 * users to login into the application.
 *
 * @author Adam Nowak
 */

public class LoginActivity extends AppCompatActivity implements OnClickListener {

    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private EditText editTextEmail;
    private EditText editTextPassword;

    private AppCompatButton buttonLogin;
    private AppCompatButton buttonRegister;

    private InputValidation inputValidation;

    private DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();

}
    private void initViews(){
        nestedScrollView = (NestedScrollView) findViewById(R.id.nextedScrollView);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.Login_Email_Layout);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.Login_Password_Layout);
        editTextEmail = (EditText) findViewById(R.id.Login_Email);
        editTextPassword = (EditText) findViewById(R.id.Login_Password);
        buttonLogin = (AppCompatButton) findViewById(R.id.Login_Button);
        buttonRegister = (AppCompatButton) findViewById(R.id.Login_Register_Button);

    }
    private void initListeners(){
        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }
    private void initObjects(){
        dbHandler = new DBHandler(activity);
        inputValidation = new InputValidation(activity);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.Login_Button:
                verifyFromSQLite();
                break;
            case R.id.Login_Register_Button:
                Intent intentRegister = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }
    public void verifyFromSQLite(){
        if(!inputValidation.isInputEmail(editTextEmail,textInputLayoutEmail,getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputFilled(editTextEmail,textInputLayoutEmail,getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputFilled(editTextPassword,textInputLayoutPassword,getString(R.string.error_message_password))){
            return;
        }
        if(dbHandler.checkUser(editTextEmail.getText().toString()
         , editTextPassword.getText().toString())){
            Intent usersIntent = new Intent(activity,HomepageActivity.class);
            usersIntent.putExtra("EMAIL",editTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(usersIntent);
        }else{
            Snackbar.make(nestedScrollView,getString(R.string.error_valid_email_password),Snackbar.LENGTH_LONG).show();
        }
    }
    private void emptyInputEditText(){
        editTextEmail.setText(null);
        editTextPassword.setText(null);
    }
}

