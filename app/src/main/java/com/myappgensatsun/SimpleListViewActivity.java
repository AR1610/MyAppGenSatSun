package com.myappgensatsun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListViewActivity extends AppCompatActivity {
    ListView listView;
    // Data
    String strLang[] = {"Android", "Java", ".net", "PHP", "C", "C++", "IOS", "Python"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strLang);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(SimpleListViewActivity.this, "Selected Item is "+strLang[i],
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}