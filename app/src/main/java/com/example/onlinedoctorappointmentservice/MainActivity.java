package com.example.onlinedoctorappointmentservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button login;
    EditText email_User,password_User;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email_User=findViewById(R.id.email);
        password_User=findViewById(R.id.password);
        login=findViewById(R.id.button);
        textView=findViewById(R.id.register_view);
        progressBar=findViewById(R.id.progress_Login);
        firebaseAuth=FirebaseAuth.getInstance();
        //Register user first
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        //
       /* String mail=email_User.getText().toString().trim();
        String pass=password_User.getText().toString().trim();

        String s1=FirebaseAuth.getInstance().getCurrentUser().getEmail();
        String s2=FirebaseAuth.getInstance().getCurrentUser().get*/


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=email_User.getText().toString().trim();
                String s2=password_User.getText().toString().trim();
                if(TextUtils.isEmpty(s1))
                {
                    email_User.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(s2))
                {
                    password_User.setError("Password is required");
                    return;
                }
                if(s2.length()<6)
                {
                    password_User.setError("Password must be >= 6 Character");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Log.e("User","Sign in successful");
                            //FirebaseUser user=firebaseAuth.getCurrentUser();
                            startActivity(new Intent(getApplicationContext(),DashBoard_Activity.class));

                        }
                        else
                        {
                            Log.e("User","Error Occured");
                           // progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(MainActivity.this,"User denied",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}