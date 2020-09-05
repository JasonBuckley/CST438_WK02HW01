package com.example.wk02hw01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.NetworkStatsManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    public static final String USERNAME = "Admin";
    public static final String PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = findViewById(R.id.username);
        mPasswordEditText = findViewById(R.id.password);
        mLoginButton = findViewById(R.id.loginButton);

    }

    public void login(View v){
        String username = mNameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        boolean passes[] = LoginUtil.compareCredentials(username, password);

        if(!passes[0]){
            mPasswordEditText.setText("");
            mPasswordEditText.setHintTextColor(Color.RED);
        }else{
            mPasswordEditText.setHintTextColor(Color.GRAY);
        }

        if(!passes[1]){
            mNameEditText.setText("");
            mNameEditText.setHintTextColor(Color.RED);
        }else{
            mNameEditText.setHintTextColor(Color.GRAY);
        }

        if(LoginUtil.authenticate(passes[0], passes[1])){
            Log.i("Testing","Did it get here");
            startActivity(LandingActivity.getIntent(getApplicationContext()));
        }else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }
}