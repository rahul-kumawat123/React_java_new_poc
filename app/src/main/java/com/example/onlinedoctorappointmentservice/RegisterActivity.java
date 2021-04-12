package com.example.onlinedoctorappointmentservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText name,phone,email,password;
    Button register;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.mobile);
        email=findViewById(R.id.EmailRegister);
        password=findViewById(R.id.PasswordRegister);
        register=findViewById(R.id.button2);

        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progress);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String User_name=name.getText().toString().trim();
                String User_phone=phone.getText().toString().trim();
                /**
                 *  Storing user data in shared preference
                 */
                SharedPreferences sharedPreferences=getSharedPreferences("User_Data",MODE_PRIVATE);
                SharedPreferences.Editor myEdit=sharedPreferences.edit();
                myEdit.putString("name",name.getText().toString());
                myEdit.putString("email",email.getText().toString());

                /**
                * Validation of input
                 */

                if(TextUtils.isEmpty(User_name))
                {
                    name.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(User_phone))
                {
                    phone.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(mail))
                {
                    email.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    password.setError("Password is required");
                    return;
                }
                if(pass.length()<6)
                {
                    password.setError("Password must be >= 6 Character");
                    return;
                }
                /*if(fAuth.getCurrentUser()!=null)
                {
                    startActivity(new Intent(getApplicationContext(),Dashboard_Activity.class));
                    finish();
                }*/
                progressBar.setVisibility(View.VISIBLE);
                /**
                 *  REGISTER THE USER IN FIREBASE
                  */

                fAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this,"User created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"Error creating the user",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}