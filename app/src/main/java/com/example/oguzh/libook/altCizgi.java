package com.example.oguzh.libook;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;





/**
 * Created by oguzh on 10 Ağu 2018.
 */

public class altCizgi extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    TextView tvokulNo, tvEmail,tvBolum;
    String okulNo,email,bolum;




    public altCizgi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static altCizgi newInstance(String okulNo,String email,String bolum) {
        altCizgi fragment = new altCizgi();
        Bundle args = new Bundle();
        args.putString("OKULNO2", okulNo);
        args.putString("EMAIL2", email);
        args.putString("BOLUM2", bolum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            okulNo = getArguments().getString("OKULNO2");
            bolum = getArguments().getString("BOLUM2");
            email = getArguments().getString("EMAIL2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.alt_cizgi, container, false);
        tvokulNo=(TextView) view.findViewById(R.id.tv_Hosgeldin);
        tvEmail=(TextView) view.findViewById(R.id.tv_Email);
        tvBolum=(TextView) view.findViewById(R.id.tv_Bolum);
        tvokulNo.setText(okulNo);
        tvEmail.setText(email);
        tvBolum.setText(bolum);



        return view;
    }
    //2. opsiyonda kullanıldı
    public void SetName(String enteredName){
        tvokulNo.setText(enteredName);

    }

}
