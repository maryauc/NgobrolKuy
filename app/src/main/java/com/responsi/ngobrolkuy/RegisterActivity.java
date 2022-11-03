package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword, etKonfirmasiPassword;
    private TextView tvRegister, tvAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.username);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        etKonfirmasiPassword = findViewById(R.id.konfirmasiPassword);
        tvRegister = findViewById(R.id.register);
        tvAkun = findViewById(R.id.akun);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(RegisterActivity.this, LoginActivity.class);

                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String konfirmasiPassword = etKonfirmasiPassword.getText().toString();

                if (username.isEmpty()){
                    etUsername.setError("Username is required!");
                }else if (email.isEmpty()){
                    etEmail.setError("Email is required");
                }else if (password.isEmpty()){
                    etPassword.setError("Password is required");
                }else if (!password.equals(konfirmasiPassword)){
                    Toast.makeText(RegisterActivity.this, "Password is not Match", Toast.LENGTH_SHORT).show();
                }else{
                    register.putExtra("username", username);
                    register.putExtra("email", email);
                    register.putExtra("password", password);
                    register.putExtra("konfirmasiPassword", konfirmasiPassword);
                    startActivity(register);
                }
            }
        });

        tvAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent akun = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(akun);
            }
        });
    }
}