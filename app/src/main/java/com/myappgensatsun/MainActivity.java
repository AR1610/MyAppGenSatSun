package com.myappgensatsun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUserName;
    Button btnLogin;
    ImageView imgLogo;
    Button btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserName = findViewById(R.id.edt_username);
        btnLogin = findViewById(R.id.btn_login);
        imgLogo = findViewById(R.id.img_logo);
        btnGoogle = findViewById(R.id.btn_google);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implicit Intent
         Intent i = new Intent();
         i.setAction(Intent.ACTION_VIEW);
         i.setData(Uri.parse("https://www.google.com/"));
         startActivity(i);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String strUserName = edtUserName.getText().toString();
             if (strUserName.equals("")){
                 Toast.makeText(MainActivity.this, "Please Enter Valid UserName", Toast.LENGTH_SHORT).show();
             }else {
                 imgLogo.setImageResource(R.drawable.dolphin_icon);
                 Toast.makeText(MainActivity.this, "UserName is "+strUserName, Toast.LENGTH_SHORT).show();
                // Explicit Intent
                 Intent i = new Intent(MainActivity.this,HomeActivity.class);
                 i.putExtra("KEY_USERNAME",strUserName);
                 startActivity(i);

             }
            }
        });


    }
}