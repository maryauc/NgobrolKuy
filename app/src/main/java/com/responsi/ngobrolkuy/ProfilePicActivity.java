package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ProfilePicActivity extends AppCompatActivity {

    private ImageView ivFoto;
    private CardView cvLanjut;
    private TextView tvLewati;
    private ImageView ivPencilIcon;
    private static final int GALLERY_REQUEST_CODE = 1;
    private static final String TAG = ProfilePicActivity.class.getCanonicalName();
    private Bitmap bitmap;
    private Uri imgUri = null;
    private boolean change_img = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        ivFoto = findViewById(R.id.profilePic);
        cvLanjut = findViewById(R.id.lanjut);
        tvLewati = findViewById(R.id.lewat);
        ivPencilIcon = findViewById(R.id.pencil);
        String uname = getIntent().getExtras().getString("username");
        String pass = getIntent().getExtras().getString("password");

        ivPencilIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ubah = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(ubah, GALLERY_REQUEST_CODE);
            }
        });

        ivPencilIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pencil = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pencil, GALLERY_REQUEST_CODE);
            }
        });

        cvLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanjut = new Intent(ProfilePicActivity.this, HomeChatActivity.class);
                lanjut.putExtra("profilepic", imgUri.toString());
                lanjut.putExtra("username", uname);
                lanjut.putExtra("password", pass);
                startActivity(lanjut);
            }
        });

        tvLewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lewat = new Intent(ProfilePicActivity.this, HomeChatActivity.class);
                lewat.putExtra("username", uname);
                lewat.putExtra("password", pass);
                startActivity(lewat);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "     Batal mengambil gambar     ", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (requestCode == GALLERY_REQUEST_CODE){
                if (data != null){
                    try {
                        change_img = true;
                        imgUri = data.getData();
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imgUri);
                        ivFoto.setImageBitmap(bitmap);
                        tvLewati.setVisibility(View.INVISIBLE);
                        cvLanjut.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        Toast.makeText(this, "     Gagal mengambil gambar     ", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
        }
    }
}