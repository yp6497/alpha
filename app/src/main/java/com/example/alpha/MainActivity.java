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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    //User user ;
    String emailS, passwordS;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }

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

        /*
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
         */
    }

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

