package com.example.inklocal.asyncronus;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    Button btnfragment_Satu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentSatu fragmentSatu = new FragmentSatu();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragmentSatu);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();

        btnfragment_Satu = (Button) findViewById(R.id.btnfragment_Satu);
        btnfragment_Satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDua fragmentDua = new FragmentDua();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragmentDua);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });


    }
}