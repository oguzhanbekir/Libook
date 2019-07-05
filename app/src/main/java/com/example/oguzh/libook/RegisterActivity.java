package com.example.oguzh.libook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private TextView tvgeriDon;
    private EditText etrOkulno, etrEmail,etrBolum,etrParola;
    private Button btnKayit;
    private RequestQueue requestQueue;
    private static final String URL = "http://192.168.1.102:80/test/user_control2.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

      etrOkulno = (EditText)findViewById(R.id.et_RokulNumara);
      etrEmail = (EditText)findViewById(R.id.et_Remail);
      etrBolum = (EditText)findViewById(R.id.et_Rbolum);
      etrParola= (EditText)findViewById(R.id.et_Rparola);
      tvgeriDon = (TextView) findViewById(R.id.tv_girisDon);
      btnKayit=(Button)findViewById(R.id.btn_RGiris);

        requestQueue= Volley.newRequestQueue(this);
      tvgeriDon.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent geriDon=new Intent(RegisterActivity.this,MainActivity.class);
              startActivity(geriDon);
          }
      });

      btnKayit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String et_okulNo = etrOkulno.getText().toString().trim();
              String et_parola = etrParola.getText().toString().trim();
              String et_bolum = etrBolum.getText().toString().trim();
              String et_email = etrEmail.getText().toString().trim();


              if(et_okulNo.isEmpty() ||  et_parola.isEmpty() || et_bolum.isEmpty() || et_email.isEmpty() )
              {
                  Toast.makeText(getApplicationContext(),"Lütfen Alanları Boş Bırakmayınız", Toast.LENGTH_SHORT).show();

              }
              else
              {
                  if(et_parola.length()>8){
                      request = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
                          @Override
                          public void onResponse(String response) {
                              try {
                                  JSONObject jsonObject = new JSONObject(response);
                                  if(jsonObject.names().get(0).equals("success")){
                                      Toast.makeText(getApplicationContext(),"Okul numarası daha önceden kullanılmış",Toast.LENGTH_SHORT).show();

                                  }else if(jsonObject.names().get(0).equals("success1")){
                                      Toast.makeText(getApplicationContext(),"Kaydınız başarıyla oluşturuldu",Toast.LENGTH_SHORT).show();
                                  }else{
                                      Toast.makeText(getApplicationContext(),"Kullanıcı adı veya parola hatalıdır.", Toast.LENGTH_SHORT).show();
                                  }
                              } catch (JSONException e) {
                                  e.printStackTrace();
                              }

                          }
                      }, new Response.ErrorListener() {
                          @Override
                          public void onErrorResponse(VolleyError error) {

                          }
                      }){
                          @Override
                          protected Map<String, String> getParams() throws AuthFailureError {
                              HashMap<String,String> hashMap = new HashMap<String, String>();
                              hashMap.put("okulNo",etrOkulno.getText().toString());
                              hashMap.put("password",etrParola.getText().toString());
                              hashMap.put("email",etrEmail.getText().toString());
                              hashMap.put("bolum",etrBolum.getText().toString());

                              return hashMap;
                          }
                      };
                      requestQueue.add(request);
                  } else {
                      Toast.makeText(getApplicationContext(),"Parolanızı 8 karakterden fazla girin", Toast.LENGTH_SHORT).show();
                  }


              }
          }
      });


    }
}
