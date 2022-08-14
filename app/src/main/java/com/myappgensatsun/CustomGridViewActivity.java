package com.myappgensatsun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class CustomGridViewActivity extends AppCompatActivity {
    GridView gridView;
    String strLang[] = {"Android", "Java", "PHP", "C", "C++", "Python", "IOS", ".NET"};
    int imgData[] = {R.mipmap.ic_launcher_round, R.drawable.ic_java,
            R.drawable.ic_php, R.drawable.ic_c, R.drawable.ic_cc,
            R.drawable.ic_python, R.drawable.ic_ios, R.drawable.ic_house};
    ArrayList<LangModel> langModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);
        gridView = findViewById(R.id.grid_view);
        langModelArrayList = new ArrayList<LangModel>();
        for (int i = 0; i < strLang.length; i++) {

            LangModel langModel = new LangModel(strLang[i], imgData[i]);
            langModelArrayList.add(langModel);
        }

        MyGridAdapter myGridAdapter = new MyGridAdapter(this,langModelArrayList);
        gridView.setAdapter(myGridAdapter);

    }
}