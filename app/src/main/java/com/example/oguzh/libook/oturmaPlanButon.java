package com.example.oguzh.libook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link oturmaPlanButon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class oturmaPlanButon extends Fragment implements View.OnClickListener {
    private String idSeat, checkinn, okulNo;
    private Button btnCheckinn;
    private TextView tvvvv;
    private RequestQueue queue;
    private static final String URL = "http://192.168.1.102:80/test/checkinn_control.php";
    private StringRequest request;

    public oturmaPlanButon() {
        // Required empty public constructor
    }


    public static oturmaPlanButon newInstance(String param1, String param2, String param3) {
        oturmaPlanButon fragment = new oturmaPlanButon();
        Bundle args = new Bundle();
        args.putString("IDSEAT", param1);
        args.putString("CHECKINN", param2);
        args.putString("OKULNO3", param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idSeat = getArguments().getString("IDSEAT");
            checkinn = getArguments().getString("CHECKINN");
            okulNo = getArguments().getString("OKULNO3");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_oturma_plan_buton, container, false);
        btnCheckinn = (Button) view.findViewById(R.id.btn_Checkinn);
        tvvvv = (TextView) view.findViewById(R.id.tvv);
        queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        tvvvv.setText(idSeat);
        btnCheckinn.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View view) {
     /*   oturmaPlanButon oturma = new oturmaPlanButon();
        FragmentManager manager1=getFragmentManager();
        FragmentTransaction transaction1 = manager1.beginTransaction();
        transaction1.add(R.id.ly_Main2, oturma,"asd");*/

     /* oturmaPlanButon oturmaPlan= (oturmaPlanButon) getFragmentManager().findFragmentByTag("deneme");
        if(oturmaPlan!=null){
            getFragmentManager().beginTransaction().remove(oturmaPlan).commit();


        }*/

        final String abc = checkinn, bca = idSeat, cba = okulNo;

        String bc = checkinn;
        tvvvv.setText(bca);
        request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.names().get(0).equals("success1")) {
                        Toast.makeText(getContext(), bca+"Kaydınız başarıyla oluşturuldu", Toast.LENGTH_SHORT).show();

                    } else if (jsonObject.names().get(0).equals("success")) {
                        Toast.makeText(getContext(), "Okul numarası daha önceden kullanılmış", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Kullanıcı adı veya parola hatalıdır.", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("okulNo", cba);
                hashMap.put("id_Checkinn", abc);
                hashMap.put("id_Seat", bca);
                tvvvv.setText(bca);
                return hashMap;
            }
        };
        queue.add(request);

/*transaction1.commit();*/









    }


}