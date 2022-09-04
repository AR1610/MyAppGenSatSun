package com.myappgensatsun;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class AFragment extends Fragment {
    GridView gridView;
    String strLang[] = {"Android", "Java", "PHP", "C", "C++", "Python", "IOS", ".NET"};
    int imgData[] = {R.mipmap.ic_launcher_round, R.drawable.ic_java,
            R.drawable.ic_php, R.drawable.ic_c, R.drawable.ic_cc,
            R.drawable.ic_python, R.drawable.ic_ios, R.drawable.ic_house};
    ArrayList<LangModel> langModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_a, container, false);

        gridView = rootview.findViewById(R.id.grid_view);
        langModelArrayList = new ArrayList<LangModel>();
        for (int i = 0; i < strLang.length; i++) {

            LangModel langModel = new LangModel(strLang[i], imgData[i]);
            langModelArrayList.add(langModel);
        }

        MyGridAdapter myGridAdapter = new MyGridAdapter(getActivity(),langModelArrayList);
        gridView.setAdapter(myGridAdapter);


        return rootview;
    }
}