package com.myappgensatsun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class TypeofMenuActivity extends AppCompatActivity {

    TextView tvClick;
    Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeof_menu);
        tvClick = findViewById(R.id.tv_click);
        registerForContextMenu(tvClick);
        btnPopUp = findViewById(R.id.btn_popup);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu = new PopupMenu(TypeofMenuActivity.this,btnPopUp);
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.item_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int id = menuItem.getItemId();
                        if (id == R.id.item_add) {
                            Toast.makeText(TypeofMenuActivity.this, "Add is clicked", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });

            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.item_add) {
            Toast.makeText(this, "Add is clicked", Toast.LENGTH_SHORT).show();
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_add) {
            Toast.makeText(this, "Add is clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}