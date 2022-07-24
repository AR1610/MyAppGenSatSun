package com.myappgensatsun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btnAlert,btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btnAlert = findViewById(R.id.btn_alert);
        btnCustomDialog = findViewById(R.id.btn_ctm_dialog);


        btnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.raw_dialog,null);
                EditText edtValue = myview.findViewById(R.id.edt_value);
                Button btnAdd = myview.findViewById(R.id.btn_add);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      String strData =   edtValue.getText().toString();
                        Toast.makeText(AlertDialogActivity.this, "Value is "+strData, Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setView(myview);
                builder.show();

            }
        });

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setIcon(R.drawable.dolphin_icon);
                builder.setTitle("MyAppGen SatSun");
                builder.setMessage("Are you sure, you want to delete this file?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "Yes is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(AlertDialogActivity.this, "No ", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });


    }
}