package com.example.alpha;

import static com.example.alpha.help.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;

import android.app.Notification;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class notification extends AppCompatActivity {

    public EditText notiText;
    public NotificationManagerCompat nManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notiText=findViewById(R.id.et);
        nManager = NotificationManagerCompat.from(this);
    }




    public void Notification(View view) {
        String title = "NOTIFICATION";
        String mess = notiText.getText().toString();
        notiText.setText("");
        //create notification
        Notification n = new NotificationCompat.Builder(this, CHANNEL_ID)

                .setContentTitle(title)
                .setContentText(mess)
                //.setSmallIcon(R.drawable.icon)
                .setPriority(NotificationCompat.PRIORITY_LOW) //importens
                .build();

        nManager.notify(1, n);

    }

        //private static final int CAMERA_REQUEST = 102;
        //ImageView imageView;
        //Uri filePath;

        // request code

        // firebase storage and StorageReference
        /*
        FirebaseStorage storage;
        StorageReference storageReference;
        private Uri photoUri;
        private DataSnapshot mStorageRef;
        private FirebaseAuth auth;
        int count=0 ;
        //private StorageReference ref;

         */
            /*
            setContentView(R.layout.activity_notification);
            ActionBar actionBar;
            actionBar = getSupportActionBar();
            ColorDrawable colorDrawable
                    = new ColorDrawable(
                    Color.parseColor("#0F9D58"));
            actionBar.setBackgroundDrawable(colorDrawable);

            imageView = findViewById(R.id.imageview);

            // get the Firebase  storage reference
            storage = FirebaseStorage.getInstance();
            storageReference = storage.getReference();

             */
        }

         /*
        public void openCam(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //startActivityForResult(intent, 101);

            //if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            if (true) {
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    // Error occurred while creating the File
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(this,
                            "com.example.android.fileprovider",
                            photoFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(intent, CAMERA_REQUEST);
                }
            }
        }

          */
          /*
        private File createImageFile() throws IOException {
            // Create an image file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    imageFileName,  /* prefix */
                //    ".jpg",         /* suffix */
                 //   storageDir      /* directory */
            //);

            // Save a file: path for use with ACTION_VIEW intents
           // photoUri = Uri.fromFile(image);
           // return image;
      //  }

        /*
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK && requestCode == CAMERA_REQUEST) {
                imageView.setImageURI(photoUri);
            }
        }

        public void uploadpic(View view) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            //UploadTask uploadTask = mStorageRef.child("images/users/" + auth.getCurrentUser().getUid() + "-" + Gallery.count).putFile(photoUri);
            //Gallery.count++;
            storageReference.putFile(filePath).uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(notification.this, "Successfully Uploaded", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(notification.this, "Failed to upload.", Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploaded " + (int) progress + "%");
                }
            });
        }
         */
