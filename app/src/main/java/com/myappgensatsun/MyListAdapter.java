package com.myappgensatsun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<APIDataModel> langModelArrayList;
    public MyListAdapter(Context context, ArrayList<APIDataModel> langModelArrayList) {

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
        view = layoutInflater.inflate(R.layout.raw_list,null);

        TextView tvData = view.findViewById(R.id.tv_data);

        tvData.setText(langModelArrayList.get(i).getApi_fn()+"   "+langModelArrayList.get(i).getApi_ln());

        return view;
    }
}
