package com.example.onlinedoctorappointmentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView Doctor_login,Patient_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Doctor_login=findViewById(R.id.DoctorLogin);
        Patient_login=findViewById(R.id.PatientLogin);

        Doctor_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DoctorLogin.class));
            }
        });
        Patient_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}