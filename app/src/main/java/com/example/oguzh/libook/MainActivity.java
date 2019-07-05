package com.example.oguzh.libook;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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


public class MainActivity extends AppCompatActivity {
    private TextView tv_Kayit;
    private EditText etOkulno,etPassword;
    private Button btnGiris;
    private RequestQueue requestQueue;
    private static final String URL = "http://192.168.1.102:80/test/user_control.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        etOkulno=(EditText) findViewById(R.id.et_kullaniciadi);
        etPassword=(EditText)findViewById(R.id.et_parola);
        btnGiris=(Button)findViewById(R.id.btn_Giris);
        tv_Kayit=(TextView)findViewById(R.id.tv_kayitol);
        requestQueue= Volley.newRequestQueue(this);
        tv_Kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed_text = etOkulno.getText().toString().trim();
                String ed1_text = etPassword.getText().toString().trim();
                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null || ed1_text.isEmpty() || ed1_text.length() == 0 || ed1_text.equals("") || ed1_text == null)
                {
                    Toast.makeText(getApplicationContext(),"Lütfen Alanları Boş Bırakmayınız", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    request = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                if(jsonObject.names().get(0).equals("success")){

                                    String okulNo=jsonObject.getString("success").toString();
                                   String eMail=jsonObject.getString("success1").toString();
                                    String bolum=jsonObject.getString("success2").toString();
                                    Toast.makeText(getApplicationContext(),"Başarılı bir şekilde giriş yapıldı",Toast.LENGTH_SHORT).show();

                                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                                    intent.putExtra("OKULNO",okulNo);
                                    intent.putExtra("EMAIL",eMail);
                                   intent.putExtra("BOLUM",bolum);
                                    startActivity(intent);
                                }else {
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
                            hashMap.put("okulNo",etOkulno.getText().toString());
                            hashMap.put("password",etPassword.getText().toString());

                            return hashMap;
                        }
                    };
                    requestQueue.add(request);
                }
                }





        });

    }




}
