package com.example.alpha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText et_mail, et_password;
    //User user ;
    String emailS, passwordS;
    FirebaseAuth mAuth;
    ProgressBar progressBar_ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        //email = findViewById(R.id.email);
        //password = findViewById(R.id.password);
        et_mail=(EditText) findViewById(R.id.et_email);
        et_password=(EditText) findViewById(R.id.et_password);
        progressBar_ma=(ProgressBar) findViewById(R.id.progressBar_ma);

        progressBar_ma.setVisibility(View.INVISIBLE);

    }

    public void insert(View view) {
        progressBar_ma.setVisibility(View.VISIBLE);
        String email=et_mail.getText().toString();
        String password=et_password.getText().toString();
        if (!email.isEmpty() && !password.isEmpty())
        {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressBar_ma.setVisibility(View.INVISIBLE);
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(MainActivity.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressBar_ma.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity.this, "Registration Error: "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            et_mail.setText("");
            et_password.setText("");
        }
        else
        {
            progressBar_ma.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Enter all the required information!", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    public void SignIn(View view) {

        emailS = email.getText().toString();
        passwordS = password.getText().toString();

        if (TextUtils.isEmpty(emailS))
            email.setError("Email is required");
        if (TextUtils.isEmpty(passwordS))
            password.setError("Password is required");
        else {
            if (password.length() < 6)
                password.setError("password must be longer than 6 digits");
            else {
                fAuth.createUserWithEmailAndPassword
                        (emailS, passwordS).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() { //this
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }


        if (TextUtils.isEmpty(emailS))
            email.setError("Email is required");
        if (TextUtils.isEmpty(passwordS))
            password.setError("Password is required");
        else {
            if (password.length() < 6)
                password.setError("password must be longer than 6 digits");
            else {
                fAuth.signInWithEmailAndPassword
                        (emailS, passwordS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "User Signed", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(MainActivity.this, "Error" + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }

     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Gallery) {
            Intent si = new Intent(this, gallery.class);
            startActivity(si);
        }
        else if (id == R.id.Camera)
        {
            Intent si = new Intent(this, camera.class);
            startActivity(si);
        }
        else if (id == R.id.Notification)
        {
            Intent si = new Intent(this, notification.class);
            startActivity(si);
        }
        else if (id == R.id.Map)
        {
            Intent si = new Intent(this, map.class);
            startActivity(si);
        }

        return true;
    }


}

