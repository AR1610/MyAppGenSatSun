package com.myappgensatsun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.myappgensatsun.utils.MyUtils;
import com.myappgensatsun.utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class APICALL_GET_Activity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicall_get);
        listView = findViewById(R.id.list_view);
        ArrayList<APIDataModel> apiDataModelArrayList = new ArrayList<APIDataModel>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, MyUtils.MAIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i= 0; i< jsonArray.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String strFn = jsonObject.getString("first_name");
                        String strLn = jsonObject.getString("last_name");

                        APIDataModel apiDataModel = new APIDataModel();
                        apiDataModel.setApi_fn(strFn);
                        apiDataModel.setApi_ln(strLn);

                        apiDataModelArrayList.add(apiDataModel);
                    }

                    MyListAdapter myGridAdapter = new MyListAdapter(APICALL_GET_Activity.this,apiDataModelArrayList);
                    listView.setAdapter(myGridAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}