package com.example.alpha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class gallery extends AppCompatActivity {


    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        iv = (ImageView) findViewById(R.id.iv);


    }

        public void openGallery (View view){

            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 22);
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK && requestCode == 22) {
                iv.setImageURI(data.getData());

                UploadTask uploadTask = FBref.storageRef.child("images/" + data.getData().getLastPathSegment()).putFile(data.getData());
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(gallery.this, "Failed to upload", Toast.LENGTH_SHORT).show();
                        // Handle unsuccessful uploads
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        // ...
                        Toast.makeText(gallery.this, "Photo uploaded", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Camera) {
            Intent si = new Intent(this, camera.class);
            startActivity(si);
        }
        else if (id == R.id.Auth)
        {
            Intent si = new Intent(this, MainActivity.class);
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






