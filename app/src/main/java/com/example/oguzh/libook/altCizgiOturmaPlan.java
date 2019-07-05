package com.example.oguzh.libook;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Array;

import static android.graphics.Color.BLUE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link altCizgiOturmaPlan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class altCizgiOturmaPlan extends Fragment implements View.OnClickListener{
     OnNameSetListener nameListener;


    Button btn101,btn102,btn103,btn104,btn105,btn106,btn107,btn108,btn109,btn110,btn111,btn112,btn113,btn114,btn115,btn116,btnCheckinn;
   Boolean flag=true,flag1=true,flag2=true,flag3=true,flag4=true,flag5=true,flag6=true,flag7=true,flag8=true,flag9=true,flag10=true,flag11=true,flag12=true,flag13=true,flag14=true,flag15=true;
    TextView tvUstyazi;
    String a[]=new String[16],b[]=new String[16],c,ac,ab;
    public altCizgiOturmaPlan() {
        // Required empty public constructor
    }


    public static altCizgiOturmaPlan newInstance(String[] param3,String[] param4,String param5) {
        altCizgiOturmaPlan fragment = new altCizgiOturmaPlan();
        Bundle args = new Bundle();

        args.putStringArray("ARRAY",param3);
        args.putStringArray("ARRAY2",param4);
        args.putString("OKULNO2",param5);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            a=getArguments().getStringArray("ARRAY");
            b=getArguments().getStringArray("ARRAY2");
            c=getArguments().getString("OKULNO2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Ifragmentnflate the layout for this
        View view=inflater.inflate(R.layout.fragment_alt_cizgi_oturma_plan, container, false);
        btn101=(Button)view.findViewById(R.id.btn_101);btn101.setText("101");
        btn102=(Button)view.findViewById(R.id.btn_102);btn102.setText("102");
        btn103=(Button)view.findViewById(R.id.btn_103);btn103.setText("103");
        btn104=(Button)view.findViewById(R.id.btn_104);btn104.setText("104");
        btn105=(Button)view.findViewById(R.id.btn_105);btn105.setText("105");
        btn106=(Button)view.findViewById(R.id.btn_106);btn106.setText("106");
        btn107=(Button)view.findViewById(R.id.btn_107);btn107.setText("107");
        btn108=(Button)view.findViewById(R.id.btn_108);btn108.setText("108");
        btn109=(Button)view.findViewById(R.id.btn_109);btn109.setText("109");
        btn110=(Button)view.findViewById(R.id.btn_110);btn110.setText("110");
        btn111=(Button)view.findViewById(R.id.btn_111);btn111.setText("111");
        btn112=(Button)view.findViewById(R.id.btn_112);btn112.setText("112");
        btn113=(Button)view.findViewById(R.id.btn_113);btn113.setText("113");
        btn114=(Button)view.findViewById(R.id.btn_114);btn114.setText("114");
        btn115=(Button)view.findViewById(R.id.btn_115);btn115.setText("115");
        btn116=(Button)view.findViewById(R.id.btn_116);btn116.setText("116");
        tvUstyazi=(TextView) view.findViewById(R.id.tv_Ustyazi);
        btnCheckinn=(Button)view.findViewById(R.id.btn_Checkinn);

            if(btn101.getText().toString().equals(a[0]) && b[0].equals("1")){
                btn101.setBackgroundColor(Color.RED);
                flag=false;
            }
            if(btn102.getText().toString().equals(a[1]) && b[1].equals("1")){
                btn102.setBackgroundColor(Color.RED);
                flag1=false;
            }
            if(btn103.getText().toString().equals(a[2]) && b[2].equals("1")){
                btn103.setBackgroundColor(Color.RED);
                flag2=false;
            }
            if(btn104.getText().toString().equals(a[3]) && b[3].equals("1")){
                btn104.setBackgroundColor(Color.RED);
                flag3=false;
            }
            if(btn105.getText().toString().equals(a[4]) && b[4].equals("1")){
                btn105.setBackgroundColor(Color.RED);
                flag4=false;
            }
            if(btn106.getText().toString().equals(a[5]) && b[5].equals("1")){
                btn106.setBackgroundColor(Color.RED);
                flag5=false;
            }
            if(btn107.getText().toString().equals(a[6]) && b[6].equals("1")){
                btn107.setBackgroundColor(Color.RED);
                flag6=false;
            }
            if(btn108.getText().toString().equals(a[7]) && b[7].equals("1")){
                btn108.setBackgroundColor(Color.RED);
                flag7=false;
            }
            if(btn108.getText().toString().equals(a[8]) && b[8].equals("1")){
                btn108.setBackgroundColor(Color.RED);
                flag8=false;
            }
            if(btn109.getText().toString().equals(a[9]) && b[9].equals("1")){
                btn110.setBackgroundColor(Color.RED);
                flag9=false;
            }
            if(btn111.getText().toString().equals(a[10]) && b[10].equals("1")){
                btn111.setBackgroundColor(Color.RED);
                flag10=false;
            }
            if(btn112.getText().toString().equals(a[11]) && b[11].equals("1")){
                btn112.setBackgroundColor(Color.RED);
                flag11=false;
            }
            if(btn113.getText().toString().equals(a[12]) && b[12].equals("1")){
                btn113.setBackgroundColor(Color.RED);
                flag12=false;
            }
            if(btn114.getText().toString().equals(a[13]) && b[13].equals("1")){
                btn114.setBackgroundColor(Color.RED);
                flag13=false;
            }
            if(btn115.getText().toString().equals(a[14]) && b[14].equals("1")){
                btn115.setBackgroundColor(Color.RED);
                flag14=false;
            }
            if(btn116.getText().toString().equals(a[15]) && b[15].equals("1")){
                btn116.setBackgroundColor(Color.RED);
                flag15=false;
            }




        btn101.setOnClickListener(this);
        btn102.setOnClickListener(this);
        btn103.setOnClickListener(this);
        btn104.setOnClickListener(this);
        btn105.setOnClickListener(this);
        btn106.setOnClickListener(this);
        btn107.setOnClickListener(this);
        btn108.setOnClickListener(this);
        btn109.setOnClickListener(this);
        btn110.setOnClickListener(this);
        btn111.setOnClickListener(this);
        btn112.setOnClickListener(this);
        btn113.setOnClickListener(this);
        btn114.setOnClickListener(this);
        btn115.setOnClickListener(this);
        btn116.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View view) {


        oturmaPlanButon oturmaPlan= (oturmaPlanButon) getFragmentManager().findFragmentByTag("deneme");


        switch (view.getId()){
            case R.id.btn_101:
                    if(flag==true) {
                        btn101.setBackgroundColor(Color.BLUE);
                        ac="101";
                        ab="1";
                        if(oturmaPlan!=null){
                            getFragmentManager().beginTransaction().remove(oturmaPlan).commit();
                        }

                        oturmaPlanButon oturma = oturmaPlanButon.newInstance(ac,ab,c);
                        FragmentManager manager1=getFragmentManager();
                        FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.add(R.id.ly_Main2, oturma,"deneme");

                        transaction1.commit();
                    }
                    else {
                        Toast.makeText(getContext(), "Bu koltuk doludur", Toast.LENGTH_SHORT).show();
                    }

                    if(flag1==true)
                        btn102.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    if(flag2==true)
                        btn103.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    if(flag3==true)
                        btn104.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

             break;
            case R.id.btn_102:
                if(flag1==true) {
                    btn102.setBackgroundColor(Color.BLUE);
                    ac="102";
                    ab="1";
                   if(oturmaPlan!=null){
                        getFragmentManager().beginTransaction().remove(oturmaPlan).commit();
                    }

                    oturmaPlanButon oturma = oturmaPlanButon.newInstance(ac,ab,c);
                    FragmentManager manager1=getFragmentManager();
                    FragmentTransaction transaction1 = manager1.beginTransaction();
                    transaction1.add(R.id.ly_Main2, oturma,"deneme");

                    transaction1.commit();

                  //  onNameSet(ac,ab,c);
                }
                else
                    Toast.makeText(getContext(),"Bu koltuk doludur",Toast.LENGTH_SHORT).show();
                if(flag==true)
                    btn101.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if(flag2==true)
                    btn103.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if(flag3==true)
                    btn104.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;
            case R.id.btn_103:
                if(flag2==true) {
                btn103.setBackgroundColor(Color.BLUE);
                ac="103";
                ab="1";
                    if(oturmaPlan!=null){
                        getFragmentManager().beginTransaction().remove(oturmaPlan).commit();
                    }

                    oturmaPlanButon oturma = oturmaPlanButon.newInstance(ac,ab,c);
                    FragmentManager manager1=getFragmentManager();
                    FragmentTransaction transaction1 = manager1.beginTransaction();
                    transaction1.add(R.id.ly_Main2, oturma,"deneme");

                    transaction1.commit();

                }
                else{
                    Toast.makeText(getContext(),"Bu koltuk doludur",Toast.LENGTH_SHORT).show();

                }

                if(flag1==true)
                    btn102.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if(flag==true)
                    btn101.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if(flag3==true)
                    btn104.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;
            case R.id.btn_104:
                if(flag3==true) {
                    btn104.setBackgroundColor(Color.BLUE);
                    ac="104";
                    ab="1";

                    if(oturmaPlan!=null){
                        getFragmentManager().beginTransaction().remove(oturmaPlan).commit();

                    }

                    oturmaPlanButon oturma2 = oturmaPlanButon.newInstance(ac,ab,c);
                    FragmentManager manager2=getFragmentManager();
                    FragmentTransaction transaction2 = manager2.beginTransaction();
                    transaction2.add(R.id.ly_Main2, oturma2,"deneme");


                    transaction2.commit();
                }
                else
                    Toast.makeText(getContext(),"Bu koltuk doludur",Toast.LENGTH_SHORT).show();
                if(flag1==true)
                    btn102.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if(flag2==true)
                    btn103.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                if(flag==true)
                    btn101.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                break;

        }





    }


    public void onNameSet(String ac, String ab, String c) {
        tvUstyazi.setText(ac+" "+ab+" "+c);
        oturmaPlanButon oturma = oturmaPlanButon.newInstance(ac,ab,c);
        FragmentManager manager1=getFragmentManager();
        FragmentTransaction transaction1 = manager1.beginTransaction();
        transaction1.add(R.id.ly_Main2, oturma,"deneme");
        transaction1.commit();
    }

    public interface OnNameSetListener {
        // TODO: Update argument type and name
        void onNameSet(String a,String b,String c);
    }

}
