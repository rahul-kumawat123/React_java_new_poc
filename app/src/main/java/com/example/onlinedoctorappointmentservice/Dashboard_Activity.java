package com.example.onlinedoctorappointmentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard_Activity extends AppCompatActivity {

    Button logout_button;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_);

        logout_button=findViewById(R.id.logout);
        firebaseAuth=FirebaseAuth.getInstance();
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    firebaseAuth.signOut();
                    Toast.makeText(Dashboard_Activity.this,"User sign out successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}