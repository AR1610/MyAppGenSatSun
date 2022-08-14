package com.myappgensatsun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyGridAdapter extends BaseAdapter {
    Context context;
    ArrayList<LangModel> langModelArrayList;
    public MyGridAdapter(Context context, ArrayList<LangModel> langModelArrayList) {

        this.context = context;
        this.langModelArrayList = langModelArrayList;
    }

    @Override
    public int getCount() {
        return langModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return langModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.raw_grid,null);

        ImageView imgData = view.findViewById(R.id.img_data);
        TextView tvData = view.findViewById(R.id.tv_data);

        imgData.setImageResource(langModelArrayList.get(i).getImgData());
        tvData.setText(langModelArrayList.get(i).getStrData());

        return view;
    }
}
