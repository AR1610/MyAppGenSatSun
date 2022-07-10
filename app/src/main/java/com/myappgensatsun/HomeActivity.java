package com.myappgensatsun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUserName = findViewById(R.id.tv_username);

        Intent i = getIntent();
        String strUserName =  i.getStringExtra("KEY_USERNAME");
        tvUserName.setText(strUserName);

    }
}