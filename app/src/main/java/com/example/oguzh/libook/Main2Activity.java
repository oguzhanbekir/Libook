package com.example.oguzh.libook;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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


public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    TextView tvAnasayfa,tvOturum,tvAna,tvLogoff;
    private RequestQueue requestQueue;
    private static final String URL = "http://192.168.1.102:80/test/seat_control.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvAnasayfa=(TextView)findViewById(R.id.tv_Anasayfa);
        tvOturum=(TextView)findViewById(R.id.tv_OturmaPlan);
        tvAna=(TextView)findViewById(R.id.tv_Hosgeldin);
        tvLogoff=(TextView)findViewById(R.id.tv_logoff);
        requestQueue= Volley.newRequestQueue(this);



        tvLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        tvAnasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Fragment fragment:getSupportFragmentManager().getFragments()) {
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                }
                String okulno2=getIntent().getStringExtra("OKULNO");
                String eMail2=getIntent().getStringExtra("EMAIL");
                String bolum2=getIntent().getStringExtra("BOLUM");


                altCizgi alt=altCizgi.newInstance(okulno2,eMail2,bolum2);
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
               transaction.add(R.id.ly_Main2,alt);
                transaction.commit();


            }
        });

        tvOturum.setOnClickListener(new View.OnClickListener() {
            altCizgiOturmaPlan alt2=new altCizgiOturmaPlan();
            FragmentTransaction transaction;



            @Override
            public void onClick(View view) {
                final String okulno2=getIntent().getStringExtra("OKULNO");
                final String dizi[]=new String[16];
                final String dizi2[]=new String[16];

                for(int i=101;i<117;i++)
                {
                    final int finalI = i;



                    request = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                if(jsonObject.names().get(0).equals("success")){

                                    String okulNo=jsonObject.getString("success").toString();
                                    String eMail=jsonObject.getString("success1").toString();
                                    int c=finalI-101;
                                    dizi[c]=okulNo;
                                    dizi2[c]=eMail;

                                    alt2=altCizgiOturmaPlan.newInstance(dizi,dizi2,okulno2);
                                    FragmentManager manager=getSupportFragmentManager();
                                    transaction=manager.beginTransaction();
                                    transaction.add(R.id.ly_Main2,alt2,"OTURUM");
                                    transaction.commit();




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


                            hashMap.put("id_Seat",String.valueOf(finalI));

                            return hashMap;
                        }
                    };
                    requestQueue.add(request);




                }




                for (Fragment fragment:getSupportFragmentManager().getFragments()) {
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                }



            }
        });

    }


    @Override
    public void onClick(View view) {


    }
}

