package com.myappgensatsun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.myappgensatsun.utils.MyUtils;
import com.myappgensatsun.utils.VolleySingleton;

import java.util.HashMap;
import java.util.Map;

public class APICALL_SignUpActivity extends AppCompatActivity {

    EditText edtFn,edtLn,edtEmail,edtPassword;
    Button btnLogin,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtFn = findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
         btnSignUp = findViewById(R.id.btn_signUp);


         btnSignUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 String strFN = edtFn.getText().toString();
                 String strLN = edtLn.getText().toString();
                 String strEmail = edtEmail.getText().toString();
                 String strPassword = edtPassword.getText().toString();

                 loadAPI(strFN,strLN,strEmail,strPassword);
             }
         });
    }

    private void loadAPI(String strFN, String strLN, String strEmail, String strPassword) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUtils.MAIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("TAG", "onResponse: "+response );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("first_name",strFN);
                map.put("last_name",strLN);
                map.put("email",strEmail);
                map.put("Password",strPassword);

                return map;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}