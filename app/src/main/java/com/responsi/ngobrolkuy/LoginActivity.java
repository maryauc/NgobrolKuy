package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView tvLogin, tvSignin, tvLupaPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvLogin = findViewById(R.id.login);
        tvSignin = findViewById(R.id.signin);
        tvLupaPassword = findViewById(R.id.lupaPassword);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(LoginActivity.this, HomeChatActivity.class);
                startActivity(Login);
            }
        });

        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signin = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(Signin);
            }
        });

        tvLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LupaPassword = new Intent(LoginActivity.this, PulihkanPasswordActivity.class);
                startActivity(LupaPassword);
            }
        });
    }

    public void handleLogin(View view){

    }
}