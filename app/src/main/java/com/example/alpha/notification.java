package com.example.alpha;

import static com.example.alpha.help.CHANNEL_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
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
    public static final String CHANNEL_ID = "channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notiText=findViewById(R.id.et);
        nManager = NotificationManagerCompat.from(this);
        //createNotificationChannels();

        createNotificationChannels();

    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel",
                    NotificationManager.IMPORTANCE_LOW
            );

            channel.setDescription("This is a notification");
            NotificationManager m = getSystemService(NotificationManager.class);
            m.createNotificationChannel(channel);
        }
    }

    public void uploadnot(View view) {

        String title = "NOTIFICATION";
        String mess = notiText.getText().toString();
        notiText.setText("");
        //create notification

        Notification n = new NotificationCompat.Builder(this, CHANNEL_ID)

                .setContentTitle(title)
                .setContentText(mess)
                .setSmallIcon(R.drawable.icon)
                .setPriority(NotificationCompat.PRIORITY_LOW) //importens
                .build();

        nManager.notify(1, n);

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
        else if (id == R.id.Auth)
        {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        else if (id == R.id.Camera)
        {
            Intent si = new Intent(this, camera.class);
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