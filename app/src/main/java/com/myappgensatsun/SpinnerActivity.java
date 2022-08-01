package com.myappgensatsun;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpinnerActivity extends AppCompatActivity {

    TextView tvSpinner;
    Spinner spinner;

    String strLang[] = {"Select Item","Android","Java",".net","PHP","C","C++","IOS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        tvSpinner = findViewById(R.id.tv_spinner);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,strLang){
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                TextView tvData = (TextView) super.getDropDownView(position, convertView, parent);

                if (position == 0){

                    tvData.setTextColor(Color.GRAY);
                }else {
                    tvData.setTextColor(Color.MAGENTA);

                }

                return tvData;
            }
        };
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i != 0){
                    tvSpinner.setText("Selected item is "+strLang[i]);

                }

           /*     if (!strLang[i].equals("Select Item")){
                    tvSpinner.setText("Selected item is "+strLang[i]);

                }*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}