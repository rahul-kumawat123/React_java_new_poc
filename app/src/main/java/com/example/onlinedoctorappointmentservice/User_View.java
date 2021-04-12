package com.example.onlinedoctorappointmentservice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class User_View extends AppCompatActivity {

    TextView Name_Usershow,Email_Usershow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);
        SharedPreferences sP=getSharedPreferences("User_Data",MODE_PRIVATE);
        String s_name=sP.getString("name","");
        String s_email=sP.getString("email","");
        Name_Usershow=findViewById(R.id.name_here);
        Email_Usershow=findViewById(R.id.email_here);

        Name_Usershow.setText(s_name);
        Email_Usershow.setText(s_email);
    }
}
