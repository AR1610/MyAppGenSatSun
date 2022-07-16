package com.myappgensatsun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImagePickActivity extends AppCompatActivity {

    ImageView imgDP;
    Button btnGallery,btnCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pick);

        imgDP = findViewById(R.id.img_dp);
        btnGallery = findViewById(R.id.btn_gallery);
        btnCamera = findViewById(R.id.btn_camera);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,2);

            }
        });


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  i = new Intent();
                i.setAction(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){

        Uri uri =  data.getData();
        imgDP.setImageURI(uri);

        }
        else if (requestCode == 2){

         Bitmap bitmap = (Bitmap) data.getExtras().get("data");

         imgDP.setImageBitmap(bitmap);
        }


    }
}